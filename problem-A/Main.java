package com.example.demossss;

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
