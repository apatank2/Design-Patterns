package troubleShootSearch.util;

public class Results implements FileDisplayI {
	private FileProcessor fileProcessor;
	
	public Results()
	{
		fileProcessor = new FileProcessor();
	}
	
	@Override
	public void write(String txt, String outputFile) {
		// TODO Auto-generated method stub
		fileProcessor.FileWriter(txt, outputFile);
	}
	
}
