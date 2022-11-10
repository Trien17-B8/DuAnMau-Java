/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLGioHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLGioHangService {

    List<QLGioHang> getAll();

    String insert(QLGioHang qlgioHang);

    String update(QLGioHang qlgioHang, UUID id);

    String detele(UUID id);
}
