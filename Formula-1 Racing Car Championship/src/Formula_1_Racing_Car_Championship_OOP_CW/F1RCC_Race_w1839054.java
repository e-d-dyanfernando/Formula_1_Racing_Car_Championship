package Formula_1_Racing_Car_Championship_OOP_CW;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class F1RCC_Race_w1839054 implements Serializable {
    private String date;
    private HashMap <Integer,F1RCC_Formula1Driver_w1839054>  participatingDrivers = new HashMap<>();

    public HashMap<Integer, F1RCC_Formula1Driver_w1839054> getParticipatingDrivers() {
        return participatingDrivers;
    }

    public String getDate() {
        return date;
    }

    public F1RCC_Race_w1839054(String date){
        this.date=date;
    }

    // Race race = new Race(date);                     //race object

    public void addDriver(F1RCC_Formula1Driver_w1839054 driver,int position){
        participatingDrivers.put(position,driver);

        /*System.out.println("\nparticipating drivers");                                        //print participating drivers in the race
        Iterator itr=participatingDrivers.iterator();
        while(itr.hasNext())
        {
            String obj = (String) itr.next();
            System.out.println(obj);*/
    }
}