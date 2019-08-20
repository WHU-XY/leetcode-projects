package match;

public class NewSolution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if ((strIndex == str.length) && (patternIndex == pattern.length)){
            return true;
        }
        //pattern先到尾，匹配失败
        if ((strIndex != str.length) && (patternIndex == pattern.length)) {
            return false;
        }

        if ((patternIndex+1) < pattern.length && (pattern[patternIndex+1] == '*')){

        }else{
            if ((str[strIndex] == pattern[patternIndex] && strIndex != str.length) || (pattern[patternIndex] == '.' && patternIndex != pattern.length)){
                return matchCore(str, strIndex++, pattern, patternIndex++);
            }else {
                return false;
            }
        }
        return false;
    }
}
