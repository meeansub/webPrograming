package f201432005;

public class Book {
	int id; //프라이머리
	String title; //책제목
	String author; //저자
	int categoryId; //카테고리
	int price; //가격
	int publisherId; //출판사
	Boolean available; // 대여가능
	String cateogryName; //카테고리명
	String ptitle; //출판사명

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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getCateogryName() {
		return cateogryName;
	}
	public void setCateogryName(String cateogryName) {
		this.cateogryName = cateogryName;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}


}
