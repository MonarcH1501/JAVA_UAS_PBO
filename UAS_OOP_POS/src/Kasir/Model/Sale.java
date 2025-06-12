package Kasir.Model;

import java.util.Date;
import java.util.List;

public class Sale {
    private String transactionNo;
    private Date date;
    private double totalPrice;
     private double discount;
    private double tax;
    private double totalPay;
    private double kembalian;
    private List<SaleDetail> saleDetails;

    public Sale(String transactionNo, Date date, double totalPrice, double discount, double tax,double totalPay, double kembalian,List<SaleDetail> saleDetails) {
        this.transactionNo = transactionNo;
        this.date = date;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.tax = tax;
        this.saleDetails = saleDetails;
        this.totalPay = totalPay;
        this.kembalian = kembalian;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public double getKembalian() {
        return kembalian;
    }

    public void setKembalian(double kembalian) {
        this.kembalian = kembalian;
    }

    
    
    public String getTransactionNo() { return transactionNo; }
    public Date getDate() { return date; }
    public double getTotalPrice() { return totalPrice; }
    public double getDiscount() { return discount; }
    public double getTax() { return tax; }
    public double gettotalPay(){return totalPay;}
    public double getkembalian(){return kembalian;}
    public List<SaleDetail> getSaleDetails() { return saleDetails; }
}