package btvnbuoi10;

public class ThreadCaculator extends java.lang.Thread {
    private String name;
    private int start;
    private int end;
    private int sum;

    public ThreadCaculator(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void run() {
        System.out.println(name + " started");
        sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println("Tổng từ " + start + " đến " + end + " bằng " + sum);
        System.out.println(name + " finished");
    }
}
