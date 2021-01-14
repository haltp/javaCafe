package jcafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	Connection conn = null;

	public ProductDAO() {
		try {
			String user = "hr";
			String pw = "hr";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Database에 연결되었습니다.\n");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속실패 : " + sqle.toString());
		} catch (Exception e) {
			System.out.println("Unkonwn error");
			e.printStackTrace();
		}
	}// ProductDAO
	
	public ProductVO getProduct(ProductVO vo) {
		String sql = "select * product where item_no = ?";
		ProductVO v = null;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getItemNO());
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				v = new ProductVO();
				v.setAlt(rs.getString("alt"));
				v.setCategory(rs.getString("category"));
				v.setContent(rs.getString("content"));
				v.setImage(rs.getString("image"));
				v.setItem(rs.getString("item"));
				v.setItemNO(rs.getString("item_no"));
				v.setLikeIt(rs.getInt("like_it"));
				v.setLink(rs.getString("link"));
				v.setPrice(rs.getInt("price"));
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return v;
	}

	public void insertProduct(ProductVO vo) {
		String sql = "insert into product (item_no, item, category, price, content, like_it, image)"
				+ "values(?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getItemNO());
			psmt.setString(2, vo.getItem());
			psmt.setString(3, vo.getCategory());
			psmt.setInt(4, vo.getPrice());
			psmt.setString(5, vo.getContent());
			psmt.setInt(6, vo.getLikeIt());
			psmt.setString(7, vo.getImage());

			r = psmt.executeUpdate();
			System.out.println(r + "건이 입력됨");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<ProductVO> getProductList() {
		String sql = "select * from product order by 1";
		List<ProductVO> list = new ArrayList<>();
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setItemNO(rs.getString("item_no"));
				vo.setItem(rs.getString("item"));
				vo.setAlt(rs.getString("alt"));
				vo.setCategory(rs.getString("category"));
				vo.setContent(rs.getString("content"));
				vo.setImage(rs.getString("image"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setLink(rs.getString("link"));
				vo.setPrice(rs.getInt("price"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}// getProductList()
}