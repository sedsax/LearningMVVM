package com.ankauniss.learningmvvm

import androidx.lifecycle.ViewModel


class SayfaViewModel : ViewModel() {
    var sonuc = "0"
    fun toplamaYap(sayi1:String, sayi2:String){
        val alinanSayi1 = sayi1.toInt()
        val alinanSayi2 = sayi2.toInt()

        sonuc = (alinanSayi1+alinanSayi2).toString()
    }

    fun carpmaYap(sayi1:String, sayi2:String){
        val alinanSayi1 = sayi1.toInt()
        val alinanSayi2 = sayi2.toInt()

        sonuc = (alinanSayi1*alinanSayi2).toString()
    }
}