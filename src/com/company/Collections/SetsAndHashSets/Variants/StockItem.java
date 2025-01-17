package company.Collections.SetsAndHashSets.Variants;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock = 0; // can be initialized later
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        setPrice(price);
        this.quantityInStock = quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock - reserved;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityInStock;
    }


    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;

        if (newQuantity >= 0) {
            this.quantityInStock = newQuantity;
        }
    }

    public int reserveStock(int quantity) {
        if (quantity <= availableQuantity()) { // Use the method, not the field
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finalizeStock(int quantity) {
        if (quantity <= reserved) {
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return quantity;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31; // just adding an arbitrary number
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals() ");
        if (obj == this) {
            return true;
        }

        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(StockItem o) {
  //      System.out.println("Entering StockItem.compareTo() ");
        if (this == o) {
            return 0;
        }

        if (o != null) { // always check null to prevent errors once entering the block
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price + ". Reserved: " + this.reserved;
    }
}
