class Solution {
        static final int MOD = 1_000_000_007;
            long[] treeSum;
                long[] treeSq;
                    long[] lazy;

                        void pushUp(int node) {
                                treeSum[node] = (treeSum[2 * node] + treeSum[2 * node + 1]) % MOD;
                                        treeSq[node] = (treeSq[2 * node] + treeSq[2 * node + 1]) % MOD;
                                            }

                                                void apply(int node, int l, int r, long val) {
                                                        val %= MOD;
                                                                int len = r - l + 1;
                                                                        treeSq[node] = (treeSq[node] + 2 * val % MOD * treeSum[node] % MOD + val * val % MOD * len % MOD) % MOD;
                                                                                treeSum[node] = (treeSum[node] + val * len) % MOD;
lazy[node] = (lazy[node] + val) % MOD;
}
void pushDown(int node, int l, int r) {
if (lazy[node] != 0) {
int mid = l + (r - l) / 2;
apply(2 * node, l, mid, lazy[node]);
apply(2 * node + 1, mid + 1, r, lazy[node]);
lazy[node] = 0;
}
}
void update(int node, int l, int r, int ql, int qr, long val) {
if (ql <= l && r <= qr) {
apply(node, l, r, val);
return;
}
pushDown(node, l, r);
int mid = l + (r - l) / 2;
if (ql <= mid) update(2 * node, l, mid, ql, qr, val);
if (qr > mid) update(2 * node + 1, mid + 1, r, ql, qr, val);
pushUp(node);
}                                                                                                                                                                                                                                                                public int sumCounts(int[] nums) {
                                                                                                                                                                                                                                                                        int n = nums.length;
                                                                                                                                                                                                                                                                                treeSum = new long[4 * n];
                                                                                                                                                                                                                                                                                        treeSq = new long[4 * n];
                                                                                                                                                                                                                                                                                                lazy = new long[4 * n];
                                                                                                                                                                                                                                                                                                        int maxVal = 0;
                                                                                                                                                                                                                                                                                                                for (int x : nums) {
                                                                                                                                                                                                                                                                                                                            if (x > maxVal) maxVal = x;
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                            int[] lastPos = new int[maxVal + 1];
                                                                                                                                                                                                                                                                                                                                                    java.util.Arrays.fill(lastPos, -1);
                                                                                                                                                                                                                                                                                                                                                            long ans = 0;
                                                                                                                                                                                                                                                                                                                                                                    for (int i = 0; i < n; i++) {
                                                                                                                                                                                                                                                                                                                                                                                int prev = lastPos[nums[i]];
                                                                                                                                                                                                                                                                                                                                                                                            update(1, 0, n - 1, prev + 1, i, 1);
                                                                                                                                                                                                                                                                                                                                                                                                        ans = (ans + treeSq[1]) % MOD;
                                                                                                                                                                                                                                                                                                                                                                                                                    lastPos[nums[i]] = i;
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                    return (int) ans;
                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                        }
