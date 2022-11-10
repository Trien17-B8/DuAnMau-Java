/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLHoaDon;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLHoaDonService {

    List<QLHoaDon> getAll();

    String insert(QLHoaDon qlhoaDon);

    String update(QLHoaDon qlhoaDon, UUID id);

    String delete(UUID id);
    
    List<QLHoaDon> getFrmHoaDon();
    
    String addFrmHoaDon(QLHoaDon qlHoaDon);
}
