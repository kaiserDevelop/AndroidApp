package com.cvv.vaccinationrecord.utilities

import com.cvv.vaccinationrecord.viewmodels.CatPetsViewModelFactory
import com.cvv.vaccinationrecord.viewmodels.UserViewModelFactory

object InjectorUtils {

    fun provideCatPetsViewModel(): CatPetsViewModelFactory {
        return CatPetsViewModelFactory()
    }

    fun providerUserViewModel(): UserViewModelFactory {
        return UserViewModelFactory()
    }
}