package com.josetesan.poc.GeoIp.services;

import com.josetesan.poc.GeoIp.beans.Location;
import com.josetesan.poc.GeoIp.repositories.reactive.ReactiveBlockRepository;
import com.josetesan.poc.GeoIp.repositories.reactive.ReactiveLocationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Log4j2
public class ReactiveGeoIpService {

    private ReactiveLocationRepository reactiveLocationRepository;
    private ReactiveBlockRepository reactiveBlockRepository;

    public ReactiveGeoIpService(ReactiveLocationRepository reactiveLocationRepository, ReactiveBlockRepository reactiveBlockRepository) {
        this.reactiveLocationRepository = reactiveLocationRepository;
        this.reactiveBlockRepository = reactiveBlockRepository;
    }

    public Mono<Location> getLocationFor(String ip) {
        log.info("Retrieving ip {}", ip);

        return getNetworkFromIp(ip)
            .map(reactiveBlockRepository::findById)
            .flatMap(Mono::single)
            .map(block -> reactiveLocationRepository.findById(block.getGeonameId()))
            .flatMap(Mono::single)
            .subscribeOn(Schedulers.single());

    }

    private Mono<String> getNetworkFromIp(String ip) {
        return Mono.just("1.4.1.0/24");
    }
}
