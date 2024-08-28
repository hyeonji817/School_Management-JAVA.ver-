import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Department;
import study.java.myschool.service.DepartmentService;
import study.java.myschool.service.impl.DepartmentServiceImpl;

public class Main03 {
	public static void main(String[] args) {

		/** ó�� ����� ����� Log4J ��ü ���� */
		// --> import org.apache.logging.log4j.LogManager;
		// --> import org.apache.logging.log4j.Logger;
		Logger logger = LogManager.getFormatterLogger(Main03.class.getName());
		
		/** ������ �����͸� ��� �ִ� Beans ��ü ���� */
		// --> import study.java.myschool.model.Department;
		Department dept = new Department();
		dept.setDeptno(308);
		
		/** �����ͺ��̽� ���� */
		// --> import org.apache.ibatis.session.SqlSession;
		SqlSession session = MyBatisConnectionFactory.getSqlSession();
		
		/** ������ ó�� ���� */
		// �����Ͻ� ������ ���� Service ��ü ����
		// --> import study.java.myschool.service.DepartmentService;
		// --> import study.java.myschool.service.impl.DepartmentServiceImpl;
		DepartmentService departmentService = new DepartmentServiceImpl(session);
		
		try {
			// �а� �����ϱ�
			departmentService.deleteDepartment(dept);
			// ��������� �����ͺ��̽��� �ݿ��ϱ�
			session.commit();
			// ó�� ����� �α׿� ����ϱ�
			logger.debug("������ ���� �Ϸ�");
		} catch (NullPointerException e) {
			logger.error("������ �����Ͱ� �����ϴ�.");
		} catch (Exception e) {
			logger.error("������ ������ �����߽��ϴ�." + e.getMessage());
		}
		
		/** �����ͺ��̽� ���� ���� */
		session.close();
		
	}
}
