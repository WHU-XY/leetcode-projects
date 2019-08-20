package maxArea;

public class Application {
    public static void main(String[] args) {
        int[] height = {1,8,2,4,9,8,10,20,10};
        Solution solution = new Solution();
        int result = solution.maxArea(height);
        System.out.println(result);
    }
}
