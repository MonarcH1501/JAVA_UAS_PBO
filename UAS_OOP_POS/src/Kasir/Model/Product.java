package Kasir.Model;

public class Product {
    private String id;
    private String supplierId;
    private String code;
    private String name;
    private double price;

    public Product(String id, String supplierId, String code, String name, double price) {
        this.id = id;
        this.supplierId = supplierId;
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }
    public String getSupplierId() { return supplierId; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
