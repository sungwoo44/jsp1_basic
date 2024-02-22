package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import project.vo.CustomerVo;

public class TblCustomerDao {
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
    //회원 가입
    public void join(CustomerVo vo){
        // 할일1 : SQL 작성하기 (매개변수 표시 정확히 합시다.)
        String sql="insert into tbl_custom(custom_id,name,email,age,reg_date) " + 
                    "values (?, ?, ?, ?, sysdate)";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   
                //할일2 : 매개변수 바인딩 (매개변수 타입에 맞는 메소드를 실행합시다.)
                pstmt.setString(1, vo.getCustomId());
                pstmt.setString(2, vo.getName());
                pstmt.setString(3, vo.getEmail());
                pstmt.setInt(4, vo.getAge());

                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }//close는 자동으로 합니다. finally 없음
    }

    //회원정보수정
    public void modify(CustomerVo vo) {

        String sql=  "update tbl_custom set email = ?, age = ? where custom_id = ?";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   //매개변수 바인딩
                pstmt.setString(1, vo.getEmail());
                pstmt.setInt(2, vo.getAge());
                pstmt.setString(3, vo.getCustomId());

                pstmt.executeUpdate();          //실행
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }
    }
    //회원 탈퇴
    public void delete(String customerId) {

        String sql=  "delete from tbl_custom where custom_id = ?";
        try (Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);)
            {   
                //매개변수 바인딩
                pstmt.setString(1, customerId);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }
    }
    //회원정보 ※PK※ 조회 - 조회 결과 행 개수는? : select * from tbl_custom where custom_id = ?
    //                          ㄴ 0 개 : 조회 결과 없다. 조회 결과가 있다면 only 1개.!!
    //                          ㄴ 리턴 타입 CustomerVo
    public CustomerVo getCustomer(String customerId){
        CustomerVo vo = null;
        String sql = "select * from tbl_custom where custom_id = ? ";
        try(
            Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            pstmt.setString(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){      //첫번째 행 조회결과가 있으면 true , 없으면 false
                //할일 : 객체 만들어서 vo 변수에 참조시키기
                vo = new CustomerVo(rs.getString(1), 
                                    rs.getString(2), 
                                    rs.getString(3),
                                    rs.getInt(4), 
                                    rs.getDate(5));
            }
        } catch(SQLException e){
            System.out.println("getCustomer 예외 발생 : " + e.getMessage());
        }    
        return vo;
    }
    

    //관리자를 위한 기능 : 모든 회원정보 조회  select * from tbl_custom
    public List<CustomerVo> allCustomers() {
        List<CustomerVo> list = new ArrayList<>();
        String sql = "select * from tbl_custom";
        try(
            Connection connection = getConnection();       //auto close
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new CustomerVo(rs.getString(1), 
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getInt(4), 
                                        rs.getDate(5)));
            }
        }catch(SQLException e){
            System.out.println("selectAll 예외 발생 : " + e.getMessage());
        }

        return list;
    }


    	//동명이인 and 동일나이 가능성 있으므로 조회결과 여러 행 일때는 list 에 저장합니다.
    
    public List<CustomerVo> selectByNameAge(String name,int age){
    	String sql = "select * from tbl_custom where name = ? and age =?";
    	List<CustomerVo> list = new ArrayList<>();
    	try (
    			Connection connection = getConnection();    
    			PreparedStatement pstmt = connection.prepareStatement(sql);
  
    	){
    		
    		pstmt.setString(1, name);
    		pstmt.setInt(2, age);
    		ResultSet rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			list.add(new CustomerVo(rs.getString(1),
    									rs.getString(2),
    									rs.getString(3),
    									rs.getInt(4),
    									rs.getDate(5)));
    		
    	
    		}
    	}catch(SQLException e){
    		System.out.println("selectByNameAge 예외 발생 "+e.getMessage());
    		
    		
    	}

    	return list;




}
}