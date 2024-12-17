import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

public class TrimFirstCharactersOfFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileToString = FileUtils.readFileToString(new File("d://1AstraZeneca//manifestdeployissue.json"), Charset.defaultCharset());
		String[] split = fileToString.split("\n");
		for (int i = 0; i < split.length; i++) {
			String line = split[i];
	
			String substring = line.substring(28, line.length());
			System.out.println(substring);

		}
	}

}
