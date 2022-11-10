/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLChiTietSP;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLChiTietSPService {
    
    List<QLChiTietSP> getAll();
    
    String insert(QLChiTietSP qlctsp);
    
    String update(QLChiTietSP qlctsp, UUID id);
    
    String delete(UUID id);
    
    List<QLChiTietSP> getFrmBH();
    
    List<QLChiTietSP> getFrmFinal();
    
}
