import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Department;
import study.java.myschool.service.DepartmentService;
import study.java.myschool.service.impl.DepartmentServiceImpl;

public class Main01 {
	public static void main(String[] args) {
		
		/** ó�� ����� ����� Log4J ��ü ���� */
		// �Ķ���ʹ� ���� Ŭ������ �̸�(String)
		// --> import org.apache.logging.log4j.LogManager;
		// --> import org.apache.logging.log4j.Logger;
		Logger logger = LogManager.getFormatterLogger(Main01.class.getName());

		/** ����� �����͸� ��� �ִ� Beans ��ü ���� */
		// --> import study.java.myschool.model.Department;
		Department dept = new Department();
		dept.setDname("��������а�");
		dept.setLoc("��Ű�");

		/** �����ͺ��̽� ���� */
		SqlSession session = MyBatisConnectionFactory.getSqlSession();

		/**  ������ ó�� ���� */
		// �����Ͻ� ������ ���� Service ��ü ����
		DepartmentService departmentService = new DepartmentServiceImpl(session);
		// ����� ����� ���Ϲޱ� ���� Beans ��ü
		Department result = null;
		
		try {
			// �а� �����ϱ�
			result = departmentService.addDepartment(dept);
			// �������� �����ͺ��̽��� �ݿ��ϱ�
			session.commit();
			// ó�� ����� �α׿� ����ϱ�
			logger.debug("����� ������ >> " + result.toString());
		} catch (NullPointerException e) {
			// ����� �����Ͱ� ���� ���
			logger.error("����� �����Ͱ� �����ϴ�.");
		} catch (Exception e) {
			// SQL���� ������ �ִ� ���.
			// �����ͺ��̽��κ��� ���޵Ǵ� �����޽����� ���� Ȯ���ϱ� ���Ͽ�
			//  e.getMessage()�� ���ϰ��� �Բ� ����Ѵ�.
			logger.error("������ ���忡 �����߽��ϴ�." + e.getMessage());
		}
		
		/** �����ͺ��̽� ���� ���� */
		session.close();
	}
}
