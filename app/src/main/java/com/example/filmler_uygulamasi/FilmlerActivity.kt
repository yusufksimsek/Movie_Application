package com.example.filmler_uygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmler_uygulamasi.databinding.ActivityFilmlerBinding

class FilmlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilmlerBinding
    private lateinit var filmListe: ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter
    private lateinit var vt: VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler

        binding.toolbarFilmler.title = "Filmler : ${kategori.kategori_ad}"
        setSupportActionBar(binding.toolbarFilmler)

        binding.FilmlerRv.setHasFixedSize(true)
        binding.FilmlerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        vt = VeritabaniYardimcisi(this)
        filmListe = Filmlerdao().tumFilmlerByKategoriId(vt,kategori.kategori_id)

        adapter = FilmlerAdapter(this,filmListe)
        binding.FilmlerRv.adapter = adapter

    }
}