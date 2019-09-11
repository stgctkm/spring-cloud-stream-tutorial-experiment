package cloud.stream.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding(Source.class)
public class SinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinkApplication.class, args);
	}

}
