public interface StackInterface {

    public void push(Object newEntry);  //add a new entry to the top of the stack

	public Object pop();                //remove and return the top of the stack
	
	public Object peek();               //retrieve the top of the stack
	
	public boolean isEmpty();           //determine whether the stack is empty
	
	public void clear();                //remove all entries from the stack
}