import java.util.*;
class Items{
	private int itemId;
	private String name;
	private int price;
	private int quantity;
	public Items(int itemId, String name, int price, int quantity)
	{
		this.itemId=itemId;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	public void update_quantity(int qty)
	{
		this.quantity=qty;
	}
	public int get_quantity()
	{
		return quantity;
	}
	public int get_price()
	{
		return price;
	}
	public int get_Id()
	{
		return itemId;
	}
	public String get_name()
	{
		return name;
	}
	
}
class Products{
	private ArrayList<Items> arr=new ArrayList<Items>();
	public void add_product(int itemId, String name, int price, int quantity)
	{
		Items item = new Items(itemId, name, price, quantity);
		arr.add(item);
	}
	public void remove_product(int itemId)
	{
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).get_Id()==itemId)
				arr.remove(i);
		}
	}
	public void update_quantity(int itemId, int new_qty)
	{
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).get_Id()==itemId)
				arr.get(i).update_quantity(new_qty);
		}
	}
	public void price_product(int itemId)
	{
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).get_Id()==itemId)
				 System.out.println((arr.get(i).get_quantity())*(arr.get(i).get_price()));
	
		}
	}
	public void total_price()
	{
		int sum=0;
		for(int i=0;i<arr.size();i++)
		{
			sum = sum + (arr.get(i).get_quantity())*(arr.get(i).get_price());
		}
		System.out.println(sum);
	}
	public void display_items()
	{
		for(int i=0;i<arr.size();i++)
		{
			System.out.print("\n The " + (i+1) + " item is: \n" + arr.get(i).get_Id() + "\t" + arr.get(i).get_name() + "\t" + arr.get(i).get_price() + "\t" + arr.get(i).get_quantity() + "\n");	
		}
	}
}
public class Cart {
	public static void main(String args[])
	{
		Products prod=new Products();
		int id,price,qty;
		String name;
		System.out.println("Select options: \n press 1 to add product to cart \n press 2 to remove product from cart \n "
				+ "press 3 to update price of product \n press 4 to update quantity of product \n press 5 to get price of particular product"
				+ "\n press 6 to get billing price \n press 7 to display list of products \n press 8 to exit \n");
		do
		{
			Scanner sc=new Scanner(System.in);
			int option=sc.nextInt();
			switch(option)
			{
			case 1: System.out.println("Enter Id of product");
					id=sc.nextInt();
					System.out.println("Enter name of product");
					name=sc.next();
					System.out.println("Enter price of product");
					price=sc.nextInt();
					System.out.println("Enter quantity of product");
					qty=sc.nextInt();
					prod.add_product(id, name, price, qty);
					break;
			case 2: System.out.println("Enter Id of product");
					id=sc.nextInt();
					prod.remove_product(id);
					break;
			case 3: System.out.println("Enter Id of product");
					id=sc.nextInt();
					System.out.println("Enter new price of product");
					price=sc.nextInt();
					prod.update_price(id,price);
					break;
			case 4: System.out.println("Enter Id of product");
					id=sc.nextInt();
					System.out.println("Enter new quantity of product");
					qty=sc.nextInt();
					prod.update_quantity(id,qty);
					break;
			case 5: System.out.println("Enter Id of product");
					id=sc.nextInt();
					System.out.println(" Total price of product is ");
					prod.price_product(id);
					break;
			case 6: System.out.println("Total billing price of product is ");
					prod.total_price();
					break;
			case 7: System.out.println("list of products is : \n");
					prod.display_items();
					break;	
			case 8: System.exit(0);
			}
			System.out.println("Choose option again:");
		}while(true);
		
	}
	
}
