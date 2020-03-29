
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class DuplicateCounter {
	Map<String, Integer> words = new HashMap<String, Integer>();

	void count(String input) {
		Scanner in = null;
		try {
			in = new Scanner(new File(input));

			while (in.hasNextLine()) {
				String line = in.nextLine();
				String[] splitLine = line.split(" ");
				for (int i = 0; i < splitLine.length; i++) {
					String str = splitLine[i].toLowerCase();
					Integer freq = words.get(str);
					words.put(str, (freq == null) ? 1 : freq + 1);
				}
			}
		} catch (Exception e) {
			System.out.println("There has been an error. GoodBye.");
		}
		in.close();

	}

	void write(String output) {
		FileWriter out = null;
		try {
			out = new FileWriter(output);

			for (Entry<String, Integer> e : words.entrySet())
				out.write(e.getKey() + ": " + e.getValue() + "\n");
			out.close();
		} catch (Exception e1) {
			System.out.println("There has been an error. GoodBye.");
		}
	}
}
