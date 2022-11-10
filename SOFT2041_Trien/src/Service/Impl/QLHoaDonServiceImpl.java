/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Repository.HoaDonRepository;
import Repository.IHoaDonRepository;
import Service.QLHoaDonService;
import ViewModels.QLHoaDon;
import ViewModels.QLKhachHang;
import ViewModels.QLNhanVien;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLHoaDonServiceImpl implements QLHoaDonService {

    private final IHoaDonRepository re = new HoaDonRepository();
    private final List<QLHoaDon> listQL = new ArrayList<>();

    @Override
    public List<QLHoaDon> getAll() {
        listQL.clear();
        for (HoaDon x : re.getAll()) {
            QLKhachHang idKH = new QLKhachHang(x.getIdKH().getId(), x.getIdKH().getTen());
            QLNhanVien idNV = new QLNhanVien(x.getIdNV().getId(), x.getIdNV().getTen());
            QLHoaDon qlhd = new QLHoaDon(x.getId(), idKH, idNV, x.getMa(), x.getNgayTao(), x.getNgayThanhToan(), x.getNgayShip(), x.getNgayNhan(), x.getTinhTrang(), x.getTenNguoiNhan(), x.getDiaChi(), x.getSdt());
            listQL.add(qlhd);
        }
        return listQL;
    }

    @Override
    public String insert(QLHoaDon qlhoaDon) {
        KhachHang idKH = new KhachHang(qlhoaDon.getIdKH().getId());
        NhanVien idNV = new NhanVien(qlhoaDon.getIdNV().getId());
        HoaDon qlhd = new HoaDon(idKH, idNV, qlhoaDon.getMa(), qlhoaDon.getNgayTao(), qlhoaDon.getNgayThanhToan(), qlhoaDon.getNgayShip(), qlhoaDon.getNgayNhan(), qlhoaDon.getTinhTrang(), qlhoaDon.getTenNguoiNhan(), qlhoaDon.getDiaChi(), qlhoaDon.getSdt());
        if (re.insert(qlhd)) {
            return "Thanh Cong ";
        } else {
            return "That Bai";
        }

    }

    @Override
    public String update(QLHoaDon qlhoaDon, UUID id) {
        KhachHang idKH = new KhachHang(qlhoaDon.getIdKH().getId());
        NhanVien idNV = new NhanVien(qlhoaDon.getIdNV().getId());
        HoaDon qlhd = new HoaDon(idKH, idNV, qlhoaDon.getMa(), qlhoaDon.getNgayTao(), qlhoaDon.getNgayThanhToan(), qlhoaDon.getNgayShip(), qlhoaDon.getNgayNhan(), qlhoaDon.getTinhTrang(), qlhoaDon.getTenNguoiNhan(), qlhoaDon.getDiaChi(), qlhoaDon.getSdt());
        if (re.update(qlhd, id)) {
            return "Thanh Cong ";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String delete(UUID id) {
        if (re.delete(id)) {
            return "Thanh Cong ";
        } else {
            return "That Bai";
        }
    }

    @Override
    public List<QLHoaDon> getFrmHoaDon() {
        listQL.clear();
        for (HoaDon hoaDon : re.getFrmHoaDon()) {
            QLNhanVien qlnv = new QLNhanVien(hoaDon.getIdNV().getId(), hoaDon.getIdNV().getTen());
            QLHoaDon qlhd = new QLHoaDon(hoaDon.getId(),qlnv, hoaDon.getMa(), hoaDon.getNgayTao(), hoaDon.getTinhTrang());
            listQL.add(qlhd);
        }
        return listQL;
    }

    @Override
    public String addFrmHoaDon(QLHoaDon qlHoaDon) {
        NhanVien qlnv = new NhanVien(qlHoaDon.getIdNV().getId());
        HoaDon qlhd = new HoaDon(qlnv, qlHoaDon.getMa(), qlHoaDon.getNgayTao(), qlHoaDon.getTinhTrang());
        if (re.addFrmHoaDon(qlhd)) {
            return "";
        } else {
            return "";
        }
    }

}
