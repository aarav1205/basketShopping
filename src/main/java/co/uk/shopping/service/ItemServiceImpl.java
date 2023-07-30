package co.uk.shopping.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService{

    @Override
    public double calculateTotalPrice(List<String> cart) {
        Map<String, Long> cartWithQuantity = cart.stream()
                .collect(Collectors.groupingBy(e->e, Collectors.counting()));
        Map<String, Double> items = getItemsRate();
        double totalPrice = 0;
        for (Map.Entry<String, Long> entry : cartWithQuantity.entrySet()) {
            String item = entry.getKey();
            long quantity = entry.getValue();
            double itemPrice = items.get(item);
            double discountedPrice = applyDiscount(item, itemPrice, quantity);
            totalPrice += discountedPrice;
        }
        return totalPrice;
    }

    // Method to apply discounts on selected items
    private  double applyDiscount(String item, double price, long quantity) {
        double discountedPrice = price;
        if (item.equals("Melon")) {
            long numFreeItems = quantity / 2;
            discountedPrice = (quantity - numFreeItems) * price;
        }

        // Buy 3 for the price of 2 discount
        if (item.equals("Lime")) {
            long numDiscountedSets = quantity / 3;
            discountedPrice = (quantity - numDiscountedSets) * price;
        }
        return discountedPrice;
    }

    private static Map<String, Double> getItemsRate(){
        Map<String, Double> items = new HashMap<>();
        // Adding items and their prices
        items.put("Apple", 0.35);
        items.put("Banana", 0.20);
        items.put("Melon", 0.50);
        items.put("Lime", 0.15);
        return items;
    }

}
