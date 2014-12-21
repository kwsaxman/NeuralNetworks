import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) {
		String filename = "comparison.nn";
		try {
			NeuralNetwork nn = NeuralNetwork.createFromFile(filename);
			nn.toFile("comparions-copy.nn");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
