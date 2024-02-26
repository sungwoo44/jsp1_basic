package day5;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;

public class DynamicSqlTest {

	public static void main(String[] args) {
		testNoFilter();
		testCateFilter();
		testPnameFilter();
		testPnameCateFilter();
		testAllFilter();
		testTestOrderByFilter();

	}
	
	public static void testNoFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list =dao.search(null);
		System.out.println(" "+ list);		// 전체 조회
	}
	
	public static void testTestOrderByFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String,Object> map = new HashMap<>();
		map.put("column", "PRICE");
		List<ProductDto> list =dao.search(map);
		System.out.println(" "+ list);		// 전체 조회
	}
	
	
	public static void testCateFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String,Object> map = new HashMap<>();
		map.put("category", "B1"); 	//key 는 파라미터 이름, value 는 검색하고 싶은 컬럼값
		//			↑	key 메퍼 xml 확인!	//value는 검색하고 싶은거!
		List<ProductDto> list =dao.search(map);
		System.out.println(" "+ list);		// 전체 조회
	}
	public static void testPnameFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String,Object> map = new HashMap<>();
		map.put("keyword", "사과"); 	//key 는 파라미터 이름, value 는 검색하고 싶은 컬럼값
		//			↑	key 메퍼 xml 확인!	//value는 검색하고 싶은거!
		List<ProductDto> list =dao.search(map);
		System.out.println(" "+ list);		// 전체 조회
	}
	
	public static void testPnameCateFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String,Object> map = new HashMap<>();
		map.put("category", "B2");
		map.put("keyword", "머스"); 	//key 는 파라미터 이름, value 는 검색하고 싶은 컬럼값
		//			↑	key 메퍼 xml 확인!	//value는 검색하고 싶은거!
		List<ProductDto> list =dao.search(map);
		System.out.println(" "+ list);		// 전체 조회
	}
	
	
	public static void testAllFilter() {
		MybatisProductDao dao = new MybatisProductDao();
		Map<String,Object> map = new HashMap<>();
		
//		map.put("category", "B2");
//		map.put("keyword", "머스"); 	
		
		//문제 : 가격 필터도 적용되도록 매퍼 xml 의 동적 쿼리를 수정하세요.
		map.put("from", 10000); 	
		map.put("to", 60000); 	
		
		List<ProductDto> list =dao.search(map);
		System.out.println(" "+ list);		// 전체 조회
	}

}
