/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.NSX;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface INSXRepository {

    List<NSX> getAll();

    NSX getOne(UUID id);

    boolean insert(NSX nsx);

    boolean update(NSX nsx, UUID id);

    boolean delete(UUID id);
}
