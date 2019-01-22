import java.util.ArrayList;

public class BSTree {

    private TreeNode root;

    public BSTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int elem) {
        TreeNode newNode = new TreeNode();
        newNode.iData = elem;

        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            while (true) {
                TreeNode parent = current;
                if (elem < current.iData) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        newNode.parent = parent;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        newNode.parent = parent;
                        return;
                    }
                }
            }
        }
    }

    public boolean find(int elem) {
        if (root == null) {
            return false;
        }
        TreeNode current = root;
        while (current.iData != elem) {
            if (elem < current.iData) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private void deleteWithoutChilds(TreeNode current) {
        if (current == root) {
            root = null;
        } else {
            if (current.parent.left == current) {
                current.parent.left = null;
            } else {
                current.parent.right = null;
            }
        }
    }

    private void deleteWithOneLeftChild(TreeNode current) {
        if (current == root) {
            root = current.left;
        } else if (current.parent.left == current) {
            current.parent.left = current.left;
        } else {
            current.parent.right = current.left;
        }
    }

    private void deleteWithOneRightChild(TreeNode current) {
        if (current == root) {
            root = current.right;
        } else if (current.parent.left == current) {
            current.parent.left = current.right;
        } else {
            current.parent.right = current.right;
        }
    }

    private void deleteWithTwoChilds(TreeNode current) {
        TreeNode successor = getSuccessor(current);

        if (successor.left == null && successor.right == null) {
            deleteWithoutChilds(successor);
        } else {
            deleteWithOneRightChild(successor);
        }
        TreeNode parentCurr = current.parent;


        if (parentCurr.left == current) {
            parentCurr.left = successor;
        } else {
            parentCurr.right = successor;
        }
        successor.left = current.left;
        successor.right = current.right;
    }

    public boolean delete(int elem) {
        if (root == null) {
            return false;
        }
        TreeNode current = root;
        while (current.iData != elem) {
            if (elem < current.iData) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.left == null && current.right == null) {
            deleteWithoutChilds(current);
        } else if (current.right == null) {
            deleteWithOneLeftChild(current);
        } else if (current.left == null) {
            deleteWithOneRightChild(current);
        } else {
            deleteWithTwoChilds(current);
        }
        return true;
    }

    public void view(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < level; i++) {
            System.out.print("- ");
        }
        System.out.println(node.iData);
        view(node.left, level + 1);
        view(node.right, level + 1);
    }


    private void copyBSTreeToArrayList(TreeNode node, ArrayList<TreeNode> nodeList) {
        if (node.left != null) {
            copyBSTreeToArrayList(node.left, nodeList);
        }
        nodeList.add(node);
        if (node.right != null) {
            copyBSTreeToArrayList(node.right, nodeList);
        }
    }

    public BSTreeIterator iterator() {
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        if (root != null) {
            copyBSTreeToArrayList(root, nodeList);
        }
        return new BSTreeIterator(nodeList);
    }

    public void print() {
        System.out.print("BST:");
        BSTreeIterator iterator = this.iterator();

        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            System.out.print(node.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BSTree tree = new BSTree();

        tree.insert(50);
        tree.insert(21);
        tree.insert(75);
        tree.insert(12);
        tree.insert(73);


        tree.view(tree.getRoot(), 0);

        boolean result1 = tree.find(21);
        System.out.println("Wynik wyszukania 21:" + result1);

        boolean result2 = tree.find(40);
        System.out.println("Wynik wyszukania 73:" + result2);


        tree.delete(25);
        tree.view(tree.getRoot(), 0);
    }
}
