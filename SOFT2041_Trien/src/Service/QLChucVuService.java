/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLChucVu;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLChucVuService {

    List<QLChucVu> getAll();

    QLChucVu getOne(UUID id);

    String insert(QLChucVu qlChucVu);

    String update(QLChucVu qLChucVu, UUID id);

    String delete(UUID id);
}
