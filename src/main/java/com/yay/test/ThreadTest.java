package com.yay.test;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2019/5/17 18:15
 */
public class ThreadTest implements Runnable {

    static int c = 0;

    private A a;

    public ThreadTest(A a) {
        this.a = a;
    }

    @Override
    public void run() {

        c = 1;
        a.b = "cc";
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        a.b = "b";
        Thread t1 = new Thread(new B(a));
        Thread t2 = new Thread(new ThreadTest(a));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("last, a.b:" + a.b + ", c:" + c);

    }


    static class A {

        private String b;

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }


    static class B implements Runnable {

        private A a;

        public B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                System.out.println(a.b);
                System.out.println(c);
                if (i > 3) {
                    break;
                }
                if ("cc".equals(a.b)) {
                    i ++;
                }
            }
        }
    }

}
