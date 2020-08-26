package board;

public class Reply {
	private String reply;
	private int Id;
	private String Writer;
	private String yymmdd;
	
	Reply(){
		
	}
	
	Reply(int Id, String Writer, String reply, String yymmdd){
		this.Id = Id;
		this.Writer = Writer;
		this.reply = reply;
		this.yymmdd = yymmdd;
	}
	
	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		this.Writer = writer;
	}

	public String getYymmdd() {
		return yymmdd;
	}

	public void setYymmdd(String yymmdd) {
		this.yymmdd = yymmdd;
	}

	
	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
}