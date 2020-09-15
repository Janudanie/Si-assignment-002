package bankclient;

import bankserver.*;

import java.rmi.Naming;
import java.util.List;

public class BankClient {



    public static void main(String[] args)throws Exception {
        String remoteEngine = "rmi://localhost/BankServices";


        bankInterface obj = (bankInterface) Naming.lookup(remoteEngine);



        /*obj.createNewCustomer("alex");
        obj.createNewCustomer("brian");
        obj.createNewCustomer("jacob");
        obj.createNewCustomer("hansen");
        obj.createNewCustomer("jensen");*/
        System.out.println("Size of database is " + obj.getSizeofDatabase() + " KB");
    }





}
