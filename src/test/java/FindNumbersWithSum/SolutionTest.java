package FindNumbersWithSum;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findNumbersWithSum() {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(new Solution().FindNumbersWithSum(array,7));
    }
}