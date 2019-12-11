/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PV
 */
public class Order {

    private List<Product> p;
    private String UserName;
    private String FullName;
    private String time;
    private String OrderID;
    private int Price;

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String DingDangSo(int n) {
        String u = Integer.toString(n);
        for (int i = u.length(); i > 0; i = i - 3) {
            u = u.substring(0, i) + "." + u.substring(i);

        }
        return u.substring(0, u.length() - 1);
    }

    public List<Product> getP() {
        return p;
    }

    public void setP(List<Product> p) {
        this.p = p;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return DingDangSo(Price);
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

}
