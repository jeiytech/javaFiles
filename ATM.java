/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.*;
import java.time.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class ATM {
    //ATM project
    // 11/25/2021 10:48 
    
    String Pass, pass, AC, fName, mName, sName, DOB, gender, addr, beneficiary;
    long NIN;
    int CC, transact;
    long Num;
    double ac, acBalance, transfer;
    Formatter x;
    private Scanner y;
    Scanner s = new Scanner(System.in);
    float a;

    //TO DO: Create a page to Register or Login
    public void RegOrLog(){
        
        System.out.println("******************************************");
        System.out.println("***************WELCOME to GlassFish ATM...");
        System.out.println("***************What would you like to do?...");
        System.out.println("******************************************\n");

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Cancel\n");
           String majorChoice = s.nextLine();
            switch (majorChoice) {
            case "1":
                Register();
                break;
            case "2":
                Login();
                break;
            default:
                System.out.println("\n\n***************Bye*********************\n\n");
                System.exit(0);
        }
    }
    
    public void Register() {
        
    /*
    REGISTER Function
    1. Checks if Account exists in case of an unlikely repetion of the same random numbers generated by the "genAccount" function.
    */
        try {
            System.out.println("********************Welcome to GlassFish ATM...");
            System.out.println("********************Register***********************\n ");
            genAccount();
        } catch (Exception e) {
            // Display an error message to the user
            System.out.println("Error: " + e.getMessage());
        }

    }
    
    public void genAccount(){
  /*
    genAccount function
        1. Generate Account Number using a function to initialise 10 variables to give 10 random integers as an Account number.
        2. Regenerate account number if Account Number generated earlier exists.
        3. Receive input from user for password.
        4. A very low probability of repeating the same random numbers as "genAccount" can produce up to billions of different results
 */        
        
        try{
            Random dice = new Random();

            int a,b,c,d,k,f,g,h,i,j;
            System.out.println("First Name: ");
            String fname = s.nextLine();
            a = dice.nextInt(2);
            b = dice.nextInt(9);
            c = dice.nextInt(9);
            d = dice.nextInt(9);
            k = dice.nextInt(2);
            f = dice.nextInt(2);
            g = dice.nextInt(2);
            h = dice.nextInt(9);
            i = dice.nextInt(2);
            j = dice.nextInt(2);           
            AC = a + "" + b +""+ c +""+ d +""+ k +""+ f +""+ g +""+ h +""+ i +""+ j +"";
            System.out.println("\nGlassfish Bank will not be held responsible for information leaked by Customersn\nNote: This is personal and should not be shared with anyone for any reason\n");
            System.out.println("Thanks for registering with us "+fname);
            System.out.println("Your Account Number is: "+AC+"\n");
            
            checkFile();
        }
        catch(Exception e){
            System.err.println("Error: "+ e.getMessage());
        }
        }
    
    public void checkFile(){
        System.out.println("\nEnter Account Number: ");
        AC = s.nextLine();
        
        System.out.println("Please enter desired Password: ");
        Pass = s.nextLine();
        
    File f = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\ATM\\"+AC+"-"+Pass.hashCode()+".txt");
    
    if(!f.exists()) {
        createFile();
    } else {
        System.out.println(f.getName() + " exists!");
        System.out.println("Loading... Generating new account Number...\n");
        genAccount();
    }
    }
    
    public void createFile(){
    try{
    x = new Formatter(AC+"-"+Pass.hashCode()+".txt");
    System.out.println("\nYou created an Account");
    writeFile();
    }catch(Exception e){
        System.err.println("\nCannot create Account "+ e.getMessage());
    }   
    }
    
    public void writeFile(){
            int trial = 1;
            String next;
            do{
        try{
            System.out.println("First Name: ");
            fName = s.next();

            System.out.println("Middle Name: ");
            mName = s.next();

            System.out.println("Surname: ");
            sName = s.next();
            
            System.out.println("Date Of Birth: ");
            System.out.println("Format: dd/mm/yyyy");
            DOB = s.next();

            System.out.println("National Identification Number: ");
            NIN = s.nextLong();

            System.out.println("**************PHONE NUMBER*********************");
            System.out.println("Country Code: Example: (+234)Nigeria");
            CC = s.nextInt();
            
            System.out.println("Phone Number: Example: 8012345678");
            Num = s.nextLong();

            System.out.println("Gender: ");
            gender = s.next();

            System.out.println("Address: ");
            addr = s.next();
            
        x.format("%s", "Account Number: "+AC+"\n");
        x.format("%s", "First Name: "+fName+"\n");
        x.format("%s", "Middle Name: "+mName+"\n");
        x.format("%s", "Surname: "+sName+"\n");
        x.format("%s", "Date Of Birth: "+DOB+"\n");
        x.format("%s", "National Identification Number: "+NIN+"\n");
        x.format("%s", "Country Code: "+CC+"\n");
        x.format("%s", "Phone Number: "+Num+"\n");
        x.format("%s", "Gender: "+gender+"\n");
        x.format("%s", "Address: "+addr+"\n");
        x.format("%s", "Password: "+Pass.hashCode());
        
        x.close();
        
        next = s.nextLine();
        System.out.println("What do you want to do next: ");
        System.out.println("1. Login");
        System.out.println("2. Quit");
        
        next = s.nextLine();

        if( null != next) {
            switch (next) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    System.out.println("Thank you for trusting our services ");
                    System.exit(0);
                default:
                    System.out.println("Invalid return...");
                    System.exit(0);
            }
            }
        trial = 2;
        }catch(Exception e){
            System.out.println("Invalid return "+ e.getMessage());
        }
            }while(trial == 1);
    }
    
    public void openFile(){
        
        System.out.println("Enter Account Number: ");
        AC = s.nextLine();
    try{
        y = new Scanner(new File(AC+".txt"));
        readFile();
    }catch(Exception e){
        System.err.println("Records not found");
    }
    }
    
    public void readFile(){
        while(y.hasNext()){
            String a = y.nextLine();
            
            System.out.printf("%s\n", a);
            x.close();
        }
    }
    
    public void createAccount(){
        try{
    x = new Formatter(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt");
        System.out.println("Enter Amount to Deposit: You must deposit at least an equivalent of $10 or #5000");
        acBalance = 0.00;
        transfer = s.nextDouble();
        if(transfer > 5000){
            acBalance = ac + transfer;
        x.format("%.2f", acBalance);
        x.close();
        LocalTime time1 = LocalTime.now();
        System.out.println("Present time is: " + time1);
        System.out.println("Thank you for trusting our services..");
        
        System.out.println("\n\nWould you like to perform another transaction?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        transact = s.nextInt();
        switch (transact){
            case 1:
                Login();
                break;
            case 2: 
                System.exit(0);
            default:
                System.out.println("Invalid Input...\n\n");
                System.exit(0);
        }
        }else{
           System.out.println("You must deposit at least an equivalent of $10 or #5000");
           createAccount();
        }
        
    }catch(Exception e){
        System.err.println("Cannot create Account "+ e.getMessage());
    }
    }
    
    public void Login(){ 
        System.out.println("********************Welcome to GlassFish ATM...");
        System.out.println("********************Login***********************");
        
            int trial;
            final int count = 3;
            for(trial = 1; trial <= count; trial++){
            System.out.println("Account Number: ");
            AC = s.nextLine();
            System.out.println("Password: ");
            Pass  = s.nextLine();
            
            File f = new File("C:\\Users\\HP\\Documents\\NetBeansProjects\\ATM\\"+AC+"-"+Pass.hashCode()+".txt");
            if(f.exists()){
                trial = 1;
                loginn();    
        }else{
            System.out.println("Account does not exist");    
            }
            }System.err.println("You have exceeded trial counts");
            System.exit(0);
    }

    public void withdraw(){
        try {
            y = new Scanner(new File(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(y.hasNextFloat()){
            try { 
                a = y.nextFloat();
                ac = a;
                
                x = new Formatter(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt");
                
                System.out.println("Enter Amount to Deposit: ");
                transfer = s.nextDouble();
                if(transfer > ac){
                    acBalance = ac - transfer;
                x.format("%.2f", acBalance);
                x.close();
                LocalTime time1 = LocalTime.now();
                System.out.println("Time: " + time1);
                System.out.println("\nThank you for trusting our services..");
                System.out.println("Do you want to perform other transactions?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int oTraw;
                            oTraw = s.nextInt();
                            if (oTraw == 1){
                                loginn();
                            }
                            else{
                                System.exit(0);
                            }
                }else{
                    System.out.println("Insufficient funds...");
                System.out.println("Do you want to perform other transactions?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int oTraw;
                            oTraw = s.nextInt();
                            if (oTraw == 1){
                                loginn();
                            }
                            else{
                                System.exit(0);
                            }
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    }
    
    public void deposit(){
        try {
            y = new Scanner(new File(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(y.hasNextFloat()){
              try {
                  a = y.nextFloat();
                  ac = a;

                  x = new Formatter(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt");
                  transfer = s.nextDouble();
                  System.out.println("Enter Amount to Deposit: ");
                  
                  transfer = s.nextDouble();
                  acBalance = ac + transfer;
                  x.format("%.2f", acBalance);
                  x.close();
                  LocalTime time1 = LocalTime.now();
                  System.out.println("Deposit Time: " + time1);
                  System.out.println("\nThank you for trusting our services..");
                System.out.println("Do you want to perform other transactions?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int oTraw;
                            oTraw = s.nextInt();
                            if (oTraw == 1){
                                loginn();
                            }
                            else{
                                System.exit(0);
                            }
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
              }

    }
    }
    
    public void checkBalance(){
        
    try{
        y = new Scanner(new File(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt"));
        while(y.hasNext()){
            a = y.nextFloat();
            System.out.printf("\n\n\nAvailable Balance: %s\n", a+"\n\n\n");
            acBalance = a;
             x = new Formatter(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt");
             x.format("%.2f", acBalance);
             x.close();
             LocalTime time1 = LocalTime.now();
             System.out.println("Time: " + time1);
             System.out.println("\nThank you for trusting our services..");
                System.out.println("Do you want to perform other transactions?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int oTraw;
                            oTraw = s.nextInt();
                            if (oTraw == 1){
                                loginn();
                            }
                            else{
                                System.exit(0);
                            }
        }
    }catch(Exception e){
        System.out.println("File not found" + e.getMessage());
    }
    }
    
    public void transferMoney(){
    
        try {
            y = new Scanner(new File(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(y.hasNextFloat()){
              try {
                  a = y.nextFloat();
                  ac = a;

                  x = new Formatter(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt");
                  System.out.println("Enter account number of beneficiary: ");
                  beneficiary = s.nextLine();
                  System.out.println("Enter Amount to Transfer: ");
                  transfer = s.nextDouble();
                  if(transfer > ac){
                  acBalance = ac - transfer;
                  x.format("%.2f", acBalance);
                  x.close();
                  System.out.println(transfer+" has been transferred to Account number "+beneficiary);
                  LocalTime time1 = LocalTime.now();
                  System.out.println("Time: " + time1);
                  System.out.println("\nThank you for trusting our services..");
                System.out.println("Do you want to perform other transactions?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int oTraw;
                            oTraw = s.nextInt();
                            if (oTraw == 1){
                                loginn();
                            }
                            else{
                                System.exit(0);
                            }
                  }else{
                      System.out.println("Insufficient funds...");
                System.out.println("Do you want to perform other transactions?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int oTraw;
                            oTraw = s.nextInt();
                            if (oTraw == 1){
                                loginn();
                            }
                            else{
                                System.exit(0);
                            }
                  }
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
              }

    }
    }
    
    public void airTime(){
    try {
            y = new Scanner(new File(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(y.hasNextFloat()){
              try {
                  a = y.nextFloat();
                  ac = a;

                  x = new Formatter(AC+"-"+Pass.hashCode()+"-"+"acB"+".txt");
                  System.out.println("Enter Phone number to credit: ");
                  beneficiary = s.nextLine();
                  System.out.println("Enter Amount of Airtime: ");
                  transfer = s.nextDouble();
                  if(transfer > ac){
                      acBalance = ac - transfer;
                  x.format("%.2f", acBalance);
                  x.close();
                  System.out.println(beneficiary+" has been credited a sum of "+transfer);
                  LocalTime time1 = LocalTime.now();
                  System.out.println("Time: " + time1);
                  System.out.println("\nThank you for trusting our services..");
                System.out.println("Do you want to perform other transactions?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int oTraw;
                            oTraw = s.nextInt();
                            if (oTraw == 1){
                                loginn();
                            }
                            else{
                                System.exit(0);
                            }
                  }else{
                         System.out.println("Insufficient funds...");
                System.out.println("Do you want to perform other transactions?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int oTraw;
                            oTraw = s.nextInt();
                            if (oTraw == 1){
                                loginn();
                            }
                            else{
                                System.exit(0);
                            }
                  }
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
              }

    }
    }
    
    public void loginn(){
        String action;
                System.out.println("********************Welcome to GlassFish ATM...");
                System.out.println("1. Withdrawal");
                System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Transfer Money");
                System.out.println("5. Buy Airtime");
                System.out.println("6. Cancel");
                
                action = s.nextLine();
                
                if(null != action) {
                    switch (action) {
                        case "1":
                            //withdrawal function
                           withdraw();
                            break;
                        case "2":
                            //deposit function
                            deposit();
                            break;
                        case "3":
                            //check balance
                            checkBalance();
                            break;
                        case "4":
                            //transfer money
                            transferMoney();
                            break;
                        case "5":
                            //Buy airtime
                            airTime();
                            break;
                        case "6":
                            System.exit(0);
                    }
                }
            }
    
    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        ATM display = new ATM();
        display.RegOrLog();
        display.withdraw();
        display.genAccount();
        display.Register();
        display.checkFile();
        display.writeFile();
        display.openFile();
        display.readFile();
        display.Login();
        display.checkBalance();
        display.withdraw();
        display.deposit();
       
    }

}