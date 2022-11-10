/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.MauSac;
import Utilities.SQLServerConnection;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class MauSacRepository implements IMauSacRepository {

    @Override
    public List<MauSac> getAll() {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[MauSac]";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<MauSac> listMauSac = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac mauSac = new MauSac(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3));
                listMauSac.add(mauSac);
            }
            return listMauSac;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public MauSac getOne(UUID id) {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[MauSac] "
                + "  WHERE id = ?";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new MauSac(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new MauSacRepository().getAll());
    }

    @Override
    public boolean insert(MauSac ms) {
        String query = "INSERT INTO [dbo].[MauSac] "
                + "           ([Ma] "
                + "           ,[Ten]) "
                + "     VALUES "
                + "           (?,?) ";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getTen());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(MauSac ms, UUID id) {
        String query = "UPDATE [dbo].[MauSac] "
                + "   SET[Ma] = ? "
                + "      ,[Ten] = ? "
                + " WHERE Id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ms.getMa());
            ps.setObject(2, ms.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[MauSac] "
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
