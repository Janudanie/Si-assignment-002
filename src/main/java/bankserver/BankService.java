package bankserver;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


@RestController
public class BankService extends UnicastRemoteObject implements bankInterface{
    BankDb databaseConnection = new BankDb();

    BankService() throws RemoteException{}


    @Override
    public List<Customer> getMillionaires() {
        return null;
    }

    public String sayHello(String e){

        databaseConnection.getSize();
        return "Hello " + e;
    }

    @Override
    public void createNewCustomer(String name) throws RemoteException {
        databaseConnection.insertNewCustomer(name);
    }

    @Override
    public int getSizeofDatabase() throws RemoteException {
        return databaseConnection.getDatabaseSize();
    }


}
