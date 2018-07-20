package ShoppingCart;

import java.util.Scanner;

public class ShoppingCart {
    public static void main(String args[]) {
        Products customerProducts = new Products();
        fixedOrderPromotion order = new fixedOrderPromotion();
        fixedProductPromotion product = new fixedProductPromotion();
        int itemId, price, itemQuantity;
        float totalDiscount;
        String name, code;
        System.out
                .println("Select options: \n press 1 to add product to cart \n press 2 to remove product from cart \n "
                        + "press 3 to update quantity of product \n press 4 to get price of particular product"
                        + "\n press 5 to get billing price \n press 6 to display list of products \n"
                        + "press 7 to enter promocode \n press 8 to exit \n");
        do {
            System.out.println("The existing products are:");
            customerProducts.displayExistingItems();
            System.out.println("\n");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
            case 1:
                System.out.println("Enter Id of product");
                itemId = sc.nextInt();
                System.out.println("Enter quantity of product");
                itemQuantity = sc.nextInt();
                customerProducts.addProduct(itemId, itemQuantity);
                break;
            case 2:
                System.out.println("Enter Id of product");
                itemId = sc.nextInt();
                customerProducts.removeProduct(itemId);
                break;
            case 3:
                System.out.println("Enter Id of product");
                itemId = sc.nextInt();
                System.out.println("Enter new quantity of product");
                itemQuantity = sc.nextInt();
                customerProducts.updateQuantity(itemId, itemQuantity);
                break;
            case 4:
                System.out.println("Enter Id of product");
                itemId = sc.nextInt();
                System.out.println(" Total price of product is ");
                int priceOfProduct = customerProducts.piceOfProduct(itemId);
                System.out.println(priceOfProduct);
                break;
            case 5:
                System.out.print("Total billing price of product is ");
                int sumOfProducts = customerProducts.totalPrice()
                        + product.getFixedDiscount(customerProducts)
                        + order.getFixedDiscount(customerProducts);
                System.out.println(sumOfProducts);
                break;
            case 6:
                System.out.print("list of products is : \n");
                customerProducts.displayItems();
                break;
            case 8:
                System.exit(0);
            case 7:
                System.out.println("Enter Promocode");
                code = sc.next();
                if (order.isPromotionApplicable(code)) {
                    System.out.println("Discount available on fixed order is:");
                    int discount, minimumAmount;
                    minimumAmount = 20000;
                    discount = 25;
                    order.setMinimumPrice(minimumAmount);
                    if (order.getMinimumPrice(customerProducts) >= minimumAmount) {
                        order.setFixedDiscount(discount);
                    }
                    totalDiscount = discount
                            * order.getMinimumPrice(customerProducts) / 100;
                    System.out.println(discount + "%");
                    System.out.println("Discount availed:" + totalDiscount);
                } else {
                    System.out.println("No discount available on fixed order");
                    if (product.isPromotionApplicable(code)) {
                        System.out
                                .println("Discount available on fixed product is:");
                        int discount, minimumAmount;
                        minimumAmount = 2000;
                        discount = 20;
                        product.setMinimumPrice(minimumAmount);
                        int sumPrice = product
                                .getMinimumPrice(customerProducts);
                        product.setFixedDiscount(discount);
                        totalDiscount = discount * sumPrice / 100;
                        System.out.println(discount + "%");
                        System.out.println("Discount availed:" + totalDiscount);
                    } else {
                        System.out
                                .println("No discount available on fixed product");
                    }
                }
                break;
            }
            System.out.println("\n Choose option again: \n");
        } while (true);
    }
}
