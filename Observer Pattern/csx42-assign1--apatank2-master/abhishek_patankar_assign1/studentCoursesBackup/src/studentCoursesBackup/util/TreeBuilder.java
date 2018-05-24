package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.Operations;
import studentCoursesBackup.util.Results;
public class TreeBuilder {
	public Node root;
    /**
     * Constructor
     */
    public TreeBuilder(){};
	/**
	 * Check if Bnumber is already inserted into the tree.
	 * @param bno
	 * @return
	 */
	public boolean FindNode(int bno){
		Node current = root;
		while(current!=null){
			if(current.GetBno()==bno){
				return true;
			}else if(current.GetBno()>bno){
				current = current.GetLeft();
			}else{
				current = current.GetRight();
			}
		}
		return false;
	}
	/**
	 * Print output of the tree using
	 * in-order traversal.
	 * @param tree
	 */
	public void printNode(FileDisplayInterface tree)
	{
		InOrderTraversal(root,(Results)tree);
	}
	/**
	 * Stored the Bnumber and Courses Registered 
	 * in Result instance
	 * @param TraverseNode
	 * @param tree
	 */
	public void InOrderTraversal(Node TraverseNode,Results tree)
	{
		if(TraverseNode!=null)
		{
			InOrderTraversal(TraverseNode.GetLeft(),tree);
			if (TraverseNode.GetCourse() == null)
				tree.Line.add(TraverseNode.GetBno() + ":");
			else
			tree.Line.add(TraverseNode.GetBno() + ":" + " " + TraverseNode.GetCourse());
			InOrderTraversal(TraverseNode.GetRight(),tree);
		}
	}
	
	/**
	 * For every new Bnumber insert the Bnumber
	 * and corresponding Course into the Binary Tree
	 * @param newNode
	 * @param buid
	 * @param Course_Name
	 */
	public void InsertBST(Node newNode,int buid,String Course_Name){
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(buid<current.GetBno()){				
				current = current.GetLeft();
				if(current==null){
					parent.SetLeft(newNode);
					return;
				}
			}else{
				current = current.GetRight();
				if(current==null){
					parent.SetRight(newNode);
					return;
				}
			}
		}
	}
	/**
	 * Find Node in the tree for updation of the Courses.
	 * @param Bno
	 * @return
	 */
	public Node SearchNode(int Bno)
	{
		Node SNode = root;
		while(SNode.GetBno() != Bno)
		{
			if(Bno < SNode.GetBno())
				SNode = SNode.GetLeft();
			else
				SNode = SNode.GetRight();
			if(SNode == null)
				return null;
		}
		return SNode;
	}
	/**
	 * Method to update or delete the Course on 
	 * the basis of Bnumber.
	 * @param bno
	 * @param Course
	 * @param Operation_Type
	 */
	public void UpdateTree(int bno,String Course,Operations Operation_Type){
		Node SearchNode = SearchNode(bno);
		SearchNode.update(Course,Operation_Type);
		SearchNode.CoursesUpdated(Course,Operation_Type);
		
	}
	/**
	 * Overridden method to return Bnumber and Courses for root of the tree.
	 */
	public String toString()
	{
		return "B-Number and Courses for root node is: "+root.GetBno()+ " " +root.GetCourse();
	}
}
