/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLCuaHang {

    private UUID id;
    private String ma;
    private String ten;
    private String diaChi;
    private String thanhPho;
    private String quocGia;

    public QLCuaHang() {
    }

    public QLCuaHang(UUID id) {
        this.id = id;
    }

    public QLCuaHang(UUID id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public QLCuaHang(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    
    public QLCuaHang(String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

    
    public QLCuaHang(UUID id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return "CuaHang{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", diaChi=" + diaChi + ", thanhPho=" + thanhPho + ", quocGia=" + quocGia + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{id, ma, ten, diaChi, thanhPho, quocGia};
    }
}
