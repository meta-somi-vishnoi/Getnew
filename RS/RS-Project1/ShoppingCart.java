import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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

	public void updateQuantity(int quantity) {
		this.quantity = quantity;
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

class Products {
	private ArrayList<Items> listCustomer = new ArrayList<Items>();
	private ArrayList<Items> productPresent = new ArrayList<Items>();

	public Products() {
		Items mobiles = new Items(1, "Mobiles", 10000, 50);
		Items cameras = new Items(2, "Cameras", 5000, 100);
		Items laptops = new Items(3, "laptops", 30000, 20);
		Items watch = new Items(4, "watch", 2000, 10);
		Items ipads = new Items(5, "Ipads", 7000, 20);
		Items tablets = new Items(6, "Tablets", 25000, 70);
		productPresent.add(mobiles);
		productPresent.add(cameras);
		productPresent.add(laptops);
		productPresent.add(watch);
		productPresent.add(ipads);
		productPresent.add(tablets);
	}

	public void addProduct(int itemId, int quantity) {
		int flag = 0;
		int price;
		String name;
		for (int j = 0; j < productPresent.size(); j++) {
			if (itemId == productPresent.get(j).getId()
					&& quantity <= productPresent.get(j).getQuantity()) {
				price = productPresent.get(j).getPrice();
				name = productPresent.get(j).getName();
				Items item = new Items(itemId, name, price, quantity);
				listCustomer.add(item);
				flag = 1;
				productPresent.get(j).updateQuantity(
						productPresent.get(j).getQuantity() - quantity);
			}
			if (flag == 0) {
				System.out.println("Item cannot be added");
			}
		}
	}

	public void removeProduct(int itemId) {
		int flag = 0;
		for (int i = 0; i < listCustomer.size(); i++) {
			if (listCustomer.get(i).getId() == itemId) {
				for (int j = 0; j < productPresent.size(); j++) {
					if (productPresent.get(j).getId() == itemId) {
						productPresent.get(j).updateQuantity(
								productPresent.get(j).getQuantity()
										+ listCustomer.get(i).getQuantity());
					}
				}
				listCustomer.remove(i);
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
		for (int j = 0; j < productPresent.size(); j++) {
			if (productPresent.get(j).getId() == itemId
					&& productPresent.get(j).getQuantity() >= newQuantity) {
				for (int i = 0; i < listCustomer.size(); i++) {
					if (listCustomer.get(i).getId() == itemId) {
						listCustomer.get(i).updateQuantity(newQuantity);
						productPresent.get(j).updateQuantity(
								productPresent.get(j).getQuantity()
										- newQuantity);
					}
				}
			} else {
				System.out.println("Insufficient products present in list");
			}
		}
	}

	public int priceOfProduct(int itemId) {
		for (int i = 0; i < listCustomer.size(); i++) {
			if (listCustomer.get(i).getId() == itemId) {
				return ((listCustomer.get(i).getQuantity()) * (listCustomer
						.get(i).getPrice()));
			} else {
				System.out.println("Enter valid product Id");
				return 0;
			}
		}
		return 0;
	}

	public int totalPrice() {
		int totalSum = 0;
		for (int i = 0; i < listCustomer.size(); i++) {
			totalSum = totalSum + (listCustomer.get(i).getQuantity())
					* (listCustomer.get(i).getPrice());
		}
		return totalSum;
	}

	public void displayItems() {
		for (int i = 0; i < listCustomer.size(); i++) {
			System.out.print("\n The " + (i + 1) + " item is: \n"
					+ listCustomer.get(i).getId() + "\t"
					+ listCustomer.get(i).getName() + "\t"
					+ listCustomer.get(i).getPrice() + "\t"
					+ listCustomer.get(i).getQuantity() + "\n");
		}
	}

	public void displayExistingItems() {
		for (int i = 0; i < productPresent.size(); i++) {
			System.out.print(" The " + (i + 1) + " item is: \n"
					+ productPresent.get(i).getId() + "\t"
					+ productPresent.get(i).getName() + "\t"
					+ productPresent.get(i).getPrice() + "\t"
					+ productPresent.get(i).getQuantity() + "\n");
		}
	}
}

public class ShoppingCart {
	public static void main(String args[]) {
		Products product = new Products();
		int itemId, itemPrice, itemQuantity;
		float totalDiscount;
		String itemName;
		System.out.println("Select options: \n press 1 to add product to cart \n press 2 to remove product from cart \n "
				+ "press 3 to update quantity of product \n press 4 to get price of particular product"
			        + "\n press 5 to get billing price \n press 6 to display list of products \n press 7 to exit \n");
		do {
			System.out.println("The existing products are:");
			product.displayExistingItems();
			System.out.println("\n");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter Id of product");
				itemId = sc.nextInt();
				System.out.println("Enter quantity of product");
				itemQuantity = sc.nextInt();
				product.addProduct(itemId, itemQuantity);
				break;
			case 2:
				System.out.println("Enter Id of product");
				itemId = sc.nextInt();
				product.removeProduct(itemId);
				break;
			case 3:
				System.out.println("Enter Id of product");
				itemId = sc.nextInt();
				System.out.println("Enter new quantity of product");
				itemQuantity = sc.nextInt();
				product.updateQuantity(itemId, itemQuantity);
				break;
			case 4:
				System.out.println("Enter Id of product");
				itemId = sc.nextInt();
				System.out.println(" Total price of product is ");
				int priceProduct = product.priceOfProduct(itemId);
				System.out.println(priceProduct);
				break;
			case 5:
				System.out.print("Total billing price of product is ");
				int sumProduct = product.totalPrice();
				System.out.println(sumProduct);
				break;
			case 6:
				System.out.print("List of products is : \n");
				product.displayItems();
				break;
			case 7:
				System.exit(0);
			}
			System.out.println("\n Choose option again: \n");
		} while (true);
	}
}
