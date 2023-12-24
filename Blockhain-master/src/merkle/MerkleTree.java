package merkle;
import utils.HashingUtils;
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
    private List<String> merkleTree;

    public MerkleTree(List<String> transactions) {
        merkleTree = new ArrayList<>(transactions);
        constructTree();
    }
    private void constructTree() {
        int size = merkleTree.size();
        int levels = (int) Math.ceil(Math.log(size) / Math.log(2));

        int currentLevelSize = size;
        for (int i = 0; i < levels - 1; i++) {
            List<String> level = new ArrayList<>();
            for (int j = 0; j < currentLevelSize; j += 2) {
                String leftChild = merkleTree.get(j);
                String rightChild = (j + 1 < currentLevelSize) ? merkleTree.get(j + 1) : "";
                String parent = combineHashes(leftChild, rightChild);
                level.add(parent);
            }
            merkleTree.addAll(level);
            currentLevelSize = level.size();
        }
    }
    private String combineHashes(String left, String right) {
        return HashingUtils.applySHA256(left + right);
    }
    public List<String> getMerkleTree() {
        return merkleTree;
    }
}
