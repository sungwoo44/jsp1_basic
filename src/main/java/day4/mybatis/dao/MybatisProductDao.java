package day4.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.ProductDto;
import day4.mybatis.dto.cateDto;
import mybatis.SqlSessionBean;

public class MybatisProductDao {
	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	
	public MybatisProductDao() {
		//테스트 db 연결 : 나중에 지웁시다.
//		SqlSession sqlSession =sessionFactory.openSession();
//		System.out.println("db 연결 및 sql 실행 객체: "+ sqlSession);
	}
	
	
	//  SqlSession 객체: insert,update,delete,select 메소드는 sql을 실행합니다.
//					ㄴ 첫번째 인자는 sql매커 파일은 namespace속성.id속성
//					ㄴ 두번째 인자는 sql 실행에 파라미터가 있으면 작성합니다.
	
	public List<ProductDto> selectAll(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectAll");
		sqlSession.close();
		return list;
	}
	public List<ProductDto> selectByCategory(String category){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectByCategory",category);
		sqlSession.close();
		return list;
	}
	public List<ProductDto> selectByPname(String pname){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.selectByPname",pname);
		sqlSession.close();
		return list;
	}
	
	public int insert(ProductDto vo) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblproduct.insert",vo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public int getPriceTable(Map<String,Integer> map) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.update("tblproduct.getPriceTable",map);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public List<ProductDto> search(Map<String,Object> map){
		SqlSession sqlSession = sessionFactory.openSession();
		List<ProductDto> list = sqlSession.selectList("tblproduct.search",map);
		sqlSession.close();
		return list;
	}
	
	public List<cateDto> getCategories(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<cateDto> list = sqlSession.selectList("tblproduct.getCategories");
		sqlSession.close();
		return list;

	}
	
	
}
