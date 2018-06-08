package lecture1;

public class User {
	int id; //primary key
	String name; //사용자이름

	String loginId;
    String password;
    String email;
    boolean enabled;
    String userType;
    int departmentId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
