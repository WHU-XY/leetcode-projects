package printMinNumber;

import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void printMinNumber() {
        int[] array = {3,32,312};
        System.out.println(new Solution().PrintMinNumber(array));
    }
}