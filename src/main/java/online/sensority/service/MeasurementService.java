package online.sensority.service;

import online.sensority.mongodb.repository.MeasurementMongoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

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
//
////    public Flux<MeasurementMessage> events(String id) {
////        return Flux.<MeasurementMessage>generate(movieEventSynchronousSink -> {
////            String[] theatres = { "PVR", "Gopalan", "Rex", "Big Cinemas", "Multiplex", "Innovative", "Cinepolis" };
////            int idx = new Random().nextInt(theatres.length);
////            String random = (theatres[idx]);
////            MeasurementMessage measurementMessage =  new MeasurementMessage(id, random, new Date());
//////            publishEvent(measurementEvent);
////            movieEventSynchronousSink.next(measurementMessage);
////        }).delayElements(Duration.ofSeconds(5));
////    }
//
//    public Mono<RabbitMessage> getById(String id) {
//        return measurementMongoRepository.findById(id);
//    }
//
//    public Flux<RabbitMessage> getAll() {
//        return measurementMongoRepository.findAll();
//    }
//
////    private void publishEvent(MeasurementEvent measurementEvent) {
////        rabbitMQService.sendMessage(measurementEvent);
////    }
//
//    public Mono<RabbitMessage> update(String id, String title) {
//        return measurementMongoRepository
//                .findById(id)
//                .map(p -> new RabbitMessage(p.getId(), title))
//                .flatMap(measurementMongoRepository::save);
//    }
//
//    public Mono<RabbitMessage> delete(String id) {
//        return measurementMongoRepository
//                .findById(id)
//                .flatMap(p -> measurementMongoRepository.deleteById(p.getId()).thenReturn(p));
//    }
//
//    public Mono<RabbitMessage> create(String title) {
//        return measurementMongoRepository
//                .save(new RabbitMessage(null, title))
//                .doOnSuccess(measurement -> publisher.publishEvent(new MeasurementCreationEvent(measurement)));
//    }

}
