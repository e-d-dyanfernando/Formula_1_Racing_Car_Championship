package Formula_1_Racing_Car_Championship_OOP_CW;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface F1RCC_ChampionshipManager_w1839054 {

    public void Create_driver();
    public void Delete_driver();
    public void Change_driver();
    public void Display_statistics();
    public void Display_driver_table();
    public void Add_race();
    public void Save_file() throws IOException;
    public void Load_file() throws IOException, ClassNotFoundException;
}