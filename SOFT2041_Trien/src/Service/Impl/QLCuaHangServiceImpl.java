/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.CuaHang;
import Repository.CuaHangRepository;
import Repository.ICuaHangRepository;
import Service.QLCuaHangService;
import ViewModels.QLCuaHang;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLCuaHangServiceImpl implements QLCuaHangService {

    private final ICuaHangRepository re = new CuaHangRepository();
    private final List<QLCuaHang> listQLCuaHang = new ArrayList<>();

    @Override
    public List<QLCuaHang> getAll() {
        listQLCuaHang.clear();
        for (CuaHang cuaHang : re.getAll()) {
            QLCuaHang ql = new QLCuaHang(cuaHang.getId(), cuaHang.getMa(), cuaHang.getTen(), cuaHang.getDiaChi(), cuaHang.getThanhPho(), cuaHang.getQuocGia());
            listQLCuaHang.add(ql);
        }
        return listQLCuaHang;
    }

    @Override
    public QLCuaHang getOne(UUID id) {
        var cuaHang = re.getOne(id);
        return new QLCuaHang(cuaHang.getId(), cuaHang.getMa(), cuaHang.getTen(), cuaHang.getDiaChi(), cuaHang.getThanhPho(), cuaHang.getQuocGia());
    }

    @Override
    public String insert(QLCuaHang qLCuaHang) {
        CuaHang cuaHang = new CuaHang(qLCuaHang.getId(), qLCuaHang.getMa(), qLCuaHang.getTen(), qLCuaHang.getDiaChi(), qLCuaHang.getThanhPho(), qLCuaHang.getQuocGia());
        if (re.insert(cuaHang)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(QLCuaHang qLCuaHang, UUID id) {
        CuaHang cuaHang = new CuaHang(qLCuaHang.getId(), qLCuaHang.getMa(), qLCuaHang.getTen(), qLCuaHang.getDiaChi(), qLCuaHang.getThanhPho(), qLCuaHang.getQuocGia());
        if (re.update(cuaHang, id)) {
            return "Thanh Cong";
        } else {
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

    

}
