import java.lang.Math.*;

public class L10_BasicBST{
	private class BSTNode{
		int element;
		BSTNode left;
		BSTNode right;

		public BSTNode(int item){
			this.element = item;
			this.left = null;
			this.right = null;
		}
	}

	private BSTNode root;

	public L10_BasicBST(){
		root = null;
	}

	// use recursion

	public void insert(int item){
		root = insert(item,root);
	}

	private BSTNode insert(int item, BSTNode treeroot){
		if(treeroot == null){
			treeroot = new BSTNode(item);
		}else{
			if(item < treeroot.element){
				treeroot.left = insert(item,treeroot.left);
			}else{
				treeroot.right = insert(item,treeroot.right);
			}
		}
		return treeroot;
	}

	public int countOdds(){
		return countOdds(root);
	}

	private int countOdds(BSTNode treeroot){
		int answer;

		if (treeroot == null){
			answer = 0;
		}else{

			if(treeroot.left != null && (treeroot.left.element % 2 != 0)){
				answer = countOdds(treeroot.left) + 1;
			}

			if(treeroot.right != null && (treeroot.right.element % 2 != 0)){
				answer = countOdds(treeroot.right) + 1;
			}
		}
		return answer;
	}

	public int height(){
		if(root == null){
			return -1;
		}else{
			return height(root) -1 ;	
		}
		
	}

	private int height(BSTNode treeroot){
		int result;
		if(treeroot == null){
			result = 0;
		}else{
			result = 1 + Math.max(height(treeroot.left),height(treeroot.right));
		}
		return result;
	}

	public int countLeaves(){
		return countLeaves(root);
	}

	private int countLeaves(BSTNode treeroot){
		int leaves;

		if(treeroot == null){
			leaves = 0;
		}else{
			if(treeroot.right == null && treeroot.left == null){ // if both its childeren are null then it is a leaf
				leaves = 1; // how does this add up? you are just assigning it, shouldnt it be +=?
			}else{
				leaves = countLeaves(treeroot.left) + countLeaves(treeroot.right); // each time it's called both values can only be one...this is where the recursion adds them i believe
			}
		}
		
		return leaves;

	}

	public int countOneChildParents(){
		return countOneChildParents(root);
	}

	private int countOneChildParents(BSTNode treeroot){
		int result;
		if(treeroot == null){
			return 0;
		}else {
			if((treeroot.left != null && treeroot.right == null) || (treeroot.left == null && treeroot.right != null)){
				result = 1;
			}else{
				result = countOneChildParents(treeroot.left) + countOneChildParents(treeroot.right);
			}
		}
		return result;
	}
}