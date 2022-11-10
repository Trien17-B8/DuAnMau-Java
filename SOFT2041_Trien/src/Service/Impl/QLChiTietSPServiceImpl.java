/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.ChiTietSP;
import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
import Repository.ChiTietSPRepository;
import Repository.IChiTietSPRepository;
import Service.QLChiTietSPService;
import ViewModels.QLChiTietSP;
import ViewModels.QLDongSP;
import ViewModels.QLMauSac;
import ViewModels.QLNSX;
import ViewModels.QLSanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLChiTietSPServiceImpl implements QLChiTietSPService {

    private final IChiTietSPRepository re = new ChiTietSPRepository();
    private final List<QLChiTietSP> listQLSP = new ArrayList<>();

    @Override
    public List<QLChiTietSP> getAll() {
        listQLSP.clear();
        for (ChiTietSP x : re.getAll()) {
            QLSanPham idSP = new QLSanPham(x.getIdSP().getId(), x.getIdSP().getTen());
            QLNSX idNSX = new QLNSX(x.getIdNSX().getId(), x.getIdNSX().getTen());
            QLMauSac idMauSac = new QLMauSac(x.getIdMauSac().getId(), x.getIdMauSac().getTen());
            QLDongSP idDongSP = new QLDongSP(x.getIdDongSP().getId(), x.getIdDongSP().getTen());
            QLChiTietSP chiTietSP = new QLChiTietSP(x.getId(), idSP, idNSX, idMauSac, idDongSP, x.getNamBH(), x.getMoTa(), x.getSoLuongTon(), x.getGiaNhap(), x.getGiaBan());
            listQLSP.add(chiTietSP);
        }
        return listQLSP;
    }

    @Override
    public String insert(QLChiTietSP qlctsp) {
        SanPham idSP = new SanPham(qlctsp.getIdSP().getId());
        NSX idNSX = new NSX(qlctsp.getIdNSX().getId());
        MauSac idMauSac = new MauSac(qlctsp.getIdMauSac().getId());
        DongSP idDongSP = new DongSP(qlctsp.getIdDongSP().getId());
        ChiTietSP chiTietSP = new ChiTietSP(idSP, idNSX, idMauSac, idDongSP, qlctsp.getNamBH(), qlctsp.getMoTa(), qlctsp.getSoLuongTon(), qlctsp.getGiaNhap(), qlctsp.getGiaBan());
        if(re.insert(chiTietSP)){
            return "Thanh Cong";
        }else{
            return "That Bai";
        }
    }

    @Override
    public String update(QLChiTietSP qlctsp, UUID id) {
        SanPham idSP = new SanPham(qlctsp.getIdSP().getId());
        NSX idNSX = new NSX(qlctsp.getIdNSX().getId());
        MauSac idMauSac = new MauSac(qlctsp.getIdMauSac().getId());
        DongSP idDongSP = new DongSP(qlctsp.getIdDongSP().getId());
        ChiTietSP chiTietSP = new ChiTietSP( idSP, idNSX, idMauSac, idDongSP, qlctsp.getNamBH(), qlctsp.getMoTa(), qlctsp.getSoLuongTon(), qlctsp.getGiaNhap(), qlctsp.getGiaBan());
        if(re.update(chiTietSP, id)){
            return "Thanh Cong";
        }else{
            return "That Bai";
        }
    }

    @Override
    public String delete(UUID id) {
        if(re.delete(id)){
            return "Thanh Cong";
        }else{
            return "That Bai";
        }
    }

    @Override
    public List<QLChiTietSP> getFrmBH() {
        listQLSP.clear();
        for (ChiTietSP x : re.getFrmBH()) {
            QLSanPham sp = new QLSanPham(x.getIdSP().getMa(), x.getIdSP().getTen());
            QLChiTietSP ctsp = new QLChiTietSP(sp, x.getNamBH(), x.getMoTa(), x.getSoLuongTon(), x.getGiaBan(), x.getGiaNhap());
            listQLSP.add(ctsp);
        }
        return listQLSP ;
    }

    @Override
    public List<QLChiTietSP> getFrmFinal() {
        for (ChiTietSP chiTietSP : re.getFrmFinal()) {
            QLSanPham qLSanPham = new QLSanPham(chiTietSP.getIdSP().getId());
            QLChiTietSP qlctsp = new QLChiTietSP(qLSanPham, chiTietSP.getMoTa(), chiTietSP.getSoLuongTon(), chiTietSP.getGiaNhap(), chiTietSP.getGiaBan());
            listQLSP.add(qlctsp);
        }
        return listQLSP;
    }

}
