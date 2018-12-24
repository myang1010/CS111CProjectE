import java.util.*;

public class BinarySearchTreeWithDups<T extends Comparable<? super T>> extends BinarySearchTree<T>
implements SearchTreeInterface<T>, java.io.Serializable {

	public BinarySearchTreeWithDups() {
		super();
	}

	public BinarySearchTreeWithDups(T rootEntry) {
		super(rootEntry);
		setRootNode(new BinaryNode<T>(rootEntry));
	}

	@Override
	public T add(T newEntry) {
		T result = newEntry;
		if (isEmpty()) {
			setRootNode(new BinaryNode<T>(newEntry));
		} else {
			addEntryHelperNonRecursive(newEntry);
		}
		return result;
	}

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	private void addEntryHelperNonRecursive(T newEntry) {
		BinaryNodeInterface<T> currentNode = getRootNode();
		assert currentNode != null;
		boolean found = false;

		while (!found){
			T currentEntry = currentNode.getData();
			int comparison = newEntry.compareTo(currentEntry);

			if(comparison == 0){

				if (currentNode.hasLeftChild()){
					currentNode = currentNode.getLeftChild();						
				}
				else {
					found = true;
					currentNode.setLeftChild(new BinaryNode<T>(newEntry));
				}	
			}

			else if (comparison < 0){
				if (currentNode.hasLeftChild())
					currentNode = currentNode.getLeftChild();
				else{
					found = true;
					currentNode.setLeftChild(new BinaryNode<T>(newEntry));
				}
			}

			else {
				assert comparison > 0 ;
				if (currentNode.hasRightChild())
					currentNode = currentNode.getRightChild();
				else {
					found = true;
					currentNode.setRightChild(new BinaryNode<T>(newEntry));
				}
			}
		}
	}

	// YOUR CODE HERE! THIS METHOD CANNOT BE RECURSIVE.
	public int countEntriesNonRecursive(T target) {
		// this initial code is meant as a suggestion to get your started- use it or delete it!
		int count = 0;
		BinaryNodeInterface<T> currentNode = getRootNode();

		while (currentNode != null){
			T currentEntry = currentNode.getData();
			int comparison = target.compareTo(currentEntry);

			if (comparison == 0){
				count++;
				currentNode = currentNode.getLeftChild();
			}
			else if (comparison < 0){
				currentNode = currentNode.getLeftChild();
			}	
			else{	
				currentNode = currentNode.getRightChild();
			}
		}			

		return count;
	}

	// this method is from Kevin Zhou
	public int countGreaterRecursive(T target) {

		BinaryNodeInterface<T> rootNode = getRootNode();

		return countGreaterRecursiveHelper(rootNode, target);
	}

	private int countGreaterRecursiveHelper(BinaryNodeInterface<T> node, T target) {

		int count = 0;

		if(node != null) {

			//If greater than desired number, add to count
			if(target.compareTo(node.getData()) < 0) {              
				count++;//Adding count
			}

			if(node.hasLeftChild()) {
				//After adding count, recursive call the left Child to add all numbers greater on left Child
				count = count + countGreaterRecursiveHelper(node.getLeftChild(), target);
			}

			if(node.hasRightChild()) {
				//After adding count, recursive call the right Child to add all numbers greater on right Child
				count = count + countGreaterRecursiveHelper(node.getRightChild(), target);
			}
		}

		else {
			//Return 0 if the node is null
			return 0;
		}

		return count;
	}

	// YOUR CODE HERE! MUST BE USE A STACK!! 
	public int countGreaterWithStack(T target) {
		int count = 0;
		BinaryNodeInterface<T> rootNode = getRootNode();
		Stack<BinaryNodeInterface<T>> nodeStack = new Stack<BinaryNodeInterface<T>>();
		nodeStack.push(rootNode);

		while (!nodeStack.isEmpty()&&rootNode!=null){
			BinaryNodeInterface<T> topStack = nodeStack.pop();

			if (topStack.hasLeftChild())
				nodeStack.push(topStack.getLeftChild());
			if (topStack.hasRightChild())
				nodeStack.push(topStack.getRightChild());
			if (target.compareTo(topStack.getData())<0)
				count++;
		}
		return count;
	}

	// YOUR EXTRA CREDIT CODE HERE! THIS METHOD MUST BE O(n).
	public int countUniqueValues() {
		HashSet<T> hashTable = new HashSet<T>(); 
		return countUniqueValuesHelper(getRootNode(), hashTable);
	}

	private int countUniqueValuesHelper(BinaryNodeInterface<T> root, HashSet<T> hashTable){ 

		if (root!=null){
			hashTable.add(root.getData());
			countUniqueValuesHelper(root.getLeftChild(),hashTable);
			countUniqueValuesHelper(root.getRightChild(),hashTable);
		}		
		return hashTable.size();
	} 

	public int getLeftHeight() {
		BinaryNodeInterface<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasLeftChild()) {
			return 0;
		} else {
			return rootNode.getLeftChild().getHeight();
		}
	}

	public int getRightHeight() {
		BinaryNodeInterface<T> rootNode = getRootNode();
		if(rootNode==null) {
			return 0;
		} else if(!rootNode.hasRightChild()) {
			return 0;
		} else {
			return rootNode.getRightChild().getHeight();
		}
	}
}