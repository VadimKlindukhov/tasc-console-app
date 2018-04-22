package com.vadim.task.logic;

import com.vadim.task.util.DayTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * greeting message generating logic
 * @author Вадим
 */
public class GreetingMessageProducer {
    
    /**
     * bundle with localized messages
     */
    private final ResourceBundle messages;
    
    /**
     * default constructor
     */
    public GreetingMessageProducer() {
        messages = ResourceBundle.getBundle("messages", Locale.getDefault());
    }
    
    /**
     * get localized time specific greeting
     * @param hours full hours
     * @param cityName city name
     * @return greeting
     */
    public String getGreeting(int hours, String cityName) {
        DayTime dayTime = getPartOfDay(hours);
        String localizedTimeSpecificMessage = messages.getString(dayTime.getValue());
        return localizedTimeSpecificMessage + ", " + cityName;
    }
    
    /**
     * get part of day by hour value
     * @param hour full hours
     * @return day time enum object
     */
    public DayTime getPartOfDay(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("invalid root arg: the value mast be beetween 0 and 23");
        } else if (hour >= 6 && hour < 9) {
            return DayTime.MORNING;
        } else if (hour >= 9 && hour < 19) {
            return DayTime.DAY;
        } else if (hour >= 19 && hour < 23) {
            return DayTime.EVENING;
        } else {
            return DayTime.NIGHT;
        }
    }
}
