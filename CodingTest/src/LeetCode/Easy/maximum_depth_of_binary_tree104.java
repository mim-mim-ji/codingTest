package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class maximum_depth_of_binary_tree104 {

    /*
    root = [3,9,20,null,null,15,7]
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

    //BFS 풀이
    /*
    root node부터 Queue에 삽입한다.
    Queue의 size만큼 iteration을 수행하며 Queue에 삽입된 front 노드를 poll, 해당 노드의 자식 노드들을 Queue에 offer 한다.
    같은 level에 있는 node들을 모두 검사한 후 depth를 증가시킨다.
    2~3을 반복한다.
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);

        while(! queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode currNode = queue.poll();
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
            depth++;
        }

        return depth;
    }

    // DFS 풀이: 재귀
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;

        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);

        return Math.max(leftD, rightD)+1;
    }
}
