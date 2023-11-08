public class CharIntPair implements Comparable<CharIntPair> {
    public char c;
    public int count;

    public CharIntPair(char c, int count) {
        this.c = c;
        this.count = count;
    }

    @Override
    public int compareTo(CharIntPair a) {
        boolean b = ((this.count < a.count) || (this.count == a.count && this.c < a.c));
        return b ? -1 : 1;
    }

    public static int indexOf (String[] arr, String e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public static String substring (String s, int l, int r) {
        String res = "";
        for (int i = l; i <= r; i++) {
            res += s.charAt(i);
        }
        return res;
    }
}


