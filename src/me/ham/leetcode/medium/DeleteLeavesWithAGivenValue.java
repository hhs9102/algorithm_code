package me.ham.leetcode.medium;


import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/delete-leaves-with-a-given-value/
public class DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root.left!=null)
            root.left = removeLeafNodes(root.left, target);
        if(root.right!=null)
            root.right = removeLeafNodes(root.right, target);

        return root.left == root.right && root.val == target ? null : root;
    }
    @Test
    public void test(){
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(3);
        expected.right.right = new TreeNode(4);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        assertEquals(expected, removeLeafNodes(root, 2));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TreeNode)) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val &&
                    Objects.equals(left, treeNode.left) &&
                    Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

}
