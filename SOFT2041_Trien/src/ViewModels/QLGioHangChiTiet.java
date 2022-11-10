/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author hp
 */
public class QLGioHangChiTiet {

    private int stt;
    private QLGioHang idGioHang;
    private QLChiTietSP idChiTietSP;
    private int soLuong;
    private double donGia;
    private double donGiaKhiGiam;

    public QLGioHangChiTiet() {
    }

    public QLGioHangChiTiet(QLGioHang idGioHang) {
        this.idGioHang = idGioHang;
    }

    public QLGioHangChiTiet(QLChiTietSP idChiTietSP, int soLuong, double donGia) {
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public QLGioHangChiTiet(QLGioHang idGioHang, QLChiTietSP idChiTietSP, int soLuong, double donGia, double donGiaKhiGiam) {
        this.idGioHang = idGioHang;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public QLGioHang getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(QLGioHang idGioHang) {
        this.idGioHang = idGioHang;
    }

    public QLChiTietSP getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(QLChiTietSP idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public QLGioHangChiTiet(int stt) {
        this.stt = stt;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(double donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public Object[] toDataRow() {
        return new Object[]{idGioHang.getId(), idChiTietSP.getId(), soLuong, donGia, donGiaKhiGiam};
    }

}
