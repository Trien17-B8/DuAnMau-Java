/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;


import ViewModels.QLHoaDonChiTiet;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLHoaDonChiTietService {

    List<QLHoaDonChiTiet> getAll();

    String insert(QLHoaDonChiTiet qlhdct);

    String update(QLHoaDonChiTiet qlhdct, UUID id);

    String delete(UUID id);
    
    List<QLHoaDonChiTiet> getFrmGH();
    
    List<QLHoaDonChiTiet> getFrmGHid(UUID id);
}
