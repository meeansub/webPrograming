package lecture1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {

	public static Article createArticle(ResultSet resultSet) throws SQLException {
		Article article=new Article();
		article.setId(resultSet.getInt("id"));
		article.setUserId(resultSet.getInt("userId"));
		article.setNo(resultSet.getInt("no"));
		article.setTitle(resultSet.getString("title"));
		article.setBoardId(resultSet.getInt("boardId"));
		article.setBody(resultSet.getString("body"));
		article.setNotice(resultSet.getBoolean("notice"));
		article.setWriteTime(resultSet.getTimestamp("writeTime"));
		article.setName(resultSet.getString("name"));
		article.setBoardName(resultSet.getString("boardName"));
		return article;


	}
	public static List<Article> findAll(int currentPage, int pageSize, String ss, String st, String od)throws Exception {
		String sql ="call article_findAll(?,?,?,?,?)";

		try (Connection connection = DB.getConnection("bbs2");
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, (currentPage - 1) * pageSize); // firstRecordIndex
			statement.setInt(2, pageSize);                     // pageSize
			statement.setString(3, ss);                        // 조회 방법
			statement.setString(4, st + "%");                  // 검색 문자열
			statement.setString(5, od);                        // 정렬 순서

			try (ResultSet resultSet = statement.executeQuery()) {
				ArrayList<Article> list = new ArrayList<Article>();

				while(resultSet.next()) {
					list.add(createArticle(resultSet));
				}
				return list;
			}
		}
	}
	public static int count(String ss,String st) throws Exception {
		String sql = "call article_count(?, ?)";
		try (Connection connection = DB.getConnection("bbs2");
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, ss);                        // 조회 방법
			statement.setString(2, st + "%");                  // 검색 문자열
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next())
					return resultSet.getInt(1);
			}
		}
		return 0;
	}
	public static Article findOne(int id) throws Exception {
        String sql = "SELECT * FROM article WHERE id=?";
        try (Connection connection = DB.getConnection("bbs2");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	Article article=new Article();
            		article.setId(resultSet.getInt("id"));
            		article.setUserId(resultSet.getInt("userId"));
            		article.setNo(resultSet.getInt("no"));
            		article.setTitle(resultSet.getString("title"));
            		article.setBoardId(resultSet.getInt("boardId"));
            		article.setBody(resultSet.getString("body"));
            		article.setNotice(resultSet.getBoolean("notice"));
            		article.setWriteTime(resultSet.getTimestamp("writeTime"));



            		return article;
                }
            }
            return null;
        }
    }
	public static void update(Article article) throws Exception {
		String sql = "UPDATE article SET title=?, body=?, notice=?, userId=?" +
                " WHERE id = ?";

        try (Connection connection = DB.getConnection("bbs2");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getBody());
            statement.setBoolean(3, article.getNotice());
            statement.setInt(4, article.getUserId());
            statement.setInt(5, article.getId());


            statement.executeUpdate();
        }
    }
	public static void insert(Article article) throws Exception {
        String sql = "INSERT article (userId, boardId, no, title, body, notice, writeTime)" +
                     " VALUES(?,?,?,?,?,?,?)";
        try (Connection connection = DB.getConnection("bbs2");
             PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setInt(1, article.getUserId());
        	statement.setInt(2, article.getBoardId());
        	statement.setInt(3, article.getNo());
            statement.setString(4, article.getTitle());
            statement.setString(5, article.getBody());
            statement.setBoolean(6, article.getNotice());
            statement.setTimestamp(7, article.getWriteTime());


            statement.executeUpdate();
        }
    }
	public static void delete(int id) throws Exception {
		String sql ="DELETE FROM article WHERE id=?";
		try (Connection connection = DB.getConnection("article1");
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, id);
	            statement.executeUpdate();
	        }

	}



}
