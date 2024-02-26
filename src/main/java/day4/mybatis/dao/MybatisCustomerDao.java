package day4.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import day4.mybatis.dto.BuyDto;
import day4.mybatis.dto.CustomerDto;
import day4.mybatis.dto.ProductDto;
import mybatis.SqlSessionBean;

public class MybatisCustomerDao {
	private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();
	
	public MybatisCustomerDao() {
		//테스트 db 연결 : 나중에 지웁시다.
//		SqlSession sqlSession =sessionFactory.openSession();
//		System.out.println("db 연결 및 sql 실행 객체: "+ sqlSession);
	}
	
	
	//  SqlSession 객체: insert,update,delete,select 메소드는 sql을 실행합니다.
//					ㄴ 첫번째 인자는 sql매커 파일은 namespace속성.id속성
//					ㄴ 두번째 인자는 sql 실행에 파라미터가 있으면 작성합니다.
	
	public int insert(CustomerDto vo) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.insert("tblcustomer.insert",vo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public List<CustomerDto> update(CustomerDto vo) {
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustomer.update",vo);
		sqlSession.commit();
		sqlSession.close();
		return list;
	}
	
	public int delete(String customerId) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.delete("tblcustomer.delete", customerId);
		sqlSession.commit();
		sqlSession.close(); 
		return result;
	}
	public int getCustomer(String customerId) {
		SqlSession sqlSession = sessionFactory.openSession();
		int result = sqlSession.selectOne("tblcustomer.getCustomer",customerId);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	public List<CustomerDto> allCustomers(){
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerDto> list = sqlSession.selectList("tblcustomer.allCustomers");
		sqlSession.close();
		return list;
	}
	
	public List<CustomerDto> selectByNameAge(CustomerDto vo){
		SqlSession sqlSession = sessionFactory.openSession();
		List<CustomerDto> list= sqlSession.selectList("tblcustomer.selectByNameAge",vo);
		sqlSession.close();
		return list;
	}
	
	
	
}
