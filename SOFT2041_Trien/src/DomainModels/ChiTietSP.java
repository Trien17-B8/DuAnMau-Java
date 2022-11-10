/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.UUID;

/**
 *
 * @author hp
 */
public class ChiTietSP {

    private UUID id;
    private SanPham idSP;
    private NSX idNSX;
    private MauSac idMauSac;
    private DongSP idDongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private double giaNhap;
    private double giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(UUID id) {
        this.id = id;
    }

    public ChiTietSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public ChiTietSP(SanPham idSP, int namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        this.idSP = idSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSP(UUID id, SanPham idSP, NSX idNSX, MauSac idMauSac, DongSP idDongSP, int namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        this.id = id;
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSP(SanPham idSP, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        this.idSP = idSP;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSP(UUID id, SanPham idSP) {
        this.id = id;
        this.idSP = idSP;
    }

    public ChiTietSP(SanPham idSP, NSX idNSX, MauSac idMauSac, DongSP idDongSP, int namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        this.idSP = idSP;
        this.idNSX = idNSX;
        this.idMauSac = idMauSac;
        this.idDongSP = idDongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public NSX getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(NSX idNSX) {
        this.idNSX = idNSX;
    }

    public MauSac getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(MauSac idMauSac) {
        this.idMauSac = idMauSac;
    }

    public DongSP getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(DongSP idDongSP) {
        this.idDongSP = idDongSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" + "id=" + id + ", idSP=" + idSP + ", idNSX=" + idNSX + ", idMauSac=" + idMauSac + ", idDongSP=" + idDongSP + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuongTon=" + soLuongTon + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + '}';
    }

}
