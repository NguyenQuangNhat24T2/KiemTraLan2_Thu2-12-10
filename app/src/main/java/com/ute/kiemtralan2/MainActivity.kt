package com.ute.kiemtralan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTenCongViec = findViewById<EditText>(R.id.etTenCongViec)
        val etMoTaCongViec = findViewById<EditText>(R.id.etMoTaCongViec)
        val btnTaoCongViec = findViewById<Button>(R.id.btnTaoCongViec)

        btnTaoCongViec.setOnClickListener {
            val ten = etTenCongViec.text.toString()
            val moTa = etMoTaCongViec.text.toString()

            val intentChuyenManHinh = Intent(this, ChiTietCongViecActivity::class.java)
            intentChuyenManHinh.putExtra("duLieuTen", ten)
            intentChuyenManHinh.putExtra("duLieuMoTa", moTa)
            startActivity(intentChuyenManHinh)
        }
    }
}