package Admin.Model;

import Admin.Controller.*;

public class Supp {
    private int id;
    private String codeSupplier;
    private String nameSupplier;
    private String contactSupplier;
    private String addressSupplier;
    
    public Supp(int id, String codeSupplier, String nameSupplier, String contactSupplier, String addressSupplier) {
     this.id = id;
     this.codeSupplier = codeSupplier;
     this.nameSupplier = nameSupplier;
     this.contactSupplier = contactSupplier;
     this.addressSupplier = addressSupplier;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeSupplier() {
        return codeSupplier;
    }

    public void setCodeSupplier(String codeSupplier) {
        this.codeSupplier = codeSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getContactSupplier() {
        return contactSupplier;
    }

    public void setContactSupplier(String contactSupplier) {
        this.contactSupplier = contactSupplier;
    }

    public String getAddressSupplier() {
        return addressSupplier;
    }

    public void setAddressSupplier(String addressSupplier) {
        this.addressSupplier = addressSupplier;
    }
    
}
