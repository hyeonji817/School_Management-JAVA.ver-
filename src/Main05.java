import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.java.myschool.MyBatisConnectionFactory;
import study.java.myschool.model.Department;
import study.java.myschool.service.DepartmentService;
import study.java.myschool.service.impl.DepartmentServiceImpl;

public class Main05 {
	public static void main(String[] args) {
		
		/** ó�� ����� ����� Log4J ��ü ���� */
		// --> import org.apache.logging.log4j.LogManager;
		// --> import org.apache.logging.log4j.Logger;
		Logger logger = LogManager.getFormatterLogger(Main03.class.getName());
		
		/** �����ͺ��̽� ���� */
		// --> import org.apache.ibatis.session.SqlSession;
		SqlSession session = MyBatisConnectionFactory.getSqlSession();
		
		/** ������ ó�� ���� */
		// �����Ͻ� ������ ���� Service ��ü ����
		// --> import study.java.myschool.service.DepartmentService;
		// --> import study.java.myschool.service.impl.DepartmentServiceImpl;
		DepartmentService departmentService = new DepartmentServiceImpl(session);
		// ��ȸ ����� ����� ��ü ���� --> import java.util.List;
		List<Department> list = null;
		
		try {
			// �а� ��ȸ�ϱ�
			list = departmentService.getDepartmentList();
			// ��ȸ����� �ݺ������� ��ĵ�ϸ鼭 ����Ѵ�.
			for (int i=0; i<list.size(); i++) {
				Department temp = list.get(i);
				logger.debug(String.format("��ȸ���[%d] >> %s", i, temp.toString()));
			}
		} catch (NullPointerException e) {
			logger.error("��ȸ�� �����Ͱ� �����ϴ�.");
		} catch (Exception e) {
			logger.error("������ ��ȸ�� �����߽��ϴ�." + e.getMessage());
		}
		
		/** �����ͺ��̽� ���� ���� */
		session.close();
		
	}
}
