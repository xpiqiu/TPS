package training.adv.team1.Domin;

public class User {
	private String id;
	private String name;
	private String password;
	private int userType;
	private int satusMark;

	public User() {
		super();
	}

	public User(String id, String name, String password, int userType, int satusMark) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.userType = userType;
		this.satusMark = satusMark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getSatusMark() {
		return satusMark;
	}

	public void setSatusMark(int satusMark) {
		this.satusMark = satusMark;
	}

}
