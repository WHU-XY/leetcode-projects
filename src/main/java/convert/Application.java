package convert;

public class Application {
    public static void main(String[] args) {
        String s = "HelloWorld";
        int numRows = 2;
        Solution solution = new Solution();
        String result = solution.convert(s, numRows);
        System.out.println(result);
    }
}
