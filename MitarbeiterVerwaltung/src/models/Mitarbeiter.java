package models;

public class Mitarbeiter {
	String name;
	int alter;
	String email;
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Mitarbeiter() {
		this("Hans", 22, "hans@cool.de", "12345");
	}
	
	public Mitarbeiter(String name, int alter, String email, String password) {
		super();
		this.name = name;
		this.alter = alter;
		this.email = email;
		this.password = password;
	}	
}
