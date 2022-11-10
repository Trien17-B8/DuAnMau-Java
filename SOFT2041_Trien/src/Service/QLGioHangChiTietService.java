/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLGioHang;
import ViewModels.QLGioHangChiTiet;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLGioHangChiTietService {

    List<QLGioHangChiTiet> getAll();

    String insert(QLGioHangChiTiet qlghct);

    String update(QLGioHangChiTiet qlghct, UUID id);

    String delete(UUID id);

}
