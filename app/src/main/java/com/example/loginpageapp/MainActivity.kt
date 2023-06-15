package com.example.loginpageapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginpageapp.databinding.ActivityMainBinding
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)
        setContentView(view)

        binding.btnGirisYap.setOnClickListener {
            var kayitliKullanici = preferences.getString("kullanici","")
            var kayitliparola = preferences.getString("parola","")

            var girisKullanici = binding.girisKullaniciAdi.text.toString()
            var girisParola = binding.girisParola.text.toString()

            if ((kayitliKullanici == girisKullanici) && (kayitliparola == girisParola)){

                intent = Intent(applicationContext,MainHosgeldin::class.java)
                startActivity(intent)

                }else{

                    Toast.makeText(applicationContext,"Giriş Bilgileri Hatalı",Toast.LENGTH_LONG).show()
                }




        }
        binding.btnKayitOl.setOnClickListener {
            intent = Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
        }












    }
}