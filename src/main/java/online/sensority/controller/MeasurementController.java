package online.sensority.controller;

import online.sensority.model.Measurement;
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
        return measurementService.events(id);
    }

    @GetMapping(value = "/{id}")
    Mono<Measurement> getMovieById(@PathVariable String id){
        return measurementService.getById(id);
    }

    @GetMapping
    Flux<Measurement> getAllMovies(){
        return measurementService.getAll();
    }
}
