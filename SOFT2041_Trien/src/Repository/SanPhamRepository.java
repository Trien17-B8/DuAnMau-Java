/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPham;
import Utilities.SQLServerConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class SanPhamRepository implements ISanPhamRepository {

    @Override
    public List<SanPham> getAll() {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[SanPham]";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<SanPham> listSanPham = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString(1));
                SanPham sanPham = new SanPham(id, rs.getString(2), rs.getString(3));
                listSanPham.add(sanPham);
            }
            return listSanPham;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public SanPham getOne(UUID id) {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[SanPham] "
                + "  WHERE id = ?";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new SanPham(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        SanPhamRepository s = new SanPhamRepository();
        System.out.println(s.getAll());
    }

    @Override
    public boolean insert(SanPham sanPham) {
        String query = "INSERT INTO [dbo].[SanPham] "
                + "           ([Ma] "
                + "           ,[Ten]) "
                + "     VALUES "
                + "           (?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sanPham.getMa());
            ps.setObject(2, sanPham.getTen());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(SanPham sanPham, UUID id) {
        String query = "UPDATE [dbo].[SanPham] "
                + "   SET[Ma] = ? "
                + "      ,[Ten] = ? "
                + " WHERE id = ? ";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sanPham.getMa());
            ps.setObject(2, sanPham.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[SanPham] "
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
}
