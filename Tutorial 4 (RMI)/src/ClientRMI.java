import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientRMI 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String input;
		
		try {
			System.setSecurityManager(new RMISecurityManager());
			System.out.println("Looking for the remote object in the registry");
			InterfaceRMI serverStub = (InterfaceRMI) Naming.lookup("rmi://localhost:" + ServerRMI.port + "/RemoteObj");
			System.out.println("Server stub returned");
			while(true)
			{
				System.out.print(">>");
				input = scanner.nextLine();
				System.out.println("Server skeleton and server stub communicating");
				System.out.println(serverStub.method(input));
			}
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException: " + e.getMessage());
		} catch (RemoteException e) {
			System.out.println("RemoteException: " + e.getMessage());
		} catch (NotBoundException e) {
			System.out.println("NotBoundException: " + e.getMessage());
		}
	}
}
