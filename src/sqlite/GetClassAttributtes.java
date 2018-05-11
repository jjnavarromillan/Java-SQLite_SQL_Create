package sqlite;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GetClassAttributtes {
	Object obj;
	public GetClassAttributtes(Object obj){
		this.obj = obj;
	}
	public Object getObject(){
		return obj;
	}
	public void getAttributes() 
	{
		try{
			List<Object> Objects = new ArrayList<Object>();
			Class<?> objClass = obj.getClass();
			String nameO = obj.getClass().getName();
			Field[] fieldss = obj.getClass().getDeclaredFields();
			int o=0;
		    for(Field field : fieldss) {
		        String name = field.getName();
		        field.setAccessible(true);
		        Object value = field.get(obj);
		    }
		}
		catch(Exception e){
			System.out.print("Error " + e.toString());
		}
	}



	public Object getValueFromVariableName(String VariableName)
	{
		
		try{
			
			Field o = obj.getClass().getDeclaredField(VariableName);
			
			o.setAccessible(true);
			return o.get(obj);
		}
		catch(Exception e){
			System.out.print("Error " + e.toString());
			return null;
		}
		
	}
	public void setValueFromVariableName(String VariableName,Object value)
	{
		try{
			Field o = obj.getClass().getDeclaredField(VariableName);
			o.setAccessible(true);
			o.set(obj, (Object) value);
		}
		catch(Exception e){
			System.out.print("Error " + e.toString());
		}
	}
	public String getTypeFromVariableName(String VariableName)
	{
			try{
				Field o = obj.getClass().getDeclaredField(VariableName);
				o.setAccessible(true);
				return o.getType().toString();
			}
			catch(Exception e){
				System.out.print("Error " + e.toString());
				return null;
			}
		}
	public String getClassNameFromVariableName(String VariableName)
	{
		try{
			Field o = obj.getClass().getDeclaredField(VariableName);
			o.setAccessible(true);
			return o.getType().toString();
		}
		catch(Exception e){
			System.out.print("Error " + e.toString());
			return null;
		}
	}
	public List<String> getFields()
	{
		List<String> strFields= new ArrayList<String>();
		try{
			List<Object> Objects = new ArrayList<Object>();
			Class<?> objClass = obj.getClass();
			String nameO = obj.getClass().getName();
			Field[] fieldss = obj.getClass().getDeclaredFields();
			int o=0;
		    for(Field field : fieldss) {
		    	field.setAccessible(true);

		    	if(!field.getName().equals("") && !field.getName().contains("Comparator")){

					if(isValidType(field) ){
						strFields.add(field.getName());
					}

		    	}
		    }
	    
		}
		catch(Exception e){
			System.out.print("Error " + e.toString());
			 
		}
		return strFields;
		
	}
	public boolean isValidType(Field field){

		if(field.getType().toString().equals("int")){
			return true;
		}
		if(field.getType().toString().equals("boolean")){
			return true;
		}
		if(field.getType().toString().contains(".String")) {
			return true;
		}
		if(field.getType().toString().equals("double")) {
			return true;
		}
		if(field.getType().toString().contains(".Date")){
			return true;
		}
		return false;
	}
	public String getClassName(){
		return obj.getClass().getName();
		
	}
	public String getClassSimpleName(){
		return obj.getClass().getSimpleName();
		
	}
}
