/**
 * @author Kevin Saxman
 * 
 */
public class Node {

	private NodeType	type;
	private NodeValue	value;
	private final int	index;

	private int[]		outputs;

	/**
	 * Constructor.
	 * 
	 * @param type START, MIDDLE, or END
	 * @param value POSTIVE or NEGATIVE
	 * @param index the index in the ArrayList of the NeuralNetwork
	 * @param outputs postions of connected output nodes
	 */
	public Node(NodeType type, NodeValue value, int index, int[] outputs) {
		setType(type);
		setValue(value);
		this.index = index;
		setOutputs(outputs);
	}

	/**
	 * This function returns the output of the node given the input
	 * 
	 * @param input array of integers
	 * @return output
	 */
	public int execute(int[] input) {
		if (value == NodeValue.POSITIVE) {
			return sum(input);
		} else {
			return negate(sum(input));
		}
	}

	/**
	 * This function returns the output of the node given an input
	 * 
	 * @param input integer
	 * @return output
	 */
	public int execute(int input) {
		if (value == NodeValue.POSITIVE) {
			return input;
		} else {
			return negate(input);
		}
	}

	private static int sum(int[] input) {
		int sum = 0;
		for (int i : input) {
			sum += i;
		}
		return sum;
	}

	private static int negate(int input) {
		return 0 - input;
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

	/**
	 * @return
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @return the ouputs
	 */
	public int[] getOutputs() {
		return outputs;
	}

	/**
	 * @param ouputs the ouputs to set
	 */
	public void setOutputs(int[] ouputs) {
		this.outputs = ouputs;
	}

	@Override
	public String toString() {
		String string = type.toString() + "\t" + value.toString() + "\t"
						+ this.index;
		for (int i = 0; i < outputs.length; i++) {
			string += "\t" + outputs[i];
		}
		return string;
	}
}
