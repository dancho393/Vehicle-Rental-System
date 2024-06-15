package cli.command.invoice.calculate.car.insurance;

import cli.base.Command;

public interface CalculateCarInsuranceCommand extends Command<CalculateCarInsuranceRequest,CalculateCarInsuranceResponse> {
    CalculateCarInsuranceResponse execute(CalculateCarInsuranceRequest request);
}
