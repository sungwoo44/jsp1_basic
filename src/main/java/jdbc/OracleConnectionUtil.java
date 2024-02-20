package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionUtil {
    //Connection 타입 객체 생성하는 메소드
    
    public static String DRIVER ="oracle.jdbc.driver.OracleDriver";
    public static String URL="jdbc:oracle:thin:@//192.168.30.25:1521/XE";        
    public static String USERNAME = "C##idev";
    private static String PASSWORD = "1234";


    public static Connection getConnection(){   
        //Connection conn = OracleConnectionUtil.getConnection(); 으로 실행!!
        Connection conn = null;
         

         try {
            //ojdbc11.jar 라이브러리에 포함된 드라이버 클래스를 메모리에 로드 
            // java 6부터 jdbc4.0버전이 지원되고 그 때부터 생략 가능
            
            Class.forName(DRIVER); 
            conn = DriverManager.getConnection(URL,USERNAME, PASSWORD);  
         }catch(Exception e){
            System.out.println("데이터베이스 연결 예외 발생 함.\n\t"+e.getMessage());
         }

         return conn;
    }

    //실행순서 : 1) getConnection()
    //          2) SQL 실행   (개발 프로그램에서 가장 많이 실행하는 SQL은 DML(셀렉,인서트,업데이트,딜리트) 입니다. )
    //                      OracleConnectionUtil 는 1),3)에서 사용!                            
    //          3) close

    //인자로 전달된 Connection 객체를 close.sql 실행이 종료되면 close 해야합니다. 
    public static void close(Connection conn){
        try {
           if(conn!= null) conn.close();
            
        } catch (SQLException e) {
                System.out.println("데이터베이스 연결 해제 예외 발생 :\n\t" +e.getMessage());
        }
    }
}
 