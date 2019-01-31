package com.josetesan.poc.GeoIp.repositories.reactive;

import com.josetesan.poc.GeoIp.beans.Location;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveLocationRepository extends ReactiveCassandraRepository<Location,String> {
}
