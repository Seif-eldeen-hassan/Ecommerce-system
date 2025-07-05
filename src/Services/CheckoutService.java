package Services;
import model.*;

import java.util.ArrayList;

public class CheckoutService {

    public static boolean isBalanceEnough(Customer customer , cart cart){
        return customer.getBalance() >= cart.getSubtotal();
    }

    public static double currentBalance(Customer customer , cart cart){
        double currentBalance = customer.getBalance() - (cart.getSubtotal()+ShippingService.getShipCost()) ;
        customer.setBalance(currentBalance);
        return currentBalance ;
    }

    public static void PrintCartDetails(Customer customer , cart cart){
        System.out.println("******* Checkout Details *******");
        for(CartItem c : cart.getProducts()){
            System.out.printf("%-25s %10.2f%n", c.getQuantity() + "x " + c.getProduct().getName(), c.itemSubtotal());
        }
        System.out.println("-------------------------------------");
        System.out.println("Subtotal: " + cart.getSubtotal());
        System.out.println("Shipping: " + ShippingService.getShipCost());
        System.out.println("Amount: " + (cart.getSubtotal() + ShippingService.getShipCost()));
        System.out.println("Your New Balance: " + currentBalance(customer, cart));
    }

    public static ArrayList<ShippableItem> extractShippableItems(cart cart){
        ArrayList<ShippableItem> shippables = new ArrayList<>();
        for(CartItem c : cart.getProducts()){
            if(c.getProduct() instanceof Shippable){
                shippables.add(new ShippableItem((Shippable) c.getProduct(), c.getQuantity()));
            }
        }
        return shippables;
    }

    public static void checkout(Customer customer , cart cart) {
        if(cart.isEmpty()){
            System.out.println("Can't checkout empty cart");
        }
        else if(!isBalanceEnough(customer, cart)){
            System.out.println("Not enough balance");
        }
        else {
            ShippingService.shipItems(extractShippableItems(cart));
            PrintCartDetails(customer, cart);


        }

    }
}
