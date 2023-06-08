package com.sapan;

public class Task implements Runnable {
    
    private String input;
    
    public Task(String s){
        this.input=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. input = " + input);
        takeABreak();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void takeABreak() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
