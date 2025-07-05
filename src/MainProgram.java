import model.*;
import Services.CheckoutService;

import java.util.ArrayList;

public class MainProgram {
    Customer first_customer = new Customer("Seif Eldeen Hassan " , 20000);
    Customer second_customer = new Customer("Ahmed " , 5000);
    cart cart = new cart();
    public MainProgram() {
        // Products for testing
        Product TV = new Product("TV", 5999, 3);
        ExpiringProduct Cheese = (new ExpiringProduct("Cheese", 29.99, 10, true));
        ExpiringProduct Chips = (new ExpiringProduct("Chips", 5, 7, false));
        ShippableProduct Washing_Machine = (new ShippableProduct("Washing Machine", 3499, 2, 9000));
        ShipExpirableProduct Frozen_Pizza =(new ShipExpirableProduct("Frozen Pizza", 79, 5, 70, false));

        // 1)  testing all products with sufficient balance
        System.out.println("\n -------- 1) Testing All Products with sufficient balance -------- \n");
        cart.addProduct(TV,1);
        cart.addProduct(Cheese,3);
        cart.addProduct(Washing_Machine,2);
        cart.addProduct(Frozen_Pizza,5);
        CheckoutService.checkout(first_customer,cart);

        // 2)  testing products with insufficient balance
        System.out.println("\n-------- 2) Testing products with insufficient balance --------\n");
        cart.clear();
        cart.addProduct(TV,1);
        CheckoutService.checkout(second_customer,cart);

        // 3) testing checkout with empty cart
        System.out.println("\n-------- 3) Testing checkout with empty cart --------\n");
        cart.clear();
        CheckoutService.checkout(second_customer,cart);

        // 4) Adding Expired Product
        System.out.println("\n-------- 4) Testing adding Expired Product -------\n");
        cart.addProduct(Cheese,2);

        // 5) Adding more Product than the stock
        System.out.println("\n-------- 5) Testing adding more Product than the stock -------\n");
        cart.clear();
        cart.addProduct(Frozen_Pizza,20);

        // 6) Check out products that will not be shipped
        System.out.println("\n-------- 6) Check out products that will not be shipped -------\n");
        cart.clear();
        cart.addProduct(TV,1);
        cart.addProduct(Chips,3);
        CheckoutService.checkout(first_customer,cart);

    }

    public static void main(String[] args) {
        new MainProgram();
    }

}





