package sqlite;

public class ObjectToSQLite {
	public static String ObjectToSQLite_Create(Object object, Class<?> classname, String FieldID)throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE '"+classname.getSimpleName()+"' ");

        stringBuilder.append("'"+FieldID+"' INTEGER PRIMARY KEY  NOT NULL ,");

        
        GetClassAttributtes get =new GetClassAttributtes(object);
        for(int i=0;i<get.getFields().size();i++){
            String ColumnName = get.getFields().get(i);

            if(!ColumnName.equals("") && !ColumnName.equals(FieldID) && !ColumnName.contains("Comparator")){

                String typeValue = get.getTypeFromVariableName(ColumnName);

                if(typeValue.equals("class java.lang.String")){

                    stringBuilder.append("'"+ColumnName+"' String VARCHAR(256)");

                }
                if(typeValue.equals("int")){
                    int objectvalue= Integer.parseInt(get.getValueFromVariableName(ColumnName).toString());
                   
                }
                if(typeValue.equals("float")){
                    stringBuilder.append("'"+ColumnName+"' DOUBLE ");
                }
                if(typeValue.equals("double")){
                    stringBuilder.append("'"+ColumnName+"' DOUBLE ");
                }
                if(typeValue.equals("boolean")){
                    stringBuilder.append("'"+ColumnName+"' BOOL ");
                }
                if(typeValue.equals("class java.util.Date")){
                    stringBuilder.append("'"+ColumnName+"' TEXT ");
                }
                
                if(i<get.getFields().size()-1){
                    stringBuilder.append(",");
                }
            }
            
        }
        
        return stringBuilder.toString();
    }
}