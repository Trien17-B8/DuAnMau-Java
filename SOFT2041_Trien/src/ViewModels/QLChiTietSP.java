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
public class QLChiTietSP {

    private UUID id;
    private int stt;
    private QLSanPham idSP;
    private QLNSX idNSX;
    private QLMauSac idMauSac;
    private QLDongSP idDongSP;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private double giaNhap;
    private double giaBan;

    public QLChiTietSP(QLSanPham idSP) {
        this.idSP = idSP;
    }
    

    public QLChiTietSP() {
    }

    public QLChiTietSP(UUID id) {
        this.id = id;
    }

    public QLChiTietSP(UUID id, QLSanPham idSP, QLNSX idNSX, QLMauSac idMauSac, QLDongSP idDongSP, int namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
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

    public QLChiTietSP(QLSanPham idSP, QLNSX idNSX, QLMauSac idMauSac, QLDongSP idDongSP, int namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
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

    public QLChiTietSP( QLSanPham idSP, int namBH, String moTa, int soLuongTon, double giaNhap, double giaBan) {
        this.idSP = idSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public QLSanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(QLSanPham idSP) {
        this.idSP = idSP;
    }

    public QLNSX getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(QLNSX idNSX) {
        this.idNSX = idNSX;
    }

    public QLMauSac getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(QLMauSac idMauSac) {
        this.idMauSac = idMauSac;
    }

    public QLDongSP getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(QLDongSP idDongSP) {
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

    public Object[] toDataRow() {
        return new Object[]{id, idSP.getTen(), idNSX.getTen(), idMauSac.getTen(), idDongSP.getTen(), namBH, moTa, soLuongTon, giaNhap, giaBan};
    }

    public Object[] frmDataRow(){
        return new Object[]{stt, idSP.getMa(), idSP.getTen(), namBH,moTa, soLuongTon, giaNhap, giaBan};
    }
    
    
}
