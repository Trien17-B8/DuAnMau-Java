/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChucVu;
import Utilities.SQLServerConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author hp
 */
public class ChucVuRepository implements IChucVuRepository {

    @Override
    public List<ChucVu> getAll() {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[ChucVu]";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            List<ChucVu> listChucVu = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UUID id = UUID.fromString(rs.getString(1));
                ChucVu chucVu = new ChucVu(id, rs.getString(2), rs.getString(3));
                listChucVu.add(chucVu);
            }
            return listChucVu;
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public ChucVu getOne(UUID id) {
        String query = "SELECT [Id] "
                + "      ,[Ma] "
                + "      ,[Ten] "
                + "  FROM [dbo].[ChucVu] "
                + "  WHERE id = ?";
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ChucVu(UUID.fromString(rs.getString(1)), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean insert(ChucVu chucVu) {
        String query = "INSERT INTO [dbo].[ChucVu] "
                + "           ([Ma] "
                + "           ,[Ten]) "
                + "     VALUES "
                + "           (?,?)";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, chucVu.getMa());
            ps.setObject(2, chucVu.getTen());
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(ChucVu chucVu, UUID id) {
        String query = "UPDATE [dbo].[ChucVu] "
                + "   SET[Ma] = ? "
                + "      ,[Ten] = ? "
                + " WHERE id = ? ";
        int check = 0;
        try ( Connection con = SQLServerConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, chucVu.getMa());
            ps.setObject(2, chucVu.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(UUID id) {
        String query = "DELETE FROM [dbo].[ChucVu] "
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
