import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private int count = 0;

    // synchronized 키워드를 사용하여 동기화된 메서드
    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // 여러 스레드에서 동시에 increment() 메서드 호출
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        // 여러 스레드 생성
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        // 스레드 실행
        thread1.start();
        thread2.start();

        try {
            // 스레드 실행이 완료될 때까지 대기
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 최종 결과 출력
        System.out.println("Count: " + counter.getCount());
    }
}
