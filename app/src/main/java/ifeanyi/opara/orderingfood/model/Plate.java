package ifeanyi.opara.orderingfood.model;

public class Plate {
    private String item;
    private String description;
    private String worth;

    public Plate(String item, String description, String worth) {
        this.item = item;
        this.description = description;
        this.worth = worth;
    }

    public Plate(String item, String worth) {
        this.item = item;
        this.worth = worth;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorth() {
        return worth;
    }

    public void setWorth(String worth) {
        this.worth = worth;
    }
}
