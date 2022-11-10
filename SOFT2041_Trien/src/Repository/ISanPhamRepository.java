/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.SanPham;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface ISanPhamRepository {

    List<SanPham> getAll();

    SanPham getOne(UUID id);

    boolean insert(SanPham sanPham);

    boolean update(SanPham sanPham, UUID id);

    boolean delete(UUID id);
}
