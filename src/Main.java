import javax.swing.JOptionPane;
public class Main {
    static String username, password;
    static int i;

    //setting all the initial values
    static float withdrawal = 0, withdrawn = 0, deposit = 0, deposited = 0, oldBalance = 3000, newBalance = 3000;

    // -------------- MAIN FUNCTION
    public static void main(String[] args) {
        int choice = 0;
        while (choice != 3) {
            String[] options = {"Create Account", "Login","Reset Password", "Quit"};
            choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    createAccount();
                    break;
                case 1:
                    Login();
                    break;
                case 2:
                    resetPassword();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "GOODBYE");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
                    break;
            }
        }
    }

    // -------------- CREATE ACCOUNT METHOD
    static void createAccount() {
        for(int p = 1; p > 0 ; p++) {
            username = JOptionPane.showInputDialog("Enter a username:");
            password = JOptionPane.showInputDialog("Enter a password:");
            if(username.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(null, "PLEASE ENTER A VALID USERNAME OR PASSWORD");
            }
            else {
                JOptionPane.showMessageDialog(null, "Account created successfully!");
                break;
            }
        }
    }

    // -------------- LOGIN METHOD
    static void Login(){
        JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR CREDENTIALS TO LOGIN");

        String newUsername = JOptionPane.showInputDialog(null, "PLEASE ENTER YOUR USERNAME");
        String newPassword = JOptionPane.showInputDialog(null, "PLEASE ENTER YOUR PASSWORD");

        if(newUsername.equals(username) && newPassword.equals(password) ) {
            menu();
        }
        else {
            JOptionPane.showMessageDialog(null, "userName or password does not match");
        }
    }

    // -------------- RESET PASSWORD METHOD
    static void resetPassword() {
        if (username == null || password == null) {
            JOptionPane.showMessageDialog(null, "Account not created yet!");
        } else {
            String currentUserName = JOptionPane.showInputDialog("Enter your username:");
            if (!currentUserName.equals(username)) {
                JOptionPane.showMessageDialog(null, "Incorrect userName!");
            } else {
                String newPassword = JOptionPane.showInputDialog("Enter new password:");
                password = newPassword;
                JOptionPane.showMessageDialog(null, "Password reset successful!");
            }
        }
    }

    // -------------- DEPOSIT METHOD
    static void Deposit() {
        try {
            deposit = Float.parseFloat(JOptionPane.showInputDialog("How much would you like to deposit in Ghc? "));
            if (deposit < 0) {
                JOptionPane.showMessageDialog(null,"You can not deposit that amount. enter a valid Amount");
            }
            else {
                String confirmPassword = JOptionPane.showInputDialog(null, "PLEASE ENTER YOUR PASSWORD");
                if (confirmPassword.equals(password)){
                    oldBalance = newBalance;
                    newBalance += deposit;
                    deposited += deposit;
                    JOptionPane.showMessageDialog(null, "You have deposited " + deposit + "Ghc");
                }
                else {
                    JOptionPane.showMessageDialog(null,"incorrect password");
                }
            }
        } catch (Exception var2) {
            JOptionPane.showMessageDialog(null, "Error!\nEnter a valid number or press 5 to exit");
        }
    }

    // -------------- CHECK BALANCE METHOD
    static void checkBalance() {
        try {
            String newPassword = JOptionPane.showInputDialog(null, "PLEASE ENTER YOUR PASSWORD");

            if(newPassword.equals(password) ) {
                JOptionPane.showMessageDialog(null, "You now have " + newBalance + "Ghc\nOld balance is " + oldBalance + "Ghc");
            }
            else {
                JOptionPane.showMessageDialog(null, "userName or password does not match");
            }

        } catch (Exception var1) {
            JOptionPane.showMessageDialog(null, "Error!\nEnter a valid number or press 5 to exit");
        }
    }

    // -------------- WITHDRAW METHOD
    static void Withdraw() {
        try {
            withdrawal = (float) Integer.parseInt(JOptionPane.showInputDialog("How much would you like to withdraw?"));
            String newPassword = JOptionPane.showInputDialog(null, "PLEASE ENTER YOUR PASSWORD");

            if(newPassword.equals(password) ) {
                if (newBalance >= withdrawal) {
                    oldBalance = newBalance;
                    newBalance -= withdrawal;
                    withdrawn += withdrawal;
                    JOptionPane.showMessageDialog(null, "Withdrawal Successful! (:\nYou have withdrawn " + withdrawal + "Ghc");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient Funds! ):");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "userName or password does not match");
            }

        } catch (Exception var1) {
            JOptionPane.showMessageDialog(null, "Error!\nEnter a valid number or press 5 to exit");
        }
    }

    // -------------- SUMMARY METHOD
    static void Summary() {
        String newPassword = JOptionPane.showInputDialog(null, "PLEASE ENTER YOUR PASSWORD");
        if(newPassword.equals(password) ) {
            JOptionPane.showMessageDialog(null, username + ", you have deposited " + deposited + "Ghc.\nYou have withdrawn " + withdrawn + "Ghc.\nYour old balance is " + oldBalance + "Ghc.\n Your new balance is " + newBalance + "Ghc.");
        }
        else {
            JOptionPane.showMessageDialog(null, "userName or password does not match");
        }
    }

    // -------------- MENU METHOD
    static void menu(){
        do {
            try {

                i = Integer.parseInt(JOptionPane.showInputDialog("Welcome " + username + "!\nWhat would you like to do? \n" +
                        "Enter 1: Deposit\n" +
                        "Enter 2: Check Balance\n" +
                        "Enter 3: Withdraw\n" +
                        "Enter 4: Summary\n" +
                        "Enter 5: Exit"));
                switch (i) {
                    case 1:
                        Deposit();
                        break;
                    case 2:
                        checkBalance();
                        break;
                    case 3:
                        Withdraw();
                        break;
                    case 4:
                        Summary();
                        break;
                    case 5:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "ERROR, retry");
                        break;
                }
            } catch (Exception var2) {
                JOptionPane.showMessageDialog(null, "Error!\nEnter a valid number or press 5 to exit");
            }}
        while(i !=5);
        JOptionPane.showMessageDialog(null, " Goodbye " + username + "!");
    }
}