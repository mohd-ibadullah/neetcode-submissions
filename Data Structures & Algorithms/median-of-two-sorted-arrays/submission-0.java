class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = total / 2;
        int a[] = nums1;
        int b[] = nums2;
        if (nums1.length > nums2.length) {
            int temp[] = a;
            a = b;
            b = temp;
        }
        int l = 0;
        int r = a.length;
        while (true) {
            int al = Integer.MIN_VALUE;
            int ar = Integer.MAX_VALUE;
            int bl = Integer.MIN_VALUE;
            int br = Integer.MAX_VALUE;
            int i = (l + r) / 2;
            int j = half - i;
            if (i > 0) {
                al = a[i-1];
            }
            if (i < a.length) {
                ar = a[i];
            }
            if (j > 0) {
                bl = b[j-1];
            }
            if (j < b.length) {
                br = b[j];
            }
            if (al <= br && bl <= ar) {
                if (total % 2 == 0) {
                    return (Math.max(al, bl) + Math.min(ar, br)) / 2.0;
                } else {
                    return Math.min(ar, br);
                }
            } else if (al > br) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
    }
}
