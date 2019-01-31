package com.josetesan.poc.GeoIp.repositories.blocking;

import com.josetesan.poc.GeoIp.beans.Block;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends CassandraRepository<Block,String> {


}
