package com.example.demo.rxjava;

import io.reactivex.rxjava3.core.Observable;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


public class RxJavaTest {
    @Test
    public void testRxJavaSimple() {
        Observable.just(1, 2, 3, 4, 5)
                  .forEach(i -> System.out.println("i : " + i));
    }

    @Test
    public void testMap() throws InterruptedException {
        Observable.interval(500, TimeUnit.MILLISECONDS)
                  .map(e -> e * e)
                  .subscribe(e -> System.out.println("Received: " + e));
        Thread.sleep(5000);
    }

    @Test
    public void testFilter() throws InterruptedException {
        Observable.interval(500, TimeUnit.MILLISECONDS)
                  .filter(e -> e % 2 == 0)
                  .subscribe(e -> System.out.println("Received: " + e));
        Thread.sleep(5000);
    }

    @Test
    public void testCount() throws InterruptedException {
        Observable.interval(500, TimeUnit.MILLISECONDS)
                  .count()
                  .subscribe(e -> System.out.println("Received: " + e));
        Thread.sleep(5000);
    }

    @Test
    public void testZip() {
        Observable.zip(
                Observable.just("A", "B", "C", "D", "E"),
                Observable.just(6, 7, 8, 9, 10),
                (x, y) -> x + y
        ).forEach(System.out::println);
    }
}
