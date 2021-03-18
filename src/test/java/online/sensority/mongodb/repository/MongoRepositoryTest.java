package online.sensority.mongodb.repository;

import lombok.extern.log4j.Log4j2;
import online.sensority.model.RabbitMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.function.Predicate;

@Log4j2
@DataMongoTest
@ActiveProfiles("test")
public class MongoRepositoryTest {

    @Autowired
    private Environment environment;

    private final MeasurementMongoRepository repository;

    public MongoRepositoryTest(@Autowired MeasurementMongoRepository repository) {
        this.repository = repository;
    }

//    @Test
//    public void getAll() {
//        Flux<RabbitMessage> saved = repository.saveAll(Flux.just(new RabbitMessage(null, "Josh"), new RabbitMessage(null, "Matt"), new RabbitMessage(null, "Jane")));
//
//        Flux<RabbitMessage> composite = repository.findAll().thenMany(saved);
//
//        Predicate<RabbitMessage> match = measurement -> saved.any(saveItem -> saveItem.equals(measurement)).block();
//
//        StepVerifier
//                .create(composite)
//                .expectNextMatches(match)
//                .expectNextMatches(match)
//                .expectNextMatches(match)
//                .verifyComplete();
//    }
}
