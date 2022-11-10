/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NSX;
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
public class NSXRepository implements INSXRepository {

    @Override
    public List<NSX> getAll() {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[NSX]";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<NSX> listNSX = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NSX nsx = new NSX(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3));
                listNSX.add(nsx);
            }
            return listNSX;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public NSX getOne(UUID id) {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[NSX] "
                + "  WHERE id =?";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new NSX(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new NSXRepository().getAll());
    }

    @Override
    public boolean insert(NSX nsx) {
        String query = "INSERT INTO [dbo].[NSX] "
                + "           ([Ma] "
                + "           ,[Ten]) "
                + "     VALUES "
                + "           (?,?) ";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nsx.getMa());
            ps.setObject(2, nsx.getTen());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(NSX nsx, UUID id) {
        String query = "UPDATE [dbo].[NSX] "
                + "   SET [Ma] = ? "
                + "      ,[Ten] = ? "
                + " WHERE Id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, nsx.getMa());
            ps.setObject(2, nsx.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[NSX] "
                + "      WHERE Id = ? ";
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
