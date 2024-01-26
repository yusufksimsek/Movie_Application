package com.example.filmler_uygulamasi

import java.io.Serializable

data class Yonetmenler(
    var yonetmen_id:Int,
    var yonetmen_ad:String
) : Serializable {}