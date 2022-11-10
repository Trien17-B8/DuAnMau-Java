/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLCuaHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLCuaHangService {

    List<QLCuaHang> getAll();

    QLCuaHang getOne(UUID id);

    String insert(QLCuaHang qLCuaHang);

    String update(QLCuaHang qLCuaHang, UUID id);

    String delete(UUID id);
}
