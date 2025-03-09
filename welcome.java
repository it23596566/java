import java.util.Scanner;
class welcome{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String fname = scan.nextLine();
        System.out.print("Enter your last Name: ");
        String lname = scan.nextLine();
        System.out.print("Welocme to the Second Year "+fname +lname);
    }
}
