package com.ute.kiemtralan2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        val etChinhSuaTen = findViewById<EditText>(R.id.etChinhSuaTen)
        val etChinhSuaMoTa = findViewById<EditText>(R.id.etChinhSuaMoTa)
        val btnLuuChinhSua = findViewById<Button>(R.id.btnLuuChinhSua)

        // Nhan du lieu hien tai de hien thi len o nhap
        val tenHienTai = intent.getStringExtra("duLieuTen") ?: ""
        val moTaHienTai = intent.getStringExtra("duLieuMoTa") ?: ""
        etChinhSuaTen.setText(tenHienTai)
        etChinhSuaMoTa.setText(moTaHienTai)

        // Xu ly su kien khi nhan Luu de tra ve ket qua
        btnLuuChinhSua.setOnClickListener {
            val tenMoi = etChinhSuaTen.text.toString()
            val moTaMoi = etChinhSuaMoTa.text.toString()

            val intentKetQua = Intent().apply {
                putExtra("tenDaSua", tenMoi)
                putExtra("moTaDaSua", moTaMoi)
            }
            setResult(Activity.RESULT_OK, intentKetQua)
            finish()
        }
    }
}