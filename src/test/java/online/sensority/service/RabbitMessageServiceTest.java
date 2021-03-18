package online.sensority.service;

import lombok.extern.log4j.Log4j2;
import online.sensority.model.RabbitMessage;
import online.sensority.mongodb.repository.MeasurementMongoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;
import java.util.function.Predicate;

@Log4j2
@DataMongoTest
@Import(MeasurementService.class)
@ActiveProfiles("test")
public class RabbitMessageServiceTest {

    private final MeasurementService service;
    private final MeasurementMongoRepository repository;

    public RabbitMessageServiceTest(@Autowired MeasurementService service,
                                    @Autowired MeasurementMongoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

  /*  @Test
    public void getAll() {
        Flux<RabbitMessage> saved = repository.saveAll(Flux.just(new RabbitMessage(null, "Josh"), new RabbitMessage(null, "Matt"), new RabbitMessage(null, "Jane")));

        Flux<RabbitMessage> composite = service.getAll().thenMany(saved);

        Predicate<RabbitMessage> match = measurement -> saved.any(saveItem -> saveItem.equals(measurement)).block();

        StepVerifier
                .create(composite)
                .expectNextMatches(match)
                .expectNextMatches(match)
                .expectNextMatches(match)
                .verifyComplete();
    }

    @Test
    public void save() {
        Mono<RabbitMessage> measurementMono = service.create("email@email.com");
        StepVerifier
                .create(measurementMono)
                .expectNextMatches(saved -> StringUtils.hasText(saved.getId()))
                .verifyComplete();
    }

    @Test
    public void delete() {
        String test = "test";
        Mono<RabbitMessage> deleted = service
                .create(test)
                .flatMap(saved -> service.delete(saved.getId()));
        StepVerifier
                .create(deleted)
                .expectNextMatches(measurement -> measurement.getTitle().equalsIgnoreCase(test))
                .verifyComplete();
    }

    @Test
    public void update() throws Exception {
        Mono<RabbitMessage> saved = service
                .create("test")
                .flatMap(p -> service.update(p.getId(), "test1"));
        StepVerifier
                .create(saved)
                .expectNextMatches(p -> p.getTitle().equalsIgnoreCase("test1"))
                .verifyComplete();
    }

    @Test
    public void getById() {
        String test = UUID.randomUUID().toString();
        Mono<RabbitMessage> deleted = service
                .create(test)
                .flatMap(saved -> service.getById(saved.getId()));
        StepVerifier
                .create(deleted)
                .expectNextMatches(measurement -> StringUtils.hasText(measurement.getId()) && test.equalsIgnoreCase(measurement.getTitle()))
                .verifyComplete();
    }*/
}
