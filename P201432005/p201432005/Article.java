package lecture1;

import java.sql.Timestamp;

public class Article {
	int id; //프라이머리키
	int boardId; //보더에서 외래키, 게시판 제목
	String boardName;
	int userId; //유저에서 외래키
	int no; //글번호
	Timestamp writeTime; //작성시각
	String title; //글제목
	String body; //글 본문
	Boolean notice; //공지글여부
	String name; //작성자 이름

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Timestamp getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Timestamp writeTime) {
		this.writeTime = writeTime;
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
	public Boolean getNotice() {
		return notice;
	}
	public void setNotice(Boolean notice) {
		this.notice = notice;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}




}
