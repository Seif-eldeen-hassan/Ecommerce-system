package Services;

import model.Shippable;
import model.ShippableItem;

import java.util.ArrayList;

public class ShippingService {
    private static double ShippingFees = 30;
    public static String TotalPackageWeight(ArrayList<ShippableItem> items){
        double totalWeight = 0;
        for(ShippableItem s : items){
            totalWeight += s.getTotalNumericWeight();
        }
        if (totalWeight >= 1000) {
            double inKg = totalWeight / 1000.0;
            return String.format("%.2f kg", inKg);
        } else {
            return String.format("%.0f g", totalWeight);
        }
    }

    public static void shipItems(ArrayList<ShippableItem> items){
        System.out.println("\n******** Shipment notice ********");
        if(items.size()==0){
            System.out.println("No shippable items found");
        }

        for(ShippableItem s : items){
            System.out.printf("%-20s %10s%n", s.getQuantity() + "x " + s.getItem().getname(), s.getTotalWeight());
        }
        if(items.size()!=0){
            System.out.println("Total package weight: " + TotalPackageWeight(items));
        }
        System.out.println();
    }

    public static double getShipCost(){
        return ShippingFees;
    }
}
