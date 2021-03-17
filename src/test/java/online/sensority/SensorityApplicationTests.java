package online.sensority;

import online.sensority.model.Measurement;
import online.sensority.mongodb.repository.MeasurementMongoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class SensorityApplicationTests {

	private MeasurementMongoRepository repository;

	@Test
	void contextLoads() {
	}

}
