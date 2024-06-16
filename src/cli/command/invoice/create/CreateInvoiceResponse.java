package cli.command.invoice.create;

import cli.base.CommandResponse;
import model.Invoice;

public class CreateInvoiceResponse implements CommandResponse {
    private Invoice invoice;

    public CreateInvoiceResponse(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
