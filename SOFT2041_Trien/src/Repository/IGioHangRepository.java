/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.GioHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface IGioHangRepository {

    List<GioHang> getAll();

    boolean insert(GioHang gioHang);

    boolean update(GioHang gioHang, UUID id);

    boolean detele(UUID id);
}
