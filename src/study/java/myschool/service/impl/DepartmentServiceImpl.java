package study.java.myschool.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import study.java.myschool.model.Department;
import study.java.myschool.model.Professor;
import study.java.myschool.model.Student;
import study.java.myschool.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	/** MyBatis�� Mapper�� ȣ���ϱ� ���� SqlSession ��ü */
	// --> import org.apache.ibatis.session.SqlSession;
	private SqlSession session;
	
	/** ������. SqlSession�� ���޹޴´�. */
	public DepartmentServiceImpl(SqlSession session) {
		this.session = session;
	}
	
	/** �а� �����ϱ� -> ���� �� ����� ����� ��ȸ�Ͽ� �����Ѵ�. */
	// -> import study.java.myschool.model.Department;
	@Override
	public Department addDepartment(Department params) 
			throws NullPointerException, Exception {
		int row_count = session.insert("DepartmentMapper.add_department", params);
		
		// ����� �������� �� ���� ���� ��� ������ ���ܸ� �߻���Ų��.
		if (row_count == 0) {
			throw new NullPointerException();
		}
		
		return session.selectOne("DepartmentMapper.get_department_item", params);
	}

	/** �а� �����ϱ� -> ������ ����� ��ȸ�Ͽ� �����Ѵ�. */
	@Override
	public Department editDepartment(Department params) 
			throws NullPointerException, Exception {
		int row_count = session.update("DepartmentMapper.edit_department", params);
		
		// ������ �������� �� ���� ���� ��� ������ ���ܸ� �߻���Ų��.
		if (row_count == 0) {
			throw new NullPointerException();
		}
		
		return session.selectOne("DepartmentMapper.get_department_item", params);
	}

	/** �а� �����ϱ� */
	@Override
	public void deleteDepartment(Department params) 
			throws NullPointerException, Exception {
		// 1) �л� ������ ����
		// --> import study.java.myschool.model.Student;
		Student stud = new Student();
		stud.setDeptno(params.getDeptno());
		session.delete("StudentMapper.remove_student_by_deptno", stud);
		
		// 2) ���� ������ ����
		// --> import study.java.myschool.model.Professor;
		Professor prof = new Professor();
		prof.setDeptno(params.getDeptno());
		session.delete("ProfessorMapper.remove_professor_by_deptno", prof);
		
		// 3) �а� ������ ����
		int row_count = session.delete(
				"DepartmentMapper.remove_department", params);
		
		// ���������� ������ ���� ���� ��� ������ ���ܸ� �߻���Ų��.
		if (row_count == 0) {
			throw new NullPointerException();
		}
	}

	/** �а� ������ ��ȸ�ϱ� (������) */
	@Override
	public Department getDepartmentItem(Department params) 
			throws NullPointerException, Exception {
		Department item = session.selectOne(
				"DepartmentMapper.get_department_item", params);
		
		if (item == null) {
			throw new NullPointerException();
		}
		
		return item;
	}

	/** �а� ������ ��ȸ (������) */
	@Override
	public List<Department> getDepartmentList() 
			throws NullPointerException, Exception {
		List<Department> list = session.selectList(
				"DepartmentMapper.get_department_list", null);
		
		if (list == null) {
			throw new NullPointerException();
		}
		
		return list;
	}

}
