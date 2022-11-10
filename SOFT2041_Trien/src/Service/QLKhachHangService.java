/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLKhachHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLKhachHangService {

    List<QLKhachHang> getAll();

    QLKhachHang getOne(UUID id);

    String insert(QLKhachHang qlkh);

    String update(QLKhachHang qlkh, UUID id);

    String delete(UUID id);
}
