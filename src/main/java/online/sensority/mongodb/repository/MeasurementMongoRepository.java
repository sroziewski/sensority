package online.sensority.mongodb.repository;

import online.sensority.model.Measurement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MeasurementMongoRepository extends ReactiveMongoRepository<Measurement, String> {

    Mono<Measurement> findFirstByTitle(String title);
}
