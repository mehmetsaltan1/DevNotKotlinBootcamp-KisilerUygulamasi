package com.example.kisileruygulamasi.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.repo.KisilerDaoRepository

class KisiKayitFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val krepo = KisilerDaoRepository(application)
    fun kayit(kisi_ad: String, kisi_tel: String) {
        krepo.kisiKayit(kisi_ad,kisi_tel)
    }
}