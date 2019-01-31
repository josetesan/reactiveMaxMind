package com.josetesan.poc.GeoIp.beans;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("locations")
public class Location {

    @PrimaryKey("geoname_id")
    private String geonameId;
    @Column("locale_code")
    private String localeCode;
    @Column("continent_code")
    private String continentCode;
    @Column("continent_name")
    private String continentName;
    @Column("country_iso_code")
    private String countryIsoCode;
    @Column("country_name")
    private String countryName;
//    @Column("is_in_european_union")
//    private boolean isInEuropeanUnion;

}
