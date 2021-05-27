package commands;

import java.io.IOException;
import java.util.ArrayList;

import model.ClipBoard;
import model.selectedList;

public class CopyCommand implements ICommand, IUndoable {
	
	
	 ArrayList<ShapeDrawCommand> thisClipBoard = new  ArrayList<ShapeDrawCommand>();
	
	
	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("copy works");
		thisClipBoard.addAll(selectedList.selected);
		ClipBoard.clipBoardList.addAll(selectedList.selected);
		CommandHistory.add(this);
		
	}
	
	
	

	@Override
	public void undo() {
		// TODO Auto-generated method stub

		ClipBoard.clipBoardList.removeAll(thisClipBoard);
		
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

		
		ClipBoard.clipBoardList.addAll(thisClipBoard);
		
		
	}

	

}
