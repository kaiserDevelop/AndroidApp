package com.cvv.vaccinationrecord.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvv.vaccinationrecord.data.User
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class UserViewModel: ViewModel() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private var _currentUser: MutableLiveData<FirebaseUser> = MutableLiveData<FirebaseUser>()
    private var firebaseUser: FirebaseUser? = null

    init {
        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun createUserWithEmail(email: String, password: String, name: String) {
        //viewModelScope.launch(Dispatchers.IO) {

            /*
            var idUser: String? = ""
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        Log.d(TAG, "signInWithEmail:success")
                        idUser = auth.currentUser?.uid

                        _currentUser.value = auth.currentUser
                    } else {

                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                    }
                }

            */
        //}

            viewModelScope.launch(Dispatchers.IO) {
                try {
                    var idUser: String? = ""
                    firebaseUser = auth.createUserWithEmailAndPassword(email, password).await().user
                    /*auth.currentUser.let {
                        firebaseUser = it
                        idUser = it?.uid
                    }*/
                    idUser = firebaseUser?.uid
                    insertUserInCollection(idUser, name, email)
                }catch (e: Exception) {
                    Log.w(TAG, "createUserWithEmail:failure", e)
                }
            }
            _currentUser.value = firebaseUser
    }

    private suspend fun insertUserInCollection(idUser: String?, name: String, email: String) {

            val user = User(idUser!!, name, email)
            val document = firestore.collection("Users").document()
            user.idUser = idUser
            document.set(user).await()

    }
}