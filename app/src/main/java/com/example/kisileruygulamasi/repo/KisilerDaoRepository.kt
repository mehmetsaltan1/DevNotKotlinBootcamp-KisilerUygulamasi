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
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(0,kisi_ad,kisi_tel)
            vt.kisilerDao().kisiEkle(yeniKisi)
        }

    }

    fun kisiGuncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenKisi = Kisiler(kisi_id,kisi_ad,kisi_tel)
            vt.kisilerDao().kisiGuncelle(guncellenenKisi)
        }
    }

    fun kisiAra(aramaKelimesi: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = vt.kisilerDao().kisiAra(aramaKelimesi)
        }
    }

    fun kisiSil(kisi_id: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinecekKisi = Kisiler(kisi_id,"","")
            vt.kisilerDao().kisiSil(silinecekKisi)
            tumKisileriAl()
        }
    }
    fun tumKisileriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = vt.kisilerDao().tumKisiler()
        }
    }
}