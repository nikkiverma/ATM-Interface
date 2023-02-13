import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Machine mc = new Machine();
        mc.login();

    }

}

class Machine {
    Scanner sc = new Scanner(System.in);
    int totalamount = 2000;
    boolean machine = true;
    int withdraw_amt, deposite_amt, transfer_amt, transaction = 0;

    void login() {

        int userid = 1221, password = 2390;

        System.out.println("\n\t\t\t\tWelcome to ATM Machine of Oasis....");

        System.out.println("\n\n\nEnter your id:");
        int id = sc.nextInt();
        System.out.println("Enter your password:");
        int pass = sc.nextInt();

        if (id == userid && pass == password) {
            System.out.println("Logined successfully!!!!");
            menu();
        } else {
            System.out.println("Login Failed!!!!\nPlease Enter Correct Details");
            login();

        }
    }

    void menu() {
        do {

            System.out.println(
                    "Enter your choise:\n\t1.Transaction history\n\t2.Withdraw\n\t3.Deposite\n\t4.Transfer\n\t5.Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    transaction();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposite();
                    break;
                case 4:
                    transfermoney();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid number.....");
                    menu();
            }
        } while (machine);

    }

    void transaction() {
        if (transaction == 0) {
            System.out.println("You did not do any transaction yet..");
        } else {
            System.out.println("Deposite amount:" + deposite_amt);
            System.out.println("withdraw amount:" + withdraw_amt);
            System.out.println("transfer amount:" + transfer_amt);

        }

    }

    void withdraw() {
        System.out.println("Enter amount you want to withdraw:");
        withdraw_amt = sc.nextInt();
        if (withdraw_amt > totalamount) {
            System.out.println("Insufficient amount!!!!");
            // menu();
        } else {

            totalamount -= withdraw_amt;
            transaction++;
            System.out.println("Thank you!!!!\nCollelct your money.... \nNow Your current balance is " + totalamount);
        }

    }

    void deposite() {
        System.out.println("Enter amount you want to deposite:");
        deposite_amt = sc.nextInt();
        totalamount += deposite_amt;
        transaction++;
        System.out.println("Thank you!!!!\nYour current balance is " + totalamount);

    }

    void transfermoney() {
        System.out.println("Enter amount you want to transfer:");
        transfer_amt = sc.nextInt();
        if (transfer_amt > totalamount) {
            System.out.println("Insufficient amount!!!!!");

        } else {

            System.out.println("Enter account number:");
            int acc = sc.nextInt();
            totalamount -= transfer_amt;
            transaction++;
            System.out.println("Transfer success!!!!\nMoney transfered to account no. " + acc
                    + "\nYour current balance is " + totalamount);

        }
    }

}
