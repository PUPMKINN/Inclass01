import java.util.Scanner

// Lớp cha chứa thông tin chung của nhân viên
open class NhanVien(
    var maNhanVien: String,
    var hoTen: String,
    var ngaySinh: String,
    var diaChi: String
) {
    // Hàm nhập thông tin nhân viên
    open fun nhapThongTin() {
        val scanner = Scanner(System.`in`)
        println("Nhập thông tin nhân viên:")
        print("Mã nhân viên: ")
        maNhanVien = scanner.nextLine()
        print("Họ tên: ")
        hoTen = scanner.nextLine()
        print("Ngày sinh: ")
        ngaySinh = scanner.nextLine()
        print("Địa chỉ: ")
        diaChi = scanner.nextLine()
    }

    // Hàm xuất thông tin nhân viên
    open fun xuatThongTin() {
        println("Thông tin nhân viên:")
        println("Mã nhân viên: $maNhanVien")
        println("Họ tên: $hoTen")
        println("Ngày sinh: $ngaySinh")
        println("Địa chỉ: $diaChi")
    }
}

// Lớp con kế thừa từ lớp cha, đại diện cho nhân viên sản xuất
class NVSanXuat(
    maNhanVien: String,
    hoTen: String,
    ngaySinh: String,
    diaChi: String,
    var soSanPham: Int
) : NhanVien(maNhanVien, hoTen, ngaySinh, diaChi) {

    // Hàm nhập thông tin nhân viên sản xuất
    override fun nhapThongTin() {
        super.nhapThongTin()
        val scanner = Scanner(System.`in`)
        print("Số sản phẩm: ")
        soSanPham = scanner.nextInt()
    }

    // Hàm xuất thông tin nhân viên sản xuất
    override fun xuatThongTin() {
        super.xuatThongTin()
        println("Số sản phẩm: $soSanPham")
    }

    // Hàm tính lương của nhân viên sản xuất
    fun tinhLuong(): Double {
        return soSanPham * 20000.0
    }

    // 5 constructors cho lớp NVSanXuat
    constructor() : this("", "", "", "", 0)
    constructor(maNhanVien: String, hoTen: String) : this(maNhanVien, hoTen, "", "", 0)
    constructor(maNhanVien: String, hoTen: String, soSanPham: Int) : this(maNhanVien, hoTen, "", "", soSanPham)
    constructor(maNhanVien: String, hoTen: String, ngaySinh: String, diaChi: String) : this(maNhanVien, hoTen, ngaySinh, diaChi, 0)
}

// Lớp con kế thừa từ lớp cha, đại diện cho nhân viên công nhật
class NVCongNhat(
    maNhanVien: String,
    hoTen: String,
    ngaySinh: String,
    diaChi: String,
    var soNgay: Int
) : NhanVien(maNhanVien, hoTen, ngaySinh, diaChi) {

    // Hàm nhập thông tin nhân viên công nhật
    override fun nhapThongTin() {
        super.nhapThongTin()
        val scanner = Scanner(System.`in`)
        print("Số ngày làm việc: ")
        soNgay = scanner.nextInt()
    }

    // Hàm xuất thông tin nhân viên công nhật
    override fun xuatThongTin() {
        super.xuatThongTin()
        println("Số ngày làm việc: $soNgay")
    }

    // Hàm tính lương của nhân viên công nhật
    fun tinhLuong(): Double {
        return soNgay * 300000.0
    }

    // 5 constructors cho lớp NVCongNhat
    constructor() : this("", "", "", "", 0)
    constructor(maNhanVien: String, hoTen: String) : this(maNhanVien, hoTen, "", "", 0)
    constructor(maNhanVien: String, hoTen: String, soNgay: Int) : this(maNhanVien, hoTen, "", "", soNgay)
    constructor(maNhanVien: String, hoTen: String, ngaySinh: String, diaChi: String) : this(maNhanVien, hoTen, ngaySinh, diaChi, 0)
}

fun main() {
    val scanner = Scanner(System.`in`)
    var choice: Int

    // Danh sách nhân viên
    val nhanVienSanXuat = NVSanXuat()
    val nhanVienCongNhat = NVCongNhat()

    do {
        println("\n----- MENU -----")
        println("1. Nhập thông tin nhân viên sản xuất")
        println("2. Nhập thông tin nhân viên công nhật")
        println("3. Xuất thông tin nhân viên sản xuất")
        println("4. Xuất thông tin nhân viên công nhật")
        println("5. Tính lương nhân viên sản xuất")
        println("6. Tính lương nhân viên công nhật")
        println("0. Thoát")

        print("Chọn chức năng (0-6): ")
        choice = scanner.nextInt()

        when (choice) {
            1 -> {
                nhanVienSanXuat.nhapThongTin()
                println("Thông tin nhân viên sản xuất đã được nhập.")
            }
            2 -> {
                nhanVienCongNhat.nhapThongTin()
                println("Thông tin nhân viên công nhật đã được nhập.")
            }
            3 -> {
                nhanVienSanXuat.xuatThongTin()
                println("Lương nhân viên sản xuất: ${nhanVienSanXuat.tinhLuong()} VND")
            }
            4 -> {
                nhanVienCongNhat.xuatThongTin()
                println("Lương nhân viên công nhật: ${nhanVienCongNhat.tinhLuong()} VND")
            }
            5 -> println("Lương nhân viên sản xuất: ${nhanVienSanXuat.tinhLuong()} VND")
            6 -> println("Lương nhân viên công nhật: ${nhanVienCongNhat.tinhLuong()} VND")
            0 -> println("Ứng dụng kết thúc.")
            else -> println("Chức năng không hợp lệ. Vui lòng chọn lại.")
        }

    } while (choice != 0)
}

