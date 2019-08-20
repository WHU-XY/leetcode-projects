package isMatches;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String pattern = ".*";
        String s = "ab";
        boolean result = Pattern.compile(pattern).matcher(s).matches();
        System.out.println(result);
    }
}
