import java.util.List;

public class InvoiceController {
    private InvoiceModel model;

    public InvoiceController(InvoiceModel model) {
        this.model = model;
    }

    public String addInvoice(Invoice invoice) {
        model.addInvoice(invoice);
        return "Invoice added successfully.";
    }

    public String getInvoices() {
        List<Invoice> invoices = model.getInvoices();
        StringBuilder sb = new StringBuilder();
        for (Invoice invoice : invoices) {
            sb.append(invoice.toString()).append("\n");
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
}