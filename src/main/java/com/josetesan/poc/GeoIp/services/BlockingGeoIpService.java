package com.josetesan.poc.GeoIp.services;

import com.josetesan.poc.GeoIp.beans.Location;
import com.josetesan.poc.GeoIp.repositories.blocking.BlockRepository;
import com.josetesan.poc.GeoIp.repositories.blocking.LocationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BlockingGeoIpService {

    private LocationRepository locationRepository;
    private BlockRepository blockRepository;

    public BlockingGeoIpService(LocationRepository locationRepository, BlockRepository blockRepository) {
        this.locationRepository = locationRepository;
        this.blockRepository = blockRepository;
    }

    public Location getLocationFor(String ip) {
        log.info("Retrieving ip {}", ip);

        String network = getNetworkFromIp(ip);

        return this.blockRepository.findById(network)
            .map(block -> locationRepository.findById(block.getGeonameId()))
            .flatMap(i -> i)
            .orElseThrow(IllegalArgumentException::new);

    }

    private String getNetworkFromIp(String ip) {
        return "1.4.1.0/24";
    }
}
