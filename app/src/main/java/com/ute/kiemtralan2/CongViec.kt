package com.ute.kiemtralan2

import java.io.Serializable

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: String = "Chua hoan thanh"
) : Serializable {

    // Bo sung ham tra ve chuoi thong tin cong viec
    fun layThongTinChiTiet(): String {
        return "Ten: $tenCongViec\nMo ta: $moTa\nTrang thai: $trangThai"
    }
}