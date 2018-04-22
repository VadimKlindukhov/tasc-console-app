package com.vadim.task.logic;

import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

/**
 * timezone search logic
 * @author Вадим
 */
public class TimeZoneProducer {
    
    /**
     * filtered time zone id list
     * zone ids with city name inside
     * system and etc/GMT zones excluded
     */
    private List<String> zoneIds;
    
    /**
     * default constructor
     */ 
    public TimeZoneProducer() {
        init();
    }
    
    private void init() {
        zoneIds = Arrays.stream(TimeZone.getAvailableIDs())
                .filter(id -> id.matches("^.*/.*$"))//filter countries amd specific timezones
                .filter(id -> !(id.startsWith("Etc") || id.startsWith("SystemV")))//filter gmt zones and SystemV zones
                .peek(id -> id = "")
                .collect(Collectors.toList());
    }
    
    /**
     * get timezone by city name or zone id
     * @param zoneId zonde id
     * @param cityName city name
     * @return timezone object for @param cityName
     */
    public TimeZone getTimeZone(String zoneId, String cityName) {
        if(zoneId != null && !zoneId.isEmpty()) {
            return getTimeZoneById(zoneId);
        } else {
            return getTimeZoneByCityName(cityName);
        }
    }

    public TimeZone getTimeZoneById(String zoneId) {
        return TimeZone.getTimeZone(zoneId);
    }
    
    /**
     * get time zone by city name
     * @param name city name
     * @return time zone object or null if zone not found
     */
    public TimeZone getTimeZoneByCityName(String name) {
        String arg = name.trim().replaceAll("//s", "_");
        for(String zoneId : zoneIds) {
            if(zoneId.endsWith("/" + arg)) {
                return TimeZone.getTimeZone(zoneId);
            }
        }
        return null;
    }
}
