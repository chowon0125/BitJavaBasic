package facebook;

public class StudentServiceImpl implements StudentService {

	Student[] list = null;
	int index;
	
	public StudentServiceImpl() {
		list = new Student[3];
		index = 0;
	}
	public void registration(Student student) {
		list[index] = student;
		index++;
	}

	public Student[] list() {
		return list;
	}

}
