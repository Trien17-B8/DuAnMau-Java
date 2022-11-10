/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.CuaHang;
import Utilities.SQLServerConnection;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class CuaHangRepository implements ICuaHangRepository {

    @Override
    public List<CuaHang> getAll() {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "      ,[DiaChi] "
                + "      ,[ThanhPho] "
                + "      ,[QuocGia] "
                + "  FROM [dbo].[CuaHang]";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<CuaHang> listCuaHang = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CuaHang cuaHang = new CuaHang(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                listCuaHang.add(cuaHang);
            }
            return listCuaHang;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public CuaHang getOne(UUID id) {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "      ,[DiaChi] "
                + "      ,[ThanhPho] "
                + "      ,[QuocGia] "
                + "  FROM [dbo].[CuaHang] "
                + "  WHERE id = ?";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new CuaHang(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(CuaHang cuaHang) {
        String query = "INSERT INTO [dbo].[CuaHang] "
                + "           ([Ma] "
                + "           ,[Ten] "
                + "           ,[DiaChi] "
                + "           ,[ThanhPho] "
                + "           ,[QuocGia]) "
                + "     VALUES "
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cuaHang.getMa());
            ps.setObject(2, cuaHang.getTen());
            ps.setObject(3, cuaHang.getDiaChi());
            ps.setObject(4, cuaHang.getThanhPho());
            ps.setObject(5, cuaHang.getQuocGia());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(CuaHang cuaHang, UUID id) {
        String query = "UPDATE [dbo].[CuaHang] "
                + "   SET [Ma] = ? "
                + "      ,[Ten] = ? "
                + "      ,[DiaChi] = ? "
                + "      ,[ThanhPho] = ? "
                + "      ,[QuocGia] = ? "
                + " WHERE Id =?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cuaHang.getMa());
            ps.setObject(2, cuaHang.getTen());
            ps.setObject(3, cuaHang.getDiaChi());
            ps.setObject(4, cuaHang.getThanhPho());
            ps.setObject(5, cuaHang.getQuocGia());
            ps.setObject(6, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[CuaHang] "
                + "      WHERE id = ?";
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
        System.out.println(new CuaHangRepository().getOne(UUID.fromString("E2329F70-3753-448A-893E-CA5BBF6B4E60")));
    }

}
