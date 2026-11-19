class Solution {
        public long maxArrayValue(int[] nums) {
                long currentSum = nums[nums.length - 1];
                        long maxVal = currentSum;

                                for (int i = nums.length - 2; i >= 0; i--) {
                                            if (nums[i] <= currentSum) {
                                                            currentSum += nums[i];
                                                                        } else {
                                                                                        currentSum = nums[i];
                                                                                                    }
                                                                                                                maxVal = Math.max(maxVal, currentSum);
                                                                                                                        }

                                                                                                                                return maxVal;
                                                                                                                                    }
                                                                                                                                    }
