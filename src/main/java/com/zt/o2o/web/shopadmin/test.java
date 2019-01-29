package com.zt.o2o.web.shopadmin;

public class test {
  
	static int a = 0;
	boolean flag = false;
	
    public synchronized void write(){
    	a = 1;
    	flag = true;
    }
	
    public synchronized void reader(){
    	if(flag){
    		a = a + 1;
    	}
    }
    
	public static void main(String[] args) {
	
	}
	
	public static class PrintThread extends Thread{
		public static final long starttime=System.currentTimeMillis();
		@Override
		public void run(){
			try{
				while(true){
					long t=System.currentTimeMillis()-starttime;
					System.out.println("time:"+t);
					Thread.sleep(100);
				}
			}catch(Exception e){
				
			}
		}
	}

}
