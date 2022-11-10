/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.GioHang;
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

/**
 *
 * @author hp
 */
public class GioHangRepository implements IGioHangRepository {

    @Override
    public List<GioHang> getAll() {
        String query = "SELECT dbo.GioHang.Id, dbo.KhachHang.Id AS Expr1, dbo.KhachHang.Ten, dbo.GioHang.IdNV, dbo.GioHang.Ma, dbo.GioHang.NgayTao, dbo.GioHang.NgayThanhToan, dbo.GioHang.TenNguoiNhan, dbo.GioHang.DiaChi, dbo.GioHang.Sdt,  "
                + "                  dbo.GioHang.TinhTrang "
                + "FROM     dbo.GioHang INNER JOIN "
                + "                  dbo.KhachHang ON dbo.GioHang.IdKH = dbo.KhachHang.Id";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<GioHang> listGioHang = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                KhachHang idKH = new KhachHang(UUID.fromString(rs.getString(2)));
//                NhanVien idNV = new NhanVien(UUID.fromString(rs.getString(3)));
//                GioHang gioHang = new GioHang(UUID.fromString(rs.getString(1)), idKH, idNV, rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));

                KhachHang idKH = new KhachHang(UUID.fromString(rs.getString(2)), rs.getString(3));
                NhanVien idNV = new NhanVien(UUID.fromString(rs.getString(4)));
                GioHang gioHang = new GioHang(UUID.fromString(rs.getString(1)), idKH, idNV, rs.getString(5), rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
                listGioHang.add(gioHang);
            }
            return listGioHang;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(GioHang gioHang) {
        String query = "INSERT INTO [dbo].[GioHang] "
                + "           ([IdKH] "
                + "           ,[IdNV] "
                + "           ,[Ma] "
                + "           ,[NgayTao] "
                + "           ,[NgayThanhToan] "
                + "           ,[TenNguoiNhan] "
                + "           ,[DiaChi] "
                + "           ,[Sdt] "
                + "           ,[TinhTrang]) "
                + "     VALUES "
                + "           (?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gioHang.getIdKH().getId());
            ps.setObject(2, gioHang.getIdNV().getId());
            ps.setObject(3, gioHang.getMa());
            ps.setObject(4, gioHang.getNgayTao());
            ps.setObject(5, gioHang.getNgayThanhToan());
            ps.setObject(6, gioHang.getTenNguoiNhan());
            ps.setObject(7, gioHang.getDiaChi());
            ps.setObject(8, gioHang.getSdt());
            ps.setObject(9, gioHang.getTinhTrang());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(GioHang gioHang, UUID id) {
        String query = "UPDATE [dbo].[GioHang] "
                + "   SET [IdKH] = ? "
                + "      ,[IdNV] = ? "
                + "      ,[Ma] = ? "
                + "      ,[NgayTao] = ? "
                + "      ,[NgayThanhToan] = ? "
                + "      ,[TenNguoiNhan] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[Sdt] = ? "
                + "      ,[TinhTrang] = ? "
                + " WHERE Id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, gioHang.getIdKH().getId());
            ps.setObject(2, gioHang.getIdNV().getId());
            ps.setObject(3, gioHang.getMa());
            ps.setObject(4, gioHang.getNgayTao());
            ps.setObject(5, gioHang.getNgayThanhToan());
            ps.setObject(6, gioHang.getTenNguoiNhan());
            ps.setObject(7, gioHang.getDiaChi());
            ps.setObject(8, gioHang.getSdt());
            ps.setObject(9, gioHang.getTinhTrang());
            ps.setObject(10, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean detele(UUID id) {
        String query = "DELETE FROM [dbo].[GioHang] "
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
        System.out.println(new GioHangRepository().getAll());
    }
}
