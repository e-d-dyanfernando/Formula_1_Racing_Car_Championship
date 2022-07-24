package Formula_1_Racing_Car_Championship_OOP_CW;

import java.io.Serializable;

abstract class F1RCC_Driver_w1839054 implements Serializable {
    private String Name_of_the_driver;
    private String Location_of_the_driver;
    private String Team_of_the_driver;

    private int Number_of_first_positions;
    private int Number_of_second_positions;
    private int Number_of_third_positions;
    private int Number_of_points;
    private int Number_of_races;
    private int Number_of_place;

    public F1RCC_Driver_w1839054(String Name,String location,String Team){
        this.Name_of_the_driver=Name;
        this.Location_of_the_driver=location;
        this.Team_of_the_driver=Team;
    }

    public abstract void calcPoints(int place);

    public String getName_of_the_driver() {                                      //_____________________________ getters
        return Name_of_the_driver;
    }
    public void setName_of_the_driver(String name_of_the_driver) {               //_____________________________ setters
        Name_of_the_driver = name_of_the_driver;
    }

    public String getLocation_of_the_driver() {                                  //_____________________________ getters
        return Location_of_the_driver;
    }
    public void setLocation_of_the_driver(String location_of_the_driver) {       //_____________________________ setters
        Location_of_the_driver = location_of_the_driver;
    }

    public String getTeam_of_the_driver() {                                      //_____________________________ getters
        return Team_of_the_driver;
    }
    public void setTeam_of_the_driver(String team_of_the_driver) {               //_____________________________ setters
        Team_of_the_driver = team_of_the_driver;
    }

    public int getNumber_of_first_positions() {                                  //_____________________________ getters
        return Number_of_first_positions;
    }
    public void setNumber_of_first_positions(int number_of_first_positions) {    //_____________________________ setters
        this.Number_of_first_positions ++ ; //= number_of_first_positions;       //__________ to add 1 for the positions
    }

    public int getNumber_of_second_positions() {                                 //_____________________________ getters
        return Number_of_second_positions;
    }
    public void setNumber_of_second_positions(int number_of_second_positions) {  //_____________________________ setters
        Number_of_second_positions = number_of_second_positions;
    }

    public int getNumber_of_third_positions() {                                  //_____________________________ getters
        return Number_of_third_positions;
    }
    public void setNumber_of_third_positions(int number_of_third_positions) {    //_____________________________ setters
        Number_of_third_positions = number_of_third_positions;
    }

    public int getNumber_of_points() {                                           //_____________________________ getters
        return Number_of_points;
    }
    public void setNumber_of_points(int number_of_points) {                      //_____________________________ setters
        Number_of_points = number_of_points;
    }

    public int getNumber_of_races() {                                            //_____________________________ getters
        return Number_of_races;
    }
    public void setNumber_of_races(int number_of_races) {                        //_____________________________ setters
        Number_of_races = number_of_races;
    }

    public int getNumber_of_place() {                                            //_____________________________ getters
        return Number_of_place;
    }
    public void setNumber_of_place(int number_of_place) {                        //_____________________________ setters
        Number_of_place = number_of_place;
    }
}