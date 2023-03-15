package CruiseShipArrays;

//All libraries used

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CruiseShipArrays {

//Scanner
    private static final Scanner scan = new Scanner(System.in);

//2-D Array to store user first and last name in a 'Cabin'
    private static final String[][] cabin = new String[12][2];

    public static void main(String[] args) {

//Main menu
        System.out.println("\nThe Cruise Menu:\n\n"
                + "Input the corresponding letter\n\n"
                + "A: Add customer\n"
                + "V: View all cabins\n"
                + "E: Display empty cabins\n"
                + "D: Delete customer from cabin\n"
                + "F: Find cabin from customer name\n"
                + "S: Store data in a file\n"
                + "L: Load data from file\n"
                + "O: View list of passengers\n\n");
        
        String userInput = scan.nextLine();

//Switch for userInput, Corresponding letter opens the ideal method
        switch (userInput) {
            case "A":
                System.out.print("\033[H\033[2J");
                addCustomer();
                break;    
            case "V":
                System.out.print("\033[H\033[2J");
                viewCabin();
                break;
            case "E":
                System.out.print("\033[H\033[2J");
                emptyCabins();
                break;
            case "D":
                System.out.print("\033[H\033[2J");
                deleteCustomer();
                break;
            case "F":
                System.out.print("\033[H\033[2J");
                findCustomerCabin();
                break;
            case "S":
                System.out.print("\033[H\033[2J");
                storeFile();
                break;
            case "L":
                System.out.print("\033[H\033[2J");
                loadFile();
                break;   
            case "O":
                System.out.print("\033[H\033[2J");
                 viewPassengers();
                break;
                   
        }
    }

 //Add Customer       
    public static void addCustomer(){
        
        int count = 0;
        while(count<cabin.length){

            if (cabin[count][0] == null) {

                System.out.println("Adding Of A Passenger\n");
                System.out.print("Customer first name: ");
                String customerFirstName = scan.nextLine();
        
                System.out.print("Customer last name: ");
                String customerLastName = scan.nextLine();
                
//String "\033[H\033[2J" helps clear the screen
                System.out.print("\033[H\033[2J");

                System.out.println( "\nYou would like to add "
                                     + customerFirstName + " "
                                     + customerLastName
                                     + " to the cabin list?\n\nYes or No\n");
        
                String yesNo = scan.nextLine();

                if (yesNo.equals("Yes")) {

                    cabin[count][0] = customerFirstName;
                    cabin[count][1] = customerLastName;
                    
                    System.out.print("\033[H\033[2J");

                    System.out.println(customerFirstName + " " + customerLastName +
                                        " was added to cabin " + (count+1) + ".\n");
                }
            } else if (cabin[count][0] != null) { 

//If 'cabin' is occupied it will check the next cabin

                count++;
                continue;
            }

        System.out.print("Would you like to return to the Main Menu?\n\nYes or No.\n");

        String yesNo = scan.nextLine();

        if (yesNo.equals("Yes") || yesNo.equals("yes")){
            
            System.out.print("\033[H\033[2J");
            main(null);

//This method uses a while loop so no recursion needed for it to run again
        }

        count++;
 
//If all cabins are occupied then this will run
        if(count == 12){ 
            System.out.println("All cabins are full.");
            break;
        }
        }
        main(null);
        }
        
    
//View all Cabins
    public static void viewCabin() {
        System.out.println("Viewing All Cabins\n");
        System.out.println("Cabin\tFirstName\tLastName\n");
        
        for(int count=0; count<cabin.length;count++) {
            
            System.out.println( (count+1) + "\t" + cabin[count][0] + "\t\t" + cabin[count][1]);
        
        }
        
        System.out.println("\nPress enter to exit to menu");
        scan.nextLine();
        System.out.print("\033[H\033[2J");
        main(null);
    }
    


//View all empty cabins
    public static void emptyCabins() {
        
        System.out.println("Viewing Empty Cabins\n");
        System.out.println("Cabin\tEmpty");
        
        for(int count=0; count<cabin.length;count++){
            
            if (cabin[count][0] == null) {

            System.out.println( (count+1) + "\t" + "Yes");

            }
   
        }

        System.out.println("\nPress enter to return to main menu.");
        scan.nextLine();
        System.out.print("\033[H\033[2J");
        main(null);
    }
    


//Delete customer from cabin
    public static void deleteCustomer() {
 
        System.out.println("Deleting Passenger Page\n");
        System.out.print("First name: ");
        String fNameDelete = scan.nextLine();
        
        System.out.print("Second name: ");
        String lNameDelete = scan.nextLine();
        
        System.out.print("\033[H\033[2J");

        int count = 0;

//Checks cabins 1-12 and deletes the first customer whose name is found
        while(count<cabin.length){
           
            if(fNameDelete.equals(cabin[count][0]) && lNameDelete.equals(cabin[count][1])) {

                System.out.println("Are you sure you would like to delete " + fNameDelete + " " + lNameDelete + " from cabin " + (count+1) + "?\n");
            
                System.out.println("Yes or No\n");
                String yesNo = scan.nextLine();
                System.out.print("\033[H\033[2J");

                if (yesNo.equals("Yes") || yesNo.equals("yes")) {
                    
                    cabin[count][0] = null;
                    cabin[count][1] = null;
                    
                    System.out.println(fNameDelete + " " + lNameDelete + " has been removed.\n");
                    break;

                } else {
                    
                    System.out.println(fNameDelete + " " + lNameDelete + " has not been removed.\n");}
                    break;   

            } else if (count == cabin.length) {
                
                System.out.println(fNameDelete + " " + lNameDelete + " does not seem to be in the system, check your spelling.");
                continue;
                
            }

        count++;   

        }

        System.out.println("Would you like to remove a different passenger?\n");

        System.out.println("Yes or No\n");
        String yesNo = scan.nextLine();

        System.out.print("\033[H\033[2J");

        if (yesNo.equals("Yes") || yesNo.equals("yes")) {

//Recursion
            deleteCustomer();
        }
        else {main(null);}
    }
    

//Find a cabin from customer name
    public static void findCustomerCabin() {

        System.out.println("Find Passenger By Name\n");

        System.out.print("First name: ");
        String fNameFind = scan.nextLine();
        
        System.out.print("Second name: ");
        String lNameFind = scan.nextLine();
        
        System.out.print("\033[H\033[2J");

        int count = 0;
        while(count<cabin.length){
           
            if (fNameFind.equals(cabin[count][0]) && lNameFind.equals(cabin[count][1])) {

                    System.out.println(fNameFind + " " + lNameFind + " is in Cabin " + (count+1));
                    break;
                }    

            else if (count == cabin.length) {
                
                System.out.println(fNameFind + " " + lNameFind + " does not seem to be in the system, check your spelling.");
                continue;
                
            }

        count++;   

        }

        System.out.println("\nReturn to menu?\n\nYes or No\n");
        String yesNo = scan.nextLine();

        System.out.print("\033[H\033[2J");


        if (yesNo.equals("Yes") || yesNo.equals("yes")) {
            
            main(null);
        
        } else {
//Recursion
            findCustomerCabin();
        
        }
        
    }

//Store data in file
    public static void storeFile() {

        try {

            File folder = new File("CruiseShipData"); 
            folder.mkdir();
            File file = new File(folder, "CruiseShipPassengers.txt");
            file.createNewFile();

            PrintWriter writeFile = new PrintWriter(file);
        
        for(int count=0; count<cabin.length; count++) {
            
            if(cabin[count][0] != null) {
            writeFile.println( (count+1) + " " + cabin[count][0] + " " + cabin[count][1]);
            }

            }

            writeFile.close();

            System.out.println("Data has been saved!..");

//Incase file or folder can't be created
        } catch (IOException e) {
            System.out.println("File didn't save!");
        } 
        
        System.out.println("\nPress Enter to continue.");
        scan.nextLine();

        System.out.print("\033[H\033[2J");

        main(null);
    }

//Load data in file 
    public static void loadFile() {

        try {
            File dataFile = new File("CruiseshipData/CruiseShipPassengers.txt");
            Scanner fileReader = new Scanner(dataFile);

        while(fileReader.hasNextLine()){

//Cut the string apart so it can be allocated back into array
            String spliceNames = fileReader.nextLine();
            String[] splitNames = spliceNames.split(" ");

            
            int cabinNumber = Integer.parseInt(splitNames[0]);
            cabinNumber -= 1;
            String firstName = splitNames[1];
            String lastName = splitNames[2];
          
            cabin[cabinNumber][0] = firstName;
            cabin[cabinNumber][1] = lastName;

        
        }

            fileReader.close();
            System.out.println("Data was loaded!..");

//Incase the file doesn't exist
        } catch (FileNotFoundException e) {
            System.out.println("Data file was not found!...");
        }

            System.out.println("\nPress Enter to continue.");
            scan.nextLine();
            System.out.print("\033[H\033[2J");

            main(null);
    }
    
//View all passengers
    public static void viewPassengers() {

        System.out.println("View All Passengers\n");
        System.out.println("Cabin\tFirstName\tLastName\n");
        
        for(int count=0; count<cabin.length;count++) {
            
            if(cabin[count][0] != null) {
            System.out.println( (count+1) + "\t" + cabin[count][0] + "\t\t" + cabin[count][1]);
            }
        }
        
        System.out.println("\nPress Enter to continue.");
        scan.nextLine();
        System.out.print("\033[H\033[2J");

        main(null);
        
    }

    
        
       
       
    
    
}
