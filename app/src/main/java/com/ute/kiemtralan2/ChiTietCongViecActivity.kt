package com.ute.kiemtralan2

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvHienThiTen: TextView
    private lateinit var tvHienThiMoTa: TextView
    private var congViecHienTai: CongViec? = null

    private val boKetQuaChinhSua = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua ->
        if (ketQua.resultCode == Activity.RESULT_OK) {
            val duLieuNhanVe = ketQua.data
            val congViecCapNhat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                duLieuNhanVe?.getSerializableExtra("doiTuongCongViecDaSua", CongViec::class.java)
            } else {
                @Suppress("DEPRECATION")
                duLieuNhanVe?.getSerializableExtra("doiTuongCongViecDaSua") as? CongViec
            }

            congViecCapNhat?.let {
                congViecHienTai = it
                capNhatGiaoDien()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvHienThiTen = findViewById(R.id.tvHienThiTen)
        tvHienThiMoTa = findViewById(R.id.tvHienThiMoTa)
        val btnChinhSua = findViewById<Button>(R.id.btnChinhSua)

        congViecHienTai = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("doiTuongCongViec", CongViec::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("doiTuongCongViec") as? CongViec
        }

        capNhatGiaoDien()

        btnChinhSua.setOnClickListener {
            val intentChuyenSua = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("doiTuongCongViec", congViecHienTai)
            }
            boKetQuaChinhSua.launch(intentChuyenSua)
        }
    }

    private fun capNhatGiaoDien() {
        congViecHienTai?.let {
            tvHienThiTen.text = "Ten cong viec: ${it.tenCongViec}"
            tvHienThiMoTa.text = "Mo ta cong viec: ${it.moTa}"
        }
    }
}