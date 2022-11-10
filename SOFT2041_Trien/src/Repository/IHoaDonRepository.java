/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.HoaDon;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface IHoaDonRepository {

    List<HoaDon> getAll();

    boolean insert(HoaDon hoaDon);

    boolean update(HoaDon hoaDon, UUID id);

    boolean delete(UUID id);
    
    List<HoaDon> getFrmHoaDon();
    
    boolean addFrmHoaDon(HoaDon hoaDon);
}
