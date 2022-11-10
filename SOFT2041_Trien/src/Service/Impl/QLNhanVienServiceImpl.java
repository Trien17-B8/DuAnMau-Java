/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
import DomainModels.NhanVien;
import Repository.INhanVienRepository;
import Repository.NhanVienRepository;
import Service.QLNhanVienService;
import ViewModels.QLChucVu;
import ViewModels.QLCuaHang;
import ViewModels.QLNhanVien;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLNhanVienServiceImpl implements QLNhanVienService {

    private final INhanVienRepository re = new NhanVienRepository();
    private final List<QLNhanVien> listQlNhanVien = new ArrayList<>();

    @Override
    public List<QLNhanVien> getAll() {
        listQlNhanVien.clear();
        for (NhanVien nv : re.getAll()) {
            QLCuaHang idCh = new QLCuaHang(nv.getIdCh().getId(), nv.getIdCh().getTen());
            QLChucVu idCv = new QLChucVu(nv.getIdCv().getId(), nv.getIdCv().getTen());
            QLNhanVien idGuiBc = new QLNhanVien(nv.getIdGuiBC().getId(), nv.getIdGuiBC().getTen());
            QLNhanVien qlnv = new QLNhanVien(nv.getId(), nv.getMa(), nv.getTen(), nv.getTenDem(), nv.getHo(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSdt(), nv.getMatKhau(), idCh, idCv, idGuiBc, nv.getTrangThai());
            listQlNhanVien.add(qlnv);
        }
        return listQlNhanVien;
    }

    @Override
    public QLNhanVien getOne(UUID id) {
        var x = re.getOne(id);
        QLCuaHang idCh = new QLCuaHang(x.getIdCh().getId(), x.getIdCh().getTen());
        QLChucVu idCv = new QLChucVu(x.getIdCv().getId(), x.getIdCv().getTen());
        QLNhanVien idGuiBc = new QLNhanVien(x.getIdGuiBC().getId(), x.getIdGuiBC().getTen());
        return new QLNhanVien(x.getId(), x.getMa(), x.getTen(), x.getTenDem(), x.getHo(), x.getGioiTinh(), x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getMatKhau(), idCh, idCv, idGuiBc, x.getTrangThai());
    }

    @Override
    public String insert(QLNhanVien qlnv) {
        CuaHang idCh = new CuaHang(qlnv.getIdCh().getId());
        ChucVu idCv = new ChucVu(qlnv.getIdCv().getId());
        NhanVien idGuiBc = new NhanVien(qlnv.getIdGuiBC().getId());
        NhanVien nv = new NhanVien(qlnv.getId(), qlnv.getMa(), qlnv.getTen(), qlnv.getTenDem(), qlnv.getHo(), qlnv.getGioiTinh(), qlnv.getNgaySinh(), qlnv.getDiaChi(), qlnv.getSdt(), qlnv.getMatKhau(), idCh, idCv, idGuiBc, qlnv.getTrangThai());
        if (re.insert(nv)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(QLNhanVien qlnv, UUID id) {
        CuaHang idCh = new CuaHang(qlnv.getIdCh().getId());
        ChucVu idCv = new ChucVu(qlnv.getIdCv().getId());
        NhanVien idGuiBc = new NhanVien(qlnv.getIdGuiBC().getId());
        NhanVien nv = new NhanVien(qlnv.getId(), qlnv.getMa(), qlnv.getTen(), qlnv.getTenDem(), qlnv.getHo(), qlnv.getGioiTinh(), qlnv.getNgaySinh(), qlnv.getDiaChi(), qlnv.getSdt(), qlnv.getMatKhau(), idCh, idCv, idGuiBc, qlnv.getTrangThai());
        if (re.update(nv, id)) {
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
    
    public static void main(String[] args) {
        System.out.println(new QLNhanVienServiceImpl().getOne(UUID.fromString("90288D94-69FF-4A1A-90BE-1FCAA636B3E8")));
    }

}
