package findMedianSortedArrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findMedianSortedArrays() {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(new Solution().findMedianSortedArrays(a, b));
    }

    @Test
    public void findMedianSortedArraysNew() {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(new Solution().findMedianSortedArraysNew(a, b));
    }

    @Test
    public void findMedianSortedArraysMyNew() {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(new Solution().findMedianSortedArraysMyNew(a, b));
    }
}