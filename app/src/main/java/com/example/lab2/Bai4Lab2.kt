package com.example.lab2

var listSV = mutableListOf<SinhVienModel>()

fun main(){
    danhsach(listSV)
    menu()
}

fun menu(){
    var r : String?
    do {
        println("\t\tBai4 Lab2")
        println("\t1. Hiển thị danh sách sinh viên")
        println("\t2. Thêm sinh viên mới")
        println("\t3. Sửa sinh viên theo mssv")
        println("\t4. Xóa sinh viên theo mssv")
        println("Nhập số bạn muốn : ")
        var s = readLine()
        optionMenu(s!!)

        println("Bạn có muốn tiếp tục không (nhấn n để thoát) ?")
        r = readLine()
        if (r == "n"){
            break
        }
    }while (true)
}

fun optionMenu(so : Any){
    val result = when(so){
        "1" -> loadDS(listSV)
        "2" -> addSV(listSV)
        "3" -> editSV(listSV)
        "4" -> xoaSinhVien(listSV)
        else -> println("Nhập 1-4")
    }
    return result
}



fun  loadDS(list :MutableList<SinhVienModel>){
    for (i in list.indices){
        println("Sinh viên thứ ${i+1} - ${list.get(i).getThongTin()}")
    }
}
fun danhsach(list : MutableList<SinhVienModel>){
    println("Danh sách sinh viên : ")
    val sv1 = SinhVienModel("Vũ Thị Vân Anh", "42837", 8f)

    val sv2 = SinhVienModel("Nguyễn Thế Kỳ Anh","42900", 7f)

    sv2.daTotNghiep = false
    sv2.tuoi = 22

    val sv3 = SinhVienModel("Nguyễn Hoàng Long", "PH42637", 8.5f, false, 22)

    list.add(sv1)
    list.add(sv2)
    list.add(sv3)
}

fun addSV(list: MutableList<SinhVienModel>){
    println("Nhập tên sinh viên : ")
    var ten = readLine().toString()
    println("Nhập mã sinh viên : ")
    var mssv = readLine().toString()
    println("Nhập điểm TB : ")
    var diemTB = readLine().toString().toFloat()
    println("Đã tốt nghiệp chưa (y/n): ")
    var daTotNghiep : Boolean?
    var s = readLine()
    if (s == "y"){
        daTotNghiep = true
    }else if (s == "n"){
        daTotNghiep = false
    }else{
        daTotNghiep = null
    }
    println("Nhập tuổi : ")
    var tuoi : Int?
    tuoi = readLine()?.toIntOrNull()


    val sv = SinhVienModel(ten,mssv,diemTB,daTotNghiep,tuoi);
    list.add(sv)
    println("\t\tThêm thành công sinh viên : ${sv.tenSV}")
    println("Danh sách sinh viên mới ")
    loadDS(list)
}

fun xoaSinhVien(list : MutableList<SinhVienModel>){
    println("Nhập mssv bạn muốn xóa : ")
    var maSearch = readLine()
    var i = true
    for(sinhvien in list){
        if (sinhvien.mssv.equals(maSearch)){
            list.remove(sinhvien)
            println("Xóa thành công sinh vien có mssv : $maSearch")
            i = false
            break
        }
    }
    if (i){
        println("Không tìm thấy sinh viên nào có mssv : $maSearch")
    }

    println("Danh sách sinh viên mới ")
    loadDS(list)
}

fun editSV(list: MutableList<SinhVienModel>){
    println("Nhập mssv bạn muốn sửa : ")
    var maSearch = readLine()
    var i = true
    for(sinhvien in list){
        if (sinhvien.mssv.equals(maSearch)){
            println("Nhập tên sinh viên : ")
            sinhvien.tenSV = readLine().toString()
            println("Nhập mã sinh viên : ")
            sinhvien.mssv = readLine().toString()
            println("Nhập điểm TB : ")
            sinhvien.diemTB = readLine().toString().toFloat()
            println("Đã tốt nghiệp chưa (y/n): ")
            var s = readLine()
            if (s == "y"){
                sinhvien.daTotNghiep = true
            }else if (s == "n"){
                sinhvien.daTotNghiep = false
            }else{
                sinhvien.daTotNghiep = null
            }
            println("Nhập tuổi : ")
            sinhvien.tuoi = readLine()?.toIntOrNull()

            println("Sửa thành công sinh vien có mssv : $maSearch thành ${sinhvien.mssv}")
            i = false
            break
        }
    }
    if (i){
        println("Không tìm thấy sinh viên nào có mssv : $maSearch")
    }else{
        println("Danh sách sinh viên mới ")
        loadDS(list)
    }
}

