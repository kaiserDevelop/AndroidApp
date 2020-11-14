package com.cvv.vaccinationrecord.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.cvv.vaccinationrecord.utilities.getValue
import com.cvv.vaccinationrecord.utilities.testPetOwner
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.*

class PetOwnerDaoTest {
    private lateinit var database: AppDataBase
    private lateinit var petOwnerDao: PetOwnerDao

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun createDB() = runBlocking{
        var context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDataBase::class.java).build()
        petOwnerDao = database.getPetOwnerDao()

        petOwnerDao.insertPetOwner(testPetOwner)
    }

    @After
    fun closeDB() {
        database.close()
    }

    @Test
    fun testGetPets(){
        var listResult = getValue(petOwnerDao.getAllPetOwners())

        Assert.assertThat(listResult.size, Matchers.equalTo(1))

        Assert.assertThat(listResult[0], Matchers.equalTo(testPetOwner))
    }
}