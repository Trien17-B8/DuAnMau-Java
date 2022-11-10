/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChiTietSP;
import DomainModels.GioHang;
import DomainModels.GioHangChiTiet;
import DomainModels.SanPham;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Utilities.SQLServerConnection;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class GioHangChiTietRepository implements IGioHangChiTietRepository {

    @Override
    public List<GioHangChiTiet> getAll() {
        String query = "SELECT dbo.GioHang.Id, dbo.ChiTietSP.Id , dbo.GioHangChiTiet.SoLuong, dbo.GioHangChiTiet.DonGia, dbo.GioHangChiTiet.DonGiaKhiGiam "
                + "FROM     dbo.GioHang INNER JOIN "
                + "                  dbo.GioHangChiTiet ON dbo.GioHang.Id = dbo.GioHangChiTiet.IdGioHang INNER JOIN "
                + "                  dbo.ChiTietSP ON dbo.GioHangChiTiet.IdChiTietSP = dbo.ChiTietSP.Id";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<GioHangChiTiet> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHang gioHang = new GioHang(UUID.fromString(rs.getString(1)));
                ChiTietSP chiTietSP = new ChiTietSP(UUID.fromString(rs.getString(2)));
                GioHangChiTiet ghct = new GioHangChiTiet(gioHang, chiTietSP, rs.getInt(3), rs.getDouble(4), rs.getDouble(5));
                list.add(ghct);
            }
            return list;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(GioHangChiTiet ghct) {
        String query = "INSERT INTO [dbo].[GioHangChiTiet] "
                + "           ([IdGioHang] "
                + "           ,[IdChiTietSP] "
                + "           ,[SoLuong] "
                + "           ,[DonGia] "
                + "           ,[DonGiaKhiGiam]) "
                + "     VALUES "
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ghct.getIdGioHang().getId());
            ps.setObject(2, ghct.getIdChiTietSP().getId());
            ps.setObject(3, ghct.getSoLuong());
            ps.setObject(4, ghct.getDonGia());
            ps.setObject(5, ghct.getDonGiaKhiGiam());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(GioHangChiTiet ghct, UUID id) {
        String query = "UPDATE [dbo].[GioHangChiTiet] "
                + "   SET [SoLuong] = ? "
                + "      ,[DonGia] = ? "
                + "      ,[DonGiaKhiGiam] = ? "
                + " WHERE GioHangChiTiet.IdGioHang = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ghct.getSoLuong());
            ps.setObject(2, ghct.getDonGia());
            ps.setObject(3, ghct.getDonGiaKhiGiam());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[GioHangChiTiet] "
                + "      WHERE GioHangChiTiet.IdGioHang = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }



}
