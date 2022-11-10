/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChiTietSP;
import DomainModels.DongSP;
import DomainModels.MauSac;
import DomainModels.NSX;
import DomainModels.SanPham;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utilities.SQLServerConnection;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class ChiTietSPRepository implements IChiTietSPRepository {

    @Override
    public List<ChiTietSP> getAll() {
        String query = "SELECT dbo.ChiTietSP.Id, dbo.SanPham.Id , dbo.SanPham.Ten, dbo.NSX.Id , dbo.NSX.Ten , dbo.MauSac.Id , dbo.MauSac.Ten , dbo.DongSP.Id , dbo.DongSP.Ten , dbo.ChiTietSP.NamBH,  "
                + "                  dbo.ChiTietSP.MoTa, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan "
                + "FROM     dbo.ChiTietSP INNER JOIN "
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN "
                + "                  dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN "
                + "                  dbo.NSX ON dbo.ChiTietSP.IdNsx = dbo.NSX.Id INNER JOIN "
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ChiTietSP> listChiTietSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham idSP = new SanPham(UUID.fromString(rs.getString(2)), rs.getString(3));
                NSX idNSX = new NSX(UUID.fromString(rs.getString(4)), rs.getString(5));
                MauSac idMauSac = new MauSac(UUID.fromString(rs.getString(6)), rs.getString(7));
                DongSP idDongSP = new DongSP(UUID.fromString(rs.getString(8)), rs.getString(9));
                ChiTietSP chiTietSP = new ChiTietSP(UUID.fromString(rs.getString(1)), idSP, idNSX, idMauSac, idDongSP, rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getDouble(13), rs.getDouble(14));
                listChiTietSP.add(chiTietSP);
            }
            return listChiTietSP;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public ChiTietSP getOne(UUID id) {
        String query = "SELECT dbo.ChiTietSP.Id, dbo.SanPham.Id , dbo.SanPham.Ten, dbo.NSX.Id , dbo.NSX.Ten , dbo.MauSac.Id , dbo.MauSac.Ten , dbo.DongSP.Id , dbo.DongSP.Ten , dbo.ChiTietSP.NamBH,  "
                + "                  dbo.ChiTietSP.MoTa, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan "
                + "FROM     dbo.ChiTietSP INNER JOIN "
                + "                  dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN "
                + "                  dbo.DongSP ON dbo.ChiTietSP.IdDongSP = dbo.DongSP.Id INNER JOIN "
                + "                  dbo.NSX ON dbo.ChiTietSP.IdNsx = dbo.NSX.Id INNER JOIN "
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id "
                + "WHERE ChiTietSP.Id = ?";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SanPham idSP = new SanPham(UUID.fromString(rs.getString(2)), rs.getString(3));
                NSX idNSX = new NSX(UUID.fromString(rs.getString(4)), rs.getString(5));
                MauSac idMauSac = new MauSac(UUID.fromString(rs.getString(6)), rs.getString(7));
                DongSP idDongSP = new DongSP(UUID.fromString(rs.getString(8)), rs.getString(9));
                return new ChiTietSP(UUID.fromString(rs.getString(1)), idSP, idNSX, idMauSac, idDongSP, rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getDouble(13), rs.getDouble(14));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(ChiTietSP chiTietSP) {
        String query = "INSERT INTO [dbo].[ChiTietSP] "
                + "           ([IdSP] "
                + "           ,[IdNsx] "
                + "           ,[IdMauSac] "
                + "           ,[IdDongSP] "
                + "           ,[NamBH] "
                + "           ,[MoTa] "
                + "           ,[SoLuongTon] "
                + "           ,[GiaNhap] "
                + "           ,[GiaBan]) "
                + "     VALUES "
                + "           (?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, chiTietSP.getIdSP().getId());
            ps.setObject(2, chiTietSP.getIdNSX().getId());
            ps.setObject(3, chiTietSP.getIdMauSac().getId());
            ps.setObject(4, chiTietSP.getIdDongSP().getId());
            ps.setObject(5, chiTietSP.getNamBH());
            ps.setObject(6, chiTietSP.getMoTa());
            ps.setObject(7, chiTietSP.getSoLuongTon());
            ps.setObject(8, chiTietSP.getGiaNhap());
            ps.setObject(9, chiTietSP.getGiaBan());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(ChiTietSP chiTietSP, UUID id) {
        String query = "UPDATE [dbo].[ChiTietSP] "
                + "   SET [IdSP] = ? "
                + "      ,[IdNsx] = ? "
                + "      ,[IdMauSac] = ? "
                + "      ,[IdDongSP] = ? "
                + "      ,[NamBH] = ? "
                + "      ,[MoTa] = ? "
                + "      ,[SoLuongTon] = ? "
                + "      ,[GiaNhap] = ? "
                + "      ,[GiaBan] = ? "
                + " WHERE Id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, chiTietSP.getIdSP().getId());
            ps.setObject(2, chiTietSP.getIdNSX().getId());
            ps.setObject(3, chiTietSP.getIdMauSac().getId());
            ps.setObject(4, chiTietSP.getIdDongSP().getId());
            ps.setObject(5, chiTietSP.getNamBH());
            ps.setObject(6, chiTietSP.getMoTa());
            ps.setObject(7, chiTietSP.getSoLuongTon());
            ps.setObject(8, chiTietSP.getGiaNhap());
            ps.setObject(9, chiTietSP.getGiaBan());
            ps.setObject(10, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[ChiTietSP] "
                + "      WHERE Id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        
        System.out.println(new ChiTietSPRepository().getFrmBH());
    }

    @Override
    public List<ChiTietSP> getFrmBH() {
        String query = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.ChiTietSP.NamBH, dbo.ChiTietSP.MoTa, dbo.ChiTietSP.SoLuongTon, dbo.ChiTietSP.GiaNhap, dbo.ChiTietSP.GiaBan "
                + "FROM     dbo.ChiTietSP INNER JOIN "
                + "                  dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id";
        try(Connection con = SQLServerConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            List<ChiTietSP> listFrmBanHang = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2));
                ChiTietSP ctsp = new ChiTietSP(sp, rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7));
                listFrmBanHang.add(ctsp);
            }
            return listFrmBanHang;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }
    
    

}
