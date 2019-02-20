package com.yay.concurrent;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/1 19:53
 */
public class ConditionTest2 {

    private static BoundedBuffer bb = new BoundedBuffer();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new PutThread("p" + i, i).start();
            new TakeThread("t" + i).start();
        }

    }

    static class PutThread extends Thread {
        private int num;

        public PutThread(String name, int num) {
            super(name);
            this.num = num;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1);
                bb.put(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class TakeThread extends Thread {
        public TakeThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(10);
                Object take = bb.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
