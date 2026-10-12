package com.ute.kiemtralan2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvHienThiTen: TextView
    private lateinit var tvHienThiMoTa: TextView
    private var tenHienTai: String = ""
    private var moTaHienTai: String = ""

    // 1. Dang ky Activity Result API
    private val boKetQuaChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua ->
        if (ketQua.resultCode == Activity.RESULT_OK) {
            val duLieuNhanVe = ketQua.data
            val tenMoi = duLieuNhanVe?.getStringExtra("tenDaSua") ?: tenHienTai
            val moTaMoi = duLieuNhanVe?.getStringExtra("moTaDaSua") ?: moTaHienTai

            // 2. Cap nhat du lieu va giao dien
            tenHienTai = tenMoi
            moTaHienTai = moTaMoi
            tvHienThiTen.text = "Ten cong viec: $tenHienTai"
            tvHienThiMoTa.text = "Mo ta cong viec: $moTaHienTai"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvHienThiTen = findViewById(R.id.tvHienThiTen)
        tvHienThiMoTa = findViewById(R.id.tvHienThiMoTa)
        val btnChinhSua = findViewById<Button>(R.id.btnChinhSua)

        tenHienTai = intent.getStringExtra("duLieuTen") ?: ""
        moTaHienTai = intent.getStringExtra("duLieuMoTa") ?: ""

        tvHienThiTen.text = "Ten cong viec: $tenHienTai"
        tvHienThiMoTa.text = "Mo ta cong viec: $moTaHienTai"

        // Mo man hinh ChinhSuaCongViecActivity bang Activity Result API
        btnChinhSua.setOnClickListener {
            val intentChuyenSua = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("duLieuTen", tenHienTai)
                putExtra("duLieuMoTa", moTaHienTai)
            }
            boKetQuaChinhSua.launch(intentChuyenSua)
        }
    }
}