import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Department;
import study.java.myschool.service.DepartmentService;
import study.java.myschool.service.impl.DepartmentServiceImpl;

public class Main02 {
	public static void main(String[] args) {

		/** ó�� ����� ����� Log4J ��ü ���� */
		// --> import org.apache.logging.log4j.LogManager;
		// --> import org.apache.logging.log4j.Logger;
		Logger logger = LogManager.getFormatterLogger(Main02.class.getName());

		/** ������ �����͸� ��� �ִ� Beans ��ü ���� */
		// --> import study.java.myschool.model.Department;
		Department dept = new Department();
		dept.setDeptno(201);
		dept.setDname("��������а�");
		dept.setLoc("��Ű�");

		/** �����ͺ��̽� ���� */
		// --> import org.apache.ibatis.session.SqlSession;
		SqlSession session = MyBatisConnectionFactory.getSqlSession();

		/** ������ ó�� ���� */
		// �����Ͻ� ������ ���� Service ��ü ����
		// --> import study.java.myschool.service.DepartmentService;
		// --> import study.java.myschool.service.impl.DepartmentServiceImpl;
		DepartmentService departmentService = new DepartmentServiceImpl(session);
		// ������ ����� ���Ϲޱ� ���� Beans ��ü
		Department result = null;
		
		try {
			// �а� �����ϱ�
			result = departmentService.editDepartment(dept);
			// ��������� �����ͺ��̽��� �ݿ��ϱ�
			session.commit();
			// ó�� ����� �α׿� ����ϱ�
			logger.debug("������ ������ >> " + result.toString());
		} catch (NullPointerException e) {
			// ������ �����Ͱ� ���� ���
			logger.error("������ �����Ͱ� �����ϴ�.");
		} catch (Exception e) {
			// SQL���� ������ �ִ� ���.
			logger.error("������ ������ �����߽��ϴ�." + e.getMessage());
		}
		
		/** �����ͺ��̽� ���� ���� */
		session.close();

	}
}
