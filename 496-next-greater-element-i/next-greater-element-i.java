class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int result[] = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (j == nums2.length - 1) {
                        result[i] = -1;
                    } else {
                        int g = j + 1;
                        while (g < nums2.length) {
                            if (nums2[j] < nums2[g]) {
                                result[i] = nums2[g];
                                break;
                            }
                            g++;
                        }
                    }
                }
            }
        }

        return result;
    }
}
