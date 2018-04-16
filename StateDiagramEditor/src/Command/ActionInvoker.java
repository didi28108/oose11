package Command;

public class ActionInvoker {
	private Command command;
	
	public ActionInvoker(Command cd){
		command = cd;
	}
	
	public void execute(){
		command.execute();
	}
	

}
