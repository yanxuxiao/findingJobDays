package day20161125;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public static AtomicInteger number =  new AtomicInteger(0);
    public  void increase(){
        try {
        	TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        number.getAndAdd(1) ;
        System.out.println(number);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        final AtomicIntegerTest test = new AtomicIntegerTest();
        for(int i = 0 ; i < 500 ; i++){
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                    test.increase();
                    
                }
            }).start();
        }
        
        //若当期依然有子线程没有执行完毕
        while(Thread.activeCount() > 1){
            Thread.yield();//使得当前线程（主线程）让出CPU时间片
        }
        
        System.out.println("number is " + number);
    }


}
