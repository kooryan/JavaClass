package company.Collections.SetsAndHashSets.Variants;

import java.util.Map;

public class SortedCollections {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 12.60, 8);
        stockList.addStock(temp);

        temp = new StockItem("chair", 35.34, 70);
        stockList.addStock(temp);

        temp = new StockItem("cup", 2.40, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 1.90, 7);
        stockList.addStock(temp);

        temp = new StockItem("keyboard", 34.56, 50);
        stockList.addStock(temp);

        temp = new StockItem("milk", 5.89, 200);
        stockList.addStock(temp);

        temp = new StockItem("orange juice", 3.20, 200);
        stockList.addStock(temp);

        System.out.println(stockList);
        for (String s : stockList.Items().keySet()) { // order will stay the same when using unmodifiable collection
            System.out.println(s);
        }

        Basket myBasket = new Basket("Ryan");
        sellItem(myBasket, "orange juice", 3);
        sellItem(myBasket, "fire", 19306742);
        sellItem(myBasket, "keyboard", 1);

        Basket basket = new Basket("customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "chair", 4);
        System.out.println(basket);

        removeItem(myBasket, "orange juice", 2);
        removeItem(basket, "cup", 50);
        System.out.println("chair removed: " + removeItem(basket, "chair", 1));
        System.out.println(basket);

        removeItem(myBasket, "orange juice", 1);
        removeItem(myBasket, "keyboard", 1);
        System.out.println(myBasket);
        removeItem(basket,"cup", 50);
        removeItem(basket,"chair", 3);
        System.out.println(basket);

        System.out.println("\nDisplay quantity before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);
        //  temp = new StockItem("pen", 5.00);
        //  stockList.Items().put(temp.getName(), temp); // will return an UnsupportedOperation exception because our Items() method returns an unmodifiable map
        stockList.Items().get("keyboard").adjustStock(2000);
        stockList.get("keyboard").adjustStock(-1289);
//        System.out.println(stockList); // but we are able to adjust individual items
//        for (Map.Entry<String, Double> prices : stockList.PriceList().entrySet()) {
//            System.out.println(prices.getKey() + " costs " + prices.getValue());
//        }

        checkOut(myBasket);
        System.out.println(myBasket);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0; // returning 0 as the quantity
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from the stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0; // returning 0 as the quantity
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.checkOut();
    }
}
