package com.example.lab2

class SinhVienModel(var tenSV: String, var mssv: String, var diemTB: Float) {

    var daTotNghiep : Boolean? = null
    var tuoi : Int? = null

    constructor(tenSV: String, mssv: String, diemTB: Float, datotnghiep: Boolean?, tuoi: Int?) : this(tenSV, mssv, diemTB){
        this.daTotNghiep = datotnghiep
        this.tuoi = tuoi
    }

    fun getThongTin() : String{
        var sDaTotNghiep : String
        if (daTotNghiep == null){
            sDaTotNghiep = "Chưa có dữ liệu"
        }else{
            if (daTotNghiep!!){
                sDaTotNghiep = "Đã tốt nghiệp"
            }else{
                sDaTotNghiep = "Chưa tốt nghiệp"
            }
        }

        var sTuoi : String
        if (tuoi == null){
            sTuoi = "Chưa có dữ liệu"
        }else{
            sTuoi = tuoi.toString()
        }
        return "Tên: $tenSV, Mã số sinh viên: $mssv, Điểm trung bình: $diemTB, Tốt nghiệp: $sDaTotNghiep, Tuổi: $sTuoi"
    }
}