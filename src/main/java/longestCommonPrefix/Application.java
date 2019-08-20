package longestCommonPrefix;

public class Application {
    public static void main(String[] args) {
        String[] strings = {"leetcode", "leet", "lee"};
        FirstSolution solution = new FirstSolution();
        String result = solution.longestCommonPrefix(strings);
        System.out.println(result);
    }
}
