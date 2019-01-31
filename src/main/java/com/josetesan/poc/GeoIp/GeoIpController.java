package com.josetesan.poc.GeoIp;

import com.josetesan.poc.GeoIp.beans.Location;
import com.josetesan.poc.GeoIp.services.BlockingGeoIpService;
import com.josetesan.poc.GeoIp.services.ReactiveGeoIpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/geo")
@RestController
public class GeoIpController {

    private ReactiveGeoIpService reactiveGeoIpService;
    private BlockingGeoIpService blockingGeoIpService;


    public GeoIpController(ReactiveGeoIpService reactiveGeoIpService, BlockingGeoIpService blockingGeoIpService) {
        this.reactiveGeoIpService = reactiveGeoIpService;
        this.blockingGeoIpService = blockingGeoIpService;
    }

    @GetMapping("/reactive/{ip}")
    public Mono<Location> retrieveReactiveLocation(@PathVariable String ip) {
        return reactiveGeoIpService.getLocationFor(ip);
    }

    @GetMapping("/blocking/{ip}")
    public Location retrieveBlockingLocation(@PathVariable String ip) {
        return blockingGeoIpService.getLocationFor(ip);
    }
}
