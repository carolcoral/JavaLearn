package cn.xdl.bean;

public class Book {

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", info=" + info + ", rmb=" + rmb + ", imgpath=" + imgpath + "]";
	}
	private int id;
	private String name;
	private String info;
	private int rmb;
	private String imgpath;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getRmb() {
		return rmb;
	}
	public void setRmb(int rmb) {
		this.rmb = rmb;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Book(int id, String name, String info, int rmb, String imgpath) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.rmb = rmb;
		this.imgpath = imgpath;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String name, String info, int rmb, String imgpath) {
		super();
		this.name = name;
		this.info = info;
		this.rmb = rmb;
		this.imgpath = imgpath;
	}
	
	
}
