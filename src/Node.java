
public class Node {
	
	private NodeType type;
	private NodeValue value;
	
	public Node(){
		setType(NodeType.START);
		setValue(NodeValue.POSITIVE);
	}
	
	public int execute(int[] input){
		if (value == NodeValue.POSITIVE){
			return sum(input);
		} else {
			return negate(input[0]);
		} 
	}
	
	public int execute(int input){
		if (value == NodeValue.POSITIVE){
			return input;
		} else {
			return negate(input);
		} 
	}
	
	private static int sum(int[] input){
		int sum = 0;
		for (int i : input){
			sum += i;
		}
		return sum;
	}
	
	private static int negate(int input){
		return 0 - input;
	}
	
	public Node(NodeType type, NodeValue value){
		this.setType(type);
		this.setValue(value);
	}

	/**
	 * @return the type
	 */
	public NodeType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(NodeType type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public NodeValue getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(NodeValue value) {
		this.value = value;
	}

}
