import java.io.Serializable;

public class LineItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Item item;
    private int quantity;
    private double amount;

    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.amount = item.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Item: " + item.getName() + ", Quantity: " + quantity + ", Amount: " + amount;
    }

	public double getAmount() {
		return amount;
	}

    // Getters and setters (if needed)
}