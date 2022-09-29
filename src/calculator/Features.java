package calculator;

// import utils java modules
import java.util.*;

/**
 * @see Features Class
 * @hidden: every failed input fields must be push at Stack errMessage and the
 *          user recently activity must be push at logs Stack
 * 
 * @summary: method UseInputOption listening of user input, then call
 *           the useFeatureOperation method fn. In useFeatureOperation method
 *           fn, using the switch to select one of many code blocks to be
 *           executed.
 * 
 */

public class Features {

    // declare members of Feature Class
    public static double total;
    public static String brainDump;
    public static Stack<String> logs = new Stack<>();
    public static Stack<String> errMessage = new Stack<>();

    public static void UseInputOption() {

        do {
            displayFeatures();
            Scanner userInput = new Scanner(System.in);

            String setInputMenu = userInput.nextLine();
            String regexInputMenu = "(?i)1|2|3|4|5|6";
            double[] arrDouble = new double[2];
            String[] operator = { "+", "/", "-", "*", "%" };

            if (setInputMenu.matches("0|Exit|exit|EXIT")) {
                System.out.println("Exit Program...");
                userInput.close();
                break;
            }

            if (setInputMenu.matches("clear|cls")) {
                clearConsole();
                continue;
            }

            if (setInputMenu.matches("6")) {
                clearConsole();
                logs.clear();
                total = 0;
                continue;
            }

            if (setInputMenu.matches(regexInputMenu)) {
                if (total == 0) {

                    System.out.println("Enter Two number: ");

                    for (int i = 0; i < 2; i++) {
                        System.out.print(">> ");

                        try {
                            double input = Double.parseDouble(userInput.nextLine());

                            arrDouble[i] = input;
                        } catch (NullPointerException err) {
                            // TODO: handle exception
                            errMessage.push("Input is required!");
                            errMessage.push("Please, input correctly!");

                            continue;

                        } catch (NumberFormatException err) {
                            errMessage.push("Input field is must be a number!");
                            errMessage.push("Please, input correctly!");

                            continue;
                        }

                    }
                    if (arrDouble[0] != 0 && arrDouble[1] != 0) {
                        clearConsole();
                        useFeatureOperation(setInputMenu, arrDouble);
                        brainDump = "" + arrDouble[0] + " " + operator[Integer.parseInt(setInputMenu) - 1] + " "
                                + arrDouble[1] + " = " + total;
                        logs.push(brainDump);

                    }

                    continue;
                }

                if (total > 0 || total < 0) {
                    System.out.print(">> " + total + " " + operator[Integer.parseInt(setInputMenu) - 1] + " ");
                    try {
                        double input = Double.parseDouble(userInput.nextLine());
                        System.out.print(input);
                        arrDouble[1] = input;
                    } catch (NullPointerException err) {
                        // TODO: handle exception

                        errMessage.push("Input is required!");
                        errMessage.push("Please, input correctly!");
                        clearConsole();

                        continue;

                    } catch (NumberFormatException err) {
                        errMessage.push("Input field is must be a number!");
                        errMessage.push("Please, input correctly!");
                        clearConsole();

                        continue;
                    }

                    if (arrDouble[1] != 0) {
                        arrDouble[0] = total;
                        System.out.println(arrDouble[1]);
                        clearConsole();
                        useFeatureOperation(setInputMenu, arrDouble);
                        brainDump = "" + arrDouble[0] + " " + operator[Integer.parseInt(setInputMenu) - 1] + " "
                                + arrDouble[1] + " = " + total;
                        logs.push(brainDump);
                    }
                    continue;

                }

                brainDump = "";
                clearConsole();
                continue;
            } else {
                // clearConsole();
                String error = "Invalid field, features menu not found!";
                errMessage.push(error);

                continue;
            }
        } while (true);
    }

    public static void useFeatureOperation(String choose, double[] arrayNum) {

        switch (choose) {
            case "1":
                total = Operation.useAdd(arrayNum);
                break;

            case "2":
                total = Operation.useDiv(arrayNum);
                break;

            case "3":
                total = Operation.useSubs(arrayNum);
                break;

            case "4":
                total = Operation.useMulti(arrayNum);
                break;

            case "5":
                total = Operation.useModulo(arrayNum);
                break;

            // carefully if the not catched the choose of 6 opt in menu
            case "6":
                total *= 0;
                break;

            default:
                break;
        }
    }

    public static void displayFeatures() {

        System.out.println();
        System.out.println("\n\t\t\t ");
        System.out.println("\n\t\t    - CALCULATOR APP -\n");
        System.out.println("\n\t Feautures Menu:\n");
        System.out.println("\t [1] Addition");
        System.out.println("\t [2] Division");
        System.out.println("\t [3] Substraction");
        System.out.println("\t [4] Multiplication");
        System.out.println("\t [5] Modulo");
        System.out.println("\t [6] Reset");
        System.out.println("\t [0] Exit");
        if (!logs.empty()) {
            System.out.println("\n\n\t Recent Activity : \n\t   [");
            for (String log : logs) {
                System.out.println("\t\t" + log + ",");
            }
            System.out.println("\t   ]");
        }
        System.out.println("\n\n\t Total    : " + total);
        System.out.println("\t ps       : type 'clear/cls' to clear console.");
        if (!errMessage.empty()) {
            System.out.println("\n\n");
            for (String err : errMessage) {
                System.out.println("ErrStack: " + err);
            }
            errMessage.clear();
        }
        System.out.print("\nSelect Features u wanna use!");
        System.out.print("\n>> ");

    }

    // method for clear of user console
    public static void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
