package board;

public class Article {
	
	// 접근제어자
	private int id;
	private String title;
	private String body;
	private String Account;
	private String Password;
	private String Username;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setAccont(String Account) {
		this.Account = Account;
	}
	public void setPassword(String Password) {
		this.Password = Password;	
	}
	public void setUsername(String Username) {
		this.Username = Username;
	}
}