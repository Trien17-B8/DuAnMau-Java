/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author hp
 */
public class QLHoaDonChiTiet {

    private int stt;
    private QLHoaDon idHoaDon;
    private QLChiTietSP idChiTietSP;
    private int soLuong;
    private double donGia;

    public QLHoaDonChiTiet() {
    }

    public QLHoaDonChiTiet(QLHoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public QLHoaDonChiTiet(QLChiTietSP idChiTietSP, int soLuong, double donGia) {
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public QLHoaDonChiTiet(QLHoaDon idHoaDon, QLChiTietSP idChiTietSP, int soLuong, double donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public QLHoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(QLHoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
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

    public double thanhTien() {
        return soLuong * donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public Object[] toDataRow() {
        return new Object[]{idHoaDon.getId(), idChiTietSP.getId(), soLuong, donGia};
    }

    public Object[] frmGioHang() {
        return new Object[]{stt, idChiTietSP.getIdSP().getMa(), idChiTietSP.getIdSP().getTen(), soLuong, donGia, thanhTien()};
    }
}
