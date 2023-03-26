/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.orders;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import swp391.utils.DBHelper;

/**
 *
 * @author Chau Nhat Truong
 */
public class OrdersDAO implements Serializable {

    public List<Integer> addToOrders(int customerID, int paymentID, int shippingID, int Status, String cusName, String cusPhone, String cusAddress)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        long milis = System.currentTimeMillis();
        Date date = new Date(milis);
        List<Integer> generatedKeys = new ArrayList<>();
        try {
            //1. connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into Orders("
                        + "CustomerID, PaymentID, ShippingID, DateOrders, Status, "
                        + " CusName, CusPhone, CusAddress"
                        + ") "
                        + "Values("
                        + " ?, ?, ?, ?, ?, ?, ?, ?"
                        + ")";
                stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                stm.setInt(1, customerID);
                stm.setInt(2, paymentID);
                stm.setInt(3, shippingID);
                stm.setDate(4, date);
                stm.setInt(5, Status);
                stm.setString(6, cusName);
                stm.setString(7, cusPhone);
                stm.setString(8, cusAddress);
                stm.executeUpdate();
                rs = stm.getGeneratedKeys();

                if (rs.next()) {
                    generatedKeys.add(rs.getInt(1));
                }
                return generatedKeys;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return generatedKeys;
    }

    private List<OrdersDTO> ordersList;

    public List<OrdersDTO> getOrdersList() {
        return ordersList;
    }

    public List<OrdersDTO> getCustomerShippingInFoByCusID(int customerId) throws NamingException {
        List<OrdersDTO> customerDetails = new ArrayList<>();
        String sql = "SELECT MIN(o.OrdersID) AS OrdersID, o.CusName, o.CusPhone, o.CusAddress\n"
                + "FROM Orders o\n"
                + "INNER JOIN Customer c ON c.CustomerID = o.CustomerID\n"
                + "WHERE c.CustomerID = ? AND o.CusName IS NOT NULL\n"
                + "GROUP BY o.CusName, o.CusPhone, o.CusAddress";
        try (Connection conn = DBHelper.makeConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ordersDtID = rs.getInt("OrdersID");
                String cusName = rs.getString("CusName");
                String cusPhone = rs.getString("CusPhone");
                String cusAddress = rs.getString("CusAddress");
                OrdersDTO ordersDetail = new OrdersDTO(ordersDtID, cusName, cusPhone, cusAddress);
                customerDetails.add(ordersDetail);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customerDetails;
    }

    public OrdersDTO getShippingInFoByCusID(int customerId) throws NamingException {
        OrdersDTO customerDetails = null;
        String sql = "SELECT TOP 1 OrdersID, CusName, CusPhone, CusAddress, DateOrders\n"
                + "FROM Orders\n"
                + "WHERE CustomerID = ? AND CusName IS NOT NULL AND CusPhone IS NOT NULL AND CusAddress IS NOT NULL\n"
                + "ORDER BY OrdersID DESC";
        try (Connection conn = DBHelper.makeConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ordersDtID = rs.getInt("OrdersID");
                String cusName = rs.getString("CusName");
                String cusPhone = rs.getString("CusPhone");
                String cusAddress = rs.getString("CusAddress");
                Date dateOders = rs.getDate("DateOrders");
                customerDetails = new OrdersDTO(ordersDtID, dateOders, cusName, cusPhone, cusAddress);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customerDetails;
    }

    //Lay orders id moi nhat tuc la cai vua moi add vo
    public int getOrdersIdLastes() throws NamingException {
        int ordersIdLastest = 0;
        String sql = "select top 1 OrdersID from Orders order by OrdersID desc;";
        try (Connection conn = DBHelper.makeConnection();
                Statement s = conn.createStatement()) {

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                ordersIdLastest = rs.getInt("OrdersID");
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ordersIdLastest;
    }

   

    public List<OrdersDTO> getOrdersByCusId(int cusId) throws NamingException {
        List<OrdersDTO> list = new ArrayList<>();
        String sql = "select TOP 1 * from Orders where CustomerID = ? order by OrdersID desc";
        try (Connection conn = DBHelper.makeConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cusId);
            ResultSet rs = pstmt.executeQuery();
            /*
            public OrdersDTO(int ordersID, int customerID, int shippingID, Date dateOrders, int status, String cusName) {
        this.ordersID = ordersID;
        this.customerID = customerID;
        this.shippingID = shippingID;
        this.dateOrders = dateOrders;
        this.status = status;
        this.cusName = cusName;
    }
             */
            while (rs.next()) {
                int orderID = rs.getInt("OrdersID");

                int customerID = rs.getInt("CustomerID");
                int shippingID = rs.getInt("ShippingID");
                Date DateOrders = rs.getDate("DateOrders");
                int status = rs.getInt("Status");
                String cusName = rs.getString("CusName");

                OrdersDTO orders = new OrdersDTO(orderID, customerID, shippingID, DateOrders, status, cusName);
                list.add(orders);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      public boolean addToOrders(int customerID, int key)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        long milis = System.currentTimeMillis();
        Date date = new Date(milis);
        boolean result = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Insert Into Orders("
                        + " CustomerID, DateOrders, OrdersDtID"
                        + ") "
                        + "Values("
                        + " ?, ?, ?"
                        + ")";
                stm = con.prepareStatement(sql);
                stm.setInt(1, customerID);
                stm.setDate(2, date);
                stm.setInt(3, key);
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

    private List<OrdersDTO> ordersList1;

    public List<OrdersDTO> getOrdersList1() {
        return ordersList1;
    }

    private List<OrdersDTO> ordersList2;

    public List<OrdersDTO> getOrdersList2() {
        return ordersList2;
    }

    private List<OrdersDTO> ordersList3;

    public List<OrdersDTO> getOrdersList3() {
        return ordersList3;
    }

    private List<OrdersDTO> ordersList4;

    public List<OrdersDTO> getOrdersList4() {
        return ordersList4;
    }

    public void showOrders(int ordersID)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select OrdersID, CustomerID, DateOrders "
                        + "From Orders "
                        + "Where OrdersID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ordersID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    ordersID = rs.getInt("OrdersID");
                    int customerID = rs.getInt("CustomerID");
                    Date dateOrders = rs.getDate("DateOrders");
                    OrdersDTO dto = new OrdersDTO(ordersID, customerID, dateOrders);
                    if (this.ordersList1 == null) {
                        this.ordersList1 = new ArrayList<>();
                    }
                    this.ordersList1.add(dto);
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

    public void searchOrdersByDate(Date dateFrom, Date dateTo)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "Select OrdersID, CustomerID, DateOrders "
                        + "From Orders "
                        + "Where DateOrders Between ? And ? ";
                stm = con.prepareStatement(sql);
                stm.setDate(1, dateFrom);
                stm.setDate(2, dateTo);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int ordersId = rs.getInt("OrdersID");
                    int customerID = rs.getInt("CustomerID");
                    Date dateOrders = rs.getDate("DateOrders");
                    OrdersDTO dto = new OrdersDTO(ordersId, customerID, dateOrders);
                    if (this.ordersList1 == null) {
                        this.ordersList1 = new ArrayList<>();
                    }
                    this.ordersList1.add(dto);
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

    public void showOrdersRevenueByMonth()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = " SELECT MONTH(o.DateOrders) AS month, YEAR(o.DateOrders) AS year, SUM(od.Total) AS revenue "
                        + " FROM Orders o "
                        + " INNER JOIN OrdersDetail od ON o.OrdersID = od.OrdersID "
                        + " WHERE YEAR(o.DateOrders) = YEAR(GETDATE()) AND MONTH(o.DateOrders) = MONTH(GETDATE()) "
                        + " GROUP BY MONTH(o.DateOrders), YEAR(o.DateOrders)";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int month = rs.getInt("month");
                    int year = rs.getInt("year");
                    float revenue = rs.getFloat("revenue");
                    OrdersDTO dto = new OrdersDTO(month, year, revenue);
                    if (this.ordersList1 == null) {
                        this.ordersList1 = new ArrayList<>();
                    }
                    this.ordersList1.add(dto);
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

    public void showOrdersRevenueByMonthAndYear(int newYear, int newMonth)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = " SELECT MONTH(o.DateOrders) AS month, YEAR(o.DateOrders) AS year, SUM(od.Total) AS revenue "
                        + " FROM Orders o "
                        + " INNER JOIN OrdersDetail od ON o.OrdersID = od.OrdersID "
                        + " WHERE YEAR(o.DateOrders) = ? AND MONTH(o.DateOrders) = ? "
                        + " GROUP BY MONTH(o.DateOrders), YEAR(o.DateOrders) ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, newYear);
                stm.setInt(2, newMonth);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int month = rs.getInt("month");
                    int year = rs.getInt("year");
                    float revenue = rs.getFloat("revenue");
                    OrdersDTO dto = new OrdersDTO(month, year, revenue);
                    if (this.ordersList1 == null) {
                        this.ordersList1 = new ArrayList<>();
                    }
                    this.ordersList1.add(dto);
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

    public void showOrdersRevenueByYear()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = " SELECT YEAR(o.DateOrders) AS year, SUM(od.Total) AS revenue "
                        + " FROM Orders o "
                        + " INNER JOIN OrdersDetail od ON o.OrdersID = od.OrdersID "
                        + " WHERE YEAR(o.DateOrders) = YEAR(GETDATE()) "
                        + " GROUP BY YEAR(o.DateOrders) ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int year = rs.getInt("year");
                    float revenue = rs.getFloat("revenue");
                    OrdersDTO dto = new OrdersDTO(year, revenue);
                    if (this.ordersList2 == null) {
                        this.ordersList2 = new ArrayList<>();
                    }
                    this.ordersList2.add(dto);
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
    
    
    public void showOrdersRevenueByYearSearch(int yearRevenue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = " SELECT YEAR(o.DateOrders) AS year, SUM(od.Total) AS revenue "
                        + " FROM Orders o "
                        + " INNER JOIN OrdersDetail od ON o.OrdersID = od.OrdersID "
                        + " WHERE YEAR(o.DateOrders) = ? "
                        + " GROUP BY YEAR(o.DateOrders) ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, yearRevenue);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int year = rs.getInt("year");
                    float revenue = rs.getFloat("revenue");
                    OrdersDTO dto = new OrdersDTO(year, revenue);
                    if (this.ordersList2 == null) {
                        this.ordersList2 = new ArrayList<>();
                    }
                    this.ordersList2.add(dto);
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
    
    
    

    public void showTotalOrdersByMonth()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = " SELECT MONTH(DateOrders) AS month, YEAR(DateOrders) AS year, COUNT(*) AS totalOrders " +
                                " FROM Orders " +
                                " WHERE YEAR(DateOrders) = YEAR(GETDATE())  AND MONTH(DateOrders) = MONTH(GETDATE())" +
                                " GROUP BY MONTH(DateOrders), YEAR(DateOrders)" +
                                " ORDER BY MONTH(DateOrders), YEAR(DateOrders) ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int month = rs.getInt("month");
                    int year = rs.getInt("year");
                    int totalOrders = rs.getInt("totalOrders");
                    OrdersDTO dto = new OrdersDTO(month, year, totalOrders);
                    if (this.ordersList3 == null) {
                        this.ordersList3 = new ArrayList<>();
                    }
                    this.ordersList3.add(dto);
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

    public void showTotalOrdersByMonthAndYear(int newYear, int newMonth)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = " SELECT MONTH(DateOrders) AS month, YEAR(DateOrders) as year, COUNT(*) AS totalOrders "
                        + " FROM Orders "
                        + " WHERE YEAR(DateOrders) = ? AND MONTH(DateOrders) = ? "
                        + " GROUP BY MONTH(DateOrders), YEAR(DateOrders)"
                        + " ORDER BY MONTH(DateOrders), YEAR(DateOrders)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, newYear);
                stm.setInt(2, newMonth);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int month = rs.getInt("month");
                    int year = rs.getInt("year");
                    int totalOrders = rs.getInt("totalOrders");
                    OrdersDTO dto = new OrdersDTO(month, year, totalOrders);
                    if (this.ordersList3 == null) {
                        this.ordersList3 = new ArrayList<>();
                    }
                    this.ordersList3.add(dto);
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

    public void showTotalOrdersByYear()
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = " SELECT YEAR(DateOrders) AS year, COUNT(*) AS totalOrders "
                        + " FROM Orders "
                        + " WHERE YEAR(DateOrders) = YEAR(GETDATE()) "
                        + " GROUP BY YEAR(DateOrders) "
                        + "  ORDER BY  YEAR(DateOrders) ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int year = rs.getInt("year");
                    int totalOrders = rs.getInt("totalOrders");
                    OrdersDTO dto = new OrdersDTO(year, totalOrders);
                    if (this.ordersList4 == null) {
                        this.ordersList4 = new ArrayList<>();
                    }
                    this.ordersList4.add(dto);
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
    
    
    
    public void showTotalOrdersByYearSearch(int yearOrder)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = " SELECT YEAR(DateOrders) AS year, COUNT(*) AS totalOrders "
                        + " FROM Orders "
                        + " WHERE YEAR(DateOrders) = ? "
                        + " GROUP BY YEAR(DateOrders) "
                        + "  ORDER BY  YEAR(DateOrders) ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, yearOrder);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int year = rs.getInt("year");
                    int totalOrders = rs.getInt("totalOrders");
                    OrdersDTO dto = new OrdersDTO(year, totalOrders);
                    if (this.ordersList4 == null) {
                        this.ordersList4 = new ArrayList<>();
                    }
                    this.ordersList4.add(dto);
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
    

    
    
    

//    public void showOrdersID()
//            throws SQLException, NamingException {
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            con = DBHelper.makeConnection();
//            if (con != null) {
//                String sql = "Select OrdersID "
//                        + "From Orders";
//                stm = con.prepareStatement(sql);
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    int ordersID = rs.getInt("OrdersID");
//                    OrdersDTO dto = new OrdersDTO(ordersID);
//                    if (this.ordersList == null) {
//                        this.ordersList = new ArrayList<>();
//                    }
//                    this.ordersList.add(dto);
//                }
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        }
//    }
}
