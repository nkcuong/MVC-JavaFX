import java.util.List;

public class ItemView {
    public void displayItems(List<Item> items) {
        for (Item item : items) {
            System.out.println("ID: " + item.getId() + ", Name: " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + item.getQuantity());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}