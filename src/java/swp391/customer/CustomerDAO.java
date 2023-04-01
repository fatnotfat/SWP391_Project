
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.customer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import swp391.utils.DBHelper;

/**
 *
 * @author Chau Nhat Truong
 */
public class CustomerDAO implements Serializable {

    public CustomerDTO checkLogin(String email, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        CustomerDTO result = null;
        try {
            //connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //Create SQL String
                String sql = "Select CustomerID, Name, Email, Phone, Address, RankID, Sex, DateOfBirth, TypeOfLogin, Role, Status "
                        + "From Customer "
                        + "Where email = ? And Password = ? ";

                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                //ExecuteQuery
                rs = stm.executeQuery();
                //Process result
                while (rs.next()) {
                    String name = rs.getString("Name");
                    int id = rs.getInt("CustomerID");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    int rankID = rs.getInt("RankID");
                    boolean sex = rs.getBoolean("Sex");
                    Date dob = rs.getDate("DateOfBirth");
                    int typeOfLogin = rs.getInt("TypeOfLogin");
                    boolean role = rs.getBoolean("Role");
                    boolean status = rs.getBoolean("Status");
                    
                    result = new CustomerDTO(id, name, dob, email, phone, address, rankID, sex, typeOfLogin, role, status);
                }
            }//end con is available
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
        return result;
    }

    private List<CustomerDTO> accountList;

    public List<CustomerDTO> getAccountList() {
        return accountList;
    }

    public boolean createAccount(CustomerDTO dto)
            throws SQLException, NamingException, ParseException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Insert Into Customer("
                        + "Name, Password, DateOfBirth, Email, Phone, Address, Role, RankID, Sex, TypeOfLogin"
                        + ") "
                        + "Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
                        + ")";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setString(2, dto.getPassword());
                if (dto.getBirthDate() != null) {
                    java.sql.Date sqlDate = new java.sql.Date(dto.getBirthDate().getTime());
                    stm.setDate(3, sqlDate);
                } else {
                    String date = "1-1-1999";
                    DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
                    Date defaultDate = df.parse(date);
                    java.sql.Date sqlDate = new java.sql.Date(defaultDate.getTime());
                    stm.setDate(3, sqlDate);
                }
                stm.setString(4, dto.getEmail());
                stm.setString(5, dto.getPhone());
                stm.setString(6, dto.getAddress());
                stm.setBoolean(7, dto.isRole());
                stm.setInt(8, dto.getRankID());
                stm.setBoolean(9, dto.isSex());
                stm.setInt(10, dto.getTypeOfLogin());
                //4. ExecuteQuery
                int effectedRows = stm.executeUpdate();
                //5. Process result
                if (effectedRows > 0) {
                    result = true;
                }
            }//end con is available
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

    public boolean checkEmail(String email)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select Email "
                        + "From Customer "
                        + "Where Email = ?";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                //4. ExecuteQuery
                rs = stm.executeQuery();
                //5. Process result
                if (rs.next()) {
                    return true;
                }
            }//end con is available
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
        return result;
    }

    public CustomerDTO checkEmailAlreadyRegister(String email)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        CustomerDTO dto = null;
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Create SQL String
                String sql = "Select CustomerID, Name, Email, Phone, Address, RankID, Sex, DateOfBirth, TypeOfLogin, Role, Status "
                        + "From Customer "
                        + "Where Email = ? AND TypeOfLogin = 1";
                //3. Create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                //4. ExecuteQuery
                rs = stm.executeQuery();
                //5. Process result
                while (rs.next()) {
                    String name = rs.getString("Name");
                    int id = rs.getInt("CustomerID");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    int rankID = rs.getInt("RankID");
                    boolean sex = rs.getBoolean("Sex");
                    Date dob = rs.getDate("DateOfBirth");
                    int typeOfLogin = rs.getInt("TypeOfLogin");
                    boolean role = rs.getBoolean("Role");
                    boolean status = rs.getBoolean("Status");
                    dto = new CustomerDTO(id, name, dob, email, phone, address, rankID, sex, typeOfLogin, role, status);
                }
            }//end con is available
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
        return dto;
    }

    public boolean createAccountForShipping(String name, String email,
            String phone)
            throws SQLException, NamingException, ParseException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into Customer("
                        + "Name, Email, Phone"
                        + ") "
                        + "Values(?, ?, ?"
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, email);
                stm.setString(3, phone);
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

    public CustomerDTO loadInformationForPayment(String email)
            throws SQLException, NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        CustomerDTO result = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select CustomerID, Name, Email, Phone, Address "
                        + "From Customer "
                        + "Where Email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int customerID = rs.getInt("CustomerID");
                    String name = rs.getString("Name");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    result = new CustomerDTO(customerID, name, email, phone, address);
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
        return result;
    }

    public boolean updatePassword(String email, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //Connect DB
            con = DBHelper.makeConnection();
            //Create SQL String
            String sql = "Update Customer "
                    + "Set Password = ? "
                    + "Where Email = ?";
            //Create statement
            stm = con.prepareStatement(sql);
            stm.setString(1, password);
            stm.setString(2, email);
            //Execute query
            int effectedRows = stm.executeUpdate();
            //Process result
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

    public boolean updateAccount(CustomerDTO dto)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //Connect DB
            con = DBHelper.makeConnection();
            //Create SQL String Name, Password, DateOfBirth, Email, Phone, Address, Role, RankID, Sex, TypeOfLogin
            String sql = "Update Customer "
                    + "Set Name = ?, Password = ?, DateOfBirth = ?, "
                    + "Phone = ?, Address = ?, Role = ?, RankID = ?, Sex = ?, TypeOfLogin = ? "
                    + "Where Email = ?";
            //Create statement
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getName());
            stm.setString(2, dto.getPassword());
            if (dto.getBirthDate() != null) {
                java.sql.Date sqlDate = new java.sql.Date(dto.getBirthDate().getTime());
                stm.setDate(3, sqlDate);
            }
            stm.setString(4, dto.getPhone());
            stm.setString(5, dto.getAddress());
            stm.setBoolean(6, dto.isRole());
            stm.setInt(7, dto.getRankID());
            stm.setBoolean(8, dto.isSex());
            stm.setInt(9, dto.getTypeOfLogin());
            stm.setString(10, dto.getEmail());
            //Execute query
            int effectedRows = stm.executeUpdate();
            //Process result
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

    public boolean updateGoogleAccount(CustomerDTO dto)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            //Connect DB
            con = DBHelper.makeConnection();
            //Create SQL String Name, Password, DateOfBirth, Email, Phone, Address, Role, RankID, Sex, TypeOfLogin
            String sql = "Update Customer "
                    + "Set Name = ?, DateOfBirth = ?, "
                    + "Phone = ?, Address = ?, Role = ?, RankID = ?, Sex = ?, TypeOfLogin = ? "
                    + "Where Email = ?";
            //Create statement
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getName());
            if (dto.getBirthDate() != null) {
                java.sql.Date sqlDate = new java.sql.Date(dto.getBirthDate().getTime());
                stm.setDate(2, sqlDate);
            }
            stm.setString(3, dto.getPhone());
            stm.setString(4, dto.getAddress());
            stm.setBoolean(5, dto.isRole());
            stm.setInt(6, dto.getRankID());
            stm.setBoolean(7, dto.isSex());
            stm.setInt(8, dto.getTypeOfLogin());
            stm.setString(9, dto.getEmail());
            //Execute query
            int effectedRows = stm.executeUpdate();
            //Process result
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

    public List<CustomerDTO> getListFeedBackCustomer(int productID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<CustomerDTO> list = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select c.CustomerID, Name "
                        + "from Customer c, FeedBack b\n"
                        + "where c.CustomerID = b.CustomerID and b.ProductID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, productID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    CustomerDTO dto = new CustomerDTO(rs.getInt("CustomerID"), rs.getString("Name"));
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(dto);
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
        return list;
    }

    public void showCustomer()
            throws SQLException, NamingException {;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select CustomerID, Name, Email, Phone, Address, Status "
                        + "From Customer";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int customerID = rs.getInt("CustomerID");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    boolean status = rs.getBoolean("Status");
                    CustomerDTO dto = new CustomerDTO(customerID, name, email, phone, address, status);
                    if (this.accountList == null) {
                        this.accountList = new ArrayList<>();
                    }
                    this.accountList.add(dto);
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

    public boolean adminCreateAccount(String name, String password, String email,
            String phone, boolean role)
            throws SQLException, NamingException, ParseException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into Customer("
                        + "Name, Password, Email, Phone, Role, TypeOfLogin"
                        + ") "
                        + "Values(?, ?, ?, ?, ?, 0"
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, password);
                stm.setString(3, email);
                stm.setString(4, phone);
                stm.setBoolean(5, role);
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

    public boolean adminDeleteAccount(String email)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            String sql = "Update Customer "
                    + "Set Status = 0 "
                    + "Where Email = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, email);
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

    public boolean adminUpdateAccount(String email)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            String sql = "Update Customer "
                    + "Set Status = 1 "
                    + "Where Email = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, email);
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

    public boolean createAccountForShipping(String name, String email,
            String phone, String address)
            throws SQLException, NamingException, ParseException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into Customer("
                        + "Name, Email, Phone, Address"
                        + ") "
                        + "Values(?, ?, ?, ?"
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, email);
                stm.setString(3, phone);
                stm.setString(4, address);
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

    public boolean adminCreateAccount(String name, String password, String email,
            String phone, boolean role, boolean status)
            throws SQLException, NamingException, ParseException {;
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into Customer("
                        + "Name, Password, Email, Phone, Role, TypeOfLogin, Status"
                        + ") "
                        + "Values(?, ?, ?, ?, ?, 0, ?"
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, password);
                stm.setString(3, email);
                stm.setString(4, phone);
                stm.setBoolean(5, role);
                stm.setBoolean(6, true);

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

    public boolean checkTypeOfLogin(String email, String password)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select TypeOfLogin "
                        + "From Customer "
                        + "Where Email = ? And Password = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    return true;
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
        return result;
    }

    public String getNameOfUserByUserID(int userID) throws SQLException, NamingException {
        String userName = null;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement stm = null;
        try {
            con = DBHelper.makeConnection();
            String sql = "SELECT Name from Customer WHERE CustomerID = ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1, userID);
            rs = stm.executeQuery();
            while (rs.next()) {
                userName = rs.getString("Name");
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
        return userName;
    }

}
