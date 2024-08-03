import java.util.*;

public class Stobogramatic {

    private static final Map<Character, Character> STROBOGRAMMATIC_PAIRS = new HashMap<>();
    static {
        STROBOGRAMMATIC_PAIRS.put('0', '0');
        STROBOGRAMMATIC_PAIRS.put('1', '1');
        STROBOGRAMMATIC_PAIRS.put('6', '9');
        STROBOGRAMMATIC_PAIRS.put('8', '8');
        STROBOGRAMMATIC_PAIRS.put('9', '6');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the lower bound: ");
        long low = scanner.nextLong();
        System.out.print("Enter the upper bound: ");
        long high = scanner.nextLong();

        List<String> result = new ArrayList<>();
        for (int len = String.valueOf(low).length(); len <= String.valueOf(high).length(); len++) {
            char[] num = new char[len];
            findStrobogrammaticNumbers(result, num, 0, len - 1, low, high);
        }

        System.out.println("Strobogrammatic numbers in the range:");
        for (String s : result) {
            System.out.println(s);
        }

        scanner.close();
    }

    private static void findStrobogrammaticNumbers(List<String> result, char[] num, int left, int right, long low, long high) {
        if (left > right) {
            String s = new String(num);
            long val = Long.parseLong(s);
            if (val >= low && val <= high && !(s.length() > 1 && s.charAt(0) == '0')) {
                result.add(s);
            }
            return;
        }

        for (Map.Entry<Character, Character> entry : STROBOGRAMMATIC_PAIRS.entrySet()) {
            num[left] = entry.getKey();
            num[right] = entry.getValue();
            if (left == right && entry.getKey() != entry.getValue()) continue;
            findStrobogrammaticNumbers(result, num, left + 1, right - 1, low, high);
        }
    }
}
