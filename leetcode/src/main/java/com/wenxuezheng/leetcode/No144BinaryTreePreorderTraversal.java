package com.wenxuezheng.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author    
 * 2022/10/17 19:07
 */

public class No144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        new No144BinaryTreePreorderTraversal().preorderTraversal(root);

    }


    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()){

            TreeNode pop = treeNodes.pop();
            rs.add(pop.val);
            if(pop.right != null)
                treeNodes.push(pop.right);
            if(pop.left != null)
                treeNodes.push(pop.left);
        }
        return rs;
    }
}

