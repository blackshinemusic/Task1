import java.util.TreeMap;

public class Convert {
    TreeMap<Character, Integer> romanCollection = new TreeMap<>();
    TreeMap<Integer, String> arabianCollection = new TreeMap<>();

    public boolean roman(String num1) {
        return romanCollection.containsKey(num1.charAt(0));
    }

    public Convert() {
        romanCollection.put('I', 1);
        romanCollection.put('V', 5);
        romanCollection.put('X', 10);
        romanCollection.put('L', 50);
        romanCollection.put('C', 100);

        arabianCollection.put(1, "I");
        arabianCollection.put(4, "IV");
        arabianCollection.put(5, "V");
        arabianCollection.put(9, "IX");
        arabianCollection.put(10, "X");
        arabianCollection.put(40, "XL");
        arabianCollection.put(50, "L");
        arabianCollection.put(90, "XC");
        arabianCollection.put(100, "C");
    }

    public String arabRom(int res) {
        String romNum = "";
        int arabNum;
        do {
            arabNum = arabianCollection.floorKey(res);
            romNum += arabianCollection.get(arabNum);
            res -= arabNum;
        } while (res != 0);
        return romNum;
    }

    public int romArab(String num1) {
        int end = num1.length() - 1;
        char[] arrayChar = num1.toCharArray();
        int arab;
        int res = romanCollection.get(arrayChar[end]);
        for (int i = end - 1; i >= 0; i--) {
            arab = romanCollection.get(arrayChar[i]);
            if (arab < romanCollection.get(arrayChar[i + 1])) {
                res -= arab;
            } else {
                res += arab;
            }
        }
        return res;
    }
}