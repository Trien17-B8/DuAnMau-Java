/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import DomainModels.KhachHang;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public interface IKhachHangRepository {

    List<KhachHang> getAll();

    KhachHang getOne(UUID id);

    boolean insert(KhachHang kh);

    boolean update(KhachHang kh, UUID id);

    boolean delete(UUID id);

}
