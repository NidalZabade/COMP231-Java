import java.util.*;

class Test {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            enterIdAndName();
            menuDisplay();
        }

    }

    public static void enterIdAndName() {
        System.out.println("Enter user name");
        String name = sc.next();
        int id;
        while (true) {
            System.out.println("Enter balanced id");
            String input = sc.next();
            if (isInteger(input)) {
                id = Integer.parseInt(input);
            } else {
                System.out.println("The id should be an integer only, try again");
                continue;
            }
            if (id == -1) {
                System.exit(0);
            } else if (CheckEquation.isBalanced(id)) {
                System.out.println("User name: " + name + "\nUser Id: " + id);
                break;
            }
            System.out.println("The id you entered is not a balanced id, try again");

        }
    }

    public static void menuDisplay() {
        while (true) {
            System.out.println(
                    "\n1- Solve a quadratic equation given x\n2- Find the roots for the equation if they exist\n3- combine two quadratic equations\n4- Exit menu");
            System.out.println("Enter command");
            String command = sc.next();
            if (command.equals("4"))
                break;
            else
                menu(command);
        }
    }

    public static void menu(String command) {
        switch (command) {
            case "1":
                double[] coefficients = enterCoefficients();
                System.out.println("Enter value for x to solve the equation ");
                double x;
                x = enterX();
                System.out.println(
                        ("The result for the equation " + coefficients[0] + "x^2 + " + coefficients[1] + "x + "
                                + coefficients[2] + " = 0 when x = " + x
                                + " is: "
                                + CheckEquation.solveEquation(coefficients[0], coefficients[1], coefficients[2], x))
                                .trim());
                break;

            case "2":
                double[] coefficients2 = enterCoefficients();
                double[] roots;
                if (CheckEquation.isValidQuadraticEquation(coefficients2[0], coefficients2[1], coefficients2[2])) {
                    roots = CheckEquation.findEquationRoots(coefficients2[0], coefficients2[1], coefficients2[2]);
                    System.out
                            .println("The roots for the equation " + coefficients2[0] + "x^2  +  " + coefficients2[1]
                                    + "x  +  "
                                    + coefficients2[2] + "  =  0:\nx1=  " + roots[0]
                                    + "   and    x2=  " + roots[1]);

                } else {
                    System.out.println("Your equation has no real roots");

                }
                break;

            case "3":
                System.out.println("For the first equation:-");
                double[] firstCoefficients = enterCoefficients();
                System.out.println("For the second equation:-");
                double[] secondCoefficients = enterCoefficients();
                double[] combinedCoefficients = CheckEquation.combineEquations(firstCoefficients, secondCoefficients);
                System.out
                        .println("The combined equation from the first equation:  " + firstCoefficients[0] + "x^2  +  "
                                + firstCoefficients[1] + "x  +  " + firstCoefficients[2] + "  =  0");
                System.out.println("and the second equation:  " + secondCoefficients[0] + "x^2  +  "
                        + secondCoefficients[1] + "x  +  " + secondCoefficients[2] + "  =  0\nis:-");
                System.out.println("The combined equation:  " + combinedCoefficients[0] + "x^2  +  "
                        + combinedCoefficients[1] + "x  +  " + combinedCoefficients[2] + "  =  0");
                break;
            case "4":
                break;
            default:
                System.out.println("invalid input try again");

        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static double[] enterCoefficients() {
        double[] coefficients = new double[3];
        System.out.println("Enter The quadratic equation coefficients (a,b,c)");
        while (true) {
            System.out.println("Enter The first coefficient (a)");
            String firstCoefficient = sc.next();
            if (isNumber(firstCoefficient)) {
                coefficients[0] = Double.parseDouble(firstCoefficient);
                break;
            } else {
                System.out.println("The coefficients should be a number only, try again");
            }
        }

        while (true) {
            System.out.println("Enter The second coefficient (b)");
            String secondCoefficient = sc.next();
            if (isNumber(secondCoefficient)) {
                coefficients[1] = Double.parseDouble(secondCoefficient);
                break;
            } else {
                System.out.println("The coefficients should be a number only, try again");
            }
        }
        while (true) {
            System.out.println("Enter The third coefficient (c)");
            String thirdCoefficient = sc.next();
            if (isNumber(thirdCoefficient)) {
                coefficients[2] = Double.parseDouble(thirdCoefficient);
                break;
            } else {
                System.out.println("The coefficients should be a number only, try again");
            }
        }
        return coefficients;
    }

    public static double enterX() {
        while (true) {
            String x = sc.next();
            if (isNumber(x)) {
                return Double.parseDouble(x);
            } else {
                System.out.println("value of x should be a number only, try again");
            }
        }
    }
}

class CheckEquation {
    public static boolean isBalanced(int id) {
        int idLength = (int) (Math.log(id) + 1);
        int EvenDigitsSum = 0, OddDigitsSum = 0;
        int num = id;
        for (int i = 0; i < idLength; i++) {
            if (num % 10 == num / 10 % 10 && num != 0)
                return false;
            if (num != 0)
                num = num / 10;
            else
                break;
        }
        for (int i = 0; i < idLength; i++) {
            int mod = id % 10;
            id = id / 10;
            if (mod % 2 == 0) {
                EvenDigitsSum += mod;
            } else {
                OddDigitsSum += mod;
            }
        }
        return EvenDigitsSum == OddDigitsSum;
    }

    public static double solveEquation(double a, double b, double c, double x) {
        return (a * Math.pow(x, 2)) + (b * x) + (c);
    }

    public static boolean isValidQuadraticEquation(double a, double b, double c) {
        double root;
        root = Math.pow(b, 2) - (4 * a * c);
        return root >= 0;
    }

    public static double[] findEquationRoots(double a, double b, double c) {
        double[] roots = new double[2];
        double sq = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
        roots[0] = ((-b) - sq) / (2 * a);
        roots[1] = ((-b) + sq) / (2 * a);

        return roots;
    }

    public static double[] combineEquations(double[] firstCoefficients, double[] secondCoefficients) {
        double[] combinedCoefficients = new double[3];
        for (int i = 0; i < firstCoefficients.length; i++) {
            combinedCoefficients[i] = firstCoefficients[i] + secondCoefficients[i];
        }
        return combinedCoefficients;
    }

}
