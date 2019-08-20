package findMedianSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //double ans = 0;

        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];

        if (m == 0){
            if(n%2 == 0){
                return (nums2[(n-1) / 2] + nums2[n / 2]) / 2.0;
            }else {
                return nums2[n / 2];
            }
        }

        if (n == 0){
            if(m%2 == 0){
                return (nums1[(m-1) / 2] + nums1[m / 2]) / 2.0;
            }else {
                return nums1[m / 2];
            }
        }

        int count = 0; //合并数组下标
        int i = 0; //nums1下标
        int j = 0; //nums2下标
        while(count < (m+n)){
            if (i < m &&(nums1[i] < nums2[j] || j >= n)){
                nums[count++] = nums1[i++];
            }else {
                nums[count++] = nums2[j++];
            }
//            if (i < m || j < n){
//                if (i == m){
//                    while (j < n){
//                        nums[count++] = nums2[j++];
//                    }
//                    break;
//                }
//                if (j == n){
//                    while (i < m){
//                        nums[count++] = nums1[i++];
//                    }
//                    break;
//                }
//                if (nums1[i] < nums2[j]){
//                    nums[count++] = nums1[i++];
//                }else {
//                    nums[count++] = nums2[j++];
//                }
//            }
        }
        if ((m + n)%2 == 0){
            return (nums[(m + n -1) / 2] + nums[(m+n) / 2]) / 2.0;
        }else {
            return nums[(m + n) / 2];
        }
        //return ans;
    }

    public double findMedianSortedArraysNew(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 2) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public double findMedianSortedArraysMyNew(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int a = 0;// nums1数组下标
        int b = 0;// nums2数组下标
        int l = 0;
        int r = 0;
        for (int i = 0; i <= len/2; i++){
            l = r;
            if(a < m && ( b >= n|| nums1[a] < nums2[b])){
                r = nums1[a++];
            }else {
                r = nums2[b++];
            }
        }
        if (len%2 == 0){
            return (l + r)/2.0;
        }else {
            return r;
        }
    }
}
