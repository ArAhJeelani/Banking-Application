import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double balance=0;
        
        boolean isRunning = true;
        int choice;
        ArrayList<String> transactionHistory = new ArrayList<String>();

        do{
        System.out.println("\nBANKING PROGRAM\n\nWhat would you like to do\n1.Show Balance\n2.Depost Money\n3.Withdraw\n4.Transeraction History\n5. Quit");
        choice = input.nextInt(); 
        if (choice==1){
           balance = show(balance);
        }
        else if (choice==2){
           balance = deposit(balance, transactionHistory);
        }
        else if (choice==3){
           balance = withdraw(balance, transactionHistory); 
        }
        else if (choice==4){
           transeractionHistory(balance, transactionHistory); 
        }
        else if (choice==5){
            isRunning = false;
        }
    }while (isRunning);
    }
    public static double show(double balance){
        Scanner input = new Scanner(System.in);
        String value, accept;
        int rand = (int)(10*Math.random())+1;
        int rand1 = (int)(16*Math.random())+1;
        int rand2 = (int)(50000*Math.random())+20000;
        System.out.print("\nYour balance: " + balance);
        if (balance>10000){
        System.out.print("\nWould you like to take a loan: ");
        value = input.next();
        while(!value.equalsIgnoreCase("yes") && !value.equalsIgnoreCase("No")){
            System.out.print("\nERROR! Would you like to take a loan: ");
        }
        if(value.equalsIgnoreCase("yes")){
            System.out.print("\nThe Bank if Offering you a loan of " + rand2 + " With a percent rate of " + rand + " % for a span of " + rand1 + " months");
            System.out.print("\nDo you Accept: ");
            accept = input.next();
            while (!accept.equalsIgnoreCase("Yes") && !accept.equalsIgnoreCase("No")){
                System.out.print("\nERROR Do you Accept: ");
                accept = input.next();
            }
            if (accept.equalsIgnoreCase("Yes")){
                double monthlyRate = (rand / 100.0) / 12; // Convert annual % to monthly decimal
                double Annual = (monthlyRate * rand2) / (1 - Math.pow(1 + monthlyRate, -rand1));
                System.out.print("Your Annual Pay for your Loan " + Annual + ". It has been subracted from your balance. And your loan of " + rand2 +  " has been added.");
                balance = balance + rand2 - Annual;
                }
        }
       }
       return balance;
    }
      public static double deposit(double balance, ArrayList<String> transactionHistory){
        Scanner input = new Scanner(System.in);
        double value;
        System.out.print("\nHow much money would you like to deposit(Less than 10000): ");
        value = input.nextDouble();
        while(value<=0){
            System.out.print("\nERROR !You can't make this deposit!\nTry Again: ");
            value = input.nextInt();
        }
        balance = balance + value;
        if (value>=10000){
            System.out.print("\nYou have exceeded the Bank's limit of deposit" );
            balance -= value;
        }
        transactionHistory.add("Deposited: $" + value);
        return balance;
  

      }
      public static double withdraw(double balance, ArrayList<String> transactionHistory){
        Scanner input = new Scanner(System.in);
        double value;
        System.out.print("\nHow much money would you like to withdraw: ");
        value = input.nextDouble();
        while(value>balance){
            System.out.print("\nRROR! You can't make this withdraw!\nTry Again: ");
            value = input.nextInt();
        }
        balance -= value;
        transactionHistory.add("Withdraws: $" + value);
        return balance;
      }
      public static void transeractionHistory(double balance, ArrayList<String> transactionHistory){
        if (transactionHistory.isEmpty()) {
            System.out.println("\nNo transactions yet.");
      }
      else if (true) {
        for (int x=0;x<transactionHistory.size(); x++){
           System.out.print("\n" + (x+1) + " Transaction: " + transactionHistory.get(x));
        }
          
      }
    }
    }

