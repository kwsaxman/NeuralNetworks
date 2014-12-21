import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author Kevin Saxman
 * 
 */
public class NeuralNetwork {

	private final ArrayList<LinkedList<Node>>	adjacencyList;

	/**
	 * Default Constructor. Creates an empty network.
	 */
	public NeuralNetwork() {
		adjacencyList = new ArrayList<LinkedList<Node>>();
	}

	/**
	 * Constructor. Creates an empty network.
	 * 
	 * @param length
	 */
	public NeuralNetwork(int length) {
		adjacencyList = new ArrayList<LinkedList<Node>>(length);
		for (int i = 0; i < length; i++) {
			adjacencyList.add(i, new LinkedList<Node>());
		}
	}

	/**
	 * @param network
	 */
	public NeuralNetwork(NeuralNetwork network) {
		adjacencyList = network.getAdjacencyList();
	}

	/**
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static NeuralNetwork createFromFile(String filename)
																throws FileNotFoundException {
		NeuralNetwork nn = new NeuralNetwork();
		File file = new File(filename);
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String type = input.next();
			String value = input.next();
			int index = input.nextInt();
			ArrayList<Integer> outputsList = new ArrayList<Integer>();
			while (input.hasNextInt()) {
				outputsList.add(input.nextInt());
			}
			int[] outputs = new int[outputsList.size()];
			for (int i = 0; i < outputsList.size(); i++) {
				outputs[i] = outputsList.get(i);
			}
			Node node = new Node(NodeType.valueOf(type),
									NodeValue.valueOf(value), index, outputs);
			nn.addNode(node, index);
		}
		input.close();
		return nn;
	}

	public int[] executeNetwork(int[] userInputs) {
		int[] inputs = userInputs;
		if (inputs.length != adjacencyList.get(0).size()) {
			return null;
		}
		for (int i = 0; i < adjacencyList.size(); i++) {
			ListIterator<Node> listIterator = adjacencyList.get(i)
															.listIterator();
			while (listIterator.hasNext()) {
				Node node = listIterator.next();
				// TODO: next
			}

		}
		return inputs;
	}

	/**
	 * @param filename
	 * @return
	 */
	public boolean toFile(String filename) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(filename, "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		for (int i = 0; i < adjacencyList.size(); i++) {
			ListIterator<Node> listIterator = adjacencyList.get(i)
															.listIterator();
			while (listIterator.hasNext()) {
				writer.println(listIterator.next().toString());
			}
		}
		writer.close();
		return true;
	}

	/**
	 * 
	 * @param node
	 * @param index
	 */
	public void addNode(Node node, int index) {
		if (index >= adjacencyList.size()) {
			adjacencyList.add(index, new LinkedList<Node>());
		} else if (adjacencyList.get(index) == null) {
			adjacencyList.add(index, new LinkedList<Node>());
		}
		adjacencyList.get(index).add(node);
	}

	/**
	 * @return the adjacencyList
	 */
	public ArrayList<LinkedList<Node>> getAdjacencyList() {
		return adjacencyList;
	}

}
