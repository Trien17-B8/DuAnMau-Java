/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChiTietSP;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.SanPham;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utilities.SQLServerConnection;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class HoaDonChiTietRepository implements IHoaDonChiTietRepository {

    @Override
    public List<HoaDonChiTiet> getAll() {
        String query = "SELECT dbo.HoaDon.Id, dbo.ChiTietSP.Id , dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia "
                + "FROM     dbo.HoaDon INNER JOIN "
                + "                  dbo.HoaDonChiTiet ON dbo.HoaDon.Id = dbo.HoaDonChiTiet.IdHoaDon INNER JOIN "
                + "                  dbo.ChiTietSP ON dbo.HoaDonChiTiet.IdChiTietSP = dbo.ChiTietSP.Id";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDonChiTiet> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon idHoaDon = new HoaDon(UUID.fromString(rs.getString(1)));
                ChiTietSP idChiTietSP = new ChiTietSP(UUID.fromString(rs.getString(2)));
                HoaDonChiTiet hdct = new HoaDonChiTiet(idHoaDon, idChiTietSP, rs.getInt(3), rs.getInt(4));
                list.add(hdct);
            }
            return list;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(HoaDonChiTiet hdct) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet] "
                + "           ([IdHoaDon] "
                + "           ,[IdChiTietSP] "
                + "           ,[SoLuong] "
                + "           ,[DonGia]) "
                + "     VALUES "
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getIdHoaDon().getId());
            ps.setObject(2, hdct.getIdChiTietSP().getId());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getDonGia());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(HoaDonChiTiet hdct, UUID id) {
        String query = "UPDATE [dbo].[HoaDonChiTiet] "
                + "   SET [IdHoaDon] = ? "
                + "      ,[IdChiTietSP] = ? "
                + "      ,[SoLuong] = ? "
                + "      ,[DonGia] =? "
                + " WHERE HoaDonChiTiet.IdHoaDon = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getIdHoaDon().getId());
            ps.setObject(2, hdct.getIdChiTietSP().getId());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getDonGia());
            ps.setObject(5, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[HoaDonChiTiet] "
                + "      WHERE HoaDonChiTiet.IdHoaDon = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public List<HoaDonChiTiet> getFrmGH() {
        String query = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia "
                + "FROM     dbo.ChiTietSP INNER JOIN "
                + "                  dbo.HoaDonChiTiet ON dbo.ChiTietSP.Id = dbo.HoaDonChiTiet.IdChiTietSP INNER JOIN "
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDonChiTiet> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString(1), rs.getString(2));
                ChiTietSP chiTietSP = new ChiTietSP(sanPham);
                HoaDonChiTiet ghct = new HoaDonChiTiet(chiTietSP, rs.getInt(3), rs.getInt(4));
                list.add(ghct);
            }
            return list;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<HoaDonChiTiet> getFrmGHId(UUID id) {
        String query = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.HoaDonChiTiet.SoLuong, dbo.HoaDonChiTiet.DonGia  "
                + "FROM     dbo.ChiTietSP INNER JOIN "
                + "                  dbo.HoaDonChiTiet ON dbo.ChiTietSP.Id = dbo.HoaDonChiTiet.IdChiTietSP INNER JOIN "
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id "
                + "				  WHERE HoaDonChiTiet.IdHoaDon =   ?";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDonChiTiet> list = new ArrayList<>();
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString(1), rs.getString(2));
                ChiTietSP chiTietSP = new ChiTietSP(sanPham);
                HoaDonChiTiet ghct = new HoaDonChiTiet(chiTietSP, rs.getInt(3), rs.getInt(4));
                list.add(ghct);
            }
            return list;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(new HoaDonChiTietRepository().getFrmGHId(UUID.fromString("F42781C5-ABC1-48AB-B7EC-9CF212B146B0")));
    }
}
