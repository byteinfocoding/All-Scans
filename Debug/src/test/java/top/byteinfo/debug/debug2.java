package top.byteinfo.debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class debug2 {


    public static void main(String[] args) {
//  条件断点
//       conditions();

// debug 打印 log（“Breakpoint hit ” message ）（Stack trace）
//       printStackTrace();

//表达式解析   evaluate  {获得 方法返回值，变量值}
//        evaluate();

// debug时，避开某些操作 | force return
//        saveResource();

//     idea debug 常用按钮
//         keyExplain();

//
        streamDebug();



    }
    static void streamDebug(){

    }

    static void keyExplain(){
        System.out.println("");
    }

    static void saveResource(){
        System.out.println("some bad things happens");

        System.out.println(" save to db");
        System.out.println(" save to redis");
        System.out.println(" etc....");
    }
    static void evaluate() {
        System.out.println("evaluate");
        OperationLog operationLog = OperationLog.builder()
                .id(1).ipAddress("192.168").build();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
    }

    static void printStackTrace() {
        OperationLog operationLog = OperationLog.builder()
                .id(1).ipAddress("192").build();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(111);
        list.add(1111);
        System.out.println(list);
    }

    static void conditions() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread, "th1");
        Thread t2 = new Thread(myThread, "th2");
        Thread t3 = new Thread(myThread, "th3");
        Thread t4 = new Thread(myThread, "th4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-- in");

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "-- out");
            }
        }
    }
}
