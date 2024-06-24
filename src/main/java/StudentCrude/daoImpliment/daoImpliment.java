package StudentCrude.daoImpliment;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import StudentCrude.Utility.SqlUtility;
import StudentCrude.dao.StudentDAO;
import StudentCrude.model.Student;

public class daoImpliment implements StudentDAO {

	public int add(Student std) {
		int result = -1;
		try {
			SqlUtility.Db_connection();
			String qry = "insert into student values('" + std.getId() + "'," + "'" + std.getName() + "','"
					+ std.getPhone() + "'" + ",'" + std.getMarks() + "','" + std.getCity() + "','" + std.getGender()
					+ "')";
			result = SqlUtility.insert(qry);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public List<Student> getAll() {
		List<Student> student = new ArrayList<Student>();
		try {
			SqlUtility.Db_connection();
			String qry = "Select * from Student";
			ResultSet rs = SqlUtility.fetch(qry);
			if (rs != null) {
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String phone = rs.getString(3);
					float marks = rs.getFloat(4);
					String city = rs.getString(5);
					String gender = rs.getString(6);
					Student std = new Student(id, name, phone, marks, city, gender);
					student.add(std);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return student;
	}

	public Student getbyId(int id) {
		Student std = null;
		try {
			SqlUtility.Db_connection();
			String qry = "Select * from Student where id =" + id;
			ResultSet rs = SqlUtility.fetch(qry);
			if (rs != null) {
				if (rs.next()) {
					int sid = rs.getInt(1);
					String name = rs.getString(2);
					String phone = rs.getString(3);
					float marks = rs.getFloat(4);
					String city = rs.getString(5);
					String gender = rs.getString(6);
					std.setId(sid);
					std.setName(name);
					std.setPhone(phone);
					std.setMarks(marks);
					std.setCity(city);
					std.setGender(gender);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return std;
	}

	public int remove(int id) {
		int result = -1;
		try {
			SqlUtility.Db_connection();
			String qry = "delete from student where id =" + id;
			result = SqlUtility.delete(qry);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	public int update(int id, Student std) {
		try {
			SqlUtility.Db_connection();
			String qry = "update Student set name ='" + std.getName() + "', " + "phone = '" + std.getPhone()
					+ "',marks = '" + std.getMarks() + "',city = '" + std.getCity() + "','" + std.getGender() + "')";
			SqlUtility.update(qry);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

}
