import java.util.List;

public class ItemController {
    private ItemModel model;

    public ItemController(ItemModel model) {
        this.model = model;
    }

    public String addItem(Item item) {
        model.addItem(item);
        return "Item added successfully.";
    }

    public String getItems() {
        List<Item> items = model.getItems();
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }

    public Item getItemById(int id) {
        for (Item item : model.getItems()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public String updateItem(int id, Item newItem) {
        model.updateItem(id, newItem);
        return "Item updated successfully.";
    }

    public String deleteItem(int id) {
        model.deleteItem(id);
        return "Item deleted successfully.";
    }
}