// Nikita Dmitriev - Homework 9 - Threads

public class HW9 {
    public static void  main(String[] args){
        char[] arr1 = new char[]{'A', 'E', 'I', 'M', 'Q', 'U', 'Y'};
        char[] arr2 = new char[]{'B', 'F', 'J', 'N', 'R', 'V', 'Z'};
        char[] arr3 = new char[]{'C', 'G', 'K', 'O', 'S', 'W'};
        char[] arr4 = new char[]{'D', 'H', 'L', 'P', 'T', 'X'};

        myThread t1 = new myThread(arr1);
        myThread t2 = new myThread(arr2);
        myThread t3 = new myThread(arr3);
        myThread t4 = new myThread(arr4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class myThread extends Thread{
    private static int total = 0;    // Keep track of total # of threads, no need to specify
    private static int turn = 1;         // Keep track which thread has a turn
    private int id;
    private char[] chars;

    // Default case
    myThread(char[] chars){
        total++;        // Now have 1 more thread
        id = total;     // it should keep id consistent, not unique
        this.chars = chars;
    }
    // If you want to specify starting thread
    myThread(char[] chars, int startFrom){
        total++;
        id = total;
        turn = startFrom;
        this.chars = chars;
    }

    public void run(){
        printArr(chars);
        total--;        // one less thread in system, thread is done with job
    }


    private synchronized void printArr(char[] chars) {
        try {
            // start traversing your array
            for (char c : chars) {
                // wait for your turn
                while (turn != id) {
                    // this, if not set to timeout, will cause deadlock, can't understand why.
                    wait(1);
                }
                System.out.println(c);
                // when turn is at maximum, or more if previous thread is now dead
                if (turn >= total) {
                    turn = 1;
                } else {
                    turn++;
                }
                // Reveille
                notifyAll();
            }
        } catch (Throwable i){}
    }
}
