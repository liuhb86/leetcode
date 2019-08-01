/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Base64;
import java.util.ArrayList;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ByteOrder;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> buffer = new ArrayList<>();
        serialize(root, buffer);
        int[] ints = buffer.stream().mapToInt(i -> i).toArray();
        ByteBuffer byteBuf = ByteBuffer.allocate(ints.length * 4);
        IntBuffer intBuf = byteBuf.order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        intBuf.put(ints);
        String result = Base64.getEncoder().encodeToString(byteBuf.array());
        //System.out.println(result);
        return result;
    }
    
    private void serialize(TreeNode node, ArrayList<Integer> buffer) {
        if (node == null) return;
        buffer.add(node.val);
        serialize(node.left, buffer);
        serialize(node.right, buffer);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        byte[] bytes = Base64.getDecoder().decode(data);
        IntBuffer intBuf = ByteBuffer.wrap(bytes)
            .order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        int[] nums = new int[intBuf.remaining()];
        intBuf.get(nums);
        //for (int i = 0; i<nums.length;++i) System.out.print(nums[i]);
        return deserialize(new DataIterator(nums), false, 0);
    }
    
    private TreeNode deserialize(DataIterator it, boolean bounded, int bound) {
        if (!it.hasNext()) return null;
        if (bounded && it.peek() > bound) return null;
        TreeNode node = new TreeNode(it.next());
        node.left = deserialize(it, true, node.val);
        node.right = deserialize(it, bounded, bound);
        return node;
    }
    
    static class DataIterator {
        int[] nums;
        int i = 0;
        public DataIterator(int[] nums) {
            this.nums = nums;
        }
        public int peek() { return nums[i];}
        public boolean hasNext() { return i < nums.length;}
        public int next() { int n = nums[i]; i+=1; return n;}
    }
}



// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));