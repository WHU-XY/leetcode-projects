package atoi;

public class Application {
    public static void main(String[] args) {
        String s = " -429898 hh";
        s.split(",");
        Solution solution = new Solution();
        int result = solution.myAtoi(s);
        System.out.println(result);
    }
}
