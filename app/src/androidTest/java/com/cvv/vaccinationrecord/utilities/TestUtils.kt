package com.cvv.vaccinationrecord.utilities

import com.cvv.vaccinationrecord.data.PetOwner
import java.util.*

/**
 * [Calendar] object used for test
 */
val testCalendar: Calendar = Calendar.getInstance().apply {
    set(Calendar.YEAR, 1998)
    set(Calendar.MONTH, Calendar.SEPTEMBER)
    set(Calendar.DAY_OF_MONTH, 4)
}

val testPetOwner = PetOwner("Máximo","Decimo","Meridio",30,1234567890,"mail@mail.com")

/**
 * [PetProfile] objects used for test
 */
/*val testPetProfiles= arrayListOf<PetProfile>(
    PetProfile(1L,"Bridget","Cat","122123",testCalendar,"Female","Mix","Brown with white","Blue eyes","867474636"),
    PetProfile(2L,"Balto","Dog","565767",testCalendar,"Male","Alaska","Grey with white","Blue eyes","99988484"),
    PetProfile(3L,"Max","Dog","34334",testCalendar,"Male","Mix","White","Small size","4442323233"),
    PetProfile(4L,"Argos","Dog","1123434",testCalendar,"Male","Cattle Dog","Blue","Medium size","2222332333")
)*/

//val testPetProfile = testPetProfiles[0]

/**
 * [VaccinationRegistry] object test
 */
//val testVaccinationRegistry = VaccinationRegistry(testPetProfile.idProfile, testCalendar, "Apply vaccine", testCalendar, "Ok")

/**
 * [DewormingInternalProgram] object test
 */
//val testDewormingInternalProgram = DewormingInternalProgram(testPetProfile.idProfile,testCalendar,"Pet Max 4.7", testCalendar,"Ok")

/**
 * [CheckUp] object test
 */
//val testCheckUp = CheckUp(testPetProfile.idProfile, testCalendar,2,4.7,"Ok")