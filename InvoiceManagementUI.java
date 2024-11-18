import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InvoiceManagementUI {
    private InvoiceController invoiceController;
    private Stage stage;
    private TextField idField, customerField, itemIdField, itemQuantityField;
    private TextArea displayArea;
    private Button addLineItemButton, addInvoiceButton, displayInvoicesButton, deleteLineItemButton, closeButton;
    private ListView<LineItem> lineItemListView;

    public InvoiceManagementUI(InvoiceController invoiceController) {
        this.invoiceController = invoiceController;

        idField = new TextField();
        idField.setPromptText("Invoice ID");
        customerField = new TextField();
        customerField.setPromptText("Customer Name");
        itemIdField = new TextField();
        itemIdField.setPromptText("Item ID");
        itemQuantityField = new TextField();
        itemQuantityField.setPromptText("Item Quantity");
        displayArea = new TextArea();
        displayArea.setEditable(false);

        addLineItemButton = new Button("Add Line Item");
        addInvoiceButton = new Button("Add Invoice");
        displayInvoicesButton = new Button("Display Invoices");
        deleteLineItemButton = new Button("Delete Line Item");
        closeButton = new Button("Close");
        lineItemListView = new ListView<>();

        addLineItemButton.setOnAction(e -> addLineItem());
        addInvoiceButton.setOnAction(e -> addInvoice());
        displayInvoicesButton.setOnAction(e -> displayInvoices());
        deleteLineItemButton.setOnAction(e -> deleteSelectedLineItem());
        closeButton.setOnAction(e -> closeInvoiceManagement());

        VBox root = new VBox(10);
        root.getChildren().addAll(idField, customerField, itemIdField, itemQuantityField, addLineItemButton, deleteLineItemButton, lineItemListView, addInvoiceButton, displayInvoicesButton, closeButton, displayArea);

        stage = new Stage();
        stage.setScene(new Scene(root, 400, 600));
        stage.setTitle("Invoice Management");
    }

    public void show() {
        stage.show();
    }

    private void addLineItem() {
        int itemId = Integer.parseInt(itemIdField.getText());
        int quantity = Integer.parseInt(itemQuantityField.getText());
        Item item = invoiceController.getItemById(itemId);
        if (item != null) {
            LineItem lineItem = new LineItem(item, quantity);
            lineItemListView.getItems().add(lineItem);
        } else {
            displayArea.setText("Item not found.");
        }
    }

    private void deleteSelectedLineItem() {
        LineItem selectedLineItem = lineItemListView.getSelectionModel().getSelectedItem();
        if (selectedLineItem != null) {
            lineItemListView.getItems().remove(selectedLineItem);
        } else {
            displayArea.setText("No line item selected.");
        }
    }

    private void addInvoice() {
        int id = Integer.parseInt(idField.getText());
        String customerName = customerField.getText();
        Invoice invoice = new Invoice(id, customerName);
        LineItem[] lineItems = lineItemListView.getItems().toArray(new LineItem[0]);

        if (lineItems.length > 0) {
            for (LineItem lineItem : lineItems) {
                invoice.addLineItem(lineItem);
            }
        } else {
            displayArea.setText("No line items added.");
            return;
        }

        String message = invoiceController.addInvoice(invoice);
        displayInvoices();
        clearFields();
    }

    private void displayInvoices() {
        String invoices = invoiceController.getInvoices();
        displayArea.setText(invoices);
    }

    private void closeInvoiceManagement() {
        stage.close();
    }

    private void clearFields() {
        idField.clear();
        customerField.clear();
        itemIdField.clear();
        itemQuantityField.clear();
    }
}