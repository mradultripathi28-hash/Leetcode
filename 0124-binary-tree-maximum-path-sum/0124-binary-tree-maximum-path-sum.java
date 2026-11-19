/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        private int maxSum;

            public int maxPathSum(TreeNode root) {
                    maxSum = Integer.MIN_VALUE;
                            maxGain(root);
                                    return maxSum;
                                        }

                                            private int maxGain(TreeNode node) {
                                                    if (node == null) {
                                                                return 0;
                                                                        }

                                                                                // Recursively compute max contribution from left and right subtrees; ignore negative gains
                                                                                        int leftGain = Math.max(maxGain(node.left), 0);
                                                                                                int rightGain = Math.max(maxGain(node.right), 0);

                                                                                                        // Path sum if the path splits/turns at the current node
                                                                                                                int currentPathSum = node.val + leftGain + rightGain;
                                                                                                                        maxSum = Math.max(maxSum, currentPathSum);

                                                                                                                                // Return max single-branch gain that can be extended to the parent
                                                                                                                                        return node.val + Math.max(leftGain, rightGain);
                                                                                                                                            }
                                                                                                                                            }
