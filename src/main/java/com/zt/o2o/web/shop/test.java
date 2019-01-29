package com.zt.o2o.web.shop;

import java.util.ArrayList;
import java.util.List;

public class test implements Runnable{

	public static List<Integer> numberList = new ArrayList<Integer>();
    int startNum = 0;
    
	public test(int startNum) {
		super();
		this.startNum = startNum;
	}
	public void run() {
		int count = 0;
		while(count<100000){
			   numberList.add(startNum);
			   startNum += 2;
			   count++;
		}
		
	}


   public static void main(String[] args) throws InterruptedException{
		Thread t1 = new Thread(new test(0));
		Thread t2 = new Thread(new test(1));
		t1.start();
		t2.start();
		while(t1.isAlive() || t2.isAlive()){
			Thread.sleep(1);
		}
		System.out.println(numberList.size());
	}
}


