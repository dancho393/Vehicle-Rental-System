package cli.command.invoice.calculate.motorcycle.insurance;

import cli.base.Command;

public interface CalculateMotorcycleInsuranceCommand extends Command<CalculateMotorcycleInsuranceRequest, CalculateMotorcycleInsuranceResponse> {
    CalculateMotorcycleInsuranceResponse execute(CalculateMotorcycleInsuranceRequest request);
}
