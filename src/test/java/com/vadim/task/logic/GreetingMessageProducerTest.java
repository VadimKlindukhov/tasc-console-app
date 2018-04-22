package com.vadim.task.logic;

import com.vadim.task.util.DayTime;
import java.util.Locale;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Вадим
 */
public class GreetingMessageProducerTest {
    
    public GreetingMessageProducerTest() {
    }
    
    @Before
    public void setUp() {
        Locale.setDefault(Locale.US);
    }

    @Test
    public void testGetGreeting() {
        int hours = 10;
        String cityName = "Dnipro";
        GreetingMessageProducer instance = new GreetingMessageProducer();
        String expResult = "Good day, Dnipro";
        String result = instance.getGreeting(hours, cityName);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetGreetingExpException() {
        int hours = 30;
        String cityName = "Dnipro";
        GreetingMessageProducer instance = new GreetingMessageProducer();
        instance.getGreeting(hours, cityName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPartOfDayExpException() {
        int hour = -3;
        GreetingMessageProducer instance = new GreetingMessageProducer();
        DayTime expResult = null;
        DayTime result = instance.getPartOfDay(hour);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPartOfDayFor7Hours() {
        int hour = 7;
        GreetingMessageProducer instance = new GreetingMessageProducer();
        DayTime expResult = DayTime.MORNING;
        DayTime result = instance.getPartOfDay(hour);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPartOfDayFor13Hours() {
        int hour = 13;
        GreetingMessageProducer instance = new GreetingMessageProducer();
        DayTime expResult = DayTime.DAY;
        DayTime result = instance.getPartOfDay(hour);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPartOfDayFor19Hours() {
        int hour = 19;
        GreetingMessageProducer instance = new GreetingMessageProducer();
        DayTime expResult = DayTime.EVENING;
        DayTime result = instance.getPartOfDay(hour);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPartOfDayFor2Hours() {
        int hour = 2;
        GreetingMessageProducer instance = new GreetingMessageProducer();
        DayTime expResult = DayTime.NIGHT;
        DayTime result = instance.getPartOfDay(hour);
        assertEquals(expResult, result);
    }
    
}
