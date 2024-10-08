package study.java.myschool.model;

/** professor 테이블 구조에 맞춘 Java Beans 생성 */ 
// 기본 생성자 사용을 위해서 별도의 생성자는 생략한다. 
public class Professor {
	private int profno;
	private String name;
	private String userid;
	private String position;
	private int sal;
	private String hiredate; 
	private int comm; 
	private int deptno;
	
	/** getter, setter, toString만 추가하기 */
	public int getProfno() {
		return profno;
	}
	
	public void setProfno(int profno) {
		this.profno = profno;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getSal() {
		return sal;
	}
	
	public void setSal(int sal) {
		this.sal = sal;
	}
	
	public String getHiredate() {
		return hiredate;
	}
	
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	public int getComm() {
		return comm;
	}
	
	public void setComm(int comm) {
		this.comm = comm;
	}
	
	public int getDeptno() {
		return deptno;
	}
	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Professor [profno=" + profno + ", name=" + name + ", userid=" + userid + ", position=" + position
				+ ", sal=" + sal + ", hiredate=" + hiredate + ", comm=" + comm + ", deptno=" + deptno + "]";
	}
}
