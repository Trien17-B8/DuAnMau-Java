/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModels.NSX;
import Repository.INSXRepository;
import Repository.NSXRepository;
import Service.QLNSXService;
import ViewModels.QLNSX;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class QLNSXServiceImpl implements QLNSXService {

    private final INSXRepository re = new NSXRepository();
    private final List<QLNSX> listQlNSX = new ArrayList<>();

    @Override
    public List<QLNSX> getAll() {
        listQlNSX.clear();
        for (NSX nsx : re.getAll()) {
            QLNSX qlnsx = new QLNSX(nsx.getId(), nsx.getMa(), nsx.getTen());
            listQlNSX.add(qlnsx);
        }
        return listQlNSX;
    }

    @Override
    public QLNSX getOne(UUID id) {
        var x = re.getOne(id);
        return new QLNSX(x.getId(),x.getMa(), x.getTen());
    }
    
    @Override
    public String insert(QLNSX qlnsx) {
        NSX nsx = new NSX(qlnsx.getMa(), qlnsx.getTen());
        if (re.insert(nsx)) {
            return "Thanh Cong";
        } else {
            return "That Bai";
        }
    }

    @Override
    public String update(QLNSX qlnsx, UUID id) {
        NSX nsx = new NSX(qlnsx.getMa(), qlnsx.getTen());
        if (re.update(nsx, id)) {
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
        System.out.println(new QLNSXServiceImpl().getOne(UUID.fromString("140f08df-437e-4dfd-b0c5-43b7947ecaf3")));
    }

}
