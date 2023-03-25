/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.orders;

import java.io.Serializable;
import java.sql.Date;
import swp391.ordersdetail.OrdersDetailDAO;
import swp391.shippingmethod.ShippingMethodDAO;

/**
 *
 * @author Chau Nhat Truong
 */
public class OrdersDTO implements Serializable {

    private int ordersID;
    private int customerID;
    private int shippingID;
    private Date dateOrders;
    private int status;
    private String cusName;
    private String cusPhone;
    private String cusAddress;


    public OrdersDTO(int ordersID, int customerID, int shippingID, Date dateOrders, int status, String cusName) {
        this.ordersID = ordersID;
        this.customerID = customerID;
        this.shippingID = shippingID;
        this.dateOrders = dateOrders;
        this.status = status;
        this.cusName = cusName;
    }
            
    public String getNameOfMethod(){
        ShippingMethodDAO shippingMethodDAO = new ShippingMethodDAO();
        String nameOfMethod = shippingMethodDAO.getShippingNameByShippingId(this.shippingID);
        return nameOfMethod;
    }
    public OrdersDTO() {
    }
    
    public float getTotal(){
        float total = 0;
        OrdersDetailDAO dAO = new OrdersDetailDAO();
        total = total + dAO.getTotalCartByOrdersId(this.ordersID);
        return total;
    }
    
    public OrdersDTO(int ordersID, String cusName, String cusPhone, String cusAddress) {
        this.ordersID = ordersID;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }

//    public OrdersDTO(int customerID, String cusName, String cusPhone, String cusAddress) {
//        this.customerID = customerID;
//        this.cusName = cusName;
//        this.cusPhone = cusPhone;
//        this.cusAddress = cusAddress;
//    }

    public OrdersDTO(int ordersID, Date dateOrders, String cusName, String cusPhone, String cusAddress) {
        this.ordersID = ordersID;
        this.dateOrders = dateOrders;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }
    
    

    public OrdersDTO(int ordersID, int customerID, int shippingID, Date dateOrders, int status, String cusName, String cusPhone, String cusAddress) {
        this.ordersID = ordersID;
        this.customerID = customerID;
        this.shippingID = shippingID;
        this.dateOrders = dateOrders;
        this.status = status;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
    }

    public int getOrdersID() {
        return ordersID;
    }

    public void setOrdersID(int ordersID) {
        this.ordersID = ordersID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getShippingID() {
        return shippingID;
    }

    public void setShippingID(int shippingID) {
        this.shippingID = shippingID;
    }

    public Date getDateOrders() {
        return dateOrders;
    }

    public void setDateOrders(Date dateOrders) {
        this.dateOrders = dateOrders;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    

}
