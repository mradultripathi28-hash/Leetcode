class Solution {
        public int minOperations(int[] nums) {
                int n = nums.length;
                        if (n <= 1) return 0;

                                int incDrops = 0;
                                        int decDrops = 0;

                                                for (int i = 0; i < n; i++) {
                                                            int next = (i + 1) % n;
                                                                        if (nums[i] > nums[next]) {
                                                                                        incDrops++;
                                                                                                    }
                                                                                                                if (nums[i] < nums[next]) {
                                                                                                                                decDrops++;
                                                                                                                                            }
                                                                                                                                                    }

                                                                                                                                                            int pos0 = 0;
                                                                                                                                                                    for (int i = 0; i < n; i++) {
                                                                                                                                                                                if (nums[i] == 0) {
                                                                                                                                                                                                pos0 = i;
                                                                                                                                                                                                                break;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                            int ans = Integer.MAX_VALUE;

                                                                                                                                                                                                                                                    if (incDrops == 1 || (incDrops == 0 && n == 1)) {
                                                                                                                                                                                                                                                                int shift = pos0;
                                                                                                                                                                                                                                                                            ans = Math.min(ans, shift);
                                                                                                                                                                                                                                                                                        ans = Math.min(ans, (n - shift) % n + 2);
                                                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                                                        if (decDrops == 1 || (decDrops == 0 && n == 1)) {
                                                                                                                                                                                                                                                                                                                    int shift = (pos0 + 1) % n;
                                                                                                                                                                                                                                                                                                                                ans = Math.min(ans, shift + 1);
                                                                                                                                                                                                                                                                                                                                            ans = Math.min(ans, (n - shift) % n + 1);
                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                            return ans == Integer.MAX_VALUE ? -1 : ans;
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                }
