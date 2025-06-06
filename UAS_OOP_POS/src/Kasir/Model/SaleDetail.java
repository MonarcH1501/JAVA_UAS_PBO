package Kasir.Model;

public class SaleDetail {
    private int productId;
    private String productName;
    private double quantity;
    private double price;

    public SaleDetail(int productId, String productName, double quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotal() {
        return quantity * price;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getQuantity() { return quantity; }
    public double getPrice() { return price; }
}