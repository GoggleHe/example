package org.example.concurrent.executor;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(50));
        executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        try {
            Integer integer = future.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Data data = new Data();
        Future<Data> integerFuture = executor.submit(new MyTask(data), data);
        try {
            System.out.println("data=" + data);
            Data get = integerFuture.get();
            System.out.println("get=" + get);
            System.out.println("data=" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    static class Data {
        private Integer age;
        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    static class MyTask implements Runnable {
        private final Data data;

        public MyTask(Data data) {
            this.data = data;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.setAge(10000);
            data.setName("hello");
        }
    }

}
