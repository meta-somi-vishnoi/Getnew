/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotionoder;
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  




class PromotionEnum {
	final String fixProdPromotion="FAAVC";
	final String fixOdrPromotion="FAAVD";
	final String startDate="22-06-2018";
	final String endDate="22-10-2018";
	
}
/**
 *
 * @author vishn_000
 */
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

interface promotion
{
	public int getMinimumPrice(Products product);
	public void setMinimumPrice(int price);
	public int getFixedDiscount(Products product);
	public void setFixedDiscount(int discount);
	public boolean isPromotionApplicable(String code);
}

class fixedProductPromotion implements promotion
{
    private int discount;
    private int minPrice;
    fixedProductPromotion()
    {
        discount=0;
    }
    PromotionEnum valid=new PromotionEnum();
	public void setMinimumPrice(int minPrice)
	{
            this.minPrice=minPrice;
	}
	public int getMinimumPrice(Products product)
	{
            return product.discount_product(minPrice);
	}
	public int getFixedDiscount(Products product)
	{
            return (discount*(product.discount_product(minPrice))/100);
	}
	public void setFixedDiscount(int discount)
    {
            this.discount=discount;
	}
	public boolean isPromotionApplicable(String code)
	{
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		long start=0;
		long end=0;
		long current=0;
		try
		{
			Date stDate=(Date)formatter.parse(valid.startDate);
			Date enDate=(Date)formatter.parse(valid.endDate);
			start=stDate.getTime();
			end=enDate.getTime();
			current=date.getTime();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
        if(code==valid.fixProdPromotion && current>=start && current<=end)
                return true;
        return false;
	}
}

class fixedOrderPromotion implements promotion
{
    private int discount;
    private int minPrice;
    fixedOrderPromotion()
    {
        discount=0;
    }
    PromotionEnum valid=new PromotionEnum();
	public int getMinimumPrice(Products product)
	{
	        return product.total_price();
	}
	public void setMinimumPrice(int minPrice)
	{
	        this.minPrice=minPrice;
	}
	public int getFixedDiscount(Products product)
	{
	        return discount*product.total_price()/100;
	}
	public void setFixedDiscount(int discount)
	{
	        this.discount=discount;
	}
	public boolean isPromotionApplicable(String code)
	{
	 
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		long start=0;
		long end=0;
		long current=0;
		try
		{
			Date stDate=(Date)formatter.parse(valid.startDate);
			Date enDate=(Date)formatter.parse(valid.endDate);
			start=stDate.getTime();
			end=enDate.getTime();
			current=date.getTime();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
            if(code==valid.fixOdrPromotion && current>=start && current<=end)
                    return true;
            return false;
	}
}

class Products{
	private ArrayList<Items> arr=new ArrayList<Items>();
	private ArrayList<Items> prod_present=new ArrayList<Items>();
	
	public void entr_prod_existing()
	{
		Items prod1=new Items(1,"Mobiles",10000,50);
		Items prod2=new Items(2,"Cameras",5000,100);
		Items prod3=new Items(3,"laptops",30000,20);
		Items prod4=new Items(4,"watch",2000,10);
		Items prod5=new Items(5,"Ipads",7000,20);
		Items prod6=new Items(6,"Tablets",25000,70);
		prod_present.add(prod1);
		prod_present.add(prod2);
		prod_present.add(prod3);
		prod_present.add(prod4);
		prod_present.add(prod5);
	}
	public void add_product(int itemId, int quantity)
	{
		int flag=0;
		int price;
		String name; 
		for(int j=0;j<prod_present.size();j++)
		{
			if(itemId==prod_present.get(j).get_Id() && quantity<=prod_present.get(j).get_quantity())
			{
				price=prod_present.get(j).get_price();
				name=prod_present.get(j).get_name();
				Items item = new Items(itemId, name, price, quantity);
				arr.add(item);
				flag=1;
				prod_present.get(j).update_quantity(prod_present.get(j).get_quantity()-quantity);
			}
		}
		if(flag==0)
                    System.out.println("Item cannot be added");
	}
	public void remove_product(int itemId)
	{
		int flag=0;
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).get_Id()==itemId)
			{
				for(int j=0;j<prod_present.size();j++)
				{
					if(prod_present.get(j).get_Id()==itemId)
							prod_present.get(j).update_quantity(prod_present.get(j).get_quantity()+arr.get(i).get_quantity());
				}
				arr.remove(i);
				flag=1;
			}
		}
		if(flag==1)
			System.out.println("Item removed successfully");
		else
			System.out.println("Item cannot be removed");
	}
	public void update_quantity(int itemId, int new_qty)
	{
            int flag=0;
		for(int j=0;j<prod_present.size();j++)
		{
			if(prod_present.get(j).get_Id()==itemId && prod_present.get(j).get_quantity()>=new_qty)
			{
				for(int i=0;i<arr.size();i++)
				{
					if(arr.get(i).get_Id()==itemId)
					{
                                                flag=1;
						arr.get(i).update_quantity(new_qty);
						prod_present.get(j).update_quantity(prod_present.get(j).get_quantity()-new_qty);
					}
				}
			}	
		}
                if(flag==0)
			System.out.println("Item cannot be updated.");
	}
	public int price_product(int itemId)
	{
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).get_Id()==itemId)
				return ((arr.get(i).get_quantity())*(arr.get(i).get_price()));
			else
			{
				System.out.println("Enter valid product Id");
				return 0;
			}
	
		}
		return 0;
	}
	public int total_price()
	{
		int sum=0;
		for(int i=0;i<arr.size();i++)       
		{
			sum = sum + (arr.get(i).get_quantity())*(arr.get(i).get_price());
		}
		return sum;
	}
	public void display_items()
	{
		for(int i=0;i<arr.size();i++)
		{
			System.out.print("\n The " + (i+1) + " item is: \n" + arr.get(i).get_Id() + "\t" + arr.get(i).get_name() + "\t" + arr.get(i).get_price() + "\t" + arr.get(i).get_quantity() + "\n");	
		}
	}
	public void display_existing_items()
	{
		for(int i=0;i<prod_present.size();i++)
		{
			System.out.print(" The " + (i+1) + " item is: \n" + prod_present.get(i).get_Id() + "\t" + prod_present.get(i).get_name() + "\t" + prod_present.get(i).get_price() + "\t" + prod_present.get(i).get_quantity() + "\n");	
		}
	}
	public int discount_product(int minPrice)
	{
		int sum=0;
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).get_price()>=minPrice)
				sum= sum + ((arr.get(i).get_quantity())*(arr.get(i).get_price()));
		}
        return sum;
	}
}




public class Promotionoder {
	public static void main(String args[])
	{
		Products prod=new Products();
		prod.entr_prod_existing();
		fixedOrderPromotion order=new fixedOrderPromotion();
		fixedProductPromotion product=new fixedProductPromotion();
		int id,price,qty;
		float total_discount;
		String name,code;
		System.out.println("Select options: \n press 1 to add product to cart \n press 2 to remove product from cart \n "
				+ "press 3 to update quantity of product \n press 4 to get price of particular product"
				+ "\n press 5 to get billing price \n press 6 to display list of products \n"
                                + "press 7 to enter promocode \n press 8 to exit \n");
		do
		{
			System.out.println("The existing products are:");
			prod.display_existing_items();
			System.out.println("\n");
			Scanner sc=new Scanner(System.in);
			int option=sc.nextInt();
			switch(option)
			{
			case 1: System.out.println("Enter Id of product");
					id=sc.nextInt();
					System.out.println("Enter quantity of product");
					qty=sc.nextInt();
					prod.add_product(id, qty);
					break;
			case 2: System.out.println("Enter Id of product");
					id=sc.nextInt();
					prod.remove_product(id);
					break;
			case 3: System.out.println("Enter Id of product");
					id=sc.nextInt();
					System.out.println("Enter new quantity of product");
					qty=sc.nextInt();
					prod.update_quantity(id,qty);
					break;
			case 4: System.out.println("Enter Id of product");
					id=sc.nextInt();
					System.out.println(" Total price of product is ");
					int price_prod=prod.price_product(id);
					System.out.println(price_prod);
					break;
			case 5: System.out.print("Total billing price of product is ");
                                        int sum=prod.total_price()+product.getFixedDiscount(prod)+order.getFixedDiscount(prod);
					System.out.println(sum);
					break;
			case 6: System.out.print("list of products is : \n");
					prod.display_items();
					break;	
			case 8: System.exit(0);
			case 7: 
				System.out.println("Enter Promocode");
				code=sc.next();
					if(order.isPromotionApplicable(code))
					{
						System.out.println("Discount available on fixed order is:");
						int discount,amount;
						//System.out.println("Enter minimum price for fixed order discount");
						//amount=sc.nextInt();
						//System.out.println("Enter discount for fixed order promotion");
						//discount=sc.nextInt();
                                                amount=20000;
                                                discount=25;
						order.setMinimumPrice(amount);
						if(order.getMinimumPrice(prod)>=amount)
						{
							order.setFixedDiscount(discount);
						}
						total_discount=discount*order.getMinimumPrice(prod)/100;
                                                System.out.println(discount+"%");
                                                System.out.println("Discount availed:" + total_discount);
					}
					else
                                        {
						System.out.println("No discount available on fixed order");
                                                if(product.isPromotionApplicable(code))
                                                {
                                                        System.out.println("Discount available on fixed product is:");
                                                        int discount,amount;
                                                        //System.out.println("Enter minimum price for fixed product discount");
                                                        //amount=sc.nextInt();
                                                        //System.out.println("Enter discount for fixed product PROMOTION");
                                                        //discount=sc.nextInt();
                                                        amount=2000;
                                                        discount=20;
                                                        product.setMinimumPrice(amount);
                                                        int sum_price=product.getMinimumPrice(prod);
                                                        product.setFixedDiscount(discount);
                                                        total_discount=discount*sum_price/100;
                                                        System.out.println(discount+"%");
                                                        System.out.println("Discount availed:" + total_discount);
                                                }
                                                else
                                                        System.out.println("No discount available on fixed product");
                                        }
                                        break;
			
				}
			System.out.println("\n Choose option again: \n");
		}while(true);
		
	}
	
}

