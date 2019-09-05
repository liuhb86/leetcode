/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
import java.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            serialize(root, dos);
            dos.flush();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    void serialize(Node root, DataOutputStream dos) throws IOException {
        if (root == null) {
            dos.writeInt(-1);
            return;
        }
        //System.out.println(root.val);
        dos.writeInt(root.children.size());
        dos.writeInt(root.val);
        for(Node c : root.children) {
            serialize(c, dos);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        try {
            byte[] bytes = Base64.getDecoder().decode(data);
            //System.out.println(bytes.length);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            DataInputStream dis = new DataInputStream(bais);
            return deserialize(dis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    Node deserialize(DataInputStream dis) throws IOException {
        int nc = dis.readInt();
        if (nc == -1) return null;
        int v = dis.readInt();
        List<Node> children = new ArrayList<Node>();
        Node n = new Node(v, children);
        for (int i = 0; i<nc; i+=1) {
            children.add(deserialize(dis));
        }
        return n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));