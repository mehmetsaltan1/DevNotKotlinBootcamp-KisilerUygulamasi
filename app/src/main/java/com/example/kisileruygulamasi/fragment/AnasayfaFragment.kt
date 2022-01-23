package com.example.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.adapter.KisilerAdapter
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.entity.Kisiler


class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentAnasayfaBinding
    private lateinit var adapter: KisilerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)
        tasarim.toolbarAnasayfa.title = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)
        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())
        tasarim.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
            /* val kisi = Kisiler(1, "Ahmet", "11111")
             val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi)
             Navigation.findNavController(it).navigate(gecis)*/
        }
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }

    fun ara(aramaKelimesi: String) {
        Log.e("Kişi Ara", aramaKelimesi)
    }

    /*   override fun onOptionsItemSelected(item: MenuItem): Boolean {
           when (item.itemId) {
               R.id.action_ara -> {
                   Toast.makeText(requireContext(), "Ara Seçildi", Toast.LENGTH_SHORT).show()
                   return true
               }
               else -> return super.onOptionsItemSelected(item)
           }

       }*/
}