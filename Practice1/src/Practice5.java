import java.util.ArrayList;

public class Practice5 {

    public static void main (String[] args) {

    }

    public static boolean sameLetterPattern(String a, String b) {
        int x = b.charAt(0) - a.charAt(0);
        for (int i = 1; i < a.length(); i++) {
            if ((b.charAt(i) - a.charAt(i)) != x) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder SpiderVsFly (String a, String b) {
        int ax = a.charAt(0) - 'A';
        int ay = a.charAt(1) - '0';
        int bx = b.charAt(0) - 'A';
        int by = b.charAt(1) - '0';

        StringBuilder ans = new StringBuilder();
        do {
            ans.append(Character.toString(ax + 'A'));
            ans.append(Character.toString(ay + '0'));
            if (ax == bx && ay == by) {
                break;
            }
            if (ay == 0) {
                ay = 1;
                ax = bx;
            }
            else if (ax == bx || ay == by) {
                if (ax == bx) {
                    if (ay < by) ay++;
                    else ay--;
                }
                else {
                    if (ax < bx) ax++;
                    else ax--;
                }
            }
            else if (ay < by) {
                if (ax < bx) ax++;
                else ax--;
            }
            else {
                ay--;
            }
        } while (true);

        return ans;
    }

    public static int digitsCount (int n) {
        if (n < 10) {
            return 1;
        }
        else {
            return 1 + digitsCount(n/10);
        }
    }

    
}
