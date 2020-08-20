package board;

public class Reply {
	private String reply;
	private int Id;
	
	Reply(){
		
	}
	
	Reply(int Id, String reply){
		this.Id = Id;
		this.reply = reply;
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
