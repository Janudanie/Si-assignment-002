package bankserver;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class BankServer {

    public static Registry registry;

    public static void main(String[] args) {

        try {
            System.out.println("RMI server localhost starts");

            // Create a server registry at default port 1099
            registry = LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry created ");

            BankService remoteEngine = new BankService();

            String engineName = "BankServices";




            Naming.rebind("//localhost/" + engineName, remoteEngine);
            System.out.println("Engine " + engineName + " bound in registry");
        }
        catch (Exception e){
            System.out.println("error : " + e);
        }
    }

}
