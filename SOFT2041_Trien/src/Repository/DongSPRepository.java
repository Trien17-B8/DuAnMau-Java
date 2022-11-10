/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.DongSP;
import Utilities.SQLServerConnection;
import ViewModels.QLDongSP;
import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class DongSPRepository implements IDongSPRepository {

    @Override
    public List<DongSP> getAll() {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[DongSP]";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<DongSP> listDongSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongSP dongSP = new DongSP(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3));
                listDongSP.add(dongSP);
            }
            return listDongSP;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public DongSP getOne(UUID id) {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[DongSP] "
                + "  WHERE id = ?";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new DongSP(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(2));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(DongSP dongSP) {
        String query = "INSERT INTO [dbo].[DongSP] "
                + "           ([Ma] "
                + "           ,[Ten]) "
                + "     VALUES "
                + "           (?, ?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, dongSP.getMa());
            ps.setObject(2, dongSP.getTen());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(DongSP dongSP, UUID id) {
        String query = "UPDATE [dbo].[DongSP] "
                + "   SET [Ma] = ? "
                + "      ,[Ten] = ? "
                + " WHERE Id = ?";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, dongSP.getMa());
            ps.setObject(2, dongSP.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[DongSP] "
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
