package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.model.CenterType
import com.example.data.repository.AgriKnowledgeBase
import com.example.data.repository.CrossHostDiseasesRepository
import com.example.data.repository.TreatmentCentersRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Agri-Doctor AI", appName)
  }

  @Test
  fun `treatment centers repository contains agrodealers vets and hospitals`() {
    val allCenters = TreatmentCentersRepository.CENTERS
    assertTrue("Should have treatment centers across Rwanda", allCenters.isNotEmpty())

    val agrodealers = TreatmentCentersRepository.getCentersByType(CenterType.AGRODEALER_PESTICIDES)
    val vets = TreatmentCentersRepository.getCentersByType(CenterType.VETERINARY_PHARMACY)
    val hospitals = TreatmentCentersRepository.getCentersByType(CenterType.DISTRICT_HOSPITAL)

    assertTrue("Should contain agrodealers", agrodealers.isNotEmpty())
    assertTrue("Should contain veterinary pharmacies", vets.isNotEmpty())
    assertTrue("Should contain hospitals for human/animal safety", hospitals.isNotEmpty())

    val musanzeResults = TreatmentCentersRepository.getCentersByDistrict("Musanze")
    assertTrue("Should find centers in Musanze", musanzeResults.isNotEmpty())
  }

  @Test
  fun `cross host diseases repository contains plant and animal dual diseases`() {
    val diseases = CrossHostDiseasesRepository.DISEASES
    assertTrue("Should contain dual-host study diseases", diseases.size >= 4)

    val aflatoxin = diseases.find { it.id.contains("aflatoxin") }
    assertNotNull("Aflatoxin should be in repository", aflatoxin)
    assertTrue("Should detail plant symptoms", aflatoxin!!.plantSymptoms.isNotBlank())
    assertTrue("Should detail animal symptoms", aflatoxin.animalSymptoms.isNotBlank())
    assertTrue("Should have prevention advice", aflatoxin.preventionForNextSeason.isNotBlank())

    val anthrax = diseases.find { it.id.contains("anthrax") }
    assertNotNull("Anthrax should be in repository", anthrax)
    assertTrue("Anthrax should have study summary in Kinyarwanda", anthrax!!.studySummaryRw.isNotBlank())
  }

  @Test
  fun `knowledge base fallback provides dual host study diagnosis`() {
    val diag = AgriKnowledgeBase.findMatchingDiagnosis(
      cropName = "Aflatoxin (Uburozi mu bigori n'ubunyobwa)",
      description = "Maize mold and animal feed issues",
      location = "Musanze"
    )
    assertNotNull(diag)
    assertTrue("Should recommend local agrodealers and hospitals", diag.localAgrodealers.contains("Agrodealer") || diag.localAgrodealers.contains("Hospital") || diag.localAgrodealers.contains("Ibitaro"))
  }

  @Test
  fun `weather alert repository provides agro met advisory for districts`() {
    val alerts = com.example.data.repository.WeatherAlertRepository.alerts
    assertTrue("Should have multiple Rwanda agricultural districts", alerts.size >= 5)

    val musanzeAlert = com.example.data.repository.WeatherAlertRepository.getAlertForDistrict("Musanze")
    assertNotNull("Musanze alert should exist", musanzeAlert)
    assertTrue("Should contain rain chance or temperature", musanzeAlert.rainProbability > 0)
    assertTrue("Should contain Kinyarwanda action plan", musanzeAlert.farmingActionRw.isNotBlank())
    assertTrue("Should contain English action plan", musanzeAlert.farmingActionEn.isNotBlank())
    assertTrue("Should indicate vulnerable crops or animals", musanzeAlert.affectedCropsAndAnimals.isNotBlank())
  }
}


