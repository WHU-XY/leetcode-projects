package romanToInt;

public class Application {
    public static void main(String[] args) {
        String s = "MMMDCC";
        Solution solution = new Solution();
        int result = solution.romanToInt(s);
        System.out.println(result);
    }
}
