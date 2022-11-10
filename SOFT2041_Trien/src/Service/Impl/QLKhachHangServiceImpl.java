/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.KhachHang;
import Repository.IKhachHangRepository;
import Repository.KhachHangRepository;
import Service.QLKhachHangService;
import ViewModels.QLKhachHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLKhachHangServiceImpl implements QLKhachHangService {

    private final IKhachHangRepository re = new KhachHangRepository();
    private final List<QLKhachHang> listQlKhachHang = new ArrayList<>();

    @Override
    public List<QLKhachHang> getAll() {
        listQlKhachHang.clear();
        for (KhachHang kh : re.getAll()) {
            QLKhachHang qlkh = new QLKhachHang(kh.getId(), kh.getMa(), kh.getTen(), kh.getTenDem(), kh.getHo(), kh.getNgaySinh(), kh.getSdt(), kh.getDiaChi(), kh.getThanhPho(), kh.getQuocGia(), kh.getMatKhau());
            listQlKhachHang.add(qlkh);
        }
        return listQlKhachHang;
    }

    @Override
    public QLKhachHang getOne(UUID id) {
        var x = re.getOne(id);
        return new QLKhachHang(x.getId(), x.getMa(), x.getTen(), x.getTenDem(), x.getHo(), x.getNgaySinh(), x.getSdt(), x.getDiaChi(), x.getThanhPho(), x.getQuocGia(), x.getMatKhau());
    }

    @Override
    public String insert(QLKhachHang qlkh) {
        KhachHang kh = new KhachHang(qlkh.getMa(), qlkh.getTen(), qlkh.getTenDem(), qlkh.getHo(), qlkh.getNgaySinh(), qlkh.getSdt(), qlkh.getDiaChi(), qlkh.getThanhPho(), qlkh.getQuocGia(), qlkh.getMatKhau());
        if (re.insert(kh)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(QLKhachHang qlkh, UUID id) {
        KhachHang kh = new KhachHang(qlkh.getMa(), qlkh.getTen(), qlkh.getTenDem(), qlkh.getHo(), qlkh.getNgaySinh(), qlkh.getSdt(), qlkh.getDiaChi(), qlkh.getThanhPho(), qlkh.getQuocGia(), qlkh.getMatKhau());
        if (re.update(kh, id)) {
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
