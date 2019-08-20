package inversePairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SolutionTest {

    @Test
    public void inversePairs() {
        int[] array = {1,2,3,4,5,6,7,0};
        assertEquals(7,new Solution().InversePairs(array));
    }
}