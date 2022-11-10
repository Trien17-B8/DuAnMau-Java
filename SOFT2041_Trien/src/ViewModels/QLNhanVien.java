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
public class QLNhanVien {
    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    private QLCuaHang idCh;
    private QLChucVu idCv;
    private QLNhanVien idGuiBC;
    private int trangThai;

    public QLNhanVien() {
    }

    public QLNhanVien(UUID id) {
        this.id = id;
    }

    public QLNhanVien(String ten) {
        this.ten = ten;
    }

    public QLNhanVien(UUID id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public QLNhanVien(UUID id, String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, QLCuaHang idCh, QLChucVu idCv, QLNhanVien idGuiBC, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCh = idCh;
        this.idCv = idCv;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
    }

    public QLNhanVien(String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, QLCuaHang idCh, QLChucVu idCv, QLNhanVien idGuiBC, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCh = idCh;
        this.idCv = idCv;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;
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

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public QLCuaHang getIdCh() {
        return idCh;
    }

    public void setIdCh(QLCuaHang idCh) {
        this.idCh = idCh;
    }

    public QLChucVu getIdCv() {
        return idCv;
    }

    public void setIdCv(QLChucVu idCv) {
        this.idCv = idCv;
    }

    public QLNhanVien getIdGuiBC() {
        return idGuiBC;
    }

    public void setIdGuiBC(QLNhanVien idGuiBC) {
        this.idGuiBC = idGuiBC;
    }
    
    public String hoTen(){
        return ho+" "+tenDem+" "+ten;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "QLNhanVien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", tenDem=" + tenDem + ", ho=" + ho + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", matKhau=" + matKhau + ", idCh=" + idCh + ", idCv=" + idCv + ", idGuiBC=" + idGuiBC + ", trangThai=" + trangThai + '}';
    }

    public Object[] toDataRow(){
        return new Object[]{id, ma, ho +" "+tenDem+" "+ten,gioiTinh, ngaySinh, diaChi, sdt, matKhau, idCh.getTen(), idCv.getTen(), idGuiBC.getTen(), trangThai==0?"Hoat Dong":"Khong Hoat Dong"};
    }

}
