/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLNSX;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLNSXService {

    List<QLNSX> getAll();

    QLNSX getOne(UUID id);

    String insert(QLNSX qlnsx);

    String update(QLNSX qlnsx, UUID id);

    String delete(UUID id);
}
