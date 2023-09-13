
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
// ------------------------------------------POJO-CLASS-------------------------------------------------

class Pojo {

    // Color
    String setRed = "\u001B[31m";
    String setBlue = "\u001B[34m";
    String setGreen = "\u001B[32m";
    String resetColor = "\u001B[0m";

    // color setter method: 
    public String getSetRed() {
        return setRed;
    }

    public void setSetRed(String setRed) {
        this.setRed = setRed;
    }

    public String getSetBlue() {
        return setBlue;
    }

    public void setSetBlue(String setBlue) {
        this.setBlue = setBlue;
    }

    public String getSetGreen() {
        return setGreen;
    }

    public void setSetGreen(String setGreen) {
        this.setGreen = setGreen;
    }

    public String getResetColor() {
        return resetColor;
    }

    public void setResetColor(String resetColor) {
        this.resetColor = resetColor;
    }

}

// -------------------------------------------CUSTUMER-CLASS---------------------------------------------
class Customer implements Serializable {

    // user document info
    private String userName;
    private String fatherName;
    private String aadharNum;
    private String moNumber;
    private String dateofbirth;
    private String accountNum;
    private float amount;

    public Customer(String userName, String fatherName, String aadharNum, String moNumber, String dateofbirth, String accountNum, float amount) {
        this.userName = userName;
        this.fatherName = fatherName;
        this.aadharNum = aadharNum;
        this.moNumber = moNumber;
        this.dateofbirth = dateofbirth;
        this.accountNum = accountNum;
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAadharNum() {
        return aadharNum;
    }

    public void setAadharNum(String aadharNum) {
        this.aadharNum = aadharNum;
    }

    public String getMoNumber() {
        return moNumber;
    }

    public void setMoNumber(String moNumber) {
        this.moNumber = moNumber;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

}

// ------------------------------------------METHOD-CLASS-------------------------------------------------
class Methods {
// Admin login: 

    //-----------------------------------------ADMIN-LOGIN------------------------------------------------
    public boolean adminLogin(Scanner sc, Pojo objp) {
        // create a file of adminLogin class: 
        File fadmin = new File("D:\\Infobeans_Foundation\\javaNetbeans\\BankProject-01\\src\\admin.txt");
        boolean flag = false;

        try {
            if (!fadmin.exists()) {
                fadmin.createNewFile();
            }
            FileReader fr = new FileReader(fadmin);
            System.out.print("\t Enter your name: \n\t ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("\t Enter password: \n\t ");
            String password = sc.nextLine();

            BufferedReader br = new BufferedReader(fr);
            if (br.readLine().contains(name)) {
                if (br.readLine().contains(password)) {
                    System.out.println(objp.setGreen + "Login successful...." + objp.resetColor);
                    flag = true;
                } else {
                    System.out.println(objp.getSetRed() + "Wrong password...." + objp.resetColor);
                }
            } else {
                System.out.println(objp.setRed + "Wrong name...." + objp.resetColor);
            }
            return flag;

        } catch (Exception e) {
            e.printStackTrace();
            return flag;
        }

    }

    // -------------------------------------------CUSTUMER-LOGIN---------------------------------------------
    public void createCustomerAccount(Scanner sc, Pojo objp) {

        System.out.print("\t Enter your name: \n\t ");
        sc.nextLine();
        String userName = sc.nextLine();
        System.out.print("\t Enter your father name: \n\t ");
        String fatherName = sc.nextLine();
        System.out.print("\t Enter aadhar number: \n\t ");
        String aadharNum = sc.nextLine();
        System.out.print("\t Enter mobile number: \n\t ");
        String moNumber = sc.nextLine();
        System.out.print("\t Date of birth: \n\t ");
        String dateofbirth = sc.nextLine();
        System.out.print("\t account number: \n\t ");
        String accountNum = sc.nextLine();
        float amount;
        Customer cstmr = null;
        do {
            System.out.print("\t Enter amount: \n\t ");
            amount = sc.nextFloat();
            if (amount >= 1000) {
                System.out.println(objp.setGreen + "\t\t\t\t\t\t\t Congractulation your account successfully created...\n" + objp.resetColor);
                break;
            } else {
                System.out.println(objp.setRed + "Please enter minimum amount 1000 rupes..." + objp.resetColor);
            }
        } while (true);

// create a object of customer class: 
        cstmr = new Customer(userName, fatherName, aadharNum, moNumber, dateofbirth, accountNum, amount);
        try {
            // create a file : 
            File f = new File("D:\\Infobeans_Foundation\\javaNetbeans\\BankProject-01\\src\\userAcc.txt");

            if (!f.exists()) {
                f.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(f);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(cstmr);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // -------------------------------------------CUSTUMER-ACCOUNT-DETAILS-READ--------------------------------------------
    public void accountDetails(Pojo objp, Scanner sc) {
        File f = new File("D:\\Infobeans_Foundation\\javaNetbeans\\BankProject-01\\src\\userAcc.txt");

        try {
            FileReader fr = new FileReader(f);

            BufferedReader br = new BufferedReader(fr);

            System.out.println("Enter acount number: ");
            sc.nextLine();
            String accountNum = sc.nextLine();

            String s = (String) br.readLine();
            while (s != null) {
                if (s.contains(accountNum)) {
                    System.out.println((String)(br.readLine()));
                    break;
                }
                s = (String)br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

// ------------------------------------------OPERATION-CLASS-------------------------------------------------
class Operation {

    public void main() {
        // create object of pojo class
        Pojo objp = new Pojo();

        Scanner sc = new Scanner(System.in);

        String setRed = objp.getSetRed();
        String setBlue = objp.getSetBlue();
        String setGreen = objp.getSetGreen();
        String resetColor = objp.getResetColor();

        //create object of method class 
        Methods objM = new Methods();
        boolean flag2 = true;
        boolean flag3 = true;

        do {

            System.out.println("\t\t\t-------------------------------------------------------------------------------------------------------");
            System.out.println(" \t\t\t PRESS 1: Addmin login \t\t\t PRESS 2: Costumer login \t\t\t" + objp.setRed + " PRESS 3: Exit" + objp.resetColor);
            System.out.println("\t\t\t-------------------------------------------------------------------------------------------------------");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println(objp.setBlue + "\t\t\t\t\t\t\t ***** ADMIN LOGIN PAGE *****\n\t " + objp.resetColor);
                        boolean flag = objM.adminLogin(sc, objp);

                        do {

                            if (flag) {
                                System.out.println("\t\t\t-------------------------------------------------------------------------------------------------------");
                                System.out.println("\t\t\t PRESS 1: Create a new costumer account \t\t\t PRESS 2: View any account information \t\t\t");
                                System.out.println("\t\t\t PRESS 3: Remove or Block account \t\t\t\t PRESS 4: View all account list \t\t\t");
                                System.out.println("\t\t\t\t\t\t\t\t    " + objp.setRed + " PRESS 5: Exit" + objp.resetColor);
                                System.out.println("\t\t\t-------------------------------------------------------------------------------------------------------");

                                try {
                                    int choice1 = sc.nextInt();

                                    switch (choice1) {
                                        case 1:
                                            objM.createCustomerAccount(sc, objp);
                                            break;
                                        case 2:
                                            objM.accountDetails(objp, sc);
                                            ;
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            break;
                                        case 5:
                                            flag3 = false;
                                            break;
                                        default:
                                            System.out.println(objp.setRed + "Something went wrong: " + objp.resetColor);
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println(objp.setRed + "Wrong input: (please re-enter your choice)" + objp.resetColor);
                                    sc.nextLine();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            } else {
                                break;
                            }
                        } while (flag3);
                        break;

                    case 2:
                        System.out.println(objp.setBlue + "\t\t\t\t\t\t\t ***** COSTUMER LOGIN PAGE ****" + objp.resetColor);
                        break;

                    case 3:
                        System.out.println(objp.setGreen + "\t\t\t\t\t\t\t THANKS FOR VISITING OUR BANK " + objp.resetColor);
                        flag2 = false;
                        break;

                    default:
                        System.out.println(objp.setRed + "Something went wrong: " + objp.resetColor);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(objp.setRed + "Wrong input: (please re-enter your choice)" + objp.resetColor);
                sc.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (flag2);
    }
}
// ------------------------------------------MAIN-CLASS-------------------------------------------------

public class TestMainBank {

    public static void main(String[] args) {
        // create object of Operation class: 
        Operation objo = new Operation();
        objo.main();
    }
}
