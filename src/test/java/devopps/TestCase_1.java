package devopps;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import au.com.dev.controller.SubjectController;
import au.com.dev.dto.Subject;

public class TestCase_1 {
	
	@Autowired
	SubjectController serv;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testGetSubjects() throws Exception {
//		fail("Not yet implemented"); // TODO
		List<Subject> subjects = serv.getSubjects();
		System.out.println(subjects.size());
	}

}
