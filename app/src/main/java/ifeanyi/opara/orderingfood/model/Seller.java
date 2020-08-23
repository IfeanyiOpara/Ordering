package ifeanyi.opara.orderingfood.model;

public class Seller {
    public int id;
    private String seller;
    private String motto;
    private int status;

    public Seller(int id, String seller, String motto, int status) {
        this.id = id;
        this.seller = seller;
        this.motto = motto;
        this.status = status;
    }

    public Seller(String seller, String motto, int status) {
        this.seller = seller;
        this.motto = motto;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
