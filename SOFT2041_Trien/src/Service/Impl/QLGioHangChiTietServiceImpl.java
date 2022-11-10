/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.ChiTietSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;
import DomainModels.SanPham;
import Repository.GioHangChiTietRepository;
import Repository.IGioHangChiTietRepository;
import Service.QLGioHangChiTietService;
import ViewModels.QLChiTietSP;
import ViewModels.QLGioHang;
import ViewModels.QLGioHangChiTiet;
import ViewModels.QLSanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLGioHangChiTietServiceImpl implements QLGioHangChiTietService {

    private final IGioHangChiTietRepository re = new GioHangChiTietRepository();
    private final List<QLGioHangChiTiet> listQL = new ArrayList<>();

    @Override
    public List<QLGioHangChiTiet> getAll() {
        listQL.clear();
        for (GioHangChiTiet x : re.getAll()) {
            QLGioHang idGioHang = new QLGioHang(x.getIdGioHang().getId());
            QLChiTietSP idChiTietSP = new QLChiTietSP(x.getIdChiTietSP().getId());
            QLGioHangChiTiet qlghct = new QLGioHangChiTiet(idGioHang, idChiTietSP, x.getSoLuong(), x.getDonGia(), x.getDonGiaKhiGiam());
            listQL.add(qlghct);
        }
        return listQL;
    }

    @Override
    public String insert(QLGioHangChiTiet qlghct) {
        GioHang idGioHang = new GioHang(qlghct.getIdGioHang().getId());
        ChiTietSP idChiTietSP = new ChiTietSP(qlghct.getIdChiTietSP().getId());
        GioHangChiTiet ghct = new GioHangChiTiet(idGioHang, idChiTietSP, qlghct.getSoLuong(), qlghct.getDonGia(), qlghct.getDonGiaKhiGiam());
        if (re.insert(ghct)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(QLGioHangChiTiet qlghct, UUID id) {
        GioHang idGH = new GioHang(qlghct.getIdGioHang().getId());
        ChiTietSP idChiTietSP = new ChiTietSP(qlghct.getIdChiTietSP().getId());
        GioHangChiTiet ghct = new GioHangChiTiet(idGH, idChiTietSP, qlghct.getSoLuong(), qlghct.getDonGia(), qlghct.getDonGiaKhiGiam());
        if (re.update(ghct, id)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String delete(UUID id) {
        if (re.delete(id)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

}
