package com.example.demossss;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SumCalculator {
    private final int number;
    private int sum;
    public SumCalculator(int number) {
        this.number = number;
    }
    public void calculateSum() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int p= number / 5;
        int s = 1;
        int ee = p;
        for (int i = 0; i < 5; i++) {
            SumWorker worker = new SumWorker(s, ee);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            executor.execute(worker);
            s = ee + 1;
            ee = p + s - 1;
        }
        executor.shutdown();
        System.out.println("The sum of all numbers from 1 to " + number + " is " + sum);
    }
    private class SumWorker implements Runnable {
        private final int start;
        private final int end;
        public SumWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public void run() {
            int localSum = 0;
            for (int i = start; i <= end; i++) {
                localSum += i;
            }
            sum += localSum;
        }
    }
}
public class SumCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();
        SumCalculator calculator = new SumCalculator(number);
        calculator.calculateSum();
    }
}
