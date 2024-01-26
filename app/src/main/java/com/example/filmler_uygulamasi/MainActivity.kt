package com.example.filmler_uygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmler_uygulamasi.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {

    private lateinit var kategoriListe: ArrayList<Kategoriler>
    private lateinit var adapter: KategoriAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var vt: VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        veritabaniKopyala()

        binding.toolbarKategori.title = "Kategoriler"
        setSupportActionBar(binding.toolbarKategori)

        binding.kategoriRv.setHasFixedSize(true)
        binding.kategoriRv.layoutManager = LinearLayoutManager(this)

        vt = VeritabaniYardimcisi(this)

        kategoriListe = Kategorilerdao().tumKategoriler(vt)

        adapter = KategoriAdapter(this,kategoriListe)
        binding.kategoriRv.adapter = adapter
    }

    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

}