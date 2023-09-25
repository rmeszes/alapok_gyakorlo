import java.util.Scanner;
import java.util.Objects;

public class StackCalculator {
    double[] verem;
    int level;

    public StackCalculator() {
        verem = new double[100];
        level = 0;
    }

    private boolean isNumeric(String s) {
        if(s == null) return false;
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            return s.charAt(0) == '-';
        }
        return true;
    }

    private void addToStack(double i) {
        verem[level++] = i;
    }

    private void executeTask(String s) throws RuntimeException {
        switch(s) {
            case "add":
                if(level < 2) System.out.println("Nincs elég szám a stacken! (nem történt semmi)");
                else {
                    verem[level] = verem[level - 1] + verem[level - 2];
                    level++;
                }
                break;
            case "sub":
                if(level < 2) System.out.println("Nincs elég szám a stacken! (nem történt semmi)");
                else {
                    verem[level] = verem[level - 1] - verem[level - 2];
                    level++;
                }
                break;
            case "mult":
                if(level < 2) System.out.println("Nincs elég szám a stacken! (nem történt semmi)");
                else {
                    verem[level] = verem[level - 1] * verem[level - 2];
                    level++;
                }
                break;
            case "div":
                if(level < 2) System.out.println("Nincs elég szám a stacken! (nem történt semmi)");
                else {
                    verem[level] = verem[level - 1] / verem[level - 2];
                    level++;
                }
                break;
            case "top":
                if(level == 0) System.out.println("A verem üres.");
                else System.out.println(verem[level-1]);
                break;
            case "pop":
                if(level == 0) System.out.println("A verem üres.");
                else {
                    verem[level-1] = 0;
                    level--;
                }
                break;
            case "dup":
                if(level == 0) System.out.println("A verem üres.");
                else verem[level-1] = verem[level-1] * 2;
                break;
            case "list":
                for(int i = level-1; i >= 0; i--) {
                    System.out.println(verem[i]);
                }
                break;
            default:
                System.out.println("Érvénytelen feladat");
        }

    }

    public void readln(String in) {
        String result = "";
        if(isNumeric(in)) {
            addToStack(Double.parseDouble(in));
        }
        else {
            executeTask(in);
        }
    }

    public static void main(String[] args) {
        System.out.println("Stack calculator:");
        StackCalculator c = new StackCalculator();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String in = scanner.nextLine();
            if(Objects.equals(in, "exit")) break;
            c.readln(in);
        }
        scanner.close();
    }
}
