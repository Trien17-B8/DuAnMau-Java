/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLHoaDon {
    private UUID id;
    private QLKhachHang idKH;
    private int stt;
    private QLNhanVien idNV;
    private String ma;
    private Date ngayTao;
    private Date ngayThanhToan;
    private Date ngayShip;
    private Date ngayNhan;
    private int tinhTrang;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;

    public QLHoaDon() {
    }

    public QLHoaDon(UUID id, QLNhanVien idNV, String ma, Date ngayTao, int tinhTrang) {
        this.id = id;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public QLHoaDon(QLNhanVien idNV, String ma, Date ngayTao, int tinhTrang) {
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.tinhTrang = tinhTrang;
    }

    public QLHoaDon(UUID id) {
        this.id = id;
    }

    public QLHoaDon(UUID id, QLKhachHang idKH, QLNhanVien idNV, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public QLHoaDon(QLKhachHang idKH, QLNhanVien idNV, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, int tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        this.idKH = idKH;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public QLKhachHang getIdKH() {
        return idKH;
    }

    public void setIdKH(QLKhachHang idKH) {
        this.idKH = idKH;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public QLNhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(QLNhanVien idNV) {
        this.idNV = idNV;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Date getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(Date ngayShip) {
        this.ngayShip = ngayShip;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    public Object[] toDataRow(){
        return new Object[]{id, idKH.getTen(), idNV.getTen(), ma, ngayTao, ngayThanhToan, ngayShip, ngayNhan, tinhTrang==1?"Da Thanh Toan":"Chua Thanh Toan", tenNguoiNhan, diaChi, sdt};
    }
    
    public Object[] frmHDDataRow(){
        return new Object[] {stt, ma, ngayTao, idNV.getTen(),tinhTrang==0?"Chua Thanh Toan":"Da Thanh Toan"};
    }
}
