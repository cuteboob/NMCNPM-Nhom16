/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;

import entity.Member;
import entity.Order;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author PV
 */
public class ProductBLL {

    private int noOfRecords;

    public List<Product> getNewProducts(int number) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            String sql = "use SalesWebsite; select top(" + number + ") ProductID, ProductName, Image, Price, Promotion.Detail, Company, Icon, SaleOff from Product, Promotion where Product.PromotionID=Promotion.PromotionID order by NumberInStorage desc;";
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Product> prods = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("Price"));
                p.setPromotion(rs.getString("Detail"));
                p.setCompany(rs.getString("Company"));
                p.setPromotionIcon(rs.getString("Icon"));
                p.setSaleOff(rs.getFloat("SaleOff"));
                p.setProductID(rs.getString("ProductID"));
                prods.add(p);
            }
            conn.close();
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public List<Product> getCompany(String Company) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            String sql = "use SalesWebsite; select ProductID, ProductName, Image, Price, Promotion.Detail, Company, Icon, SaleOff from Product, Promotion where Product.PromotionID=Promotion.PromotionID and Company = '" + Company + "';";
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Product> prods = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("Price"));
                p.setPromotion(rs.getString("Detail"));
                p.setCompany(rs.getString("Company"));
                p.setPromotionIcon(rs.getString("Icon"));
                p.setSaleOff(rs.getFloat("SaleOff"));
                p.setProductID(rs.getString("ProductID"));
                prods.add(p);
            }
            conn.close();
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public List<Product> getPromotion(String Promotion) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            String sql = "use SalesWebsite; select ProductID, ProductName, Image, Price, Promotion.Detail, Company, Icon, SaleOff from Product, Promotion where Product.PromotionID=Promotion.PromotionID and Promotion.PromotionID = '" + Promotion + "';";
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Product> prods = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("Price"));
                p.setPromotion(rs.getString("Detail"));
                p.setCompany(rs.getString("Company"));
                p.setPromotionIcon(rs.getString("Icon"));
                p.setSaleOff(rs.getFloat("SaleOff"));
                p.setProductID(rs.getString("ProductID"));
                prods.add(p);
            }
            conn.close();
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public List<String> getNewCompany() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            String sql = "use SalesWebsite; select DISTINCT company from Product;";
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<String> prods = new ArrayList<>();
            while (rs.next()) {
                String p;
                p = rs.getString("Company");
                prods.add(p);
            }
            conn.close();
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public List<Product> getNewPromotion() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            String sql = "use SalesWebsite; select DISTINCT Promotion.Detail, Promotion.PromotionID from Product, Promotion where Product.PromotionID = Promotion.PromotionID Order By Promotion.Detail ;";
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Product> prods = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setPromotion(rs.getString("Detail"));
                p.setPromotionID(rs.getString("PromotionID"));
                prods.add(p);
            }
            conn.close();
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public List<Product> getPriceRange(String i) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            String str = null;
            switch (i) {
                case "0":
                    str = "Price*SaleOff<10000000";
                    break;
                case "1":
                    str = "Price*SaleOff>=10000000 and Price*SaleOff<=20000000";
                    break;
                case "2":
                    str = "Price*SaleOff>=20000000 and Price*SaleOff<=30000000";
                    break;
                case "3":
                    str = "Price*SaleOff>30000000";
                    break;
            }
            String sql = "use SalesWebsite; select ProductID, ProductName, Image, Price, Promotion.Detail, Company, Icon, SaleOff from Product, Promotion where Product.PromotionID=Promotion.PromotionID and " + str + ";";
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Product> prods = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("Price"));
                p.setPromotion(rs.getString("Detail"));
                p.setCompany(rs.getString("Company"));
                p.setPromotionIcon(rs.getString("Icon"));
                p.setSaleOff(rs.getFloat("SaleOff"));
                p.setProductID(rs.getString("ProductID"));
                prods.add(p);
            }
            conn.close();
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public List<Product> viewAllProducts(int offset, int noOfRecords) {
        //   String query = "select SQL_CALC_FOUND_ROWS * from Product limit " + offset + "," + noOfRecords;
        noOfRecords = offset + noOfRecords;
        String query = "SELECT  * FROM    ( SELECT    ROW_NUMBER() OVER ( ORDER BY NumberInStorage ) AS RowNum, Product.*, Icon, SaleOff  FROM  Product, Promotion WHERE  NumberInStorage >=-1 and Product.PromotionID=Promotion.PromotionID ) AS RowConstrainedResult WHERE RowNum >= " + offset + " AND RowNum < " + noOfRecords + " ORDER BY RowNum";
        List<Product> list = new ArrayList<>();
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("Price"));
                p.setPromotion(rs.getString("Detail"));
                p.setCompany(rs.getString("Company"));
                p.setPromotionIcon(rs.getString("Icon"));
                p.setSaleOff(rs.getFloat("SaleOff"));
                p.setProductID(rs.getString("ProductID"));
                list.add(p);
            }
            rs.close();

            rs = statement.executeQuery("SELECT count(*) from Product");
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
        return list;
    }

    public List<Product> sortProduct(int offset, int noOfRecords, String l) {
        //   String query = "select SQL_CALC_FOUND_ROWS * from Product limit " + offset + "," + noOfRecords;
        noOfRecords = offset + noOfRecords;
        String str = null;
        switch (l) {
            case "a-z":
                str = "ProductName";
                break;
            case "priceASC":
                str = "Price*SaleOff";
                break;
            case "priceDESC":
                str = "Price*SaleOff DESC";
                break;
        }
        String query = "SELECT  * FROM    ( SELECT    ROW_NUMBER() OVER ( ORDER BY " + str + " ) AS RowNum, Product.*, Icon, SaleOff  FROM  Product, Promotion WHERE  NumberInStorage >=-1 and Product.PromotionID=Promotion.PromotionID ) AS RowConstrainedResult WHERE RowNum >= " + offset + " AND RowNum < " + noOfRecords + " ORDER BY RowNum";
        List<Product> list = new ArrayList<>();
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("Price"));
                p.setPromotion(rs.getString("Detail"));
                p.setCompany(rs.getString("Company"));
                p.setPromotionIcon(rs.getString("Icon"));
                p.setSaleOff(rs.getFloat("SaleOff"));
                p.setProductID(rs.getString("ProductID"));
                list.add(p);
            }
            rs.close();

            rs = statement.executeQuery("SELECT count(*) from Product;");
            if (rs.next()) {
                this.noOfRecords = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException | NamingException ex) {
            System.err.println(ex);
        }
        return list;
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }

    public Product getInfoProduct(String a) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            String sql = "use SalesWebsite; select Company, NumberInStorage, ProductID, ProductName, Image, Price, Promotion.Detail as PromotionDetail, Company, Icon, SaleOff, Product.Detail as ProductDetail from Product, Promotion where Product.PromotionID=Promotion.PromotionID and ProductID= '" + a + "' ;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setCompany(rs.getString("Company"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("Price"));
                p.setPromotion(rs.getString("PromotionDetail"));
                p.setCompany(rs.getString("Company"));
                p.setPromotionIcon(rs.getString("Icon"));
                p.setSaleOff(rs.getFloat("SaleOff"));
                p.setProductID(rs.getString("ProductID"));
                p.setDetail(rs.getString("ProductDetail"));
                p.setNumberInStorage(rs.getInt("NumberInStorage"));
                conn.close();
                return p;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public List<Product> getCompany() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            String sql = "use SalesWebsite; select ProductID, NumberInStorage, ProductName, Image, Price, Promotion.Detail, Company, Icon, SaleOff from Product, Promotion where Product.PromotionID=Promotion.PromotionID;";
            ResultSet rs = statement.executeQuery(sql);
            ArrayList<Product> prods = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setPrice(rs.getInt("Price"));
                p.setPromotion(rs.getString("Detail"));
                p.setCompany(rs.getString("Company"));
                p.setPromotionIcon(rs.getString("Icon"));
                p.setSaleOff(rs.getFloat("SaleOff"));
                p.setProductID(rs.getString("ProductID"));
                p.setNumberInStorage(rs.getInt("NumberInStorage"));
                prods.add(p);
            }
            conn.close();
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public List<Order> getOrder() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            Statement statement1 = conn.createStatement();
            String setOrder = "select * from [Order], Member where [Order].UserName = Member.UserName;";
            ResultSet rs1 = statement1.executeQuery(setOrder);
            ArrayList<Order> prods = new ArrayList<>();
            while (rs1.next()) {
                Order o = new Order();
                o.setFullName(rs1.getString("FullName"));
                o.setUserName(rs1.getString("UserName"));
                o.setTime(rs1.getString("Time"));
                String OrderID = rs1.getString("OrderID");
                o.setOrderID(OrderID);
                String sql = "select * from Product, [Order], Order__Product, Promotion where Product.PromotionID = Promotion.PromotionID and Product.ProductID = Order__Product.ProductID and [Order].OrderID = Order__Product.OrderID and [Order__Product].OrderID= '"+OrderID+"';";
                ResultSet rs = statement.executeQuery(sql);
                ArrayList<Product> pList = new ArrayList<>();
                Integer Sum1 = 0;
                while (rs.next()) {
                    Product p = new Product();
                    p.setProductName(rs.getString("ProductName"));
                    p.setImage(rs.getString("Image"));
                    p.setPrice(rs.getInt("Price"));
                    p.setPromotion(rs.getString("Detail"));
                    p.setCompany(rs.getString("Company"));
                    p.setProductID(rs.getString("ProductID"));
                    p.setNumberInStorage(rs.getInt("NumberInStorage"));
                    p.setQuantity(rs.getInt("Quantity"));
                    p.setSaleOff(rs.getFloat("SaleOff"));
                    int a = rs.getInt("Price");
                    float b = rs.getFloat("SaleOff");
                    Sum1 +=(int)(a*b*p.getQuantity());
                    pList.add(p);
                }
                o.setPrice(Sum1);
                o.setP(pList);
                prods.add(o);
            }
            conn.close();
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;
    }

    public List<Member> getMember() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/SalesWebsite");
            Connection conn = ds.getConnection();
            Statement statement1 = conn.createStatement();
            String setOrder = "select Member.*, Manager_Member.Status from Member, Manager_Member where Member.UserName = Manager_Member.UserName";
            ResultSet rs = statement1.executeQuery(setOrder);
            ArrayList<Member> prods = new ArrayList<>();
            while (rs.next()) {
                Member o = new Member();
                o.setFullName(rs.getString("FullName"));
                o.setUserName(rs.getString("UserName"));
                o.setEmail(rs.getString("Email"));
                o.setPhoneNumber(rs.getString("PhoneNumber"));
                o.setStatus(rs.getBoolean("Status"));
                prods.add(o);
            }
            conn.close();
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
        return null;    }
}
