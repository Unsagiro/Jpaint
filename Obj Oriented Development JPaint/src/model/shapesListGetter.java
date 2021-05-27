package model;

public class shapesListGetter {

	 static IShapeListSubject shapesList;
	
	
	
	public shapesListGetter(IShapeListSubject shapesList)
		{
			shapesListGetter.shapesList = shapesList;
		}
	
	
	public static IShapeListSubject getShapesList()
		{
		 return shapesList;
		}
	
	
	
	
	
}
