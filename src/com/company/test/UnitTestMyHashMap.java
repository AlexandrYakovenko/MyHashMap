package com.company.test;

import com.company.MyHashMap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Result;

public class UnitTestMyHashMap {

    @Test
    public void checkPutGet(){
        MyHashMap h = new MyHashMap(3, 0.75f);
        Long value = 10L;
        h.put(1, value);
        Assert.assertEquals("MyHashMap put() and get() work: ", value, h.get(1));
    }

    @Test
    public void checkSize(){
        MyHashMap h = new MyHashMap(3, 0.75f);
        Long value = 10L;
        h.put(1, value);
        Assert.assertEquals("MyHashMap size() works: ", 1, h.size());
    }

    public static void resultReport(Result result) {
        System.out.println("Finished. Result: Failures: " +
                result.getFailureCount() + ". Ignored: " +
                result.getIgnoreCount() + ". Tests run: " +
                result.getRunCount() + ". Time: " +
                result.getRunTime() + "ms.");
    }

}
