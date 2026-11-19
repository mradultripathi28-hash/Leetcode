class Solution {
        public List<TreeNode> generateTrees(int n) {
                if (n == 0) return new ArrayList<>();
                        return buildTrees(1, n);
                            }

                                private List<TreeNode> buildTrees(int start, int end) {
                                        List<TreeNode> allTrees = new ArrayList<>();
                                                if (start > end) {
                                                            allTrees.add(null);
                                                                        return allTrees;
                                                                                }

                                                                                        for (int i = start; i <= end; i++) {
                                                                                                    List<TreeNode> leftTrees = buildTrees(start, i - 1);
                                                                                                                List<TreeNode> rightTrees = buildTrees(i + 1, end);

                                                                                                                            for (TreeNode left : leftTrees) {
                                                                                                                                            for (TreeNode right : rightTrees) {
                                                                                                                                                                TreeNode currentTree = new TreeNode(i);
                                                                                                                                                                                    currentTree.left = left;
                                                                                                                                                                                                        currentTree.right = right;
                                                                                                                                                                                                                            allTrees.add(currentTree);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                }

                                                                                                                                                                                                                                                                        return allTrees;
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            }
