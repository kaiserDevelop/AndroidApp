package com.cvv.vaccinationrecord.firebase

import android.app.Application
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class AuthRepository private constructor() {

    private lateinit var firebaseAuth : FirebaseAuth
    private var firebaseUser: FirebaseUser? = null
    lateinit var userMutableLiveData: MutableLiveData<FirebaseUser>

    init {
        Log.i(ContentValues.TAG, "AuthRepository:init")
        firebaseAuth = FirebaseAuth.getInstance()
        userMutableLiveData = MutableLiveData<FirebaseUser>()
    }

    companion object {

        @Volatile
        private var instance: AuthRepository? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    Log.i(ContentValues.TAG, "AuthRepository:getInstance")
                    instance ?: AuthRepository().also { instance = it }
                }
    }

    suspend fun registerUser(email: String, password: String) {
        firebaseUser = firebaseAuth.createUserWithEmailAndPassword(email, password).await().user
    }
}