package eg.edu.alexu.csd.datastructure.LinkedLists.cs18011305_18011304;

import java.util.Scanner;

public class UIApplication {
    public static void printingArray (int [][] array) {
        StringBuilder builder = new StringBuilder();
        builder.append("Result set in R:");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                builder.append(",");
            }
            builder.append(" (" ).append(array[i][0]).append(", ").append(array[i][1]).append(")");
        }
        System.out.println(builder.toString());
    }
    public static void main(String[] args) {
        char poly;
        char poly2;
        PolynomialSolver solver = new PolynomialSolver();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose an action\n" +
                    "-----------------------\n" +
                    "1- Set a polynomial variable\n" +
                    "2- Print the value of a polynomial variable\n" +
                    "3- Add two polynomials\n" +
                    "4- Subtract two polynomials\n" +
                    "5- Multiply two polynomials\n" +
                    "6- Evaluate a polynomial at some point\n" +
                    "7- Clear a polynomial variable\n" +
                    "==============================================");
            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Insert the variable name: A, B or C");
                    String s = in.nextLine();
                    poly = s.charAt(0);
                    while(poly != 'A' && poly != 'B' && poly != 'C') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert the variable name: A, B or C");
                        poly = in.nextLine().charAt(0);
                    }
                    System.out.println("Insert the polynomial terms in the form:\n" +
                            "(coeff1, exponent1), (coeff2, exponent2), ..");
                    String temp = in.nextLine();
                    temp = temp.replace("(", "");
                    temp = temp.replace(")", "");
                    temp = temp.replace(",", "");
                    String[] nums = temp.split(" ");
                    int[][] terms = new int[nums.length / 2][2];
                    for (int i = 0; i < terms.length; i++) {
                        terms[i][0] = Integer.parseInt(nums[2 * i]);
                        terms[i][1] = Integer.parseInt(nums[(2 * i) + 1]);
                    }
                    solver.setPolynomial(poly, terms);
                    break;
                case 2:
                    System.out.println("Insert the variable name: A, B, C or R");
                    s = in.nextLine();
                    poly = s.charAt(0);
                    while (solver.getList(poly).isEmpty()) {
                        System.out.println("Variable isnot set");
                        System.out.println("Insert the variable name: A, B, C or R");
                        poly = in.nextLine().charAt(0);
                    }
                    while(poly != 'A' && poly != 'B' && poly != 'C' && poly != 'R') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert the variable name: A, B, C, or R");
                        poly = in.nextLine().charAt(0);
                    }
                    System.out.println(solver.print(poly));
                    break;
                case 3:
                    System.out.println("Insert first operand variable name: A, B or C\n");
                    s = in.nextLine();
                    poly = s.charAt(0);
                    while(poly != 'A' && poly != 'B' && poly != 'C') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert first operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly = s.charAt(0);
                    }
                    while (solver.getList(poly).isEmpty()) {
                        System.out.println("Variable isnot set");
                        System.out.println("Insert first operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly = s.charAt(0);
                    }
                    System.out.println("Insert second operand variable name: A, B or C\n");
                    poly2 = in.nextLine().charAt(0);
                    while(poly2 != 'A' && poly2 != 'B' && poly2 != 'C') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert second operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly2 = s.charAt(0);
                    }
                    while (solver.getList(poly2).isEmpty()) {
                        System.out.println("Variable isnot set");
                        System.out.println("Insert second operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly2 = s.charAt(0);
                    }
                    printingArray(solver.add(poly, poly2));
                    break;
                case 4:
                    System.out.println("Insert first operand variable name: A, B or C\n");
                    s = in.nextLine();
                    poly = s.charAt(0);
                    while(poly != 'A' && poly != 'B' && poly != 'C') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert first operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly = s.charAt(0);
                    }
                    while (solver.getList(poly).isEmpty()) {
                        System.out.println("Variable isnot set");
                        System.out.println("Insert first operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly = s.charAt(0);
                    }
                    System.out.println("Insert second operand variable name: A, B or C\n");
                    poly2 = in.nextLine().charAt(0);
                    while(poly2 != 'A' && poly2 != 'B' && poly2 != 'C') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert second operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly2 = s.charAt(0);
                    }
                    while (solver.getList(poly2).isEmpty()) {
                        System.out.println("Variable isnot set");
                        System.out.println("Insert second operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly2 = s.charAt(0);
                    }
                    printingArray(solver.subtract(poly, poly2));
                    break;
                case 5:
                    System.out.println("Insert first operand variable name: A, B or C\n");
                    s = in.nextLine();
                    poly = s.charAt(0);
                    while(poly != 'A' && poly != 'B' && poly != 'C') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert first operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly = s.charAt(0);
                    }
                    while (solver.getList(poly).isEmpty()) {
                        System.out.println("Variable isnot set");
                        System.out.println("Insert first operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly = s.charAt(0);
                    }
                    System.out.println("Insert second operand variable name: A, B or C\n");
                    poly2 = in.nextLine().charAt(0);
                    while(poly2 != 'A' && poly2 != 'B' && poly2 != 'C') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert second operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly2 = s.charAt(0);
                    }
                    while (solver.getList(poly2).isEmpty()) {
                        System.out.println("Variable isnot set");
                        System.out.println("Insert second operand variable name: A, B or C\n");
                        s = in.nextLine();
                        poly2 = s.charAt(0);
                    }
                    printingArray(solver.multiply(poly, poly2));
                    break;
                case 6:
                    System.out.println("Insert the variable name: A, B, C or R");
                    s = in.nextLine();
                    poly = s.charAt(0);
                    while(poly != 'A' && poly != 'B' && poly != 'C' && poly != 'R') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert the variable name: A, B, C or R");
                        poly = in.nextLine().charAt(0);
                    }
                    while (solver.getList(poly).isEmpty()) {
                        System.out.println("Variable isnot set");
                        System.out.println("Insert the variable name: A, B, C or R");
                        poly = in.nextLine().charAt(0);
                    }
                    System.out.println("Please enter the value of X");
                    float value = Float.parseFloat(in.nextLine());
                    System.out.println("The result is: " + (solver.evaluatePolynomial(poly, value)));
                    break;
                case 7:
                    System.out.println("Insert the variable name: A, B, C or R");
                    s = in.nextLine();
                    poly = s.charAt(0);
                    while(poly != 'A' && poly != 'B' && poly != 'C' && poly != 'R') {
                        System.out.println("Wrong Choice");
                        System.out.println("Insert the variable name: A, B or C");
                        poly = in.nextLine().charAt(0);
                    }
                    solver.clearPolynomial(poly);
                    System.out.println("The variable " + poly + " is cleared");
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
}
