package com.cvv.vaccinationrecord

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cvv.vaccinationrecord.data.CatPets
import com.cvv.vaccinationrecord.firebase.AuthRepository
import com.cvv.vaccinationrecord.utilities.InjectorUtils
import com.cvv.vaccinationrecord.viewmodels.CatPetsViewModel
import com.cvv.vaccinationrecord.viewmodels.UserViewModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val viewModel: CatPetsViewModel by viewModels {
        InjectorUtils.provideCatPetsViewModel()
    }

    private val userViewModel: UserViewModel by viewModels {
        InjectorUtils.providerUserViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val catPets = CatPets("","Cat")
        val catPetsViewModel = CatPetsViewModel()
        catPetsViewModel.saveCatPets(catPets)*/

        viewModel.catPest.observe(this, Observer { catpets ->
            val tvName = findViewById(R.id.cvv) as TextView
            tvName.text = catpets.size.toString()

        })

        button.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            val catPet = CatPets("","Hurón")
            viewModel.saveCatPets(catPet)
        }

        buttonUser.setOnClickListener {
            //userViewModel.createUserWithEmail("max@gmail.com","12345678","Max")
            val authRepository = AuthRepository.getInstance()
        }


    }

    fun createUser() {
        val db = FirebaseFirestore.getInstance()

        // Create a new user with a first and last name
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

// Add a new document with a generated ID
        db.collection("test")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("Ok", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Error", "Error adding document", e)
            }
    }
}