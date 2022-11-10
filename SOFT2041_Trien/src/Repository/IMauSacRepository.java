/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.MauSac;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface IMauSacRepository {

    List<MauSac> getAll();

    MauSac getOne(UUID id);

    boolean insert(MauSac ms);

    boolean update(MauSac ms, UUID id);

    boolean delete(UUID id);
}
