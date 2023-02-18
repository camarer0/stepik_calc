import java.io.*;
import java.util.Scanner;

class Calculator {
    static public void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\perov\\IdeaProjects\\stepik_calc\\Calc\\src\\input.txt");
        Scanner sc = new Scanner(file);
        double a = 0.0;
        double b = 0.0;
        char znak = ' ';
        int m = 0;
        boolean is = true;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (String num : line.split(" ")) {
                m++;
                if (m == 1) {
                    try {
                        a = Double.parseDouble(num);
                    } catch (NumberFormatException e) {
                        System.out.print("Error! Not number\n");
                        is = false;
                        break;
                    }
                }
                if (m == 3) {
                    try {
                        b = Double.parseDouble(num);
                    } catch (NumberFormatException e) {
                        System.out.print("Error! Not number\n");
                        is = false;
                        break;
                    }
                }
            }
            if (is) {
                m = 0;
                for (String num : line.split(" ")) {
                    m++;
                    if (m == 2) {
                        try {
                            znak = result(num);
                        } catch (Exception s) {
                            System.out.print("Operation Error!");
                            is = false;
                            break;
                        }
                    }
                }
            }
            if (is) {
                double res = 0;
                switch (znak) {
                    case ('+'):
                        System.out.println(a + b);
                        res = a + b;
                        break;
                    case ('-'):
                        System.out.println(a - b);
                        res = a - b;
                        break;
                    case ('/'): {
                        if (b == 0.0) System.out.print("Error! Division by zero");
                        else {
                            System.out.println(a / b);
                            res = a / b;
                            break;
                        }
                    }
                    case ('*'):
                        System.out.println(a * b);
                        res = a * b;
                        break;
                }
                try (FileWriter writer = new FileWriter("C:\\Users\\perov\\IdeaProjects\\stepik_calc\\Calc\\src\\output.txt", true)) {
                    writer.write(line + " = " + res + "\n");
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
            }
        }
        sc.close();
    }
    public static char result(String nms) throws Exception {
        if(nms.equals("/") || nms.equals("*") || nms.equals("+") || nms.equals("-")) {
            return nms.charAt(0);
        }
        else throw new Exception("OperationError");
    }
}
