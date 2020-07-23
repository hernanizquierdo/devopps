package devopps;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import au.com.dev.SubjectService;
import au.com.dev.dto.Subject;

class TestCase_3 {

	@BeforeEach
	void setUp() throws Exception {
	}

	private Subject getSubject(int credits) {
		Subject s = new Subject();
		s.setName("Subject - " + credits);
		s.setCredits(credits);
		s.setPrereq("S-Y");
		return s;
	}
	@Test
	final void testAverageCreditSubjects() {
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(getSubject(4));
		subjects.add(getSubject(2));
		subjects.add(getSubject(2));
		subjects.add(getSubject(4));
		double s = SubjectService.averageCreditSubjects(subjects);
		System.out.println(s);
	}

}
