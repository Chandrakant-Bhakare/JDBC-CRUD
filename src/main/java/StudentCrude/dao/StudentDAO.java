package StudentCrude.dao;

import java.util.List;
import StudentCrude.model.Student;

public interface StudentDAO {
	int add(Student std);
	List<Student>getAll();
	Student getbyId(int id);
	int remove(int id);
	int update(int id,Student std);

}
