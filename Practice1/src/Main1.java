import java.util.*;

public class Main1  {

    public static String[] num1 = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    public static String[] num2 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String[] num3 = {"hundred"};

    public static int[] Anum1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11,
            12, 13, 14, 15, 16, 17, 18, 19};

    public static int[] Anum2 = {20, 30, 40, 50, 60, 70, 80, 90};

    public static int[] Anum3 = {100};

    public static ArrayList<StringBuilder> brackets = new ArrayList<>();
    public static ArrayList<StringBuilder> binarys = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println(nonRepeatable(new StringBuilder("abracadabra")));
        System.out.println(nonRepeatable(new StringBuilder("papparazzi")));

        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));

        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        System.out.println(alphabetRow(new StringBuilder("abcdjuwx")));

        System.out.println(charCount("aaabbcdd"));
        System.out.println(charCount("vvvvaajaaaaa"));
        System.out.println(charCount("bacdaaee"));

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        int[][] a2 = {{2, 7, 3}, {1, 4, 8}, {4, 5, 9}};
        int[][] a1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(shortestWay(a1));
        System.out.println(shortestWay(a2));

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    // n = s.length - 1
    public static StringBuilder nonRepeatable (StringBuilder s) {
        return NonRepeatable(s, s.length()-1);
    }

    public static StringBuilder NonRepeatable(StringBuilder s, int n) {
        if (n == -1) {
            return new StringBuilder();
        }
        boolean repeat = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(n) == s.charAt(i)) {
                repeat = true;
            }
        }
        StringBuilder x = NonRepeatable(s, n-1);
        x.append((repeat ? "" : s.charAt(n)));
        return x;
    }

    public static List<StringBuilder> generateBrackets(int n) {
        brackets.clear();
        GenerateBrackets(0, 0, 0, new StringBuilder());
        return brackets;
    }

    //i = 0, sum = 0, s = ""
    public static void GenerateBrackets(int n, int i, int sum, StringBuilder s) {
        if (i == 2 * n) {
            if (sum == 0) {
                brackets.add(s);
            }
        }
        else if (sum >= 0) {
            GenerateBrackets(n, i+1, sum + 1, new StringBuilder(s + "("));
            GenerateBrackets(n, i+1, sum - 1, new StringBuilder(s + ")"));
        }
    }

    public static ArrayList<StringBuilder> binarySystem(int n) {
        binarys.clear();
        BinarySystem(n, 0, 0, new StringBuilder());
        return binarys;
    }

    //i = 0, last = 0, s = ""
    public static void BinarySystem(int n, int i, int last, StringBuilder s) {
        if (i == n) {
            System.out.println(s);
        } else if (i == 0 || last == 1) {
            BinarySystem(n, i + 1, 0, new StringBuilder(s + "0"));
            BinarySystem(n, i + 1, 1, new StringBuilder(s + "1"));
        } else {
            BinarySystem(n, i + 1, 1, new StringBuilder(s + "1"));
        }
    }

    //Состояние рекурсии - ответ на преффиксе длины i
    //Параметры рекурсии - s, i, ans, current, g(increase or decrease)
    //Переход рекурсии -

    public static String alphabetRow(StringBuilder s) {
        return AlphabetRow(s, s.length()-1);
    }

    // pos = n
    public static String AlphabetRow(StringBuilder s, int pos) {
        if (pos == s.length()) {
            return AlphabetRow(s, pos - 1);
        }
        else if (pos == -1) {
            return "";
        }
        else if (pos == 0) {
            return Character.toString(s.charAt(0));
        }
        else {
            StringBuilder s1 = new StringBuilder(AlphabetRow(s, pos - 1));
            if (s1.charAt(pos - 1) == s.charAt(pos) + 1 ||
                    s1.charAt(pos - 1) == s.charAt(pos) - 1) {
                s1.append(Character.toString(s.charAt(pos)));
                return s1.toString();
            } else {
                s1.append(Character.toString(s.charAt(pos)));
                return s1.toString();
            }
        }
    }

    public static String charCount(String s) {

        ArrayList<CharIntPair> arr = new ArrayList<>();

        char cur = s.charAt(0), cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (cur != s.charAt(i)) {
                arr.add(new CharIntPair(cur, cnt));
                cur = s.charAt(i);
                cnt = 1;
            } else {
                cnt += 1;
            }
        }
        arr.add(new CharIntPair(cur, cnt));

        Collections.sort(arr);

        StringBuilder ans = new StringBuilder();

        for (CharIntPair cip : arr) {
            ans.append(cip.c);
            if (cip.count > 1) {
                ans.append(Integer.toString(cip.count));
            }

        }

        return ans.toString();
    }

    public static int convertToNum(String s) {
        String[] a = s.split(" ");
        return convertToNumA(a, 0);
    }

    public static int convertToNumA (String[] a, int pos) {
//        System.out.println("------------");
//        System.out.println(a[pos]);
//        System.out.println(indexOf(num1, a[pos]));
//        System.out.println(indexOf(num2, a[pos]));
//        System.out.println(indexOf(num3, a[pos]));
//        System.out.println("-------------");
        if (pos == a.length) {
            return 0;
        }
        if (a[pos].equals("hundred")) {
            return convertToNumA(a, pos+1);
        }
        if (CharIntPair.indexOf(num1, a[pos]) != -1) {
            if (pos != a.length - 1 && a[pos+1].equals("hundred")) {
                return (int)Anum1[CharIntPair.indexOf(num1, a[pos])] * 100 + convertToNumA(a, pos+1);
            }
            else {
                return (int)Anum1[CharIntPair.indexOf(num1, a[pos])];
            }
        }
        if (CharIntPair.indexOf(num2, a[pos]) != -1) {
            return (int) Anum2[CharIntPair.indexOf(num2, a[pos])] + convertToNumA(a, pos+1);
        }
        return 0;
    }

    //ans = "", pos = 0
    public static String uniqueSubstring(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                boolean uniq = true;
                HashSet<Character> hs = new HashSet<>();
                for (int c = i; c <= j; c++) {
                    if (hs.contains(s.charAt(c))) {
                        uniq = false;
                    }
                    hs.add(s.charAt(c));
                }
                if (uniq && ans.length() < j-i+1) {
                    ans = CharIntPair.substring(s, i, j);
                }
            }
        }
        return ans;
    }

    public static int shortestWay (int[][] map) {
        return ShortestWay(map, map.length-1, map.length-1);
    }

    public static int ShortestWay (int[][] map, int i, int j) {
        if (i == 0 && j == 0) {
            return map[i][j];
        }
        if (i == 0) {
            return map[i][j] + ShortestWay(map, i, j-1);
        }
        if (j == 0) {
            return map[i][j] + ShortestWay(map, i-1, j);
        }
        return Math.min(ShortestWay(map, i-1, j), ShortestWay(map, i, j-1)) + map[i][j];
    }

    public static String numericOrder(String s) {
        String[] a = s.split(" ");

        List<StringInt> si = new ArrayList<StringInt>();

        for (String x : a) {
            int order = 0;
            String text = "";
            for (int i = 0; i < x.length(); i++) {
                if ('0' <= x.charAt(i) && x.charAt(i) <= '9') {
                    order *= 10;
                    order += x.charAt(i) - '0';
                }
                else {
                    text += x.charAt(i);
                }
            }
            si.add(new StringInt(text, order));
        }

        Collections.sort(si);

        String ans = "";
        for (StringInt text : si) {
            ans += text.text;
            ans += " ";
        }

        return ans;
    }

    public static int switchNums (int a, int b) {
        ArrayList <Integer> na = new ArrayList<Integer> ();
        for (; a > 0; a /= 10) {
            na.add(a % 10);
        }

        Collections.sort(na);
        Collections.reverse(na);


        int ans = 0, point = 0;
        for (;; ) {
            ans *= 10;
            String s = Integer.toString(b);
            int z = s.charAt(0) - '0';
            if (point < na.size() && (z) < na.get(point)) {
                ans += na.get(point);
                point += 1;
            }
            else {
                ans += z;
            }
            s = CharIntPair.substring(s, 1, s.length()-1);
            if (s.isEmpty()) {
                break;
            }
            b = Integer.parseInt(s);
        }

        return ans;
    }
}
