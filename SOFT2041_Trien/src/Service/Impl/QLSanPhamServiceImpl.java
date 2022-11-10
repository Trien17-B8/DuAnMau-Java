/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.SanPham;
import Repository.ISanPhamRepository;
import Repository.SanPhamRepository;
import Service.QLSanPhamService;
import ViewModels.QLSanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLSanPhamServiceImpl implements QLSanPhamService {

    private final ISanPhamRepository re = new SanPhamRepository();
    private final List<QLSanPham> listQlSP = new ArrayList<>();

    @Override
    public List<QLSanPham> getAll() {
        listQlSP.clear();
        for (SanPham sanPham : re.getAll()) {
            QLSanPham qLSanPham = new QLSanPham(sanPham.getId(), sanPham.getMa(), sanPham.getTen());
            listQlSP.add(qLSanPham);
        }
        return listQlSP;
    }

    @Override
    public QLSanPham getOne(UUID id) {
        var sanPham = re.getOne(id);
        return new QLSanPham(sanPham.getId(),sanPham.getMa(), sanPham.getTen());
    }

    @Override
    public String insert(QLSanPham qLSanPham) {
        SanPham sanPham = new SanPham(qLSanPham.getMa(), qLSanPham.getTen());
        if (re.insert(sanPham)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(QLSanPham qLSanPham, UUID id) {
        SanPham sanPham = new SanPham(qLSanPham.getMa(), qLSanPham.getTen());
        if (re.update(sanPham, id)) {
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
