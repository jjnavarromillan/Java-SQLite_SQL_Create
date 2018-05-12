package sqlite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by proharvesting on 5/11/2018.
 *
     public class Company {
         private int CompanyID;
         private String Name;
         private String Description;
         private Owner Person;
     }

    USES

        db.execSQL(ObjectToSQLiteStatement.ObjectToSQLite_Create(new Company(),Company.class,"CompanyID"));

    RESULT:

        CREATE TABLE 'Company' ('CompanyID' INTEGER PRIMARY KEY  NOT NULL ,'Name' String VARCHAR(256),'Description' String VARCHAR(256));

 *
 *
 */

public class ObjectToSQLite {
	public static String ObjectToSQLite_Create(Object object, Class<?> classname, String FieldID) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE '"+classname.getSimpleName()+"' (");

        stringBuilder.append("'"+FieldID+"' INTEGER PRIMARY KEY  NOT NULL ,");


        GetClassAttributtes get =new GetClassAttributtes(object);

        List<String> StrSQLFields = new ArrayList<String>();
        for(int i=0;i<get.getFields().size();i++){
            String ColumnName = get.getFields().get(i);
            if(!ColumnName.equals("") && !ColumnName.equals(FieldID) && !ColumnName.contains("Comparator")){
                
                String typeValue = get.getTypeFromVariableName(ColumnName);

                if(typeValue.equals("class java.lang.String")){
                    StrSQLFields.add("'"+ColumnName+"' VARCHAR(256)");
                }
                if(typeValue.equals("int")){
                    StrSQLFields.add("'"+ColumnName+"' INTEGER ");
                }
                if(typeValue.equals("float")){
                    StrSQLFields.add("'"+ColumnName+"' DOUBLE ");
                }
                if(typeValue.equals("double")){
                    StrSQLFields.add("'"+ColumnName+"' DOUBLE ");
                }
                if(typeValue.equals("boolean")){
                    StrSQLFields.add("'"+ColumnName+"' BOOL ");

                }
                if(typeValue.equals("class java.util.Date")){
                    StrSQLFields.add("'"+ColumnName+"' TEXT ");
                }
            }
        }
        int counter=0;
        for (String strSQL : StrSQLFields ) {
            counter++;
            stringBuilder.append(strSQL);
            if(counter<StrSQLFields.size()){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(");");
        
        return stringBuilder.toString();
    }
}
