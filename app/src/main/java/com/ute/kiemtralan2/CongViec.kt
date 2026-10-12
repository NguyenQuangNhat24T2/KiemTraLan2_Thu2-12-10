package com.ute.kiemtralan2

import java.io.Serializable

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: String = "Chua hoan thanh"
) : Serializable