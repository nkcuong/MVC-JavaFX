import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private ItemController itemController;
    private InvoiceController invoiceController;
    private TextField idField, nameField, priceField, quantityField;
    private TextArea displayArea;
    private VBox root;

    @Override
    public void start(Stage primaryStage) {
        ItemModel itemModel = new ItemModel();
        InvoiceModel invoiceModel = new InvoiceModel(itemModel);
        itemController = new ItemController(itemModel);
        invoiceController = new InvoiceController(invoiceModel);

        root = new VBox(10);
        Scene scene = new Scene(root, 400, 600);

        // Item Management UI
        Button addItemButton = new Button("Add Item");
        Button displayItemsButton = new Button("Display Items");
        Button updateItemButton = new Button("Update Item");
        Button deleteItemButton = new Button("Delete Item");
        Button invoiceManagementButton = new Button("Invoice Management");

        idField = new TextField();
        idField.setPromptText("ID");
        nameField = new TextField();
        nameField.setPromptText("Name");
        priceField = new TextField();
        priceField.setPromptText("Price");
        quantityField = new TextField();
        quantityField.setPromptText("Quantity");
        displayArea = new TextArea();
        displayArea.setEditable(false);

        addItemButton.setOnAction(e -> addItem());
        displayItemsButton.setOnAction(e -> displayItems());
        updateItemButton.setOnAction(e -> updateItem());
        deleteItemButton.setOnAction(e -> deleteItem());
        invoiceManagementButton.setOnAction(e -> showInvoiceManagement());

        root.getChildren().addAll(idField, nameField, priceField, quantityField, addItemButton, displayItemsButton, updateItemButton, deleteItemButton, invoiceManagementButton, displayArea);

        primaryStage.setTitle("Item and Invoice Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addItem() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        Item item = new Item(id, name, price, quantity);
        String message = itemController.addItem(item);
        displayArea.setText(message);
        clearFields();
    }

    private void displayItems() {
        String items = itemController.getItems();
        displayArea.setText(items);
    }

    private void updateItem() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());
        Item newItem = new Item(id, name, price, quantity);
        String message = itemController.updateItem(id, newItem);
        displayArea.setText(message);
        clearFields();
    }

    private void deleteItem() {
        int id = Integer.parseInt(idField.getText());
        String message = itemController.deleteItem(id);
        displayArea.setText(message);
        clearFields();
    }

    private void showInvoiceManagement() {
        InvoiceManagementUI invoiceManagementUI = new InvoiceManagementUI(invoiceController);
        invoiceManagementUI.show();
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        priceField.clear();
        quantityField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}