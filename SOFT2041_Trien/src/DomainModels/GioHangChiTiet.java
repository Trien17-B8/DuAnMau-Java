/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author hp
 */
public class GioHangChiTiet {

    private GioHang idGioHang;
    private ChiTietSP idChiTietSP;
    private int soLuong;
    private double donGia;
    private double donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(GioHang idGioHang) {
        this.idGioHang = idGioHang;
    }

    public GioHangChiTiet(ChiTietSP idChiTietSP, int soLuong, double donGia) {
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public GioHangChiTiet(GioHang idGioHang, ChiTietSP idChiTietSP, int soLuong, double donGia, double donGiaKhiGiam) {
        this.idGioHang = idGioHang;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioHang getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(GioHang idGioHang) {
        this.idGioHang = idGioHang;
    }

    public ChiTietSP getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(ChiTietSP idChiTietSP) {
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

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(double donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    @Override
    public String toString() {
        return "GioHangChiTiet{" + "idGioHang=" + idGioHang + ", idChiTietSP=" + idChiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", donGiaKhiGiam=" + donGiaKhiGiam + '}';
    }

}
