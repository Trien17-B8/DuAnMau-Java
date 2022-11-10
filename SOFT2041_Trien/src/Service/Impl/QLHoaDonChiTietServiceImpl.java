/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.ChiTietSP;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.SanPham;
import Repository.HoaDonChiTietRepository;
import Repository.IHoaDonChiTietRepository;
import Service.QLHoaDonChiTietService;
import ViewModels.QLChiTietSP;
import ViewModels.QLHoaDon;
import ViewModels.QLHoaDonChiTiet;
import ViewModels.QLSanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLHoaDonChiTietServiceImpl implements QLHoaDonChiTietService {

    private final IHoaDonChiTietRepository re = new HoaDonChiTietRepository();
    private final List<QLHoaDonChiTiet> listHDCT = new ArrayList<>();

    @Override
    public List<QLHoaDonChiTiet> getAll() {
        listHDCT.clear();
        for (HoaDonChiTiet hdct : re.getAll()) {
            QLHoaDon idHD = new QLHoaDon(hdct.getIdHoaDon().getId());
            QLChiTietSP idCTSP = new QLChiTietSP(hdct.getIdChiTietSP().getId());
            QLHoaDonChiTiet qlhdct = new QLHoaDonChiTiet(idHD, idCTSP, hdct.getSoLuong(), hdct.getDonGia());
            listHDCT.add(qlhdct);
        }
        return listHDCT;
    }

    @Override
    public String insert(QLHoaDonChiTiet qlhdct) {
        HoaDon idHD = new HoaDon(qlhdct.getIdHoaDon().getId());
        ChiTietSP idCTSP = new ChiTietSP(qlhdct.getIdChiTietSP().getId());
        HoaDonChiTiet hdct = new HoaDonChiTiet(idHD, idCTSP, qlhdct.getSoLuong(), qlhdct.getDonGia());
        if (re.insert(hdct)) {
            return "Thanh Cong";
        } else {
            return "That Bia";
        }
    }

    @Override
    public String update(QLHoaDonChiTiet qlhdct, UUID id) {
        HoaDon idHD = new HoaDon(qlhdct.getIdHoaDon().getId());
        ChiTietSP idCTSP = new ChiTietSP(qlhdct.getIdChiTietSP().getId());
        HoaDonChiTiet hdct = new HoaDonChiTiet(idHD, idCTSP, qlhdct.getSoLuong(), qlhdct.getDonGia());
        if (re.update(hdct, id)) {
            return "Thanh Cong";
        } else {
            return "That Bia";
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

    

    @Override
    public List<QLHoaDonChiTiet> getFrmGH() {
        listHDCT.clear();
        for (HoaDonChiTiet x : re.getFrmGH()) {
            QLSanPham qlsp = new QLSanPham(x.getIdChiTietSP().getIdSP().getMa(), x.getIdChiTietSP().getIdSP().getTen());
            QLChiTietSP qlctsp = new QLChiTietSP(qlsp);
            QLHoaDonChiTiet qlghct = new QLHoaDonChiTiet(qlctsp, x.getSoLuong(), x.getDonGia());
            listHDCT.add(qlghct);
        }
        return listHDCT;
    }

    @Override
    public List<QLHoaDonChiTiet> getFrmGHid(UUID id) {
        listHDCT.clear();
        for (HoaDonChiTiet x : re.getFrmGHId(id)) {
            QLSanPham qlsp = new QLSanPham(x.getIdChiTietSP().getIdSP().getMa(), x.getIdChiTietSP().getIdSP().getTen());
            QLChiTietSP qlctsp = new QLChiTietSP(qlsp);
            QLHoaDonChiTiet qlghct = new QLHoaDonChiTiet(qlctsp, x.getSoLuong(), x.getDonGia());
            listHDCT.add(qlghct);
        }
        return listHDCT;
    }
    
    public static void main(String[] args) {
        
        System.out.println(new QLHoaDonChiTietServiceImpl().getFrmGHid(UUID.fromString("F42781C5-ABC1-48AB-B7EC-9CF212B146B0")));
    }

}
