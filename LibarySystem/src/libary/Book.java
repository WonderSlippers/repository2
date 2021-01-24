package libary;

public class Book {
	private int BID;
	private String name;
	private int ifborrowed;
	private String authorName;
	private int RID;
	public Book(int bID, String name, int ifborrowed, String authorname,int rID) {
		super();
		BID = bID;
		this.name = name;
		this.ifborrowed = ifborrowed;
		this.authorName=authorname;
		RID = rID;
	}
	public int getBID() {
		return BID;
	}
	public void setBID(int bID) {
		BID = bID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int isIfborrowed() {
		return ifborrowed;
	}
	public void setIfborrowed(int ifborrowed) {
		this.ifborrowed = ifborrowed;
	}
	public int getRID() {
		return RID;
	}
	public void setRID(int rID) {
		RID = rID;
	}
	

}
