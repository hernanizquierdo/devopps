package au.com.dev.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.dev.dto.Subject;
import au.com.dev.sdm.dto.Client;
import au.com.dev.sdm.dto.Quote;
import au.com.dev.sdm.dto.QuoteResource;
import au.com.dev.sdm.dto.Resource;
import au.com.dev.sdm.repository.ClientRepository;
import au.com.dev.sdm.repository.QuoteRepository;
import au.com.dev.sdm.repository.QuoteResourceRepository;
import au.com.dev.sdm.repository.ResourceRepository;

@Controller
public class QuoteController {
	
	private final ResourceRepository resourceRepository;
	private final QuoteRepository quoteRepository;
	private final QuoteResourceRepository qResourceRepo;
	private final ClientRepository clientRepository;
	
	public QuoteController(ResourceRepository resourceRepository, QuoteRepository quoteRepository, ClientRepository clientRepository, QuoteResourceRepository qResourceRepo) {
		this.resourceRepository = resourceRepository;
		this.quoteRepository = quoteRepository;
		this.clientRepository = clientRepository;
		this.qResourceRepo = qResourceRepo;
	}
	
	@GetMapping("/web/quotes")
	public String createQuote(Model model) throws Exception {
		try {
			model.addAttribute("resources", getResources());
			return "quote";
		} catch (Exception ex) {
			throw new Exception("Resources.", ex);
		}
	}
	
	@GetMapping("/web/listquotes")
	public String listQuotes(Model model) throws Exception {
		try {
			model.addAttribute("name", "Administrator");
			model.addAttribute("listQuotes", getQuotes());
			model.addAttribute("clients", getClients());
			model.addAttribute("resources", getResources());
			return "listQuotes";
		} catch (Exception ex) {
			throw new Exception("Resources.", ex);
		}
	}
	
	public List<Quote> getQuotes(){
		return quoteRepository.findAll();
	}
	
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	public  List<Resource> getResources(){
		
//		List<Client> clients = new ArrayList<Client>();
//		
//		Client c = new Client();
//		c.setName("Khimji Vaghjiani");
//		c.setPhone("0405456456");
//		c.setEmail("khim@gmail.com");
//		c.setAddress("Sydney 1");
//		c.setCity("Sydney");
//		c.setCountry("Australia");
//		c.setRegion("NSW");
//		c.setZip("2133");
//	
//		
//		clients.add(c);
//		
//		c = new Client();
//		c.setName("Yash");
//		c.setPhone("0909876543");
//		c.setEmail("yash@torrens.au");
//		c.setAddress("Sydney 1");
//		c.setCity("Sydney");
//		c.setCountry("Australia");
//		c.setRegion("NSW");
//		c.setZip("2133");
//		clients.add(c);
//		
//		c = new Client();
//		c.setName("Syed");
//		c.setPhone("08087654321");
//		c.setEmail("Syed@torrens.au");
//		c.setAddress("Sydney 1");
//		c.setCity("Sydney");
//		c.setCountry("Australia");
//		c.setRegion("NSW");
//		c.setZip("2133");
//		clients.add(c);
//		
//		c = new Client();
//		c.setName("Ammar");
//		c.setPhone("0406543678");
//		c.setEmail("ammar@torrens.au");
//		c.setAddress("Sydney 1");
//		c.setCity("Sydney");
//		c.setCountry("Australia");
//		c.setRegion("NSW");
//		c.setZip("2133");
//		clients.add(c);
//		
//		clientRepository.saveAll(clients);
		
		
		
//		Quote q = new Quote();
//		q.setClient(getClienDB(Long.valueOf("1")));
//		q.setCreated(new Date(2020,8, 12));
//		List<QuoteResource> qrs = new ArrayList<QuoteResource>();
//		
//		QuoteResource qr = new QuoteResource();
//		qr.setQty(1);
//		qr.setResource(getResourceDB(Long.getLong("1")));
//		qrs.add(qr);
//		
//		qr = new QuoteResource();
//		qr.setQty(1);
//		qr.setResource(getResourceDB(Long.getLong("4")));
//		qrs.add(qr);
//		
//		qr = new QuoteResource();
//		qr.setQty(2);
//		qr.setResource(getResourceDB(Long.getLong("3")));
//		qrs.add(qr);
//		
//		qrs = qResourceRepo.saveAll(qrs);
//		q.setQuoteResources(qrs);
//		
//		quoteRepository.save(q);
	
		
		return resourceRepository.findAll();
	}
	
	public Resource getResourceDB(Long id) {
		return resourceRepository.findById(id).get();
	}
	
	public Client getClienDB(Long id) {
		return clientRepository.findById(id).get();
	}
	

}
