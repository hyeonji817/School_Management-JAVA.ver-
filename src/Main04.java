import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Department;
import study.java.myschool.service.DepartmentService;
import study.java.myschool.service.impl.DepartmentServiceImpl;

public class Main04 {
	public static void main(String[] args) {
		
		/** ó�� ����� ����� Log4J ��ü ���� */
		// --> import org.apache.logging.log4j.LogManager;
		// --> import org.apache.logging.log4j.Logger;
		Logger logger = LogManager.getFormatterLogger(Main03.class.getName());
		
		/** ��ȸ�� �������� �Ϸù�ȣ�� �����ϰ� �ִ� Beans ��ü ���� */
		// --> import study.java.myschool.model.Department;
		Department dept = new Department();
		dept.setDeptno(201);
		
		/** �����ͺ��̽� ���� */
		// --> import org.apache.ibatis.session.SqlSession;
		SqlSession session = MyBatisConnectionFactory.getSqlSession();
		
		/** ������ ó�� ���� */
		// �����Ͻ� ������ ���� Service ��ü ����
		// --> import study.java.myschool.service.DepartmentService;
		// --> import study.java.myschool.service.impl.DepartmentServiceImpl;
		DepartmentService departmentService = new DepartmentServiceImpl(session);
		// ��ȸ ����� ����� ��ü ����
		Department item = null;
		
		try {
			// �а� ��ȸ�ϱ�
			item = departmentService.getDepartmentItem(dept);
			// ó�� ����� �α׿� ����ϱ�
			logger.debug("��ȸ�� ������ >> " + item.toString());
		} catch (NullPointerException e) {
			logger.error("��ȸ�� �����Ͱ� �����ϴ�.");
		} catch (Exception e) {
			logger.error("������ ��ȸ�� �����߽��ϴ�." + e.getMessage());
		}
		
		/** �����ͺ��̽� ���� ���� */
		session.close();
		
	}
}
