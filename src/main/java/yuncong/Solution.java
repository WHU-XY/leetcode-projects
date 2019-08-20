package yuncong;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int target = sc.nextInt();
        sc.nextLine();
        String[] datas = sc.nextLine().split(",");
        sc.close();
        printNum pn = new printNum(start, target,1);
        for (int i = 0; i < datas.length; i++){
            Thread t = new Thread(new printThreadnew(pn,i+1,datas.length),"Thread"+datas[i]);
            t.start();
        }
        datas[0].hashCode();
    }
    public static class printThread implements Runnable{

        int threadNum;
        int threadSize;
        printNum pn;

        public printThread(printNum pn, int threadNum, int threadSize){
            this.pn = pn;
            this.threadNum = threadNum;
            this.threadSize = threadSize;
        }

        @Override
        public void run() {
            while (pn.threadNum != 0){
                if (pn.threadNum == threadNum){
                    synchronized (pn) {
                        for (int i = 0; i < 5; i++){
                            if (pn.start > pn.target){
                                pn.threadNum = 0;
                                break;
                            }
                            System.out.println(Thread.currentThread().getName()+": "+ pn.start);
                            pn.start++;
                        }
                        if(pn.threadNum != 0){
                            if (pn.threadNum == threadSize){
                                pn.threadNum = 1;
                            }else {
                                pn.threadNum++;
                            }
                        }
                    }
                }
            }

        }
    }

    public static class printNum{
        int threadNum; //等于0时线程全部结束,取值范围1-最大值，代表应该执行线程
        int start;
        int target;

        public printNum(int start, int target, int threadNum){
            this.start = start;
            this.target = target;
            this.threadNum = threadNum;
        }
    }

    public static class printThreadnew implements Runnable{

        int threadNum;
        int threadSize;
        printNum pn;

        public printThreadnew(printNum pn, int threadNum, int threadSize){
            this.pn = pn;
            this.threadNum = threadNum;
            this.threadSize = threadSize;
        }

        @Override
        public void run() {
            synchronized (pn){
                while (pn.threadNum != 0){
                    if (pn.threadNum == threadNum){
                        for (int i = 0; i < 5; i++){
                            if (pn.start > pn.target)
                            {
                                pn.threadNum = 0;
                                pn.notifyAll();
                                return;
                                //break;
                            }
                            System.out.println(Thread.currentThread().getName()+": "+pn.start++);
                        }
                        if (pn.threadNum != 0){
                            pn.threadNum++;
                            if (pn.threadNum > threadSize)
                                pn.threadNum = 1;
                            pn.notifyAll();
                        }
                    }else {
                        try {
                            pn.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }
}
