package edu.dev.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Random;

@Slf4j
public class Main {

    public static void main(String[] args) {

        var numbers = getListOfIntegers();

        var start = System.currentTimeMillis();
        log.info("Current Thread: {}", Thread.currentThread().getName());

        numbers.parallelStream()
                .filter(number -> number % 2 == 0)
                .forEach(Main::evenNumbers);

        numbers.parallelStream()
                .filter(number -> number % 2 != 0)
                .forEach(Main::oddNumbers);

        var end = System.currentTimeMillis();
        log.info("Current Thread: {}, final time: {}", Thread.currentThread().getName(), end - start);
    }

    private static ArrayList<Integer> getListOfIntegers() {
        var maxValue = 100;
        var minValue = 1;
        var size = 10;
        var random = new Random();
        var numbers = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(maxValue - minValue + 1) + minValue;
            numbers.add(randomNumber);
        }

        return numbers;
    }

    private static void oddNumbers(Integer oddNumber) {
        try {

            var start = System.currentTimeMillis();
            log.info("Current Thread: {}", Thread.currentThread().getName());

            log.info("This is a odd numbers: {}", oddNumber);
            Thread.sleep(50);

            var end = System.currentTimeMillis();
            log.info("Current Thread: {}, final time: {}", Thread.currentThread().getName(), end - start);

        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    private static void evenNumbers(Integer evenNumber) {
        try {

            var start = System.currentTimeMillis();
            log.info("Current Thread: {}", Thread.currentThread().getName());

            log.info("This is a even numbers: {}", evenNumber);
            Thread.sleep(50);

            var end = System.currentTimeMillis();
            log.info("Current Thread: {}, final time: {}", Thread.currentThread().getName(), end - start);

        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

}