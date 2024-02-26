package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.vo.CustomerVo;
import project.vo.ProductVo;

public class TblProductDao {
    public static String DRIVER ="oracle.jdbc.driver.OracleDriver";

    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
   	 Connection conn = null;
        try {
           //ojdbc11.jar 라이브러리에 포함된 드라이버 클래스를 메모리에 로드 
           // java 6부터 jdbc4.0버전이 지원되고 그 때부터 생략 가능
           Class.forName(DRIVER); 
           conn = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        }catch(Exception e){
           System.out.println("데이터베이스 연결 예외 발생 함.\n\t"+e.getMessage());
        }

        return conn;
      // return DriverManager.getConnection(URL, USERNAME, PASSWORD);
   }

    //2. 카테고리로  검색하기 
	public List<ProductVo> selectByCategory(String category) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT \r\n" + 
                     "WHERE CATEGORY =? \r\n" +
                     "ORDER BY PNAME";
        try(
            Connection conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql))
		{
            psmt.setString(1, category);
		    ResultSet rs = psmt.executeQuery();
		    while(rs.next()) {  //조회결과는 n행 가능성 예측
			    list.add(new ProductVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3), 
                                        rs.getInt(4)));
		    }
        }catch(SQLException e){
            System.out.println("selectByCategory 예외 발생 : " + e.getMessage());
        }
		return list;
	}

    //3. 상품명으로 검색하기 (유사검색-> `검색어가 포함된 상품명`을 조회하기)
	public List<ProductVo> selectByPname(String pname) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT \r\n"
                + "WHERE PNAME LIKE '%' || ? || '%' \r\n"      //like는 유사 비교. % 기호 사용
                + "ORDER BY CATEGORY";
        try(
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
		{
            ps.setString(1, pname);
		    ResultSet rs = ps.executeQuery();
		
		    while(rs.next()) {
			    list.add(new ProductVo(rs.getString(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getInt(4)));
		    }
        }catch(SQLException e){
            System.out.println("selectByPname 예외 발생 : " + e.getMessage());
        }
		return list;
	}

    // 상품 가격표 Map 에 저장하기
    public Map<String, Integer> getPriceTable() {
        Map<String, Integer> map = new HashMap<>();
        String sql = "select pcode,price from tbl_product";
        try(
            Connection conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql))
		{
		    ResultSet rs = psmt.executeQuery();
		    while(rs.next()) {  
			   map.put(rs.getString(1),         //key
                       rs.getInt(2));           //value
		    }
        }catch(SQLException e){
            System.out.println("getPriceTable 예외 발생 : " + e.getMessage());
        }

        return map;
    }
    
    
    public List<ProductVo> selectAll(){
    	List<ProductVo> list = new ArrayList<>();
    	String sql= "select * from tbl_product";
    	try(
    		Connection connection = getConnection();
    		PreparedStatement pstmt = connection.prepareStatement(sql);	
    	){
    		ResultSet rs =pstmt.executeQuery();
    		while(rs.next()) {
    			list.add(new ProductVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getInt(4)));
    		}
    		
    	}catch(SQLException e) {
            System.out.println("selectAll 예외 발생 : " + e.getMessage());

    	}
    	return list;
    }
    //리턴 타입 int : 정상 
    //insert 완료하면 1 리턴
    // 		 실패하면 0 리턴
    public int insert(ProductVo vo){
    	
    	int result =0;
        // 할일1 : SQL 작성하기 (매개변수 표시 정확히 합시다.)
        String sql="insert into tbl_product(pcode,category,pname,price) " + 
                    "values (?, ?, ?, ?)";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   
                //할일2 : 매개변수 바인딩 (매개변수 타입에 맞는 메소드를 실행합시다.)
                pstmt.setString(1, vo.getPcode());
                pstmt.setString(2, vo.getCategory());
                pstmt.setString(3, vo.getPname());
                pstmt.setInt(4, vo.getPrice());

                result = pstmt.executeUpdate();
                
                
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }//close는 자동으로 합니다. finally 없음
        
        return result;
    }
    
    
    
    
    
    
    
    
    
}
