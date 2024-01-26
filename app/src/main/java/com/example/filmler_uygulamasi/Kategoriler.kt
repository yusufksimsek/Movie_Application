package com.example.filmler_uygulamasi

import java.io.Serializable

data class Kategoriler(
    var kategori_id:Int,
    var kategori_ad:String
) : Serializable {}