package ifeanyi.opara.orderingfood.model;

public class SwallowOrder {

    private int id;
    private String swallowItem;
    private String worthItem;
    private String description;

    public SwallowOrder(int id, String swallowItem, String worthItem, String description) {
        this.id = id;
        this.swallowItem = swallowItem;
        this.worthItem = worthItem;
        this.description = description;
    }

    public SwallowOrder(String swallowItem, String worthItem, String description) {
        this.swallowItem = swallowItem;
        this.worthItem = worthItem;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSwallowItem() {
        return swallowItem;
    }

    public void setSwallowItem(String swallowItem) {
        this.swallowItem = swallowItem;
    }

    public String getWorthItem() {
        return worthItem;
    }

    public void setWorthItem(String worthItem) {
        this.worthItem = worthItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
