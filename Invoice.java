import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String customerName;
    private List<LineItem> lineItems;
    private double totalAmount;

    public Invoice(int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
        this.lineItems = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
        totalAmount += lineItem.getAmount();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice ID: ").append(id).append(", Customer: ").append(customerName).append("\n");
        for (LineItem lineItem : lineItems) {
            sb.append(lineItem.toString()).append("\n");
        }
        sb.append("Total Amount: ").append(totalAmount);
        return sb.toString();
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

    // Getters and setters (if needed)
}