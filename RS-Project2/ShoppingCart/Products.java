package ShoppingCart;

import java.util.ArrayList;

class Products {
    private ArrayList<Items> listOfCustomer = new ArrayList<Items>();
    private ArrayList<Items> existingProducts = new ArrayList<Items>();

    public Products() {
        Items mobiles = new Items(1, "Mobiles", 10000, 50);
        Items cameras = new Items(2, "Cameras", 5000, 100);
        Items laptops = new Items(3, "laptops", 30000, 20);
        Items watch = new Items(4, "watch", 2000, 10);
        Items ipads = new Items(5, "Ipads", 7000, 20);
        Items tablets = new Items(6, "Tablets", 25000, 70);
        existingProducts.add(mobiles);
        existingProducts.add(cameras);
        existingProducts.add(laptops);
        existingProducts.add(watch);
        existingProducts.add(ipads);
        existingProducts.add(tablets);
    }

    public void addProduct(int itemId, int quantity) {
        int flag = 0;
        int price;
        String name;
        for (int j = 0; j < existingProducts.size(); j++) {
            if (itemId == existingProducts.get(j).getId() && quantity <= existingProducts.get(j).getQuantity()) {
                price = existingProducts.get(j).getPrice();
                name = existingProducts.get(j).getName();
                Items item = new Items(itemId, name, price, quantity);
                listOfCustomer.add(item);
                flag = 1;
                existingProducts.get(j).updateQuantity(existingProducts.get(j).getQuantity() - quantity);
            }
        }
        if (flag == 0) {
            System.out.println("Item cannot be added");
        }
    }

    public void removeProduct(int itemId) {
        int flag = 0;
        for (int i = 0; i < listOfCustomer.size(); i++) {
            if (listOfCustomer.get(i).getId() == itemId) {
                for (int j = 0; j < existingProducts.size(); j++) {
                    if (existingProducts.get(j).getId() == itemId) {
                        existingProducts.get(j).updateQuantity(existingProducts.get(j).getQuantity()
                            + listOfCustomer.get(i).getQuantity());
                    }
                }
                listOfCustomer.remove(i);
                flag = 1;
            }
        }
        if (flag == 1) {
            System.out.println("Item removed successfully");
        } else {
            System.out.println("Item cannot be removed");
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        int flag = 0;
        for (int j = 0; j < existingProducts.size(); j++) {
            if (existingProducts.get(j).getId() == itemId && existingProducts.get(j).getQuantity() >= newQuantity) {
                for (int i = 0; i < listOfCustomer.size(); i++) {
                    if (listOfCustomer.get(i).getId() == itemId) {
                        flag = 1;
                        listOfCustomer.get(i).updateQuantity(newQuantity);
                        existingProducts.get(j).updateQuantity(existingProducts.get(j).getQuantity() - newQuantity);
                    }
                }
            }
        }
        if (flag == 0) {
            System.out.println("Item cannot be updated.");
        }
    }

    public int piceOfProduct(int itemId) {
        for (int i = 0; i < listOfCustomer.size(); i++) {
            if (listOfCustomer.get(i).getId() == itemId) {
                return ((listOfCustomer.get(i).getQuantity()) * (listOfCustomer.get(i).getPrice()));
            } else {
                System.out.println("Enter valid product Id");
                return 0;
            }
        }
        return 0;
    }

    public int totalPrice() {
        int sum = 0;
        for (int i = 0; i < listOfCustomer.size(); i++) {
            sum = sum + (listOfCustomer.get(i).getQuantity()) * (listOfCustomer.get(i).getPrice());
        }
        return sum;
    }

    public void displayItems() {
        for (int i = 0; i < listOfCustomer.size(); i++) {
            System.out.print("\n The " + (i + 1) + " item is: \n"
                    + listOfCustomer.get(i).getId() + "\t"
                    + listOfCustomer.get(i).getName() + "\t"
                    + listOfCustomer.get(i).getPrice() + "\t"
                    + listOfCustomer.get(i).getQuantity() + "\n");
        }
    }

    public void displayExistingItems() {
        for (int i = 0; i < existingProducts.size(); i++) {
            System.out.print(" The " + (i + 1) + " item is: \n"
                    + existingProducts.get(i).getId() + "\t"
                    + existingProducts.get(i).getName() + "\t"
                    + existingProducts.get(i).getPrice() + "\t"
                    + existingProducts.get(i).getQuantity() + "\n");
        }
    }

    public int discountOnProduct(int minimumPrice) {
        int sumOfProducts = 0;
        for (int i = 0; i < listOfCustomer.size(); i++) {
            if (listOfCustomer.get(i).getPrice() >= minimumPrice) {
                sumOfProducts = sumOfProducts + ((listOfCustomer.get(i).getQuantity()) * (listOfCustomer.get(i).getPrice()));
            }
        }
        return sumOfProducts;
    }
}
