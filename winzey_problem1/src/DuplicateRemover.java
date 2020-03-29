import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
	Set<String> words;

	void remove(String input)

	{
		words = new LinkedHashSet<>();
		Scanner in = null;
		try {
			in = new Scanner(new File(input));

			while (in.hasNextLine()) {
				String line = in.nextLine();
				String[] splitLine = line.split(" ");
				for (int i = 0; i < splitLine.length; i++) {
					String str = splitLine[i].toLowerCase();
					words.add(str);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("There has been an error. GoodBye.");
		}
		in.close();
	}

	void write(String output) {
		FileWriter out = null;
		try {
			out = new FileWriter(output);

			for (String s : words)
				out.write(s + "\n");
			out.close();
		} catch (IOException e) {
			System.out.println("There has been an error. GoodBye.");
		}
	}
}
