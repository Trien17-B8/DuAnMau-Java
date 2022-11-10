/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utilities.SQLServerConnection;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hp
 */
public class HoaDonRepository implements IHoaDonRepository {

    @Override
    public List<HoaDon> getAll() {
        String query = "SELECT dbo.HoaDon.Id, dbo.KhachHang.Id ,dbo.KhachHang.Ho+' '+dbo.KhachHang.TenDem+' '+dbo.KhachHang.Ten, dbo.NhanVien.Id ,dbo.NhanVien.Ho+' '+dbo.NhanVien.TenDem+' '+ dbo.NhanVien.Ten , dbo.HoaDon.Ma, dbo.HoaDon.NgayTao, dbo.HoaDon.NgayThanhToan, dbo.HoaDon.NgayShip,  "
                + "                  dbo.HoaDon.NgayNhan, dbo.HoaDon.TinhTrang, dbo.HoaDon.TenNguoiNhan, dbo.HoaDon.DiaChi, dbo.HoaDon.Sdt "
                + "FROM     dbo.HoaDon INNER JOIN "
                + "                  dbo.KhachHang ON dbo.HoaDon.IdKH = dbo.KhachHang.Id INNER JOIN "
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang idKH = new KhachHang(UUID.fromString(rs.getString(2)), rs.getString(3));
                NhanVien idNV = new NhanVien(UUID.fromString(rs.getString(4)), rs.getString(5));
                HoaDon hoaDon = new HoaDon(UUID.fromString(rs.getString(1)), idKH, idNV, rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getDate(9), rs.getDate(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14));
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(HoaDon hoaDon) {
        String query = "INSERT INTO [dbo].[HoaDon] "
                + "           ([IdKH] "
                + "           ,[IdNV] "
                + "           ,[Ma] "
                + "           ,[NgayTao] "
                + "           ,[NgayThanhToan] "
                + "           ,[NgayShip] "
                + "           ,[NgayNhan] "
                + "           ,[TinhTrang] "
                + "           ,[TenNguoiNhan] "
                + "           ,[DiaChi] "
                + "           ,[Sdt]) "
                + "     VALUES "
                + "           (?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hoaDon.getIdKH().getId());
            ps.setObject(2, hoaDon.getIdNV().getId());
            ps.setObject(3, hoaDon.getMa());
            ps.setObject(4, hoaDon.getNgayTao());
            ps.setObject(5, hoaDon.getNgayThanhToan());
            ps.setObject(6, hoaDon.getNgayShip());
            ps.setObject(7, hoaDon.getNgayNhan());
            ps.setObject(8, hoaDon.getTinhTrang());
            ps.setObject(9, hoaDon.getTenNguoiNhan());
            ps.setObject(10, hoaDon.getDiaChi());
            ps.setObject(11, hoaDon.getSdt());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(HoaDon hoaDon, UUID id) {
        String query = "UPDATE [dbo].[HoaDon] "
                + "   SET [IdKH] = ? "
                + "      ,[IdNV] = ? "
                + "      ,[Ma] = ? "
                + "      ,[NgayTao] = ? "
                + "      ,[NgayThanhToan] = ? "
                + "      ,[NgayShip] = ? "
                + "      ,[NgayNhan] = ? "
                + "      ,[TinhTrang] = ? "
                + "      ,[TenNguoiNhan] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[Sdt] = ? "
                + " WHERE Id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hoaDon.getIdKH().getId());
            ps.setObject(2, hoaDon.getIdNV().getId());
            ps.setObject(3, hoaDon.getMa());
            ps.setObject(4, hoaDon.getNgayTao());
            ps.setObject(5, hoaDon.getNgayThanhToan());
            ps.setObject(6, hoaDon.getNgayShip());
            ps.setObject(7, hoaDon.getNgayNhan());
            ps.setObject(8, hoaDon.getTinhTrang());
            ps.setObject(9, hoaDon.getTenNguoiNhan());
            ps.setObject(10, hoaDon.getDiaChi());
            ps.setObject(11, hoaDon.getSdt());
            ps.setObject(12, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[HoaDon] "
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

    @Override
    public List<HoaDon> getFrmHoaDon() {
        String query = "SELECT dbo.HoaDon.Id, dbo.HoaDon.Ma, dbo.HoaDon.NgayTao, dbo.NhanVien.Id , dbo.NhanVien.Ten, dbo.HoaDon.TinhTrang "
                + "FROM     dbo.HoaDon INNER JOIN "
                + "                  dbo.NhanVien ON dbo.HoaDon.IdNV = dbo.NhanVien.Id";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<HoaDon> listFrmHD = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien(UUID.fromString(rs.getString(4)), rs.getString(5));
                HoaDon hd = new HoaDon(UUID.fromString(rs.getString(1)),nhanVien, rs.getString(2), rs.getDate(3), rs.getInt(6));
                listFrmHD.add(hd);
            }
            return listFrmHD;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addFrmHoaDon(HoaDon hoaDon) {
        String query = "INSERT INTO [dbo].[HoaDon] "
                + "           ([IdNV] "
                + "           ,[Ma] "
                + "           ,[NgayTao] "
                + "           ,[TinhTrang] ) "
                + "     VALUES "
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hoaDon.getIdNV().getId());
            ps.setObject(2, hoaDon.getMa());
            ps.setObject(3, hoaDon.getNgayTao());
            ps.setObject(4, hoaDon.getTinhTrang());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        NhanVien nv = new NhanVien(UUID.fromString("0758F4C6-3099-4FD3-A68F-6AB211BED44D"));
        Date ngayTao = new Date(2020 - 10 - 12);
        HoaDon hd = new HoaDon(nv, "HD01", ngayTao, 0);
        System.out.println(new HoaDonRepository().addFrmHoaDon(hd));
    }
}
