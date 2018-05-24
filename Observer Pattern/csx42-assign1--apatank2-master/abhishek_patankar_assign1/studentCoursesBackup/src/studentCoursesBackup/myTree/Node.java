package studentCoursesBackup.myTree;
import java.util.ArrayList;
import java.util.List;
public class Node implements ObserverI,SubjectI{
	private ArrayList<ObserverI> observers = new ArrayList<ObserverI>();
	private int bnumber;
	private Node left;
	private Node right;
	public String key;
	public List<String> courses = new ArrayList<String>();
	public Node() {
	}
	/**
	 * Constructor
	 * @param bno :- Bnumber
	 * @param Course :- Course
	 */
	public Node(int bno,String Course)
	{
		this.bnumber = bno;
		SetCourse(Course,Operations.INSERT);
	}
	/**
	 * Register the observers
	 */
	public void RegisterObserver(ObserverI o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}
	/**
	 * Remove the observers
	 */
	public void RemoveObserver(ObserverI o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}
	/**
	 * Sets the Bnumber
	 * @param bno
	 * @param Course
	 */
	public void SetBno(int bno,String Course)
	{
		this.bnumber = bno;
	}
	/**
	 * Sets the right child
	 * @param right
	 */
	public void SetRight(Node right)
	{
		this.right = right;
	}
    /**
     * Sets the left child
     * @param left
     */
	public void SetLeft(Node left)
	{
		this.left = left;
	}
    /**
     * Get the respective Bnumber for the Node
     * @return
     */
	public int GetBno()
	{
		return this.bnumber;
	}
   /**
    * Get Right Child
    * @return
    */
	public Node GetRight()
	{
		return this.right;
	}
   /**
    * Get Left Child
    * @return
    */
	public Node GetLeft()
	{
		return this.left;
	}
	/**
	 * Set Courses for the respective Bnumbers
	 * @param Course
	 * @param op :- Insert or Update
	 */
	public void SetCourse(String Course,Operations op)
	{
		int dup_cnt = 0;
		
		if (op == Operations.INSERT)
		{
		for (int i = 0; i < courses.size(); i++) {
			
			if (courses.get(i).equals(Course))
		      {
		          dup_cnt = 1;
		      }
		}
		
		if (dup_cnt == 0)
		{
			courses.add(Course); 
		}
		}
		else if (op == Operations.UPDATE)
		{
			for (int i = 0; i < courses.size(); i++) {
				
				if (courses.get(i).equals(Course))
			      {
			          dup_cnt = 1;
			      }
			}
			
			if (dup_cnt == 1)
			{
				courses.remove(Course); 
			}
			
		}
		
		
	}
	/**
	 * Returns all the courses corresponding
	 * Bnumber has registered
	 */
	public String GetCourse()
	{
		
		String rtn_key1 = null;
		int loop_cnt=0;
		for (int i = 0; i < courses.size(); i++) {
			 if (loop_cnt>0)
					{
					rtn_key1 = rtn_key1+" "+courses.get(i);
					}
					else
					{
						rtn_key1 = courses.get(i);
					}
					loop_cnt = loop_cnt + 1;
		}
		return rtn_key1;
	}
	/**
	 * Notify all the Observers
	 */
	public void notifyObservers(String Course,Operations Operation_Type)
	{
			for (ObserverI o : observers) {
		         o.update(Course,Operation_Type);
		      }
	}
	/**
	 * Following method is call whenever any update
	 * is done on the node of the original tree
	 * All the registered observers are notified regarding the same.
	 */
	public void update(String Course,Operations Operation_Type)
	{
		
		   SetCourse(Course,Operation_Type);
	}
	/**
	 * Notify all the observes if any changes are done in original tree.
	 * @param Course :- Courses for that Bnumber
	 * @param Operation_Type :- Inserting the New Course or Deleting the previous course
	 */
	public void CoursesUpdated(String Course,Operations Operation_Type)
	{
		notifyObservers(Course,Operation_Type);
	}
	
	/**
	 * Overridden method to return Bnumber and Courses for each node.
	 */
	public String toString()
	{
		return "B-Number and Courses assigned for the node is: "+GetBno()+ " " +GetCourse();
	}
	
	
	
	
	
}
