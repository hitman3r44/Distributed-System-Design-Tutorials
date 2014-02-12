package IDLmap;

import org.omg.CORBA.ORB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class clientIDL 
{

	public static void main(String[] args) throws IOException
	{
		// Initialize the ORB object
		ORB orb = ORB.init(args, null);
		// Get the reference to the CORBA object from the file
		BufferedReader bufferedReader = new BufferedReader(new FileReader("CORBA.txt"));
		String stringORB = bufferedReader.readLine();
		bufferedReader.close();
		// Transform the reference string to CORBA object
		org.omg.CORBA.Object reference_CORBA = orb.string_to_object(stringORB);
		sampleInterface aSampleInterface = sampleInterfaceHelper.narrow(reference_CORBA);
		// Call the method
		aSampleInterface.method();
	}

}
