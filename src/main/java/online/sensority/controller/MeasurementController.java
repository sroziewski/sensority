package online.sensority.controller;

import online.sensority.model.RabbitMessage;
import online.sensority.model.MeasurementMessage;
import online.sensority.service.MeasurementService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MeasurementMessage> streamMovieEvents(@PathVariable String id){
        return null;
    }

    @GetMapping(value = "/{id}")
    Mono<RabbitMessage> getMovieById(@PathVariable String id){
        return null;
    }

    @GetMapping
    Flux<RabbitMessage> getAllMovies(){
        return null;
    }
}
