import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        int[] n1 = {44, 32, 86, 19};
        int[] n2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(n1));
        System.out.println(differenceEvenOdd(n2));

        int[] n3 = {1, 2, 3, 4, 5};
        int[] n4 = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(n3));
        System.out.println(equalToAvg(n4));

        int[] n5 = {1, 2, 3};
        int[] n6 = {3, 3, -2, 408, 3, 31};
        printArray(indexMult(n5));
        printArray(indexMult(n6));

        System.out.println(reverse("Hello world"));
        System.out.println(reverse("The quick brown box"));

        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println(botHelper("Hello, I`m under the water, he help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));

         */

        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println();

        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println();

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));
        System.out.println();

        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println();

        int[] first5 = {1, -3, 2};
        System.out.println(countRoots(first5));
        int[] second5 = {2, 5, 2};
        System.out.println(countRoots(second5));
        int[] third5 = {1, -6, 9};
        System.out.println(countRoots(third5));
        System.out.println();

        String [][] first6 = {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"}, {"Pear", "Shop2", "Shop4"}};
        salesData(first6);
        String  [][] second6 = {{"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"}, {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}};
        //System.out.println(Arrays.toString(salesData(second6)));
        System.out.println(salesData(first6));
        System.out.println(salesData(second6));
        System.out.println();

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println();

        int[] first8 = {3, 1, 4, 2, 7, 5};
        System.out.println(waveForm(first8));
        int[] second8 = {1, 2, 3, 4, 5};
        System.out.println(waveForm(second8));
        int [] third8 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(third8));
        System.out.println();

        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words"));
        System.out.println();

        int [][] first10 = {{1, 2, 3, 4, 5}, {6, 7, 8, 29, 10}, {
                5, 5, 5, 5, 35}, {7, 4, 3, 14, 2}, {1, 0, 11, 10, 1}};
        System.out.println(Arrays.deepToString(dataScience(first10)));
        int [][] second10 = {{6, 4, 19, 0, 0}, {81, 25, 3, 1, 17}, {
                48, 12, 60, 32, 14}, {91, 47, 16, 65, 217}, {5, 73, 0, 4, 21}};
        System.out.println(Arrays.deepToString(dataScience(second10)));

        String[][] A =  {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}};
        salesData(A);
    }

    public static void printArray (int[] Array) {
        for (int a : Array) {
            System.out.print(a);
            System.out.print(' ');
        }
    }

    public static boolean duplicateChars (String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                return true;
            }
            map.put(c, 1);
        }
        return false;
    }

    public static String getInitials (String s) {

        String initials = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('A' <= c && c <= 'Z') {
                initials += c;
            }
        }
        return initials;
    }

    public static int differenceEvenOdd(int[] Array) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < Array.length; i++) {
            if (i % 2 == 0) {
                even += Array[i];
            }
            else {
                odd += Array[i];
            }
        }
        return Math.abs(even - odd);
    }

    public static boolean equalToAvg (int[] Array) {
        int avg = 0;
        for (int a : Array) {
            avg += a;
        }
        avg = avg / Array.length;
        for (int a : Array) {
            if (a == avg) {
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] Array) {

        int[] NArray = new int[Array.length];
        for (int i = 0; i < Array.length; i++) {
            NArray[i] = i * Array[i];
        }
        return NArray;
    }

    public static String reverse (String s) {

        String result = "";
        for(int i = s.length()-1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static int Tribonacci (int n) {

        int size = Math.max(3, n+1);
        int[] tBonac = new int[size];

        tBonac[0] = 0;
        tBonac[1] = 0;
        tBonac[2] = 1;

        for (int i = 3; i < size; i++) {
            tBonac[i] = tBonac[i-1] + tBonac[i-2] + tBonac[i-3];
        }
        return tBonac[n-1];
    }

    public static String pseudoHash (int n) {

        String result = "";
        for (int i = 0; i < n; i++) {
            long randomE = Math.round(Math.random());
            if (randomE == 0) {
                long randomInt = Math.round(Math.random() * 9);
                char c = (char) (randomInt + '0');
                result += c;
            }
            else {
                long randomChar = Math.round(Math.random() * 25);
                char c = (char) (randomChar + 'a');
                result += c;
            }
        }
        return result;
    }

    public static String botHelper (String s) {

        s = s.toLowerCase();

        String a = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (a.equals("help")) {
                    return "Calling for a stuff member";
                }
                a = "";
            }
            else {
                a += c;
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram (String a, String b) {

        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public static String replaceVovels (String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char cl = Character.toLowerCase(c);
            if (cl == 'a' || cl == 'e' || cl == 'i' || cl == 'u' || cl == 'o' || cl == 'y') {
                result = result + '*';
            }
            else {
                result = result + c;
            }
        }
        return result;
    }

    public static String stringTransform (String s) {
        String result = "";
        for (int i = 0; i < s.length();) {
            if ((i != s.length() - 1) && (s.charAt(i) == s.charAt(i+1))) {
                result = result + "Double" + Character.toUpperCase(s.charAt(i));
                i += 2;
            }
            else {
                result = result + s.charAt(i);
                i += 1;
            }
        }
        return result;
    }

    public static boolean doesBlockFit (int a, int b, int c, int w, int h) {
        int[] A = {a, b, c};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && A[i] <= w && A[j] <= h) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean numCheck (int n) {
        int sumOfSquarDigits = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int x = c - '0';
            sumOfSquarDigits += x * x;
        }
        return (sumOfSquarDigits % 2) == (n % 2);
    }

    public static int countRoots (int[] A) {
        int D = A[1] * A[1] - 4 * A[0] * A[2];
        if (D < 0) {
            return 0;
        }
        else if (D == 0) {
            return ((A[1] % (2 * A[0])) == 0) ? 1 : 0;
        }
        else {
            int sqD = (int) Math.sqrt((double)D);
            if (sqD * sqD != D) {
                return 0;
            }
            else {
                int ans = 0;
                if (Math.abs(-A[1] + sqD) % (2*A[0]) == 0) {
                    ans += 1;
                }
                if (Math.abs(-A[1] - sqD) % (2*A[0]) == 0) {
                    ans += 1;
                }
                return ans;
            }
        }
    }

    public static ArrayList<String> salesData (String[][] A) {

        ArrayList<String> result = new ArrayList<>();

        Set<String> S = new HashSet<String>();
        for (String[] X : A) {
            for (int j = 1; j < X.length; j++) {
                S.add(X[j]);
            }
        }
        ArrayList<String> A1 = new ArrayList<>();
        Iterator<String> i = S.iterator();
        while(i.hasNext()) {
            A1.add(i.next());
        }
        //System.out.println("T");
        for (String[] X : A) {
            boolean isContains = true;
            ArrayList<String> copy = new ArrayList<>();
            for (int j = 1; j < X.length; j++) {
                copy.add(X[j]);
            }
            Collections.sort(copy);
            Collections.sort(A1);
//            System.out.print(X[0]);
//            System.out.println(A1);
//            System.out.println(copy);
//            System.out.println();
            if (A1.equals(copy)){
                result.add(X[0]);
            }
        }

        return result;
    }

    public static boolean validSplit(String s) {
        int[] firstLetterCount = new int[26];
        int[] lastLetterCount = new int[26];

        String[] A = s.split(" ");
        for (String x : A){
            //System.out.println(x);

            int n0 = x.charAt(0) - 'a';
            int nn = x.charAt(x.length()-1) - 'a';
            //System.out.println(n0);
            //System.out.println(nn);
            firstLetterCount[n0] += 1;
            lastLetterCount[nn] += 1;
        }
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < 26; i++) {
            if (firstLetterCount[i] == lastLetterCount[i]) {
                count2 += 1;
            }
            else if (firstLetterCount[i] - lastLetterCount[i] == 1) {
                count1 += 1;
            }
            else if (lastLetterCount[i] - firstLetterCount[i] == 1) {
                count3 += 1;
            }
            else {
                return false;
            }
        }
        if (count1 == 1 && count3 == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean waveForm (int[] A) {
        for (int i = 0; i < A.length - 2; i++) {
            //System.out.println(i);
            if ((A[i] - A[i+1]) * (A[i+1] - A[i+2]) >= 0) {
                return false;
            }
        }
        return true;
    }

    public static char commonVovel(String s) {
        s = s.toLowerCase();
        int[] count = new int[26];
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int num = s.charAt(i) - 'a';
            //System.out.println((int) s.charAt(i));
            count[num] += 1;
        }
        int maxVovelI = 0;
        char comVovel = ' ';
        for (char c : vowels) {
            int num = c - 'a';
            //System.out.println(num);
            if (count[num] > maxVovelI) {
                maxVovelI = count[num];
                comVovel = c;
            }
        }

        return comVovel;
    }

    public static int[][] dataScience (int[][] A) {

        int n = A.length;
        int[][] result = new int[n][n];
        int[] sum = new int[n];
        int[] average = new int[n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                sum[j] += A[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            average[i] = Math.round((float) (sum[i] - A[i][i]) / (n-1));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    result[i][i] = average[i];
                }
                else {
                    result[i][j] = A[i][j];
                }
            }
        }
        return result;
    }


    public static String nonRepeatable (String s, int n=0, char prev = ' ') {
        if (n == s.length()) {
            return " ";
        }
        else if (s.charAt(n) == prev) {
            return "" + nonRepeatable(s, n+1, s.charAt(n));
        }
        else {
            return s.charAt(n) + nonRepeatable(s, n+1, s.charAt(n));
        }
    }

    public static void binarySystem(int n, int i = 0, int last = 0, String s = "") {
        if (i == n) {
            System.out.println(s);
        }
        else if (i == 0 || last == 1) {
            binarySystem(n, i+1, 0, s + "0");
            binarySystem(n, i+1, 1, s + "1");
        }
        else {
            binarySystem(n, i+1, 1, s+"1");
        }
    }

    public static String alphabetRow() {

    }

    

}