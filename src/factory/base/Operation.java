package factory.base;

public interface Operation <I extends OperationRequest,O extends OperationResponse> {
    O process(I input);
}
