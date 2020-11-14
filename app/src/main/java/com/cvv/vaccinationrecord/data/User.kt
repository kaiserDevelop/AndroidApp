package com.cvv.vaccinationrecord.data

import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp

data class User(
    var idUser: String = "",
    var name: String = "",
    var email: String = "",
    @ServerTimestamp var created: Timestamp? = null
) {
}