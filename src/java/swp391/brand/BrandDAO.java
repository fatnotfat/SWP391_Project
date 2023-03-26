/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.brand;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import swp391.utils.DBHelper;

/**
 *
 * @author Chau Nhat Truong
 */
public class BrandDAO implements Serializable {

    public boolean createBrand(BrandDTO dto)
            throws SQLException, NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        long milis = System.currentTimeMillis();
        Date date = new Date(milis);
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into Brand("
                        + "Name, Description, CreateTime, Status "
                        + ") "
                        + "Values(?, ?, ? , ? "
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getDescription());
                stm.setDate(3, date);
                stm.setBoolean(4, dto.isStatus());
                int effectedRows = stm.executeUpdate();
                if (effectedRows > 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    private List<BrandDTO> brandsList;

    public List<BrandDTO> getBrandsList() {
        return brandsList;
    }

    public void showBrand()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select BrandID, Name, Description, Status "
                        + "From Brand";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int brandID = rs.getInt("BrandID");
                    String name = rs.getString("Name");
                    String description = rs.getString("Description");
                    Boolean status = rs.getBoolean("Status");
                    BrandDTO dto = new BrandDTO(brandID, name, description, status);
                    if (this.brandsList == null) {
                        this.brandsList = new ArrayList<>();
                    }
                    this.brandsList.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public boolean updateBrand(int brandID, String name, String description, boolean status)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            String sql = "Update Brand "
                    + "Set Name = ?, Description = ?, Status = ? "
                    + "Where BrandID = ?";
            //3. Create statement
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, description);
             stm.setBoolean(3, status);
            stm.setInt(4, brandID);
            int effectedRows = stm.executeUpdate();
            if (effectedRows > 0) {
                result = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

    public boolean deleteBrand(int brandID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            String sql = "Update Brand "
                    + "Set Status = 0 "
                    + "Where BrandID = ?";
            //3. Create statement
            stm = con.prepareStatement(sql);
            stm.setInt(1, brandID);
            int effectedRows = stm.executeUpdate();
            if (effectedRows > 0) {
                result = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
