package study.java.myschool;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	/** �����ͺ��̽� ���� ��ü */ 
	private static SqlSessionFactory sqlSessionFactory;
	
	/** XML�� ��õ� ���� ������ �о���δ�. */ 
	// Ŭ���� �ʱ�ȭ ��� : Ŭ���� ������ ������ �ʱ�ȭ�� ���ȴ�. 
	// Ŭ������ ó�� �ε��� �� �� ���� ����ȴ�. 
	static {
		// ���� ������ ����ϰ� �ִ� XML�� ��� �б� 
		try {
			Reader reader = Resources.getResourceAsReader("study/java/myschool/config.xml");
			
			// sqlSessionFactory�� �������� �ʴ´ٸ� �����Ѵ�. 
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** �����ͺ��̽� ���� ��ü�� ���� DATABASE�� ������ ������ �����Ѵ�. */ 
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
