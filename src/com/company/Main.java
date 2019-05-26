package com.company;

import java.util.HashMap;
import com.company.test.UnitTestMyHashMap;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Main {

    public static void main(String[] args) {
        try {
            runTests();
            JUnitCore jUnitCore = new JUnitCore();
            Result result = jUnitCore.run(UnitTestMyHashMap.class);
            UnitTestMyHashMap.resultReport(result);
        } catch (TestException e) {
            e.printStackTrace();
        }
    }

    private static void runTests() throws TestException {
        MyHashMap myHashMapTest = new MyHashMap(4, 0.75f);

        myHashMapTest.put(1,1);
        if (myHashMapTest.get(1) == 1) {
            System.out.println("Passed. Put in bucket where key = 1 and get = " + myHashMapTest.get(1));
        } else {throw new TestException(1);}

        myHashMapTest.put(1,2);
        if (myHashMapTest.get(1) == 2) {
            System.out.println("Passed. Put in bucket where key = 1 and rewrite value, get = " + myHashMapTest.get(1));
        } else {throw new TestException(1);}

        myHashMapTest.put(2,2);
        if (myHashMapTest.get(2) == 2) {
            System.out.println("Passed. Put in bucket where key = 2 and get = " + myHashMapTest.get(2));
        } else {throw new TestException(2);}

        myHashMapTest.put(3,3);
        if (myHashMapTest.get(3) == 3) {
            System.out.println("Passed. Put in bucket where key = 3 and get = " + myHashMapTest.get(3));
        } else {throw new TestException(3);}

        myHashMapTest.put(4,4);
        if (myHashMapTest.get(4) == 4) {
            System.out.println("Passed. Put in bucket where key = 4 and get = " + myHashMapTest.get(4));
        } else {throw new TestException(4);}

        myHashMapTest.put(5,5);
        if (myHashMapTest.get(5) == 5) {
            System.out.println("Passed. Put in bucket where key = 5 and get = " + myHashMapTest.get(5));
        } else {throw new TestException(5);}

        if (myHashMapTest.size() == 5) {
            System.out.println("Passed. Function size() = " + myHashMapTest.size() );
        } else {throw new TestException("Size test");}

        //This part of code shows how fast the MyHashMap with open addressing works in milliseconds
        long BeforeMyHashMap = System.currentTimeMillis();
        MyHashMap myHashMap = new MyHashMap(100,0.75f);
        for (int i = 0; i < 1_000_000; i++) {
            myHashMap.put(i,i);
            myHashMap.get(i);
        }
        long AfterMyHashMap = System.currentTimeMillis();
        System.out.println("MyHashMap works: " + (AfterMyHashMap - BeforeMyHashMap));

        //This part of code shows how fast the HashMap works in milliseconds
        long BeforeHashMap = System.currentTimeMillis();
        HashMap hashMap = new HashMap(100,0.75f);
        for (int i = 0; i < 1_000_000; i++) {
            hashMap.put(i,i);
            hashMap.get(i);
        }
        long AfterHashMap = System.currentTimeMillis();
        System.out.println("HashMap works: " + (AfterHashMap - BeforeHashMap));
    }

     static class TestException extends Exception {
        int testId;
        String testType;

        public TestException(int testId) {
            this.testId = testId;
        }

        public TestException(String testType) {
            this.testType = testType;
        }

        @Override
        public String toString() {
            return "Test failed: " + testId + "|" + testType;
        }
    }
}
