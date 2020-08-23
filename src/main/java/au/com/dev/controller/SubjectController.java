package au.com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.dev.dto.Subject;
import au.com.dev.sdm.dto.Resource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/subjects" })
public class SubjectController {
	
	private final SubjectRepository subjectRepository;
	
	public SubjectController(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}
	
//	@GetMapping(produces = "application/json")
//	@RequestMapping(value = "/subjects", method = RequestMethod.GET) 
//	public List<Subject> getSubjects() throws Exception {
//		try {
//			return (List<Subject>) subjectRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//		} catch (Exception ex) {
//			throw new Exception("Subject.", ex);
//		}
//	}

	@PostMapping
	void addSibject( @RequestBody Subject subject) throws Exception {
		try {
			subjectRepository.save(subject);
		} catch (Exception ex) {
			throw new Exception("Subject.", ex);
		}

	}

	@DeleteMapping(path = { "/{id}" })
	public Boolean delete(@PathVariable("id") Long id) {
		System.out.println("Delete id: " + id);
		try {
			subjectRepository.deleteById(id);
			System.out.println("Successfuly removed [Subject.id] : " + id);
			return true;
		} catch (Exception e) {
			System.err.println("Error deleting DTO [Subject.id] : " + id);
			return false;
		}
	}
	
//	@GetMapping(produces = "application/json")
//	@RequestMapping(value = "/quote", method = RequestMethod.GET) 
//	public String getResources(Model model) throws Exception {
//		try {
//			model.addAttribute("resources", getAllResources());
//			return "quote";
//		} catch (Exception ex) {
//			throw new Exception("Resources.", ex);
//		}
//	}
//	
//	public static List<Resource> getAllResources(){
//		List<Resource> resources = new ArrayList<Resource>();
//		for (int i =0 ; i < 30; i++) {
//			Resource r = new Resource();
//			r.setName("Resource_" + i);
//			r.setPrice(Double.valueOf(10 * i));
//			resources.add(r);
//		}
//		return resources;
//	}
}
