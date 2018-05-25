package lecture1.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO1 {


	  public static Product createProduct(ResultSet resultSet) throws SQLException {
	        Product product = new Product();
	        product.setId(resultSet.getInt("id"));
	        product.setTitle(resultSet.getString("title"));
	        product.setCategoryId(resultSet.getString("c.name"));
	        product.setUnitCost(resultSet.getInt("unitCost"));
	        product.setQuantity(resultSet.getInt("quantity"));
	        product.setNum(resultSet.getInt("categoryId"));
	        return product;
	    }

	  public static List<Product> findAll(int currentPage, int pageSize) throws Exception {
		  String sql = " SELECT p.*, c.name " +
				  " FROM product p LEFT JOIN category c  ON p.categoryId = c.id " +
                  " LIMIT ?, ? ";
				  try (Connection connection = DB.getConnection("product");
						  PreparedStatement statement = connection.prepareStatement(sql)) {
					  statement.setInt(1, (currentPage - 1) * pageSize);
					  statement.setInt(2, pageSize);
					  try (ResultSet resultSet = statement.executeQuery()) {
						  ArrayList<Product> list = new ArrayList<Product>();
						  while (resultSet.next())
							  list.add(createProduct(resultSet));
						  return list;
					  }
				  }
	  }

    public static int count() throws Exception {
        String sql = "SELECT COUNT(*) FROM product";
        try (Connection connection = DB.getConnection("product");
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) //조회결과가 1개라 루프를 돌지 않고 if문을 사용
                    return resultSet.getInt(1);  //필드명을 줘도 되고 숫자로 줘도 됌
        }
        return 0;
    }


}
