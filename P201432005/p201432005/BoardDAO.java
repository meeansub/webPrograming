package lecture1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	public static List<Board> findAll() throws Exception{
		String sql="SELECT * FROM board";
		try(Connection connection =DB.getConnection("bbs2");
			PreparedStatement statement =connection.prepareStatement(sql);
			ResultSet resultSet =statement.executeQuery()){
			ArrayList<Board> list=new ArrayList<>();
			while(resultSet.next()) {
			Board board =new Board();
			board.setBoardName(resultSet.getString("boardName"));
			board.setId(resultSet.getInt("id"));
			list.add(board);
			}
			return list;
		}

	}
}