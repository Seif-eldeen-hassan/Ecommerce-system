package model;
import Services.CartServices;
import java.util.ArrayList;

public class cart {
    private ArrayList <CartItem> products = new ArrayList <> ();

    public void addProduct(Product product , int quantity) {
        if(CartServices.isProductExpired(product)){
            System.out.println("Sorry, product expired");
        }
        else if (!CartServices.isQuantityEnough(product,quantity)){
            System.out.println("Sorry, not enough products");
        }
        else{
            products.add(new CartItem(product, quantity));
            System.out.println("Added " + quantity + "x " + product.getName() + " to the cart");
        }
    }

    public ArrayList<CartItem> getProducts() {
        return products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public double getSubtotal() {
        double total = 0 ;
        for(CartItem c : products){
            total +=  c.itemSubtotal();
        }
        return total;
    }

    public void clear(){
        products.clear();
    }
}
