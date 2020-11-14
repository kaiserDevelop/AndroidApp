package com.cvv.vaccinationrecord.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cvv.vaccinationrecord.data.CatPets
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

class CatPetsViewModelTest {
    private lateinit var catPetsViewModel: CatPetsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {

        catPetsViewModel = CatPetsViewModel()
    }

    @Test
    fun testGetPets(){
        val calendar: Calendar = Calendar.getInstance()
        val catPets = CatPets("","Rabbit")
        catPetsViewModel.saveCatPets(catPets)
    }
}