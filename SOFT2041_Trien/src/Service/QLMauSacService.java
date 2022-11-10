/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLMauSac;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLMauSacService {

    List<QLMauSac> getAll();

    QLMauSac getOne(UUID id);

    String insert(QLMauSac qlms);

    String update(QLMauSac qlms, UUID id);

    String delete(UUID id);
}
