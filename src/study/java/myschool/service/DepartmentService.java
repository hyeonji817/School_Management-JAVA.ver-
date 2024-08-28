package study.java.myschool.service;

import java.util.List;

import study.java.myschool.model.Department;

/**
 * �а� ���� ��ɰ� ���õ� MyBatis Mapper�� ���������� ȣ���ϱ� ���� 
 * ��� ��.
 * �ϳ��� ó���� ���ؼ� �� �� �̻��� ����� ������ �ʿ䰡 ���� ���,
 * �� �������̽��� ����ü(Impl)�� ���ؼ� ó���Ѵ�. 
 */
public interface DepartmentService {
	/**
	 * �а� ������ ���� �����ϰ� ����� ������ ��ȸ�Ͽ� �����Ѵ�. 
	 * ����� ���� ���� 0�̰ų�, SQL�� ������ �ִ� ���� 
	 * ���ܸ� �߻����Ѽ�, �� �޼ҵ带 ȣ���ϴ� ��ġ���� try~catch
	 * ������ ���������� ����ϵ��� throws�� ����Ѵ�. 
	 * @param params - ����� ������ ��� �ִ� Beans 
	 * @return - ����� ������ 
	 * @throws NullPointerException - ����� �����Ͱ� ���� ��� 
	 * @throws Exception - SQLó���� ������ ���
	 */
	public Department addDepartment(Department params) throws NullPointerException, Exception;
	
	/**
	 * �а� ������ �����ϰ�, ������ ������ ��ȸ�Ͽ� �����Ѵ�. 
	 * ���� �� ������ ���� �� ���� ���ų�, SQL�� ������ �ִ� ���� 
	 * ���ܸ� �߻����Ѽ�, �� �޼ҵ带 ȣ���ϴ� ��ġ���� try~catch
	 * ������ ���������� ����ϵ��� throws�� ����Ѵ�. 
	 * @param params - ������ ������ ��� �ִ� Beans
	 * @return - ������ ������ 
	 * @throws NullPointerException - ������ �����Ͱ� ���� ��� 
	 * @throws Exception - SQLó���� ������ ���
	 */
	public Department editDepartment(Department params) throws NullPointerException, Exception;
	
	/**
	 * �а� ������ �����Ѵ�.
	 * �� ��, �а��� �ҼӵǾ� �ִ� �л��� ������ �ϰ� �����Ѵ�. 
	 * ���� �� department ���̺��� ������ ���� �� ���� ���ų�,
	 * SQL�� ������ �ִ� ���� ���ܸ� �߻����Ѽ�
	 * �� �޼ҵ带 ȣ���ϴ� ��ġ���� try~catch ������ ����������
	 * ����ϵ��� throws�� ����Ѵ�.
	 * @param params - ������ �а��� ������ ��� �ִ� Beans
	 * @return - Void
	 * @throws NullPointerException - ������ �����Ͱ� ���� ��� 
	 * @throws Exception - SQLó���� ������ ���
	 */
	public void deleteDepartment(Department params) throws NullPointerException, Exception;
	
	/**
	 * �а� �ϳ��� ������ ��ȸ�Ͽ� �����Ѵ�.
	 * @param params - ��ȸ�� ����� ������ ��� �ִ� Beans
	 * @return - ��ȸ����� ��� �ִ� Beans 
	 * @throws NullPointerException - ��ȸ�� �����Ͱ� ���� ��� 
	 * @throws Exception - SQLó���� ������ ��� 
	 */
	public Department getDepartmentItem(Department params) throws NullPointerException, Exception;
	
	/**
	 * �а� ����� ��ȸ�Ͽ� �����Ѵ�.
	 * @return - ��ȸ ����� ��� �ִ� �÷���
	 * @throws NullPointerException - ��ȸ�� �����Ͱ� ���� ���
	 * @throws Exception - SQLó���� ������ ��� 
	 */
	public List<Department> getDepartmentList() throws NullPointerException, Exception;
}
