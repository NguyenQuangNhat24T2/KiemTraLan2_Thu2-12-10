package com.ute.kiemtralan2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        val tvHienThiTen = findViewById<TextView>(R.id.tvHienThiTen)
        val tvHienThiMoTa = findViewById<TextView>(R.id.tvHienThiMoTa)

        val ten = intent.getStringExtra("duLieuTen") ?: ""
        val moTa = intent.getStringExtra("duLieuMoTa") ?: ""

        tvHienThiTen.text = "Ten cong viec: $ten"
        tvHienThiMoTa.text = "Mo ta cong viec: $moTa"
    }
}