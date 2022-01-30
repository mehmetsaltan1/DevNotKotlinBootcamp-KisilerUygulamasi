package com.example.kisileruygulamasi.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasi.entity.Kisiler
import com.example.kisileruygulamasi.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisilerDaoRepository(var application: Application) {
    var kisilerListesi : MutableLiveData<List<Kisiler>>
    var vt:Veritabani
    init {
        kisilerListesi = MutableLiveData()
        vt = Veritabani.veritabaniErisim(application.applicationContext)!!
    }

    fun kisileriGetir():MutableLiveData<List<Kisiler>>{
        return kisilerListesi

    }
    fun kisiKayit(kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi Kayıt", "$kisi_ad-$kisi_tel")

    }

    fun kisiGuncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }

    fun kisiAra(aramaKelimesi: String) {
        Log.e("Kişi Ara", aramaKelimesi)
    }

    fun kisiSil(kisi_id: Int) {
        Log.e("Kişi Sil", kisi_id.toString())
    }
    fun tumKisileriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = vt.kisilerDao().tumKisiler()
        }
    }
}