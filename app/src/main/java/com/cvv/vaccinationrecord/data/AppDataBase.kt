package com.cvv.vaccinationrecord.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = arrayOf(PetOwner::class),
    version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase: RoomDatabase() {

    //abstract fun petDao(): PetDao
    //abstract fun petProfileDao(): PetProfileDao
    /*abstract fun getVaccinationRegistryDao(): VaccinationRegistryDao
    abstract fun getDewormingInternalDao(): DewormingInternalDao
    abstract fun getCheckUpDao(): CheckUpDao
    abstract fun getHealthRecordDao(): HealthRecordDao*/
    abstract fun getPetOwnerDao(): PetOwnerDao

    companion object {
        @Volatile
        private  var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "pet_vaccination_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}