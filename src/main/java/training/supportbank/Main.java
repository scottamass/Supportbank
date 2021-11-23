package training.supportbank;
import java.io.File; // import file class
import java.io.FileNotFoundException; //error handeler
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Scanner to read text file


public class Main {
    public static void main(String args[]) {
        ArrayList<Transaction> transactions = new ArrayList<>();
    // Transaction myTransaction = new Transaction("01/01/11", "jon A", "Sarah T", "pkmn trn", 8.7f);

    // be able to read csv file


                try {
                    Scanner scanner = new Scanner(System.in);
                    File file = new File("csv/Transactions2014.csv"); // creating a varible and calling it file and assignign the info from the txt to the file
                    Scanner myReader = new Scanner(file); // scanner are for reading string , called it a varible called my reader
                    System.out.println("Welcome to SupportBank! You have these command options: \n - List All \n - List [Account]" );
                    String command = scanner.nextLine();
                    myReader.nextLine();
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                    //    System.out.println(data);

                        List<String> list = Arrays.asList(data.split(","));

                        Transaction transaction = new Transaction(list.get(0), list.get(1), list.get(2), list.get(3),Float.parseFloat(list.get(4)));
                        transactions.add(transaction);


                    }

                    myReader.close();
                }
                catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

          //Step 4
        // Create list of accounts



        // step 5
        //run through each trans action

    }

}