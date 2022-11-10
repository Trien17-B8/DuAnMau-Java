/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.ChucVuRepository;
import DomainModels.ChucVu;
import Repository.IChucVuRepository;
import Service.QLChucVuService;
import ViewModels.QLChucVu;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLChucVuServiceImpl implements QLChucVuService{

    private final IChucVuRepository re = new ChucVuRepository();
    private final List<QLChucVu> listQLChucVu = new ArrayList<>();
    

    @Override
    public List<QLChucVu> getAll() {
        listQLChucVu.clear();
        for (ChucVu ChucVu : re.getAll()) {
            QLChucVu ql = new QLChucVu(ChucVu.getId(), ChucVu.getMa(), ChucVu.getTen());
            listQLChucVu.add(ql);
        }
        return listQLChucVu;
    }
    
    @Override
    public QLChucVu getOne(UUID id) {
        var chucVu = re.getOne(id);
        return new QLChucVu(chucVu.getId(),chucVu.getMa(), chucVu.getTen());
    }

    @Override
    public String insert(QLChucVu qlChucVu) {
        ChucVu cv = new ChucVu(qlChucVu.getMa(), qlChucVu.getTen());
        if(re.insert(cv)){
            return "Thanh Cong";
        }else{
            return "That Bai";
        }
    }

    @Override
    public String update(QLChucVu qLChucVu, UUID id) {
        ChucVu cv = new ChucVu(qLChucVu.getMa(), qLChucVu.getTen());
        if(re.update(cv, id)){
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

    

    
    
}
