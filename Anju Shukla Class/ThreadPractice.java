public class ThreadPractice {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread even = new Thread(()->{
            synchronized(lock){
                for(int i=0;i<=10;i+=2){
                    System.out.println(i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                }
            }
        });
        Thread odd = new Thread(()->{
            synchronized(lock){
                for(int i=1;i<=10;i+=2){
                    System.out.println(i);
                    try{
                        Thread.sleep(25);
                    } catch(InterruptedException e){
                        e.getMessage();
                    }
                }
            }
            
        });
        even.start();
        odd.start();
    }
}
