class Solution {
        public int countValidSubarrays(int[] nums, int x) {
                int n = nums.length;
                        int validCount = 0;

                                for (int i = 0; i < n; i++) {
                                            long sum = 0;
                                                        for (int j = i; j < n; j++) {
                                                                        sum += nums[j];
                                                                                        if (sum % 10 == x && getFirstDigit(sum) == x) {
                                                                                                            validCount++;
                                                                                                                            }
                                                                                                                                        }
                                                                                                                                                }

                                                                                                                                                        return validCount;
                                                                                                                                                            }

                                                                                                                                                                private int getFirstDigit(long num) {
                                                                                                                                                                        while (num >= 10) {
                                                                                                                                                                                    num /= 10;
                                                                                                                                                                                            }
                                                                                                                                                                                                    return (int) num;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        }
