package Services;
import model.Product;
import model.Expirable;


public class CartServices {
    public static boolean isQuantityEnough(Product p , int requestedQuantity) {
        return p.getQuantity() >= requestedQuantity;
    }

    public static boolean isProductExpired(Product p) {
        if (p instanceof Expirable) {
            return ((Expirable) p).isExpired();
        }
        return false;
    }



}
