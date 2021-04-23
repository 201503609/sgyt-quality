package sgyt.com.gt.qualityproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QualityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(QualityProjectApplication.class, args);
	}

}
