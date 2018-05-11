package sqlite;

public class StartUp {

	public static void main(String[] args) throws Exception {
				
		Company company= new Company();
		String sqliteSatement = ObjectToSQLite.ObjectToSQLite_Create(company, Company.class, "CompanyID");
		System.out.println(sqliteSatement);

	}

}
