import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Department;
import study.java.myschool.service.DepartmentService;
import study.java.myschool.service.impl.DepartmentServiceImpl;

public class Main01 {
	public static void main(String[] args) {
		
		/** 처리 결과를 기록할 Log4J 객체 생성 */
		// 파라미터는 현재 클래스의 이름(String)
		// --> import org.apache.logging.log4j.LogManager;
		// --> import org.apache.logging.log4j.Logger;
		Logger logger = LogManager.getFormatterLogger(Main01.class.getName());

		/** 저장될 데이터를 담고 있는 Beans 객체 생성 */
		// --> import study.java.myschool.model.Department;
		Department dept = new Department();
		dept.setDname("정보통신학과");
		dept.setLoc("통신관");

		/** 데이터베이스 접속 */
		SqlSession session = MyBatisConnectionFactory.getSqlSession();

		/**  데이터 처리 수행 */
		// 비지니스 로직을 위한 Service 객체 생성
		DepartmentService departmentService = new DepartmentServiceImpl(session);
		// 저장된 결과를 리턴받기 위한 Beans 객체
		Department result = null;
		
		try {
			// 학과 저장하기
			result = departmentService.addDepartment(dept);
			// 저장결과를 데이터베이스에 반영하기
			session.commit();
			// 처리 결과를 로그에 기록하기
			logger.debug("저장된 데이터 >> " + result.toString());
		} catch (NullPointerException e) {
			// 저장된 데이터가 없는 경우
			logger.error("저장된 데이터가 없습니다.");
		} catch (Exception e) {
			// SQL문에 문제가 있는 경우.
			// 데이터베이스로부터 전달되는 에러메시지를 상세히 확인하기 위하여
			//  e.getMessage()의 리턴값을 함께 기록한다.
			logger.error("데이터 저장에 실패했습니다." + e.getMessage());
		}
		
		/** 데이터베이스 접속 해제 */
		session.close();
	}
}
