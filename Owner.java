
public class Owner extends User {
private boolean isAdmin;

public Owner(String name,String email) {
	super(name,email);
	this.isAdmin=true;
}


public String getOEmail() {
	return email;
}
}
