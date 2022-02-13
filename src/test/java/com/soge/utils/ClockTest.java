package com.soge.utils;


import org.junit.Before;
import org.junit.Test;

public class ClockTest {
    Clock clock;

    @Before
    public void initialise(){
        clock = new Clock();
    }
    @Test
    public void should_give_current_date_in_string_format(){
        String currentDate = clock.todayAsString();
        assert(currentDate).equals("13/02/2022");
    }
}