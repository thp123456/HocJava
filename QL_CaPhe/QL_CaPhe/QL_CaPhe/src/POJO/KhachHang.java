/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author tranc
 */
public class KhachHang {
    String idEmp;
    String name;
    String email;
    String address;
    int birthYear;
    String phone;
    float diemThuong;
    public KhachHang() {
    }

     public KhachHang(String idEmp, String name, String email, String address, int birthYear, String phone, float diemThuong) {
        this.idEmp = idEmp;
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthYear = birthYear;
        this.phone = phone;
        this.diemThuong = diemThuong;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getDiemThuong() {
        return diemThuong;
    }

    public void setDiemThuong(float diemThuong) {
        this.diemThuong = diemThuong;
    }
    
}
