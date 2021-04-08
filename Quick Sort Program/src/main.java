import java.util.*;

public class main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            method method = new method();
            System.out.println("How many integers will you enter, must be 10 or less: ");
            int arrayLength = scanner.nextInt();
            while (arrayLength < 0 || arrayLength > 10) {
                System.out.println("0 is the min and 10 is the max, try again!");
                arrayLength = scanner.nextInt();
            }
            int[] array = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                System.out.println("Enter an integer: ");
                int value = scanner.nextInt();
                array[i] = value;
            }
            while (true) {
                System.out.println("\n\nEnter 1 to quick sort \nEnter 2 to add values. \nEnter 0 to stop program.");
                int user = scanner.nextInt();
                if (user == 0) {
                    System.out.println("Thank you");
                    System.exit(0);
                }
                if (user == 1) {
                    System.out.println("\nPrevious array: ");
                    for (int i = 0; i < array.length; i++) System.out.print(array[i] + ", ");
                    method.quickSort(array, 0, arrayLength - 1);
                    method.print();
                } else if (user == 2) {
                    System.out.println("How many integers will you add?");
                    int newArrayLength = scanner.nextInt();
                    while ((arrayLength + newArrayLength) < 0 || (arrayLength + newArrayLength) > 10) {
                        System.out.println("You can only add " + (10 - arrayLength) + " more! Try again! \nIf you can only enter 0 more, enter 0!");
                        newArrayLength = scanner.nextInt();
                    }
                    int[] temp = new int[newArrayLength];
                    for (int i = 0; i < newArrayLength; i++) {
                        System.out.println("Enter an integer: ");
                        int value = scanner.nextInt();
                        temp[i] = value;
                    }
                    int[] newArray = new int[arrayLength + newArrayLength];
                    System.arraycopy(array, 0, newArray, 0, arrayLength);
                    System.arraycopy(temp, 0, newArray, arrayLength, newArrayLength);
                    array = new int[newArray.length];
                    array = newArray;
                    arrayLength = array.length;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("YOU CAN ONLY ENTER INTEGERS!!!! \nSYSTEM IS EXITING!!!");
            System.exit(0);
        } catch (NullPointerException e){
            System.out.println("ENTER MORE THAN 0 INTEGERS TO SORT!!! \nSYSTEM IS EXITING!!!");
            System.exit(0);
        }
    }
}

