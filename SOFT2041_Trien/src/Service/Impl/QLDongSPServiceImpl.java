/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.DongSP;
import Repository.DongSPRepository;
import Repository.IDongSPRepository;
import Service.QLDongSPService;
import ViewModels.QLDongSP;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLDongSPServiceImpl implements QLDongSPService {
    
    private final IDongSPRepository re = new DongSPRepository();
    private final List<QLDongSP> listQlDongSP = new ArrayList<>();
    
    @Override
    public List<QLDongSP> getAll() {
        listQlDongSP.clear();
        for (DongSP dongSP : re.getAll()) {
            QLDongSP qldsp = new QLDongSP(dongSP.getId(), dongSP.getMa(), dongSP.getTen());
            listQlDongSP.add(qldsp);
        }
        return listQlDongSP;
    }
    
    @Override
    public QLDongSP getOne(UUID id) {
        var dongSp = re.getOne(id);
        return new QLDongSP(dongSp.getId(),dongSp.getMa(), dongSp.getTen());
    }
    
    @Override
    public String insert(QLDongSP qldsp) {
        DongSP dsp = new DongSP(qldsp.getMa(), qldsp.getTen());
        if (re.insert(dsp)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }
    
    @Override
    public String update(QLDongSP qldsp, UUID id) {
        DongSP dsp = new DongSP(qldsp.getMa(), qldsp.getTen());
        if (re.update(dsp, id)) {
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
