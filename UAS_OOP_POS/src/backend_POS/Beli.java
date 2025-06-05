
package backend_POS;

import java.util.Date;

public class Beli {
    private int id;
    private String product;
    private String supplier;
    private Date date;
    private int qty;
    private String unit;
    private float totalPrice;
    private int id_supp;
    private int id_product;

    // Menampilkan Data di Table
public Beli (int a, String b, String c, Date d, int f, String g, float h){
    this.id = a;
    this.product = b;
    this.supplier = c;
    this.date = d;
    this.qty = f;
    this.unit = g;
    this.totalPrice = h;
}
    // Menambahkan Data di Table
public Beli (int a, String b, String c, Date d, int f, float h) {
    this.id = a;
    this.product = b;
    this.supplier = c;
    this.date = d;
    this.qty = f;
    this.totalPrice = h;
}

    public int getId_supp() {
        return id_supp;
    }

    public void setId_supp(int id_supp) {
        this.id_supp = id_supp;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

}