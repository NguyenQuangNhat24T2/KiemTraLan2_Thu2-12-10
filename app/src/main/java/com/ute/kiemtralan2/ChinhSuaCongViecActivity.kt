package com.ute.kiemtralan2

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        val etChinhSuaTen = findViewById<EditText>(R.id.etChinhSuaTen)
        val etChinhSuaMoTa = findViewById<EditText>(R.id.etChinhSuaMoTa)
        val btnLuuChinhSua = findViewById<Button>(R.id.btnLuuChinhSua)

        val congViecHienTai = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("doiTuongCongViec", CongViec::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("doiTuongCongViec") as? CongViec
        }

        congViecHienTai?.let {
            etChinhSuaTen.setText(it.tenCongViec)
            etChinhSuaMoTa.setText(it.moTa)
        }

        btnLuuChinhSua.setOnClickListener {
            val tenMoi = etChinhSuaTen.text.toString().trim()
            val moTaMoi = etChinhSuaMoTa.text.toString().trim()

            if (tenMoi.isEmpty()) {
                etChinhSuaTen.error = "Ten cong viec khong duoc de trong!"
                Toast.makeText(this, "Vui long nhap ten cong viec", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            congViecHienTai?.let {
                it.tenCongViec = tenMoi
                it.moTa = moTaMoi
                // maCongViec va trangThai van duoc giu nguyen trong doi tuong
            }

            val intentKetQua = Intent().apply {
                putExtra("doiTuongCongViecDaSua", congViecHienTai)
            }
            setResult(Activity.RESULT_OK, intentKetQua)
            finish()
        }
    }
}