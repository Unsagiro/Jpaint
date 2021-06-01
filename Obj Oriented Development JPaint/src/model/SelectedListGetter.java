package model;

public class SelectedListGetter {

	
	
	
	 static IShapeListSubject selectedList;
		
		
		
	public SelectedListGetter(IShapeListSubject shapesList)
		{
			SelectedListGetter.selectedList = shapesList;
		}
	
	
	public static IShapeListSubject getSelectedList()
		{
		 return selectedList;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
