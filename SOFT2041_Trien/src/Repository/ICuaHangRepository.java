/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.CuaHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface ICuaHangRepository {

    List<CuaHang> getAll();

    CuaHang getOne(UUID id);

    boolean insert(CuaHang cuaHang);

    boolean update(CuaHang cuaHang, UUID id);

    boolean delete(UUID id);
}
