/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.DongSP;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface IDongSPRepository {

    List<DongSP> getAll();

    DongSP getOne(UUID id);

    boolean insert(DongSP dongSP);

    boolean update(DongSP dongSP, UUID id);

    boolean delete(UUID id);
}
