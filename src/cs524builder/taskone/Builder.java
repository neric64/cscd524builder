package cs524builder.taskone;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//=============================================================================================================================================================
/**
 * Creates a builder that reads and executes a component-definition file.
 * 
 * @author Dan Tappan [06.02.13]
 * @author Eric Nielsen [April 2014]
 */
public class Builder
{
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Executes the builder.
	 * 
	 * @param arguments - the fully qualified filename of the definition file
	 */

	private static Blocks block = new Blocks();

	public static void main(final String[] arguments)
	{
		if (arguments.length != 2)
		{
			throw new RuntimeException("usage: input_filename output_filename ");
		}

		try
		{
			BuilderParser parser = new BuilderParser(arguments[0], arguments[1]);

			parser.parse();
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	//Will take some kind of object as input and print to screen
	public static void Export() {

	}

	//Will do some kind of math here, will also take some kind of object for input
	public static void doMath() {

	}

	public static void setVolume(List<String> volume) {
		block.setVolume(volume);
		System.out.println(block.getVolume());
	}

	public static void setComponent(String component) {
		block.setComponent(component);
		System.out.println(block.getComponent());
	}

	public static void setSocket(List<String> socket) {
		block.setSocket(socket);
		System.out.println(block.getSocket());
	}

	public static void setId(String id) {
		block.setId(id);
		System.out.println(block.getId());
	}

	public static void PrintXML(String id) {
		PrintWriter pw = null;
		List<Double> volume = new ArrayList<Double>();
		List<Double> socket = new ArrayList<Double>();

		volume = parseNumFromList(block.getVolume());
		socket = parseNumFromList(block.getSocket());

		try {
			pw = new PrintWriter(new FileWriter("outxml.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.println("<?xml version=\"1.0\"?>");
		pw.println("<component identifier=" + block.getComponent() + ">");
		pw.println("<size>");
		pw.println("<triple x=\"" + volume.get(0) + "\" y=\"" + volume.get(1) + "\" z=\"" + volume.get(2) + "\"/>");
		pw.println("</size>");
		pw.println("<socket>");
		pw.println("<triple x=\"" + socket.get(0) + "\" y=\"" + socket.get(1) + "\" z=\"" + socket.get(2) + "\"/>");
		pw.println("</socket>");
		pw.println("</component>");

		pw.close();
	}
	
	public static void printGnu(String id, List<String> startLoc) {
		List<Double> volume = new ArrayList<Double>();
		List<Double> socket = new ArrayList<Double>();

		volume = parseNumFromList(block.getVolume());
		socket = parseNumFromList(block.getSocket());
		
		
		
		System.out.println("# component [" + block.getComponent() + "] {");
		System.out.println("#top");
		System.out.println(volume.get(0) + ", " + volume.get(1) + ", " + volume.get(2));
	}

	private static List<Double> parseNumFromList(List<String> list) {
		List<String> blockList = list;
		List<Double> doubleList = new ArrayList<Double>();

		
		if(blockList.size() > 3) {
			doubleList.add(Double.parseDouble(blockList.get(2)));
			doubleList.add(Double.parseDouble(blockList.get(3)));
			doubleList.add(Double.parseDouble(blockList.get(4)));
		}
		else {

			for(int i = 0; i < blockList.size(); i++) {
				doubleList.add(Double.parseDouble(blockList.get(i)));
			}
		}

		return doubleList;
	}
}
