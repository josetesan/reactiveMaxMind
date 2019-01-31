## networks table
```cassandraql
create TABLE maxmind.networks (
   network text PRIMARY KEY,
   geoname_id text,
   registered_country_geoname_id text,
   represented_country_geoname_id text,
   is_anonymous_proxy boolean ,
   is_satellite_provider boolean
);
``` 

## locations table
```cassandraql
create TABLE maxmind.locations (
  geoname_id text PRIMARY KEY ,
  locale_code text,
  continent_code text,
  continent_name text ,
  country_iso_code text ,
  country_name text ,
  is_in_european_union boolean
);
```

## How to import:

```cassandraql
COPY maxmind.networks 
  FROM 'GeoLite2-Country-Blocks-IPv4.csv' 
  WITH DELIMITER = ',' 
  AND HEADER = true  ;

COPY maxmind.locations 
  FROM 'GeoLite2-Country-Locations-es.csv' 
  WITH DELIMITER = ',' 
  AND HEADER = true  ;
```

