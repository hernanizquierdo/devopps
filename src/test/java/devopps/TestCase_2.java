package devopps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import au.com.dev.SubjectService;
import au.com.dev.dto.Subject;

public class TestCase_2 {

	@Before
	public void setUp() throws Exception {
	}
	
	private Subject getSubject(int credits) {
		Subject s = new Subject();
		s.setName("Subject - " + credits);
		s.setCredits(credits);
		s.setPrereq("S-Y");
		return s;
	}
	@Test
	public final void testTotalCreditSubjects() {
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(getSubject(4));
		subjects.add(getSubject(2));
		subjects.add(getSubject(2));
		subjects.add(getSubject(4));
		int total = SubjectService.totalCreditSubjects(subjects);
		System.out.println(total);
	}

}
