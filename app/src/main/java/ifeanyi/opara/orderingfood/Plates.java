package ifeanyi.opara.orderingfood;

import android.os.Bundle;

public class Plates {
    private int id;
    private String order;
    private String amount;

    public Plates(int id, String order, String amount) {
        this.id = id;
        this.order = order;
        this.amount = amount;
    }

    public Plates(String order, String amount) {
        this.order = order;
        this.amount = amount;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
