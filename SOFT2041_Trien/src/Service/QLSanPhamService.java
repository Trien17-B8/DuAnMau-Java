/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLSanPham;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLSanPhamService {

    List<QLSanPham> getAll();

    QLSanPham getOne(UUID id);

    String insert(QLSanPham qLSanPham);

    String update(QLSanPham qLSanPham, UUID id);

    String delete(UUID id);
}
