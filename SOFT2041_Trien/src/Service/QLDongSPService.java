/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import ViewModels.QLDongSP;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface QLDongSPService {

    List<QLDongSP> getAll();

    QLDongSP getOne(UUID id);

    String insert(QLDongSP qldsp);

    String update(QLDongSP qldsp, UUID id);

    String delete(UUID id);
}
