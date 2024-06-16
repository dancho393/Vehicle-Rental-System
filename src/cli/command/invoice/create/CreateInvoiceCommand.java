package cli.command.invoice.create;

import cli.base.Command;

public interface CreateInvoiceCommand extends Command<CreateInvoiceRequest,CreateInvoiceResponse> {
    CreateInvoiceResponse execute(CreateInvoiceRequest request);
}
