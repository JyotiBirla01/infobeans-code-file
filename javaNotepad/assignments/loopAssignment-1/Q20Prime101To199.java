// 20. WAP to print all prime number from 101 to 199 

public class Q20Prime101To199 {
    public static void main(String[] args) {
        int count = 0;
        System.out.println("Prime between 101 to 199: ");
        for (int i = 101; i <= 199; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    // System.out.println(i +" " +j);
                    count++;
                    break;
                }
            }
            if (count == 0)
                System.out.println(i);
            count = 0;
        }
    }
}