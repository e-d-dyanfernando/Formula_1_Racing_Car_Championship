package Formula_1_Racing_Car_Championship_OOP_CW;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class F1RCC_Formula1ChampionshipManager_w1839054 implements F1RCC_ChampionshipManager_w1839054 {

    private static ArrayList<F1RCC_Formula1Driver_w1839054> f1Drivers =new ArrayList<>();
    private static ArrayList<F1RCC_Race_w1839054> Races= new ArrayList<F1RCC_Race_w1839054>();

    Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        F1RCC_Formula1ChampionshipManager_w1839054 obj= new F1RCC_Formula1ChampionshipManager_w1839054();
        //_________ Formula1ChampionshipManager object to call methods
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("______ Formula 1 Racing Car Championship - Menu Selection ______");                       // ----------- Display menu ---------------------
            System.out.println();
            System.out.println("____________________ Choose your selection _____________________");
            System.out.println();
            System.out.println("__ Enter '1' to create a new driver ____________________________\n" +
                    "__ Enter '2' to delete a driver ________________________________\n" +
                    "__ Enter '3' to change a driver ________________________________\n" +
                    "__ Enter '4' to display statistics _____________________________\n" +
                    "__ Enter '5' to display drivers in a table _____________________\n" +
                    "__ Enter '6' to add a race _____________________________________\n" +
                    "__ Enter '7' to save the file __________________________________\n" +
                    "__ Enter '8' to load the file __________________________________\n" +
                    "__ Enter '9' to open GUI _______________________________________\n"
            );

            try {

                System.out.println("_____________________ Enter your selection _____________________");
                int Menu_selection = input.nextInt();

                if (Menu_selection == 1){
                    obj.Create_driver();
                }
                if (Menu_selection == 2){
                    obj.Delete_driver();
                }
                if (Menu_selection == 3){
                    obj.Change_driver();
                }
                if (Menu_selection == 4){
                    obj.Display_statistics();
                }
                if (Menu_selection == 5){
                    obj.Display_driver_table();
                }
                if (Menu_selection == 6){
                    obj.Add_race();
                }
                if (Menu_selection == 7){
                    obj.Save_file();
                }
                if (Menu_selection == 8){
                    obj.Load_file();
                }
                if (Menu_selection == 9){
                    F1RCC_GUI_w1839054 Home_Page_GUI = new F1RCC_GUI_w1839054(f1Drivers,Races);                                    //__ object of FormulaChampionshipManager given as parameter to
                }                                                                                                                 //__ Calling GUI class constructor
                if (Menu_selection > 9) {
                    System.out.println("________ Please enter a valid selection from the menu, Thank you ________\n");
                }
            } catch (Exception e) {
                System.out.println("________ Please enter a valid selection from the menu, Thank you ________\n");
                main(null);
            }
        }
    }

    public ArrayList<F1RCC_Formula1Driver_w1839054> getF1Drivers() {                          //__ getter method to access the private arraylist
        return f1Drivers;
    }

    //----------- Creating driver and adding the driver to the arraylist
    @Override
    public void Create_driver(){
        try {
            System.out.println("enter driver name: ");
            String driverName = input.nextLine();
            System.out.println("enter driver team: ");
            String driverTeam = input.nextLine();
            System.out.println("enter driver location: ");
            String driverLocation = input.nextLine();

            boolean flag1 = true;
            for (F1RCC_Formula1Driver_w1839054 temp : f1Drivers) {
                if (temp.getTeam_of_the_driver().equals(driverTeam)) {
                    flag1 = false;
                }
            }
            if (flag1) {
                f1Drivers.add(new F1RCC_Formula1Driver_w1839054(driverName, driverLocation, driverTeam));
                System.out.println("driver " + driverName + " is added to " + driverTeam);
            }
        }catch(InputMismatchException e){
            System.out.println("------------ Try again with valid inputs -----");
        }
    }

    //-------------- Delete the driver from the arraylist-------------------------
    @Override
    public void Delete_driver() {
        System.out.println("enter driver name: " );
        String driverName = input.nextLine();
        System.out.println("enter driver team: " );
        String driverTeam = input.nextLine();

        int delObj = 0;

        for (F1RCC_Formula1Driver_w1839054 temp : f1Drivers) {

            delObj++;

            if (temp.getName_of_the_driver().equals(driverName) && temp.getTeam_of_the_driver().equals(driverTeam)) {

                f1Drivers.remove(delObj-1);
                System.out.println("driver " + temp.getName_of_the_driver() + " in " + temp.getTeam_of_the_driver() + " is removed");
                return;
            }
        }
        System.out.println("------- Please enter a valid driver -------------------------------");
    }

    // --------------- Changing the driver details -----------------------------------------
    @Override
    public void Change_driver() {
        System.out.println("enter driver team: " );
        String driverTeam=input.nextLine();
        for (F1RCC_Driver_w1839054 temp : f1Drivers) {
            if (temp.getTeam_of_the_driver().equals(driverTeam)) {
                System.out.println("enter driver name: " );
                String driverName = input.nextLine();
                System.out.println(" new driver name for the team " + driverTeam+" is " + driverName );
                temp.setName_of_the_driver(driverName);
                return;
            }
        }
        System.out.println("------- Please enter a valid team -------------------------------\n");
    }

    @Override
    public void Display_statistics() {
        System.out.println("enter driver name: " );
        String driverName=input.nextLine();
        System.out.println("enter driver team: " );
        String driverTeam= input.nextLine();

        for (F1RCC_Formula1Driver_w1839054 temp : f1Drivers) {
            if (temp.getName_of_the_driver().equals(driverName)) {
                if (temp.getTeam_of_the_driver().equals(driverTeam))
                {
                    System.out.println("name:" + temp.getName_of_the_driver() + "\n" +                               // Creating the text to display driver details in the console
                            "team: " + temp.getTeam_of_the_driver() + "\n" +
                            "location " + temp.getLocation_of_the_driver() + "\n" +
                            "NoOfFirstPositions " + temp.getNumber_of_first_positions() + "\n" +
                            "NoOfSecondPositions " + temp.getNumber_of_second_positions() + "\n" +
                            "NoOfThirdPositions " + temp.getNumber_of_third_positions() + "\n" +
                            "noOfPoints" + temp.getNumber_of_points() +"\n"
                    );
                    return;
                }
            }
        }
        System.out.println("-------------- Please enter a valid driver -------------------------------");
    }

    //------------ Display driver details table ------------------------------------
    @Override
    public void Display_driver_table() {
        Collections.sort(f1Drivers);
        System.out.println("Driver name"+ "\t\t"+ "Driver team"+ "\t\t"+ "location"+ "\t\t"+ "place"+ "\t\t"+ "No of first places"+ "\t\t"+                          // -----------  table column names ---------------
                "No of second places"+ "\t\t"+"No of third places"+ "\t\t"+ "No of points"+"\t\t");
        for(F1RCC_Driver_w1839054  temp : f1Drivers){

            System.out.println(temp.getName_of_the_driver() +"\t\t\t\t"+temp.getTeam_of_the_driver()+"\t\t\t\t" + temp.getLocation_of_the_driver()+ "\t\t\t\t"         // -----------  table column data creating ---------------
                    + temp.getNumber_of_place()+"\t\t\t\t\t"+temp.getNumber_of_first_positions()
                    + "\t\t\t\t\t\t\t\t"+ temp.getNumber_of_second_positions()+"\t\t\t\t\t"+temp.getNumber_of_third_positions()+"\t\t\t\t\t\t"+temp.getNumber_of_points());
        }
    }

    // ----------- creating and adding race to the arraylist
    @Override
    public void Add_race(){
        System.out.println("enter race date: " );
        String Date=input.nextLine();

        F1RCC_Race_w1839054  race;             //______________ create Race objects
        race = new F1RCC_Race_w1839054(Date);

        Races.add(race);                   // ------- adding race object to the arraylist

        for (F1RCC_Formula1Driver_w1839054 temp : f1Drivers) {
            Scanner input = new Scanner(System.in);
            System.out.println(temp.getName_of_the_driver()+ " was in the race?"  );
            String inOrNot = input.nextLine();
            if (inOrNot.equals("yes") ) {

                System.out.println("enter the race position:");
                int place = input.nextInt();

                if (place == 1) {
                    temp.setNumber_of_first_positions(1);
                }
                else if (place == 2) {
                    temp.setNumber_of_second_positions(1);
                }
                else if (place == 3) {
                    temp.setNumber_of_third_positions(1);
                }
                temp.calcPoints(place);
                race.addDriver(temp,place);                    //_____________add only participating drivers to the arraylist
            }
        }
    }

    @Override
    public void Save_file() throws IOException {

        FileOutputStream saveFile_driver = new FileOutputStream("saveFile_1.txt");    // Open a file to write to, named SavedObj.sav.

        ObjectOutputStream save_driver = new ObjectOutputStream(saveFile_driver);                // Create an ObjectOutputStream to put objects into save file.

        save_driver.writeObject(f1Drivers);                                               // write two objects
        save_driver.close();

        FileOutputStream save_File_race = new FileOutputStream("saveFile_2.txt");    // Open a file to write to, named SavedObj.sav.

        ObjectOutputStream save_race = new ObjectOutputStream(save_File_race);                // Create an ObjectOutputStream to put objects into save file.

        save_race.writeObject(Races);                                                    // write two objects
        save_race.close();                                                              // close
    }

    @Override
    public void Load_file() throws IOException, ClassNotFoundException {
        FileInputStream saveFile_driver = new FileInputStream("saveFile_1.txt");
        ObjectInputStream restore_driver = new ObjectInputStream(saveFile_driver);

        FileInputStream save_File_race = new FileInputStream("saveFile_2.txt");
        ObjectInputStream restore_race = new ObjectInputStream(save_File_race);

        f1Drivers= (ArrayList<F1RCC_Formula1Driver_w1839054 >) restore_driver.readObject();
        Races = (ArrayList<F1RCC_Race_w1839054 >) restore_race.readObject();

        restore_driver.close();
        restore_race.close();
    }
}