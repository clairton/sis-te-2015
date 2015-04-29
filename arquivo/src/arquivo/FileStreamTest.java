package arquivo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.junit.Test;

public class FileStreamTest {

	/**
	 * @throws IOException
	 */
	/**
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		Path p = new File("src/arquivo/arquivo.txt").toPath();
		Stream<String> lines = Files.lines(p);
		lines.filter(
			l -> l.startsWith("a")
		).forEach(System.out::println);
	}

}
