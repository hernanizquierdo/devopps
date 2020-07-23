package au.com.dev;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevApplication {

	public static Logger logger = LoggerFactory.getLogger(DevApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DevApplication.class, args);
	}

}
