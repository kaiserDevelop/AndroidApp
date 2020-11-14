package com.cvv.vaccinationrecord.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvv.vaccinationrecord.data.CatPets
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class CatPetsViewModel: ViewModel() {
    private var _catPets: MutableLiveData<ArrayList<CatPets>> = MutableLiveData<ArrayList<CatPets>>()
    private lateinit var firestore: FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
        listenToCatPets()
    }

    private fun listenToCatPets() {
        firestore.collection("CatPets").addSnapshotListener{
            snapshot, e ->
            if(e != null) {
                Log.w(TAG, "Listen Failed", e)
                return@addSnapshotListener
            }
            if(snapshot != null) {
                val allCatPets = ArrayList<CatPets>()
                val documents = snapshot.documents
                documents.forEach {
                    val catPets = it.toObject(CatPets::class.java)
                    if(catPets != null) {
                        allCatPets.add(catPets!!)
                    }
                }
                _catPets.value = allCatPets
            }
        }
    }

    fun saveCatPets(catPets: CatPets) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(5000)
            val document = firestore.collection("CatPets").document()
            catPets.idCatPets = document.id
            val set = document.set(catPets).await()
            /*set.addOnSuccessListener {
                Log.d("Firebase", "Document saved")
            }
            set.addOnFailureListener {
                Log.d("Firebase", "Save failed")
            }*/
        }

    }

    internal var catPest: MutableLiveData<ArrayList<CatPets>>
    get() {return _catPets}
    set(value) {_catPets = value}
}