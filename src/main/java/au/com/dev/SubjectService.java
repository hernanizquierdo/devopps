package au.com.dev;

import java.util.List;

import au.com.dev.dto.Subject;

public class SubjectService {
	
	public static int totalCreditSubjects (List<Subject> subjects) {
		int totalCredits = 0;
		for (Subject s : subjects) {
			totalCredits += s.getCredits();
		}
		return totalCredits;
	}
	
	public static double averageCreditSubjects (List<Subject> subjects) {
		int totalCredits = totalCreditSubjects(subjects);
		return totalCredits / subjects.size();
	}
}
