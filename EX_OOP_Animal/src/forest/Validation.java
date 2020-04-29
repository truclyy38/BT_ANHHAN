package forest;

import java.util.Scanner;

public class Validation
{

    public static final Scanner in = new Scanner(System.in);
    
    public static int checkinputintLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + "," + max + "]");
                System.out.println("Enter again");
            }
        }
    }
    
    public static String checkInputString() {
        String result;
        while (true) {

            result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("EMPTY");
                System.out.println("AGAIN");
            } else {
                return result;
            }
        }
    }
    
    public  static int checkInputInt() 
    {
        int result;
        while (true) 
        {
            result = in.nextInt();
            in.nextLine();
            if (result < 0) {
                System.out.println("WRONG!!!!!");
                System.out.println("AGAIN");
            } else return result;
        }
    }

}
