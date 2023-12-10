import java.util.ArrayList;
import java.util.*;

public class Practice5 {

    public static void main (String[] args) {

        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB") );
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println(spiderVsFly("H3", "E2").toString());
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println(digitsCount(121317) );
        System.out.println(digitsCount(544) );
        System.out.println(digitsCount(12345) );


        String[] s1 = {"cat", "create", "sat"};
        String[] s2 = {"trance", "recant"};
        String[] s3 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(s1, "caster"));
        System.out.println(totalPoints(s2, "recant"));
        System.out.println(totalPoints(s3, "tossed"));

        int[] q1 = {1, 2, 3, 4, 5};
        int[] q2 = {1, 6, 5, 4, 8, 2, 3, 7};

        System.out.println(sumsUp(q1));
        System.out.println(sumsUp(q2));

        String[] w1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        String[] w2 = {"10%"};
        String[] w3 = {"53%", "79%"};

        System.out.println(takeDownAverage(w1));
        System.out.println(takeDownAverage(w2));
        System.out.println(takeDownAverage(w3));

        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));

        System.out.println(setSetup(5, 3) );
        System.out.println(setSetup(7, 3) );



        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome") );
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
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


    public static StringBuilder spiderVsFly (String a, String b) {
        int spider_x = a.charAt(0) - 'A';
        int spider_y = a.charAt(1) - '0';
        int fly_x = b.charAt(0) - 'A';
        int fly_y = b.charAt(1) - '0';

        // x - координата по кольцу 0-7
        // y - координата между кольцами 0-4

        int cnt = 0;

        StringBuilder ans = new StringBuilder();
        do {
            char c1 = (char)(65 + spider_x);
            char c2 = (char)((int)'0' + spider_y);
            ans.append(c1);
            ans.append(c2);
            if (spider_x == fly_x && spider_y == fly_y) {
                break;
            }
            ans.append("-");
            if (spider_y == 0) {
                spider_y = 1;
                spider_x = fly_x;
            }
            else if (dist(spider_x, fly_x) > 2) {
                spider_y--;
                if (spider_y == 0) {
                    spider_x = 0;
                }
            }
            else if (spider_y < fly_y) {
                spider_y++;
            }
            else if (spider_y == fly_y) {
                if (Math.abs(spider_x - fly_x) < (7 - spider_x) + fly_x) {
                    if (spider_x < spider_y) {
                        spider_x++;
                    }
                    else {
                        spider_x--;
                    }
                }
                else {
                    spider_x = (spider_x + 1) % 8;
                }
            }
            else {
                spider_y--;
            }
            cnt += 1;
            if (cnt > 40) {
                break;
            }
        } while (true);

        return ans;
    }
    public static int dist(int spider_x, int fly_x) {
        return Math.min(Math.abs(spider_x - fly_x), (8 - spider_x) + fly_x);
    }

    public static int digitsCount (long n) {
        if (n < 10) {
            return 1;
        }
        else {
            return 1 + digitsCount(n/10);
        }
    }


    public static int totalPoints (String[] words, String word) {
        int[] wordCount = new int[26];
        for (int i = 0; i < 26; i++) {
            wordCount[i] = 0;
        }
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            wordCount[ind] += 1;
        }
        int answer = 0;
        for (String s : words) {
            int[] nCount = new int[26];
            for (int i = 0; i < 26; i++) {
                nCount[i] = 0;
            }
            for (int i = 0; i < s.length(); i++) {
                int ind = s.charAt(i) - 'a';
                nCount[ind] += 1;
            }
            int count = 0;
            boolean is_include_in_answer = true;
            for (int i = 0; i < 26; i++) {
                //System.out.print(i);
                //System.out.print(wordCount[i]);
                //System.out.println(nCount[i]);
                if (nCount[i] > wordCount[i]) {
                    is_include_in_answer = false;
                }
                count += nCount[i];
            }
            if (is_include_in_answer) {
                answer += (count - 2);
                if (count >= 6) {
                    answer += 50;
                }
            }
        }
        return answer;
    }

    public static String takeDownAverage (String[] arr) {
        int n = arr.length;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i].replaceAll("%", "");
            sum += Integer.parseInt(arr[i]);
        }
        int ans = (int)Math.round(sum / n - 5 * (n+1)) ;

        return Integer.toString(ans) + "%";
    }


    public static ArrayList< ArrayList<Integer> > sumsUp (int[] arr) {
        ArrayList< ArrayList<Integer> > answer = new ArrayList<>();


        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (arr[i] + arr[j] == 8) {
                    ArrayList<Integer> a1 = new ArrayList<Integer>();
                    if (arr[j] <= arr[i]) {
                        a1.add(arr[j]);
                        a1.add(arr[i]);
                    }
                    else {
                        a1.add(arr[i]);
                        a1.add(arr[j]);
                    }
                    answer.add(a1);
                }
            }
        }

        return answer;
    }

    
    public static String caesarCipher(String type, String s, int shift) {
        int tp = 0;
        if (type.compareTo("encode") == 0) tp = 1;
        else tp = -1;
        s = s.toUpperCase();
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = ch[i];
            int x = c - 'A';
            if (0 <= x && x <= 25) {
                int p = (65 + x + shift * tp);
                if (p > 90) {
                    p = (p - 90 + 65 - 1);
                }
                else if (p < 65) {
                    p = (90 - 65 + p + 1);
                }
                ch[i] = (char)p;
            }
            else {
                ch[i] = c;
            }
        }
        return new String(ch);
    }

    public static int setSetup (int n, int k) {
        if (k == 0) {
            return 1;
        }
        else {
            return n * setSetup(n-1, k-1);
        }
    }

    public static String timeDifference (String cityA, String timeA, String cityB) {

        HashMap<String, int[] > cityDifference = new HashMap<>();
        HashMap<String, Integer> months = new HashMap<>();
        HashMap<String, Integer> daysInMonths = new HashMap<>();

        String[] monthsArray = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        cityDifference.put("Los Angeles", new int[] {-8, 0});
        cityDifference.put("New York", new int[] {-5, 0});
        cityDifference.put("Caracas", new int[] {-4, 30});
        cityDifference.put("Buenos Aires", new int[] {-3, 0});
        cityDifference.put("London", new int[] {0, 0});
        cityDifference.put("Rome", new int[] {1, 0});
        cityDifference.put("Moscow", new int[] {3, 0});
        cityDifference.put("Tehran", new int[] {3, 30});
        cityDifference.put("New Delhi", new int[] {5, 30});
        cityDifference.put("Beijing", new int[] {8, 0});
        cityDifference.put("Canberra", new int[] {10, 0});

        daysInMonths.put("January", 31);
        daysInMonths.put("February", 28);
        daysInMonths.put("March", 31);
        daysInMonths.put("April", 30);
        daysInMonths.put("May", 31);
        daysInMonths.put("June", 30);
        daysInMonths.put("July", 31);
        daysInMonths.put("August", 31);
        daysInMonths.put("September", 30);
        daysInMonths.put("October", 31);
        daysInMonths.put("November", 30);
        daysInMonths.put("December", 31);

        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 20);
        months.put("November", 11);
        months.put("December", 12);

        // Парсим время
        // time[0] - Месяц, time[1] - Число месяца
        // time[2] - Год, time[3] - Время
        String[] time = timeA.split(" ");
        time[1] = time[1].replaceAll(",", "");

        // Получаем разницу часовых поясов
        int[] timeInCityA = cityDifference.get(cityA);
        int[] timeInCityB = cityDifference.get(cityB);
        // Получаем прибавку ко времени
        int[] timeDifference = new int[] {timeInCityB[0] - timeInCityA[0],
                                            timeInCityB[1] - timeInCityA[1]};

        // Парсим из времени time[3] часы и минуты
        String[] currentTimeInString = time[3].split(":");
        int[] currentTime = {Integer.parseInt(currentTimeInString[0]),
                             Integer.parseInt(currentTimeInString[1])};

        // newTime - Время с учетом смены часовых поясов
        // newTime[0] - Часы
        // newTime[1] - Минуты
        int[] newTime = new int[] {currentTime[0] + timeDifference[0],
                currentTime[1] + timeDifference[1]};

        int month = months.get(time[0]);
        int date = Integer.parseInt(time[1]);
        int year = Integer.parseInt(time[2]);

        if (newTime[1] < 0) {
            newTime[1] = 60 + newTime[1];
            newTime[0] -= 1;
            if (newTime[0] < 0) {
                newTime[0] = 24 - newTime[0];
                date -= 1;
                if (date == 0) {
                    month -= 1;
                    if (month >= 1) {
                        date = daysInMonths.get(monthsArray[month - 1]);
                    }
                    else {
                        year -= 1;
                        month = 12;
                        date = 31;
                    }
                }
            }
        }

        if (newTime[1] >= 60) {
            newTime[1] = newTime[1] % 60;
            newTime[0] += 1;
        }

        if (newTime[0] >= 24) {
            newTime[0] -= 24;
            date += 1;
            if (date > daysInMonths.get(monthsArray[month - 1])) {
                month += 1;
                date = 1;
                if (month > 11) {
                    month = 1;
                    year += 1;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(Integer.toString(year));
        ans.append("-");
        ans.append(Integer.toString(month));
        ans.append("-");
        ans.append(Integer.toString(date));
        ans.append(" ");
        if (newTime[0] <= 9) {
            ans.append("0");
        }
        ans.append(newTime[0]);
        ans.append(":");
        if (newTime[1] <= 9) {
            ans.append("0");
        }
        ans.append(newTime[1]);

        return ans.toString();
    }

    public static boolean isNew (int a) {
        char[] digs = ("" + a).toCharArray();
        for (int i = 1; i < digs.length; i++) {
            if (digs[i] < digs[i-1] && digs[i] != '0') {
                return false;
            }
        }
        return true;
    }
}
