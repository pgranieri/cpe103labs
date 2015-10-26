import java.lang.Math;

public class BasicBST {
	private class BSTNode {
		public int element;
		public Node left, right;


	}

	private BSTNode root;

	public BasicBST(){
		root = null;
	}

	public void insert(int value) {
		root = insert(value, root);
	}

	private BSTNode insert(int value, BSTNode treeroot){
		if(treeroot == null){
			treeroot = new BSTNode();
			treeroot.element = value;
		}else{
			if(value < treeroot.element){
				treeroot.left = insert(value, treeroot.left);
			}else{
				if(value < treeroot.element){
					treeroot.right = insert(value, treeroot.right);
				}
			}
		}
		return treeroot;
	}

	public int countOdds(){
		return countOdds(root);
	}

	private int countOdds(BSTNode treeroot){
		int answer;

		if (treeroot == null) {
			answer = 0;
		} else if (treeroot.element%2 == 0) {
			answer = countOdds(treeroot.right) + countOdds(treeroot.left);
		} else {
			answer = 1 + countOdds(treeroot.right) + countOdds(treeroot.left);
		}
		return answer;
	}

	public int height (){
		if(root == null){
			return -1;
		}else{
			return height(root);
		}
	}

	private int height(BSTNode treeroot){
		int answer;
		if (treeroot == null){ //|| treeroot.left ==null && treeroot.right == null
			answer = 0;
		} else {
			answer = 1 + Math.max(height(treeroot.left), height(treeroot.right));
		}
		return answer;
	}

	public int countLeaves(){
		return countLeaves(root);
	}

	private int countLeaves(BSTNode treeroot){
		int answer;
		if(treeroot == null){
			answer = 0;
		}else if (treeroot.right == null && treeroot.left == null) {
			answer = 1;
		} else {
			answer = countLeaves(treeroot.right) + countLeaves(treeroot.left);
		}
		return answer;
	}

	public countOneChildParents() {
		return countOneChildParents(root);
	}

	private countOneChildParents(BSTNode treeroot) {
		int answer;
		if (treeroot == null) {
			answer = 0;
		} else if ((treeroot.right == null && treeroot.left != null) || (treeroot.left == null && treeroot.right != null)) {
			answer = 1 + countOneChildParents(treeroot.right) + countOneChildParents(treeroot.left);
		} else {
			answer = countOneChildParents(treeroot.right) + countOneChildParents(treeroot.left);
		}

		return answer;
	}
}