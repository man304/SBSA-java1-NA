package board;

public class Article {
	
	// Á¢±ÙÁ¦¾îÀÚ
	private int id;
	private String title;
	private String body;
	private String writer;
	private String regDate;
	private int viewCount;
	private int page;
	
	Article() {
		
	}
	
	Article(int id, String title, String body, String writer, String regDate, int viewCount, int page) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.writer = writer;
		this.regDate = regDate;
		this.viewCount = viewCount;
		this.page = page;
	}
	
	

	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getviewCount() {
		return viewCount;
	}

	public void setviewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

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
		
}