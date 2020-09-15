package bankserver;


//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface bankInterface extends Remote {
    List<Customer> getMillionaires() throws RemoteException;
    String sayHello(String e)throws RemoteException;
    public void createNewCustomer(String name )throws RemoteException;
    public int getSizeofDatabase() throws RemoteException;



}
