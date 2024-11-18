import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemModel {
    private List<Item> items;
    private static final String ITEMS_FILE = "items.dat";

    public ItemModel() {
        items = new ArrayList<>();
        loadItemsFromFile();
    }

    public void addItem(Item item) {
        items.add(item);
        saveItemsToFile();
    }

    public List<Item> getItems() {
        return items;
    }

    private void saveItemsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ITEMS_FILE))) {
            oos.writeObject(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadItemsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ITEMS_FILE))) {
            items = (List<Item>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	public void updateItem(int id, Item newItem) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateItem'");
	}

	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteItem'");
	}
}