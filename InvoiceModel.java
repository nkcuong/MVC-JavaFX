import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceModel {
    private List<Invoice> invoices;
    private ItemModel itemModel;
    private static final String INVOICES_FILE = "invoices.dat";

    public InvoiceModel(ItemModel itemModel) {
        this.itemModel = itemModel;
        invoices = new ArrayList<>();
        loadInvoicesFromFile();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
        saveInvoicesToFile();
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public List<Item> getItems() {
        return itemModel.getItems();
    }

    private void saveInvoicesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INVOICES_FILE))) {
            oos.writeObject(invoices);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadInvoicesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INVOICES_FILE))) {
            invoices = (List<Invoice>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}