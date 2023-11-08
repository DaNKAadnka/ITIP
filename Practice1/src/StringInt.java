public class StringInt implements Comparable<StringInt> {

    public String text;
    public int order;

    public StringInt(String text, int order) {
        this.text = text;
        this.order = order;
    }


    @Override
    public int compareTo(StringInt a) {
        boolean b = ((this.order < a.order));
        return b ? -1 : 1;
    }
}
