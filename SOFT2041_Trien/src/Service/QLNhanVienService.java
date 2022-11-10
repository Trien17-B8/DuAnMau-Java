/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLNhanVien;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLNhanVienService {

    List<QLNhanVien> getAll();

    QLNhanVien getOne(UUID id);

    String insert(QLNhanVien qlnv);

    String update(QLNhanVien qlnv, UUID id);

    String delete(UUID id);
}
