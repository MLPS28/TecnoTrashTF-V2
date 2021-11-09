package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TecnoTrashTfV2Application implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TecnoTrashTfV2Application.class, args);
	}
	
	public void run(String... args) throws Exception{
		String password="SECRETO";
		String contra="DIOSITO";
		
		for(int i=0; i<2; i++) {
			String bcryPassword =passwordEncoder.encode(password);
			System.out.println(bcryPassword);
		}
		
		for(int i=0; i<2; i++) {
			String bcryPassword2 =passwordEncoder.encode(contra);
			System.out.println(bcryPassword2);
		}
		
	}

}
