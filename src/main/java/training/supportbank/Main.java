package training.supportbank;

import java.io.File; // import file class
import java.io.FileNotFoundException; //error handeler
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Scanner to read text file


public class Main {
    public static void main(String args[]) {


        // be able to read csv file
        //reformat code

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to SupportBank! You have these command options: \n - (1) List All \n - List [Account]");
        String command = inputScanner.nextLine();
        ///to-do add if statement for list all and list account
        List<Transaction> transactions = populateTransactions();
        List<Account> accounts = createEmptyAccounts(transactions);

        //  for (Transaction transaction : transactions) {
        //      System.out.println(transaction);

        //   }
        for (Account account : accounts) {
            List<Transaction> transactionsList = getTransactionsForAccount(transactions, account);
            System.out.println(transactionsList);

        }


    }


    //Step 4
    // Create list of accounts


    // step 5
    //run through each trans action

    private static boolean doesAccountExist(List<Account> accounts, String name) {
        for (Account account : accounts) {
            if (account.name.equals(name)) {
                return true;
            }


        }
        return false;
    }


    private static List<Account> createEmptyAccounts(List<Transaction> transactions) {
        ArrayList<Account> accounts = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (doesAccountExist(accounts, transaction.from) == false) {
                Account account = new Account(transaction.from);
                accounts.add(account);

            }
            if (doesAccountExist(accounts, transaction.to) == false) {
                Account account = new Account(transaction.to);
                accounts.add(account);
            }

        }
        return accounts;
    }

    private void addAndRemoveBalance() {


    }

    private static List<Transaction> getTransactionsForAccount(List<Transaction> transactions, Account account) {
        ArrayList<Transaction> accountTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.from.equals(account.name)) {
                accountTransactions.add(transaction);
            }
            if (transaction.to.equals(account.name)) {
                accountTransactions.add(transaction);
            }
        }
        return accountTransactions;
    }

    private static List<Transaction> populateTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            File file = new File("csv/Transactions2014.csv"); // creating a varible and calling it file and assignign the info from the txt to the file
            Scanner fileScanner = new Scanner(file); // scanner are for reading string , called it a varible called my reader

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();


                List<String> list = Arrays.asList(data.split(","));

                Transaction transaction = new Transaction(list.get(0), list.get(1), list.get(2), list.get(3), Float.parseFloat(list.get(4)));
                transactions.add(transaction);
            }
            fileScanner.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return transactions;
    }

}