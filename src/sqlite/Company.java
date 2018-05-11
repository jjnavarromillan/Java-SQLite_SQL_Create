package sqlite;

public class Company {
	private int CompanyID;
	private String Name;
	private String Description;
	private Owner Person;
	
	public int getCompanyID() {
		return CompanyID;
	}
	public void setCompanyID(int companyID) {
		CompanyID = companyID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Owner getPerson() {
		return Person;
	}
	public void setPerson(Owner person) {
		Person = person;
	}
	
	
	
}
