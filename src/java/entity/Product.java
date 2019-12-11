/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PV
 */
public class Product {
    private String ProductID;

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }
    private int Quantity;

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    private String Image;
    private int Price;
    private int NumberInStorage;
    private String Detail;
    private String Promotion;
    private String ProductName;
    private String Company;
    private String PromotionIcon;
    private float SaleOff;
    private String PromotionID;
    
    public List<String> SplitDetail(String s) {
    ArrayList<String> prods = new ArrayList<>();
        //String s = "CPU: Intel Celeron, N4000, 1.10 GHz RAM: 4 GB, DDR4 (On board), 2400 MHz Ổ cứng: SSD 256GB NVMe PCIe Màn hình: 15.6 inch, HD (1366 x 768) Card màn hình: Card đồ họa tích hợp, Intel® HD Graphics 620 Cổng kết nối: USB 3.1, HDMI, LAN (RJ45), USB 2.0 Hệ điều hành: Windows 10 Home SL Thiết kế: Vỏ nhựa, PIN liền Kích thước: Dày 19.9 mm, 1.7 kg";
        String[] u = s.split("CPU:");
        String[] u1 = u[1].split("RAM:");
        prods.add(u1[0]);
        String[] u2 = u1[1].split("Ổ cứng:");
        prods.add(u2[0]);
        String[] u3 = u2[1].split("Màn hình:");
        prods.add(u3[0]);
        String[] u4 = u3[1].split("Card màn hình:");
        prods.add(u4[0]);
        String[] u5 = u4[1].split("Cổng kết nối:");
        prods.add(u5[0]);
        String[] u6 = u5[1].split("Hệ điều hành:");
        prods.add(u6[0]);
        String[] u7 = u6[1].split("Thiết kế:");
        prods.add(u7[0]);
        String[] u8 = u7[1].split("Kích thước:");
        prods.add(u8[0]);
        prods.add(u8[1]);
        return prods;
    }
    
    public String DingDangSo(int n){
        String u= Integer.toString(n);
        for (int i= u.length();i>0;i=i-3){
            u= u.substring(0,i)+ "."+u.substring(i);

        }
        return u.substring(0,u.length()-1);
    }
    
    public String getPromotionID() {
        return PromotionID;
    }

    public void setPromotionID(String PromotionID) {
        this.PromotionID = PromotionID;
    }
    
    public String getPromotionIcon() {
        return PromotionIcon;
    }

    public String getSale() {
        return DingDangSo((int)(SaleOff*Price));
    }
    
    public int getSale1() {
        return (int)(SaleOff*Price);
    }
    
    public void setPromotionIcon(String PromotionIcon) {
        this.PromotionIcon = PromotionIcon;
    }

    public float getSaleOff() {
        return SaleOff;
    }

    public void setSaleOff(float SaleOff) {
        this.SaleOff = SaleOff;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getPrice() {
        return DingDangSo(Price);
    }
    public int getPrice1() {
        return Price;
    }
    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getNumberInStorage() {
        return NumberInStorage;
    }

    public void setNumberInStorage(int NumberInStorage) {
        this.NumberInStorage = NumberInStorage;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public String getPromotion() {
        return Promotion;
    }

    public void setPromotion(String Promotion) {
        this.Promotion = Promotion;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }
    
}
