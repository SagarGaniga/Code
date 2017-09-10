import java.util.Scanner;

class nextLinePriblem
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();   
        String ss = sc.nextLine();

        // Write your code here.
        double d = sc.nextDouble(); 
        ss = sc.nextLine();
        String s = sc.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
