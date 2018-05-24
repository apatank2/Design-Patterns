package studentOrientation.util;

import studentOrientation.activity.Student;

public class Results implements StdoutDisplayInterfaceI {

	@Override
	public void write(Student student) {
		String str = "";
		if(student != null)
			str = student.toString();
		System.out.println(str);
		System.out.println();
	}

}
