/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.GioHang;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import Repository.GioHangRepository;
import Repository.IGioHangRepository;
import Service.QLGioHangService;
import ViewModels.QLGioHang;
import ViewModels.QLKhachHang;
import ViewModels.QLNhanVien;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLGioHangServiceImpl implements QLGioHangService {

    private final IGioHangRepository re = new GioHangRepository();
    private final List<QLGioHang> listQL = new ArrayList<>();

    @Override
    public List<QLGioHang> getAll() {
        listQL.clear();
        for (GioHang x : re.getAll()) {
            QLKhachHang idKH = new QLKhachHang(x.getIdKH().getId(), x.getIdKH().getTen());
            QLNhanVien idNV = new QLNhanVien(x.getIdNV().getId(), x.getIdNV().getTen());
            QLGioHang qlgh = new QLGioHang(x.getId(), idKH, idNV, x.getMa(), x.getNgayTao(), x.getNgayThanhToan(), x.getTenNguoiNhan(), x.getDiaChi(), x.getSdt(), x.getTinhTrang());
            listQL.add(qlgh);
        }
        return listQL;
    }

    @Override
    public String insert(QLGioHang qlgioHang) {
        KhachHang idKH = new KhachHang(qlgioHang.getIdKH().getId());
        NhanVien idNV = new NhanVien(qlgioHang.getIdNV().getId());
        GioHang qlgh = new GioHang( idKH, idNV, qlgioHang.getMa(), qlgioHang.getNgayTao(), qlgioHang.getNgayThanhToan(), qlgioHang.getTenNguoiNhan(), qlgioHang.getDiaChi(), qlgioHang.getSdt(), qlgioHang.getTinhTrang());
        if(re.insert(qlgh)){
            return "Thanh Cong";
        }else{
            return "That Bai";
        }
    }

    @Override
    public String update(QLGioHang qlgioHang, UUID id) {
        KhachHang idKH = new KhachHang(qlgioHang.getIdKH().getId());
        NhanVien idNV = new NhanVien(qlgioHang.getIdNV().getId());
        GioHang qlgh = new GioHang( idKH, idNV, qlgioHang.getMa(), qlgioHang.getNgayTao(), qlgioHang.getNgayThanhToan(), qlgioHang.getTenNguoiNhan(), qlgioHang.getDiaChi(), qlgioHang.getSdt(), qlgioHang.getTinhTrang());
        if(re.update(qlgh, id)){
            return "Thanh Cong";
        }else{
            return "That Bai";
        }
    }

    @Override
    public String detele(UUID id) {
        if(re.detele(id)){
            return "Thanh Cong";
        }else{
            return "That Bai";
        }
    }

}
