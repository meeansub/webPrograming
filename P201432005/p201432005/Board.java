package lecture1;

public class Board {
	int id; //프라이머리키
	String boardName; // 게시판목록

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

}
