/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChucVu;
import DomainModels.CuaHang;
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
public class NhanVienRepository implements INhanVienRepository {

    @Override
    public List<NhanVien> getAll() {
        String query = "SELECT dbo.NhanVien.Id, dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.TenDem, dbo.NhanVien.Ho, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.DiaChi, dbo.NhanVien.Sdt, dbo.NhanVien.MatKhau,  "
                + "                  dbo.CuaHang.Id , dbo.CuaHang.Ten , dbo.ChucVu.Id , dbo.ChucVu.Ten ,dbo.NhanVien.Id,  dbo.NhanVien.Ho+' '+dbo.NhanVien.TenDem+' '+dbo.NhanVien.Ten,  dbo.NhanVien.TrangThai "
                + "FROM     dbo.CuaHang INNER JOIN "
                + "                  dbo.NhanVien ON dbo.CuaHang.Id = dbo.NhanVien.IdCH INNER JOIN "
                + "                  dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<NhanVien> listNhanVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang idCh = new CuaHang(UUID.fromString(rs.getString(11)), rs.getString(12));
                ChucVu idCv = new ChucVu(UUID.fromString(rs.getString(13)), rs.getString(14));
                NhanVien idGuiBc = new NhanVien(UUID.fromString(rs.getString(15)), rs.getString(16));
                NhanVien nv = new NhanVien(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), idCh, idCv, idGuiBc, rs.getInt(17));
                listNhanVien.add(nv);
            }
            return listNhanVien;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public NhanVien getOne(UUID id) {
        String query = "SELECT dbo.NhanVien.Id, dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.TenDem, dbo.NhanVien.Ho, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.DiaChi, dbo.NhanVien.Sdt, dbo.NhanVien.MatKhau,  "
                + "                  dbo.CuaHang.Id , dbo.CuaHang.Ten , dbo.ChucVu.Id , dbo.ChucVu.Ten ,dbo.NhanVien.Id,  dbo.NhanVien.Ho+' '+dbo.NhanVien.TenDem+' '+dbo.NhanVien.Ten,  dbo.NhanVien.TrangThai "
                + "FROM     dbo.CuaHang INNER JOIN "
                + "                  dbo.NhanVien ON dbo.CuaHang.Id = dbo.NhanVien.IdCH INNER JOIN "
                + "                  dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id "
                + "WHERE NhanVien.Id = ?";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CuaHang idCh = new CuaHang(UUID.fromString(rs.getString(11)), rs.getString(12));
                ChucVu idCv = new ChucVu(UUID.fromString(rs.getString(13)), rs.getString(14));
                NhanVien idGuiBc = new NhanVien(UUID.fromString(rs.getString(15)), rs.getString(16));
                return new NhanVien(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getString(10), idCh, idCv, idGuiBc, rs.getInt(17));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(NhanVien nv) {
        String query = "INSERT INTO [dbo].[NhanVien] "
                + "           ([Ma] "
                + "           ,[Ten] "
                + "           ,[TenDem] "
                + "           ,[Ho] "
                + "           ,[GioiTinh] "
                + "           ,[NgaySinh] "
                + "           ,[DiaChi] "
                + "           ,[Sdt] "
                + "           ,[MatKhau] "
                + "           ,[IdCH] "
                + "           ,[IdCV] "
                + "           ,[IdGuiBC] "
                + "           ,[TrangThai]) "
                + "     VALUES "
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getNgaySinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getSdt());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getIdCh().getId());
            ps.setObject(11, nv.getIdCv().getId());
            ps.setObject(12, nv.getIdGuiBC().getId());
            ps.setObject(13, nv.getTrangThai());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(NhanVien nv, UUID id) {
        String query = "UPDATE [dbo].[NhanVien] "
                + "   SET [Ma] = ? "
                + "      ,[Ten] = ? "
                + "      ,[TenDem] = ? "
                + "      ,[Ho] = ? "
                + "      ,[GioiTinh] = ? "
                + "      ,[NgaySinh] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[Sdt] = ? "
                + "      ,[MatKhau] = ? "
                + "      ,[IdCH] = ? "
                + "      ,[IdCV] = ? "
                + "      ,[IdGuiBC] = ? "
                + "      ,[TrangThai] = ? "
                + " WHERE Id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getTenDem());
            ps.setObject(4, nv.getHo());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getNgaySinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getSdt());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getIdCh().getId());
            ps.setObject(11, nv.getIdCv().getId());
            ps.setObject(12, nv.getIdGuiBC().getId());
            ps.setObject(13, nv.getTrangThai());
            ps.setObject(14, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[NhanVien] "
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
        //System.out.println(new NhanVienRepository().getOne(UUID.fromString("90288D94-69FF-4A1A-90BE-1FCAA636B3E8")));
        CuaHang idCh = new CuaHang(UUID.fromString("FBC50C56-5AB7-47F8-A54D-D42A88FC06C4"));
        ChucVu idCv = new ChucVu(UUID.fromString("2B35FE1A-9BF0-4547-9005-F20AE7086E7E"));
        NhanVien idNv = new NhanVien(UUID.fromString("169DF180-F71F-4016-BA9C-7FCACA663966"));
        Date ngaySinh = new Date();
        NhanVien nv = new NhanVien("2", "SG", "SD", "UU", "Nam", ngaySinh, "SDD", "0002255", "RRRE", idCh, idCv, idNv, 1);
        System.out.println(ngaySinh);
    }
}
