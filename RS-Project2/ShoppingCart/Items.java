package OnlineShopping;

class Items {
    private int itemId;
    private String name;
    private int price;
    private int quantity;

    public Items(int itemId, String name, int price, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void updateQuantity(int itemQuantity) {
        this.quantity = itemQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return itemId;
    }

    public String getName() {
        return name;
    }
}
