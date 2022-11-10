/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.GioHangChiTiet;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface IGioHangChiTietRepository {

    List<GioHangChiTiet> getAll();

    boolean insert(GioHangChiTiet ghct);

    boolean update(GioHangChiTiet ghct, UUID id);

    boolean delete(UUID id);
        
    
}
