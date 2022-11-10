/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.HoaDonChiTiet;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface IHoaDonChiTietRepository {

    List<HoaDonChiTiet> getAll();

    boolean insert(HoaDonChiTiet hdct);

    boolean update(HoaDonChiTiet hdct, UUID id);

    boolean delete(UUID id);
    
    List<HoaDonChiTiet> getFrmGH();
    
    
    List<HoaDonChiTiet> getFrmGHId(UUID id);
}
