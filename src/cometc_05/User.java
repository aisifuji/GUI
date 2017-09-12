package cometc_05;

public class User {
	private String name;
	private String password;
	private String sex;
	private String birthday;
	private String hobby;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public User(String name, String password, String sex, String birthday,
			String hobby) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.hobby = hobby;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", sex=" + sex
				+ ", birthday=" + birthday + ", hobby=" + hobby + "]";
	}
	
	
	

}
