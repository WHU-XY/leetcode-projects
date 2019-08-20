package moreThanHalfNum;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void moreThanHalfNumSolutionOne() {
        int[] array = {1,2,3,4,5,6,2,2,2,2,2,2,2};
        System.out.println(new Solution().MoreThanHalfNumSolutionOne(array));
    }

    @Test
    public void moreThanHalfNumSolutionTwo() {
        int[] array = {1,2,3,4,5,6,2,2,2,2,2,2,2};
        System.out.println(new Solution().MoreThanHalfNumSolutionTwo(array));
    }
}