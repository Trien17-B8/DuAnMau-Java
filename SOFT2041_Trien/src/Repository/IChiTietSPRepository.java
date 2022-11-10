/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.ChiTietSP;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface IChiTietSPRepository {

    List<ChiTietSP> getAll();

    ChiTietSP getOne(UUID id);

    boolean insert(ChiTietSP chiTietSP);

    boolean update(ChiTietSP chiTietSP, UUID id);

    boolean delete(UUID id);
    
    List<ChiTietSP> getFrmBH();
    
    List<ChiTietSP> getFrmFinal();
    
}
