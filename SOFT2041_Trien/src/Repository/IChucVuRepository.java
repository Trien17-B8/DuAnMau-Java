/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.ChucVu;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface IChucVuRepository {

    List<ChucVu> getAll();

    ChucVu getOne(UUID id);

    boolean insert(ChucVu chucVu);

    boolean update(ChucVu chucVu, UUID id);

    boolean delete(UUID id);
}
