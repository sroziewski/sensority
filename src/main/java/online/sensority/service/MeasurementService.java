package online.sensority.service;

import online.sensority.event.MeasurementCreationEvent;
import online.sensority.model.Measurement;
import online.sensority.model.MeasurementMessage;
import online.sensority.mongodb.repository.MeasurementMongoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

@Service
public class MeasurementService {

    private final MeasurementMongoRepository measurementMongoRepository;
//    private final RabbitMQService rabbitMQService;
    private final ApplicationEventPublisher publisher;

    public MeasurementService(MeasurementMongoRepository measurementMongoRepository, ApplicationEventPublisher publisher) {
        this.measurementMongoRepository = measurementMongoRepository;
//        this.rabbitMQService = rabbitMQService;
        this.publisher = publisher;
    }

    public Flux<MeasurementMessage> events(String id) {
        return Flux.<MeasurementMessage>generate(movieEventSynchronousSink -> {
            String[] theatres = { "PVR", "Gopalan", "Rex", "Big Cinemas", "Multiplex", "Innovative", "Cinepolis" };
            int idx = new Random().nextInt(theatres.length);
            String random = (theatres[idx]);
            MeasurementMessage measurementMessage =  new MeasurementMessage(id, random, new Date());
//            publishEvent(measurementEvent);
            movieEventSynchronousSink.next(measurementMessage);
        }).delayElements(Duration.ofSeconds(5));
    }

    public Mono<Measurement> getById(String id) {
        return measurementMongoRepository.findById(id);
    }

    public Flux<Measurement> getAll() {
        return measurementMongoRepository.findAll();
    }

//    private void publishEvent(MeasurementEvent measurementEvent) {
//        rabbitMQService.sendMessage(measurementEvent);
//    }

    public Mono<Measurement> update(String id, String title) {
        return measurementMongoRepository
                .findById(id)
                .map(p -> new Measurement(p.getId(), title))
                .flatMap(measurementMongoRepository::save);
    }

    public Mono<Measurement> delete(String id) {
        return measurementMongoRepository
                .findById(id)
                .flatMap(p -> measurementMongoRepository.deleteById(p.getId()).thenReturn(p));
    }

    public Mono<Measurement> create(String title) {
        return measurementMongoRepository
                .save(new Measurement(null, title))
                .doOnSuccess(measurement -> publisher.publishEvent(new MeasurementCreationEvent(measurement)));
    }

}
