class Solution {
    public void MergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int in = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[in] = nums1[i];
                i--;
                in--;
            } else if (nums1[i] < nums2[j]) {
                nums1[in] = nums2[j];
                j--;
                in--;
            } else {
                nums1[in] = nums1[i];
                nums1[in - 1] = nums2[j];
                i--;
                j--;
                in -= 2;
            }
        }

        while (i >= 0) {
            nums1[in] = nums1[i];
            i--;
            in--;
        }

        while (j >= 0) {
            nums1[in] = nums2[j];
            j--;
            in--;
        }
    }
}