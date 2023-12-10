import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:/Users/79085/JavaProjs/ITIP/SixthLab/src";
        String miniPath = "textFile.txt";

        File file = new File(filePath, miniPath);

        Scanner scanner = new Scanner(System.in);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map <String, Integer> countMap = new HashMap<>();

        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (countMap.containsKey(s)) {
                countMap.put(s, countMap.get(s) + 1);
            }
            else {
                countMap.put(s, 1);
            }
        }

        scanner.close();

        List<Map.Entry<String, Integer> > words = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            words.add(entry);
        }

        // сортируем список по убыванию количества повторений
        Collections.sort(words, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String,
                    Integer> o2) {
                if (o1.getValue() < o2.getValue()) return 1;
                else if (o1.getValue() == o2.getValue()) return 0;
                else return -1;
            }
        });

        for (int i = 0; i < Math.min(words.size(), 10); i++) {
            Map.Entry<String, Integer> entry = words.get(i);
            System.out.print(entry.getKey());
            System.out.print(" ");
            System.out.println(entry.getValue());
        }

    }
}
