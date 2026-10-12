package com.ute.kiemtralan2

import java.io.Serializable

class CongViec(
    var maCongViec: String = "CV01",
    var tenCongViec: String,
    var moTa: String,
    var trangThai: String = "Chua hoan thanh"
) : Serializable {

    fun layThongTinChiTiet(): String {
        return "Ma: $maCongViec\nTen: $tenCongViec\nMo ta: $moTa\nTrang thai: $trangThai"
    }

    // Ham bo sung theo yeu cau de 1
    fun laDaHoanThanh(): Boolean {
        return trangThai.equals("Da hoan thanh", ignoreCase = true)
    }
}