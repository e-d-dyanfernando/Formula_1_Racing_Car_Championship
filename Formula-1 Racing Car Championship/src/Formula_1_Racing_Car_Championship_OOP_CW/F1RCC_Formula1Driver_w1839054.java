package Formula_1_Racing_Car_Championship_OOP_CW;

import java.io.Serializable;

public class F1RCC_Formula1Driver_w1839054 extends F1RCC_Driver_w1839054 implements Serializable, Comparable<F1RCC_Formula1Driver_w1839054> {

    public F1RCC_Formula1Driver_w1839054(String Name_of_the_driver, String Location_of_the_driver, String Team_of_the_driver) {
        super(Name_of_the_driver, Location_of_the_driver, Team_of_the_driver);
    }

    @Override
    public void calcPoints(int Number_of_place) {
        if (Number_of_place == 1){
            super.setNumber_of_points(25);
        }
        if (Number_of_place == 2){
            super.setNumber_of_points(18);
        }
        if (Number_of_place == 3){
            super.setNumber_of_points(15);
        }
        if (Number_of_place == 4){
            super.setNumber_of_points(12);
        }
        if (Number_of_place == 5){
            super.setNumber_of_points(10);
        }
        if (Number_of_place == 6){
            super.setNumber_of_points(8);
        }
        if (Number_of_place == 7){
            super.setNumber_of_points(6);
        }
        if (Number_of_place == 8){
            super.setNumber_of_points(4);
        }
        if (Number_of_place == 9){
            super.setNumber_of_points(2);
        }
        if (Number_of_place == 10){
            super.setNumber_of_points(1);
        }
        else{
            System.out.println("points added="+ super.getNumber_of_points());
        }
    }

    @Override
    public int compareTo(F1RCC_Formula1Driver_w1839054 o) {
        if(this.getNumber_of_points()==o.getNumber_of_points()) {
            if (this.getNumber_of_first_positions() < o.getNumber_of_first_positions()) {
                return 1;
            } else
                return -1;
        }
        else if(this.getNumber_of_points()<o.getNumber_of_points()) {
            return  1;
        }
        else
            return  -1;
    }
}