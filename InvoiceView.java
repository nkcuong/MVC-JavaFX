import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class InvoiceView {
    private TextField idField, customerField, itemIdField, itemQuantityField;
    private TextArea displayArea;
    private Button addLineItemButton, addInvoiceButton, displayInvoicesButton;
    private ListView<LineItem> lineItemListView;

    public InvoiceView() {
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
        lineItemListView = new ListView<>();

        VBox root = new VBox(10);
        root.getChildren().addAll(idField, customerField, itemIdField, itemQuantityField, addLineItemButton, lineItemListView, addInvoiceButton, displayInvoicesButton, displayArea);
    }

    public VBox getView() {
        VBox root = new VBox(10);
        root.getChildren().addAll(idField, customerField, itemIdField, itemQuantityField, addLineItemButton, lineItemListView, addInvoiceButton, displayInvoicesButton, displayArea);
        return root;
    }

    public TextField getIdField() {
        return idField;
    }

    public TextField getCustomerField() {
        return customerField;
    }

    public TextField getItemIdField() {
        return itemIdField;
    }

    public TextField getItemQuantityField() {
        return itemQuantityField;
    }

    public TextArea getDisplayArea() {
        return displayArea;
    }

    public Button getAddLineItemButton() {
        return addLineItemButton;
    }

    public Button getAddInvoiceButton() {
        return addInvoiceButton;
    }

    public Button getDisplayInvoicesButton() {
        return displayInvoicesButton;
    }

    public ListView<LineItem> getLineItemListView() {
        return lineItemListView;
    }
}