package net.sasu.lib.elapsedtime.timeteller;


import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import net.sasu.lib.elapsedtime.timeteller.VerboseTimeTeller;

import org.junit.jupiter.api.Assertions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Tests TimeTeller
 * 
 * @author Sasu
 *
 */
public class VerboseTimeTellerTest {

    @Test
    public void getElapsedTimeTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Map<Long, String> inputExcpectedOutputMap = new LinkedHashMap<>();

        inputExcpectedOutputMap.put(0L, "0 nanoseconds");
        inputExcpectedOutputMap.put(1L, "1 nanosecond");
        inputExcpectedOutputMap.put(999L, "999 nanoseconds");
        inputExcpectedOutputMap.put(1000L, "1 microsecond");

        inputExcpectedOutputMap.put(999999L, "999 microseconds");
        inputExcpectedOutputMap.put(1000000L, "1 millisecond");
        inputExcpectedOutputMap.put(999999999L, "999 milliseconds");
        inputExcpectedOutputMap.put(1000000000L, "1.000 seconds");
        inputExcpectedOutputMap.put(1001000000L, "1.001 seconds");
        inputExcpectedOutputMap.put(1500000000L, "1.500 seconds");
        inputExcpectedOutputMap.put(1601000000L, "1.601 seconds");
        inputExcpectedOutputMap.put(15000000000L, "15.000 seconds");
        inputExcpectedOutputMap.put(15030000000L, "15.030 seconds");
        inputExcpectedOutputMap.put(12345678901L, "12.345 seconds");
        inputExcpectedOutputMap.put(12895678901L, "12.895 seconds");
        inputExcpectedOutputMap.put(59000000000L, "59.000 seconds");
        inputExcpectedOutputMap.put(60000000000L, "1 minute, 0 seconds");
        inputExcpectedOutputMap.put(61000000000L, "1 minute, 1 second");
        inputExcpectedOutputMap.put(62000000000L, "1 minute, 2 seconds");
        inputExcpectedOutputMap.put(62000000000L, "1 minute, 2 seconds");
        inputExcpectedOutputMap.put(121000000000L, "2 minutes, 1 second");
        inputExcpectedOutputMap.put(122000000000L, "2 minutes, 2 seconds");
        inputExcpectedOutputMap.put(3540000000000L, "59 minutes, 0 seconds");
        inputExcpectedOutputMap.put(3599000000000L, "59 minutes, 59 seconds");
        inputExcpectedOutputMap.put(3600000000000L, "1 hour, 0 minutes, 0 seconds");
        inputExcpectedOutputMap.put(3601000000000L, "1 hour, 0 minutes, 1 second");
        inputExcpectedOutputMap.put(3661000000000L, "1 hour, 1 minute, 1 second");
        inputExcpectedOutputMap.put(3662000000000L, "1 hour, 1 minute, 2 seconds");
        inputExcpectedOutputMap.put(3722000000000L, "1 hour, 2 minutes, 2 seconds");
        inputExcpectedOutputMap.put(7200000000000L, "2 hours, 0 minutes, 0 seconds");
        inputExcpectedOutputMap.put(86399000000000L, "23 hours, 59 minutes, 59 seconds");
        inputExcpectedOutputMap.put(86400000000000L, "1 day, 0 hours, 0 minutes, 0 seconds");
        inputExcpectedOutputMap.put(86401000000000L, "1 day, 0 hours, 0 minutes, 1 second");
        inputExcpectedOutputMap.put(86402000000000L, "1 day, 0 hours, 0 minutes, 2 seconds");
        inputExcpectedOutputMap.put(180000000000000L, "2 days, 2 hours, 0 minutes, 0 seconds");

        VerboseTimeTeller vtt = new VerboseTimeTeller();
        
        Set<Entry<Long, String>> entrySet = inputExcpectedOutputMap.entrySet();
        for (Entry<Long, String> entry : entrySet) {
            final String testResult = vtt.outputElapsedTime(entry.getKey(), TimeUnit.NANOSECONDS);
            System.out.println(entry.getKey() + " / " + entry.getValue() + ": " + testResult);
            Assertions.assertEquals(entry.getValue(), testResult, "Test with input value " + entry.getKey() + " failed.");
        }
    }
}