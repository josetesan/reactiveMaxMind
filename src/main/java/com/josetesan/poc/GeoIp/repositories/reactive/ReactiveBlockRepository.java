package com.josetesan.poc.GeoIp.repositories.reactive;

import com.josetesan.poc.GeoIp.beans.Block;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveBlockRepository extends ReactiveCassandraRepository<Block,String> {
}
