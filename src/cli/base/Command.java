package cli.base;

public interface Command  <I extends CommandRequest,O extends CommandResponse>{
    public O execute(I request);

}
