
package com.example.demossss;

import java.util.Scanner;

class PA13A {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        Thread thread = new Thread(trafficLight);
        thread.start();

        System.out.println("Enter 0 to stop");
        Scanner scanner = new Scanner(System.in);
        int zero = scanner.nextInt();
        if (zero == 0) {
            trafficLight.stop();
        }
    }
}

public class TrafficLight implements Runnable {
    int currentIndex = 0;
    boolean running = true;
    @Override
    public void run() {
        while (running) {
            switch (currentIndex % 3) {
                case 0: {
                    try {
                        System.out.println("green");
                        Thread.sleep(10000);
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 1: {
                    try {
                        System.out.println("yellow");
                        Thread.sleep(2000);
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                case 2: {
                    try {
                        System.out.println("red");
                        Thread.sleep(5000);
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            currentIndex++;
        }
    }
    public void stop() {
        System.exit(0);
    }
}
