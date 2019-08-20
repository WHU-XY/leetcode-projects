package intToRoman;

public class Application {
    public static void main(String[] args) {
        int num = 3;
        Solution solution = new Solution();
        String result = solution.intToRoman(num);
        System.out.println(result);
    }
}
