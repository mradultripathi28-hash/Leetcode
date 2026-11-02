class Solution {
        public int minMoves2(int[] nums) {
                Arrays.sort(nums);
                        int l = 0, r = nums.length - 1, moves = 0;
                                while (l < r) {
                                            moves += nums[r--] - nums[l++];
                                                    }
                                                            return moves;
                                                                }
                                                                }
