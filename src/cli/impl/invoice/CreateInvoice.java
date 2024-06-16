package cli.impl.invoice;

import cli.command.invoice.create.CreateInvoiceCommand;
import cli.command.invoice.create.CreateInvoiceRequest;
import cli.command.invoice.create.CreateInvoiceResponse;
import model.Invoice;

public class CreateInvoice implements CreateInvoiceCommand {
    @Override
    public CreateInvoiceResponse execute(CreateInvoiceRequest request) {
        Invoice invoice = new Invoice(
                request.getRentalPerDay(),
                request.getInsurancePerDay(),
                request.getDiscountPerDay(),
                request.getAddPerDay(),
                request.getRentalPrice(),
                request.getInsurancePrice(),
                request.getDiscountPrice(),
                request.getAddPricey(),
                request.getTotalPrice(),
                request.getRental()
        );
        return new CreateInvoiceResponse(invoice);
    }
}
