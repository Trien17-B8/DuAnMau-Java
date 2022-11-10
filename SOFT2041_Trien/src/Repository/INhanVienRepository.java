/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.NhanVien;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface INhanVienRepository {

    List<NhanVien> getAll();

    NhanVien getOne(UUID id);

    boolean insert(NhanVien nv);

    boolean update(NhanVien nv, UUID id);

    boolean delete(UUID id);

}
