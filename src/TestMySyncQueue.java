import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TestMySyncQueue {

    public static void main(String[] args) {
        MySyncQueue<Integer> integerMySyncQueue = new MySyncQueue<Integer>(new AtomicInteger(10));

//        new Thread(() -> {
//            for (int i = 0; i < 20; i++) {
//                try {
//                    integerMySyncQueue.put(i);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        Thread thread = new Thread(() -> {
            for (; ; ) {
                try {
                    System.out.println(integerMySyncQueue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String trim = scanner.nextLine().trim();
            if(trim.equals("exit")){
                thread.interrupt();
                return;
            }
            Integer integer = Integer.valueOf(trim);
            try {
                integerMySyncQueue.put(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
