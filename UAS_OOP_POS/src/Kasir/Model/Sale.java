package Kasir.Model;

import java.util.Date;
import java.util.List;

public class Sale {
    private String transactionNo;
    private Date date;
    private double totalPrice;
    private List<SaleDetail> saleDetails;

    public Sale(String transactionNo, Date date, double totalPrice, List<SaleDetail> saleDetails) {
        this.transactionNo = transactionNo;
        this.date = date;
        this.totalPrice = totalPrice;
        this.saleDetails = saleDetails;
    }

    public String getTransactionNo() { return transactionNo; }
    public Date getDate() { return date; }
    public double getTotalPrice() { return totalPrice; }
    public List<SaleDetail> getSaleDetails() { return saleDetails; }
}