/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.MauSac;
import Repository.IMauSacRepository;
import Repository.MauSacRepository;
import Service.QLMauSacService;
import ViewModels.QLMauSac;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLMauSacServiceImpl implements QLMauSacService{

    private final IMauSacRepository re = new MauSacRepository();
    private final List<QLMauSac> listQlMauSac = new ArrayList<>();
    
    @Override
    public List<QLMauSac> getAll() {
        listQlMauSac.clear();
        for (MauSac mauSac : re.getAll()) {
            QLMauSac qlms = new QLMauSac(mauSac.getId(), mauSac.getMa(), mauSac.getTen());
            listQlMauSac.add(qlms);
        }
        return listQlMauSac; 
   }
    
    @Override
    public QLMauSac getOne(UUID id) {
        var x = re.getOne(id);
        return new QLMauSac(x.getId(),x.getMa(), x.getTen());
    }

    @Override
    public String insert(QLMauSac qlms) {
        MauSac mauSac = new MauSac(qlms.getMa(), qlms.getTen());
        if (re.insert(mauSac)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(QLMauSac qlms, UUID id) {
        MauSac mauSac = new MauSac(qlms.getMa(), qlms.getTen());
        if (re.update(mauSac, id)) {
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
