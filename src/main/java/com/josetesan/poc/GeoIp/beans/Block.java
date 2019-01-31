package com.josetesan.poc.GeoIp.beans;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("networks")
public class Block {

    @PrimaryKey
    @Column("network")
    private String network;
    @Column("geoname_id")
    private String geonameId;
    @Column("registered_country_geoname_id")
    private String registeredCountryGeonameId;
    @Column("represented_country_geoname_id")
    private String representedCountryGeonameId;
//    @Column("is_anonimous_proxy")
//    private boolean isAnonimousProxy;
//    @Column("is_satellite_provider")
//    private boolean isSatelliteProvider;


}
