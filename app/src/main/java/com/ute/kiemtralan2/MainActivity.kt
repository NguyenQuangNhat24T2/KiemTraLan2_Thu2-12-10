package com.ute.kiemtralan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTenCongViec = findViewById<EditText>(R.id.etTenCongViec)
        val etMoTaCongViec = findViewById<EditText>(R.id.etMoTaCongViec)
        val btnTaoCongViec = findViewById<Button>(R.id.btnTaoCongViec)

        btnTaoCongViec.setOnClickListener {
            val ten = etTenCongViec.text.toString().trim()
            val moTa = etMoTaCongViec.text.toString().trim()

            // Kiem tra khong cho phep ten cong viec de trong
            if (ten.isEmpty()) {
                etTenCongViec.error = "Ten cong viec khong duoc de trong!"
                Toast.makeText(this, "Vui long nhap ten cong viec", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val doiTuongCongViec = CongViec(tenCongViec = ten, moTa = moTa)

            val intentChuyenManHinh = Intent(this, ChiTietCongViecActivity::class.java).apply {
                putExtra("doiTuongCongViec", doiTuongCongViec)
            }
            startActivity(intentChuyenManHinh)
        }
    }
}