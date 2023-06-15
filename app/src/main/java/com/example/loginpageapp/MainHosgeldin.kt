package com.example.loginpageapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.loginpageapp.databinding.ActivityMainHosgeldinBinding

class MainHosgeldin : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainHosgeldinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // burada xmlden verileri çekeceğim
        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)
        var kayitliKullanici = preferences.getString("kullanici","")
        var kayitliParola = preferences.getString("parola","")
        // textviewlere kayıtlı bilgileri aktardım
        binding.kullaniciBilgisi.text= "Kullanıcı Adı: "+kayitliKullanici.toString()
        binding.kullaniciParola.text= "Kullanıcı Parolası: "+kayitliParola.toString()
// çıkış yapacak
        binding.btnCikisYap.setOnClickListener {
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()


        }
    }
}