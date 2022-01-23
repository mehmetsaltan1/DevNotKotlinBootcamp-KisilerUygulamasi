package com.example.kisileruygulamasi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.entity.Kisiler

class KisilerAdapter(var mContext: Context, var kisilerListesi:List<Kisiler>) : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(view:View) : RecyclerView.ViewHolder(view) {
        var satir_card : CardView
        var textViewKisiBilgi:TextView
        var imageViewSilResim:ImageView
        init {
            satir_card = view.findViewById(R.id.satir_card)
            textViewKisiBilgi = view.findViewById(R.id.textViewKisiBilgi)
            imageViewSilResim = view.findViewById(R.id.imageViewSilResim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
    val kisi = kisilerListesi.get(position)
        holder.textViewKisiBilgi.text = "${kisi.kisi_ad} - ${kisi.kisi_tel}"
    }

    override fun getItemCount(): Int {
        return  kisilerListesi.size
    }

}