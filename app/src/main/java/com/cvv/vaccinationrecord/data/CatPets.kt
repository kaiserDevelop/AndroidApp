package com.cvv.vaccinationrecord.data

import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class CatPets(
    var idCatPets: String = "",
    var typePet: String = "",
    @ServerTimestamp var created: Timestamp? = null
) {
}