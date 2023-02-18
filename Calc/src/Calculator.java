import java.util.Scanner;

class Calculator {
    static public void main (String []args) {
        Scanner sc = new Scanner (System.in);
        String line = sc.nextLine();
        sc.close();
        double a = 0.0;
        double b = 0.0;
        char znak = ' ';
        int m=0;
        boolean is = true;
        for(String num:line.split(" ")) {
            m++;
            if(m==1) {
                try {
                    a = Double.parseDouble(num);
                }catch(NumberFormatException e) {
                    System.out.print("Error! Not number\n");
                    is = false;
                    break;
                }
            }
            if(m==3) {
                try {
                    b = Double.parseDouble(num);
                }catch(NumberFormatException e) {
                    System.out.print("Error! Not number\n");
                    is = false;
                    break;
                }
            }
        }
        if(is) {
            m=0;
            for(String num:line.split(" ")) {
                m++;
                if(m==2) {
                    try {
                        znak = result(num);
                    }catch(Exception s){
                        System.out.print("Operation Error!");
                        is=false;
                        break;
                    }
                }
            }
        }
        if(is) {
            switch (znak) {
                case ('+') -> System.out.print(a + b);
                case ('-') -> System.out.print(a - b);
                case ('/') -> {
                    if (b == 0.0) System.out.print("Error! Division by zero");
                    else System.out.print(a / b);
                }
                case ('*') -> System.out.print(a * b);
            }
        }
    }
    public static char result(String nms) throws Exception {
        if(nms.equals("/") || nms.equals("*") || nms.equals("+") || nms.equals("-")) {
            return nms.charAt(0);
        }
        else throw new Exception("OperationError");
    }
}
