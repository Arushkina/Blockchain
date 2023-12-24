package merkle;

import java.util.List;

public class MerkleUtils {
    public static String getMerkleRoot(List<String> transactions) {
        MerkleTree merkleTree = new MerkleTree(transactions);
        List<String> tree = merkleTree.getMerkleTree();
        return (tree.size() > 0) ? tree.get(tree.size() - 1) : "";
    }
}
