package com.vadim.task.util;

/**
 *
 * @author Вадим
 */
public enum DayTime {
    
    MORNING("morning"), DAY("day"), EVENING("evening"), NIGHT("night");
    
    private final String value;
    
    DayTime(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}