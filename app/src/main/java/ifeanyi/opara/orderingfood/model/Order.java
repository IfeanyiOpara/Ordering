package ifeanyi.opara.orderingfood.model;

import android.os.Bundle;

import java.io.Serializable;

public class Order {
    private int id;
    private String order;
    private String amount;

    public Order(int id, String order, String amount) {
        this.id = id;
        this.order = order;
        this.amount = amount;
    }

    public Order(String order, String amount) {
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
