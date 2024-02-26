package day4.mybatis.dto;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import project.vo.BuyVo;

// 웹에서는 vo 단어 대신 dto를 많이 씁니다.
// Data Transfer Object.   db, 서블릿(컨트롤러) ,jsp(뷰) 사이에서 데이터를 전달해주는 역할.

// 마이바티스에서 매핑할 때 객체는 기본생성자가 있으면 기본생성자!!!
//									없으면 커스텀 생성자로 객체 생성.
@Getter
@ToString				// ↓ 둘중 하나만 실행됨!! 
@AllArgsConstructor		//우선순위(2)커스텀 생성자 : 컬럼명과 변수명 일치 안해도 된다.
//											변수선언 순서와 컬럼순서는 일치해야 합니다. (생성자 형식 맞추기)
@NoArgsConstructor		//우선순위(1)기본 생성자 : 객체 생성 후 setter 로 동작하므로 컬럼명과 변수명 일치해야함.
@EqualsAndHashCode
public class BuyDto {
	
	 
		private int buy_Idx;
		private String customid;
		private String pcode;
		private int quantity;
		private Date buy_Date;
	
}
