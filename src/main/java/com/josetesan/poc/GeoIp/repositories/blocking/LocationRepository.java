package com.josetesan.poc.GeoIp.repositories.blocking;

import com.josetesan.poc.GeoIp.beans.Location;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CassandraRepository<Location,String> {
}
