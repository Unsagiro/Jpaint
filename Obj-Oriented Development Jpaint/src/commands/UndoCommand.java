package commands;

public class UndoCommand implements ICommand {
    @Override
    public void run(){
        CommandHistory.undo();
     // System.out.println("I got pressed (undo)");
    }
}
