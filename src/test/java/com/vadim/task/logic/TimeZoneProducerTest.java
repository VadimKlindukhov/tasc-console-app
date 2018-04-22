package com.vadim.task.logic;

import java.util.TimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Вадим
 */
public class TimeZoneProducerTest {
    
    public TimeZoneProducerTest() {
    }

    @Test
    public void testGetTimeZoneSuccess() {
        String zoneId = "GMT+2";
        String cityName = "Dnipro";
        TimeZoneProducer instance = new TimeZoneProducer();
        TimeZone expResult = TimeZone.getTimeZone("GMT+2");
        TimeZone result = instance.getTimeZone(zoneId, cityName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetTimeZoneFail() {
        String zoneId = "";
        String cityName = "Dnipro";
        TimeZoneProducer instance = new TimeZoneProducer();
        TimeZone expResult = null;
        TimeZone result = instance.getTimeZone(zoneId, cityName);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTimeZoneByCityNameSuccess() {
        String name = "Moscow";
        TimeZoneProducer instance = new TimeZoneProducer();
        TimeZone expResult = TimeZone.getTimeZone("Europe/Moscow");
        TimeZone result = instance.getTimeZoneByCityName(name);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetTimeZoneByCityNameFail() {
        String name = "Dnipro";
        TimeZoneProducer instance = new TimeZoneProducer();
        TimeZone expResult = null;
        TimeZone result = instance.getTimeZoneByCityName(name);
        assertEquals(expResult, result);
    }
    
}
