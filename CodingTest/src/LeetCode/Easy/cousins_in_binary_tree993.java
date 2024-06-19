package LeetCode.Easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class cousins_in_binary_tree993 {

    /*
    x와 y는 같은 depth에 있어야 한다 + 동시에 x와 y의 부모는 달라야한다 = 사촌 노드
     */

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
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> setParent = new HashSet<>();
        Set<Integer> setDepth = new HashSet<>();
        int depth = 0;

        queue.add(root);

        while (! queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();

                if(node.left != null){
                    if(node.left.val == x || node.left.val == y){
                        setParent.add(node);
                        setDepth.add(depth);
                    }
                    queue.add(node.left);
                }

                if(node.right != null){
                    if(node.right.val == x || node.right.val == y){
                        setParent.add(node);
                        setDepth.add(depth);
                    }
                    queue.add(node.right);
                }
            }
            depth++;
        }
        if(setDepth.size() > 1 || setParent.size() < 2) return false; //부모는 다르므로 2개, 깊이는 같으므로 1개 -> 아닌경우 false

        return true;
    }
}
