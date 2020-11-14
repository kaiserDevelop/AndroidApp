package com.cvv.vaccinationrecord.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "pet_owner")
data class PetOwner(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "second_name")
    val secondName: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: Long,
    @ColumnInfo(name = "email")
    val email: String
    /*@ColumnInfo(name = "address_id")
    val addressId: Int,
    @ColumnInfo(name = "petprofile_id")
    val petProfileId: Long*/
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_owner")
    var idOwner: Int = 0
}