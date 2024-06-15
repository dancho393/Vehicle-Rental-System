package cli.command.invoice.calculate.van.insurance;

import cli.base.Command;

public interface CalculateVanInsuranceCommand extends Command<CalculateVanInsuranceRequest,CalculateVanInsuranceResponse> {
    CalculateVanInsuranceResponse execute(CalculateVanInsuranceRequest request);
}
