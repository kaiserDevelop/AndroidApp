package com.cvv.vaccinationrecord.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PetOwnerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPetOwner(pet: PetOwner)

    @Update
    suspend fun updatePetOwner(pet: PetOwner)

    @Query("SELECT * FROM pet_owner ORDER BY id_owner ASC")
    fun getAllPetOwners(): LiveData<List<PetOwner>>
}