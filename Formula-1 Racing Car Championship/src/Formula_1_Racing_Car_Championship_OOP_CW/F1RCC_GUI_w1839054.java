package Formula_1_Racing_Car_Championship_OOP_CW;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class F1RCC_GUI_w1839054<index> extends JFrame {
    public ArrayList<F1RCC_Formula1Driver_w1839054> f1Drivers = new ArrayList<>();
    private ArrayList<F1RCC_Race_w1839054> Races= new ArrayList<F1RCC_Race_w1839054>();

    String[] columnHeading = {"NAME", "TEAM", "LOCATION", "FIRST POSITIONS", "SECOND POSITIONS", "THIRD POSITIONS", "PLACE", "POINTS"};
    private int x;
    private String[][] data = new String[x][7];


//beginning of the GUI menu
    public F1RCC_GUI_w1839054(ArrayList<F1RCC_Formula1Driver_w1839054> f1Drivers, ArrayList<F1RCC_Race_w1839054>Races) {

        //beginning of the common frame
        JFrame frame = new JFrame("Formula_1_Racing_Car_Championship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        this.f1Drivers = f1Drivers;                                                     // Passing the drivers arrayList from the console to GUI
        this.Races = Races;
        DefaultTableModel Table_Data = new DefaultTableModel(data, columnHeading);                        // Managing data for the table

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // end of the common frame

        JButton btnDriverTable;
        JButton btnCreateRaceVer1;
        JButton btnCreateRaceVer2;
        JButton btnRaceTable;
        JButton btnDriverStatistic;
        JButton btnExit;

        btnDriverTable = new JButton("Driver Table");
        btnCreateRaceVer1 = new JButton("Create Race Ver.1");
        btnCreateRaceVer2 = new JButton("Create Race Ver.2");
        btnRaceTable = new JButton("Race Table");
        btnDriverStatistic = new JButton("Driver Statistic");
        btnExit = new JButton("Exit");

        btnDriverTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);      // closing the frame
                frame.dispose();
                F1RCC_Driver_Table_w1839054(f1Drivers);
            }
        });
        btnCreateRaceVer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // closing the frame
                frame.dispose();
                F1RCC_Create_Race_Ver_1_w1839054(f1Drivers,Races);
            }
        });
        btnCreateRaceVer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // closing the frame
                frame.dispose();
                F1RCC_Create_Race_Ver_2_w1839054(f1Drivers,Races);
            }
        });
        btnRaceTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                F1RCC_Race_Table_w1839054(f1Drivers,Races);
            }
        });
        btnDriverStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                F1RCC_Driver_Statistic_w1839054(f1Drivers,Races);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
               // System.exit(0);
            }
        });                                                                       //________________________________________________ add table into a scroll pane

        btnDriverTable.setBounds(120, 10, 140, 30);
        btnCreateRaceVer1.setBounds(120, 50, 140, 30);
        btnCreateRaceVer2.setBounds(120, 90, 140, 30);
        btnRaceTable.setBounds(120, 130, 140, 30);
        btnDriverStatistic.setBounds(120, 170, 140, 30);
        btnExit.setBounds(120, 210, 140, 30);
        //________________________________________________________________ set of rules
        frame.add(btnDriverTable);
        frame.add(btnCreateRaceVer1);
        frame.add(btnCreateRaceVer2);
        frame.add(btnRaceTable);
        frame.add(btnDriverStatistic);
        frame.add(btnExit);
    }
//end of the GUI menu


//beginning of the driver table
    //https://javarevisited.blogspot.com/2014/01/java-comparator-example-for-custom.html#axzz7EcZ8VOrZ
    public static final Comparator < F1RCC_Formula1Driver_w1839054 > Position_Comparator = new Comparator<F1RCC_Formula1Driver_w1839054>() {
        @Override
        public int compare(F1RCC_Formula1Driver_w1839054 o1, F1RCC_Formula1Driver_w1839054 o2) {
            if (o1.getNumber_of_first_positions() < o2.getNumber_of_first_positions()) {
                return 1;
            }
            else {
                return -1;
            }
        }
    };

    public void F1RCC_Driver_Table_w1839054(ArrayList < F1RCC_Formula1Driver_w1839054 > f1Drivers) {

        //beginning of the common frame
        JFrame frame = new JFrame("Formula_1_Racing_Car_Championship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 400);

        this.f1Drivers = f1Drivers;                                                     // Passing the drivers arrayList from the console to GUI
        DefaultTableModel Driver_Table_Data = new DefaultTableModel(data, columnHeading);                        // Managing data for the table

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // end of the common frame
        // back button
        JButton btnBackCRV1;
        btnBackCRV1 = new JButton("Back");
        btnBackCRV1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                new F1RCC_GUI_w1839054(f1Drivers,Races);
            }
        });
        btnBackCRV1.setBounds(10, 170, 130, 30);
        frame.add(btnBackCRV1);


        JTable table;
        JScrollPane scrollPane;
        JButton btnShowTable;
        JButton btnAscending;
        JButton btnDescending;
        JButton btnPositionOrder;

        table = new JTable(Driver_Table_Data);
        table.setBounds(50, 100, 500, 1000);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 10, 1200, 300);

        btnShowTable = new JButton("Show the Table");
        btnAscending = new JButton("Ascending");
        btnDescending = new JButton("Descending");
        btnPositionOrder = new JButton("Position Order");

        btnShowTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Driver_Table_Data.setNumRows(0);
                for (F1RCC_Formula1Driver_w1839054 temp : f1Drivers) {
                    Driver_Table_Data.addRow(new String[]{temp.getName_of_the_driver(), temp.getTeam_of_the_driver(), temp.getLocation_of_the_driver(),
                            String.valueOf(temp.getNumber_of_first_positions()), String.valueOf(temp.getNumber_of_second_positions()), String.valueOf(temp.getNumber_of_third_positions()),
                            String.valueOf(temp.getNumber_of_place()), String.valueOf(temp.getNumber_of_points())
                    });
                }
                table.repaint();
            }
        });

        btnAscending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(f1Drivers);
                Driver_Table_Data.setNumRows(0);                                            //__________________close repeating
                for (F1RCC_Formula1Driver_w1839054 temp : f1Drivers) {
                    Driver_Table_Data.addRow(new String[]{temp.getName_of_the_driver(), temp.getTeam_of_the_driver(), temp.getLocation_of_the_driver(),
                            String.valueOf(temp.getNumber_of_first_positions()), String.valueOf(temp.getNumber_of_second_positions()), String.valueOf(temp.getNumber_of_third_positions()),
                            String.valueOf(temp.getNumber_of_place()), String.valueOf(temp.getNumber_of_points())
                    });
                }
                table.repaint();
            }
        });
        btnDescending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(f1Drivers);
                Collections.reverse(f1Drivers);                                      //_________________backward sorting
                Driver_Table_Data.setNumRows(0);                                            //__________________close repeating
                for (F1RCC_Formula1Driver_w1839054 temp : f1Drivers) {
                    Driver_Table_Data.addRow(new String[]{temp.getName_of_the_driver(), temp.getTeam_of_the_driver(), temp.getLocation_of_the_driver(),
                            String.valueOf(temp.getNumber_of_first_positions()), String.valueOf(temp.getNumber_of_second_positions()), String.valueOf(temp.getNumber_of_third_positions()),
                            String.valueOf(temp.getNumber_of_place()), String.valueOf(temp.getNumber_of_points())
                    });
                }
                table.repaint();
            }
        });

        btnPositionOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(f1Drivers , Position_Comparator);
                Driver_Table_Data.setNumRows(0);
                for (F1RCC_Formula1Driver_w1839054 temp : f1Drivers) {
                    Driver_Table_Data.addRow(new String[]{temp.getName_of_the_driver(), temp.getTeam_of_the_driver(), temp.getLocation_of_the_driver(),
                            String.valueOf(temp.getNumber_of_first_positions()), String.valueOf(temp.getNumber_of_second_positions()), String.valueOf(temp.getNumber_of_third_positions()),
                            String.valueOf(temp.getNumber_of_place()), String.valueOf(temp.getNumber_of_points())
                    });
                }
                table.repaint();
            }
        });                                                             //________________________________________________ add table into a scroll pane

        System.out.println(Arrays.deepToString(data));

        btnShowTable.setBounds(10, 10, 130, 30);
        btnAscending.setBounds(10, 50, 130, 30);
        btnDescending.setBounds(10, 90, 130, 30);
        btnPositionOrder.setBounds(10, 130, 130, 30);
        frame.add(scrollPane);                                        //________________________________________________________________ set of rules
        frame.add(btnShowTable);
        frame.add(btnAscending);
        frame.add(btnDescending);
        frame.add(btnPositionOrder);
    }
//end of the driver table


//beginning of the create race version 1
    public void F1RCC_Create_Race_Ver_1_w1839054 (ArrayList < F1RCC_Formula1Driver_w1839054 > f1Drivers, ArrayList <F1RCC_Race_w1839054>  Races) {

        //beginning of the common frame
        JFrame frame = new JFrame("Formula_1_Racing_Car_Championship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        this.f1Drivers = f1Drivers;                                                     // Passing the drivers arrayList from the console to GUI
        this.Races = Races;

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //end of the common frame
        //back button
        JButton btnBackCRV1;
        btnBackCRV1 = new JButton("Back");
        btnBackCRV1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                new F1RCC_GUI_w1839054(f1Drivers,Races);
            }
        });
        btnBackCRV1.setBounds(10, 100, 120, 30);
        frame.add(btnBackCRV1);

        JLabel CRV1l1;
        JTextArea driverDisplay;

        driverDisplay = new JTextArea(10,10);
        driverDisplay.setBounds(170,50, 300,300);
        frame.add(driverDisplay);
        CRV1l1=new JLabel("DATE");
        CRV1l1.setBounds(40,50, 200,30);
        frame.add(CRV1l1);

        String date = F1RCC_Generate_Random_Date_w1839054();     //__ random date created
        F1RCC_Race_w1839054 Race_Details = new F1RCC_Race_w1839054(date);
        CRV1l1.setText(date);
        StringBuilder driverText = new StringBuilder();
        for (F1RCC_Formula1Driver_w1839054 Driver_Details :f1Drivers) {
            int Position = (int) (Math.random()*(f1Drivers.size())+1);
            Race_Details.addDriver(Driver_Details,Position);
            Driver_Details.calcPoints(Position);
            driverText.append(Driver_Details.getName_of_the_driver()).append(" Driver achieved ").append(Position).append(" in the race. \n");
            driverDisplay.setEditable(false);
        }
        Races.add(Race_Details);
        try {
            Save_file();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverDisplay.setText(String.valueOf(driverText));
    }
//end of the create race version 1


    public static String F1RCC_Generate_Random_Date_w1839054(){                                         //__ common method of calling the random date for both versions
        Random random = new Random();
        int minDay = (int) LocalDate.of(2020, 6, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2021, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        return randomBirthDate.toString();
    }


//beginning of the create race version 2
    public void F1RCC_Create_Race_Ver_2_w1839054 (ArrayList < F1RCC_Formula1Driver_w1839054 > f1Drivers, ArrayList <F1RCC_Race_w1839054>  Races) {
        //beginning of the common frame
        JFrame frame = new JFrame("Formula_1_Racing_Car_Championship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        this.f1Drivers = f1Drivers;                                                     // Passing the drivers arrayList from the console to GUI
        this.Races = Races;
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // end of the common frame
        //back button
        JButton btnBackCRV2;
        btnBackCRV2 = new JButton("Back");
        btnBackCRV2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                new F1RCC_GUI_w1839054(f1Drivers,Races);
            }
        });
        btnBackCRV2.setBounds(10, 130, 130, 30);
        frame.add(btnBackCRV2);

        JLabel CRV2l1;
        JTextArea driverDisplay;

        driverDisplay = new JTextArea(10,10);
        driverDisplay.setBounds(170,50, 300,300);
        frame.add(driverDisplay);
        CRV2l1=new JLabel("DATE");
        CRV2l1.setBounds(40,50, 200,30);
        frame.add(CRV2l1);

        String date = F1RCC_Generate_Random_Date_w1839054();     //__ random date created
        F1RCC_Race_w1839054 Race_Details = new F1RCC_Race_w1839054(date);
        CRV2l1.setText(date);
        StringBuilder driverText = new StringBuilder();
        for (F1RCC_Formula1Driver_w1839054 Driver_Details :f1Drivers) {

            int Starting_Position = (int) (Math.random()*(f1Drivers.size())+1);
            int Position = (int) (Math.random()*(100)+1);

            int End_Position = (int) (Math.random()*(f1Drivers.size())+1);

            if (Position >= 1 && Position <= 40 && Starting_Position == 1){
                End_Position = 1;
                Race_Details.addDriver(Driver_Details, End_Position);
                Driver_Details.calcPoints(End_Position);
            }
            else if (Position >= 1 && Position <= 30 && Starting_Position == 2){
                End_Position = 1;
                Race_Details.addDriver(Driver_Details, End_Position);
                Driver_Details.calcPoints(End_Position);
            }
            else if (Position >= 1 && Position <= 10 && Starting_Position == 3 || Starting_Position == 4){
                End_Position = 1;
                Race_Details.addDriver(Driver_Details, End_Position);
                Driver_Details.calcPoints(End_Position);
            }
            else if (Position >= 1 && Position <= 2 && Starting_Position >= 5 && Starting_Position <= 9){
                End_Position = 1;
                Race_Details.addDriver(Driver_Details, End_Position);
                Driver_Details.calcPoints(End_Position);
            }

            driverText.append(Driver_Details.getName_of_the_driver()).append(" Driver achieved ").append(End_Position).append(" in the race. \n");
            driverDisplay.setEditable(false);
        }
        Races.add(Race_Details);
        try {
            Save_file();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverDisplay.setText(String.valueOf(driverText));
    }
//end of the create race version 2


//beginning of the race table
    public void F1RCC_Race_Table_w1839054 (ArrayList < F1RCC_Formula1Driver_w1839054 > f1Drivers, ArrayList <F1RCC_Race_w1839054>  Races) {
        //beginning of the common frame
        JFrame frame = new JFrame("Formula_1_Racing_Car_Championship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 500);

        this.f1Drivers = f1Drivers;                                                     // Passing the drivers arrayList from the console to GUI
        this.Races = Races;
        DefaultTableModel Race_Table_Data = new DefaultTableModel(data, columnHeading);                        // Managing data for the table

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //end of the common frame
        //back button
        JButton btnBackRT;
        btnBackRT = new JButton("Back");
        btnBackRT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                new F1RCC_GUI_w1839054(f1Drivers, Races);
            }
        });
        btnBackRT.setBounds(10, 130, 130, 30);
        frame.add(btnBackRT);

        frame.setLayout(null);
        //frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\admin\\Pictures\\back.png")));

        String date = F1RCC_Generate_Random_Date_w1839054();     //__ random date created
        F1RCC_Race_w1839054 Race_Details = new F1RCC_Race_w1839054(date);

        DateFormat Date =  new SimpleDateFormat("MM-dd-yyyy");
        Comparator<F1RCC_Race_w1839054> comparator = (date1,date2)->{
            return date1.getDate().compareTo(date2.getDate());
        };

        Collections.sort(Races,comparator);
        String[][] data = new String[Races.size()][10];

        for(int i =0; i < Races.size(); i++){
            F1RCC_Race_w1839054 race = (F1RCC_Race_w1839054) Races.get(i);
            HashMap<Integer, F1RCC_Formula1Driver_w1839054> temp = race.getParticipatingDrivers();

            data[i] = new String[]{race.getDate(), checkDriver(temp.get(1)),
                    checkDriver(temp.get(2)),
                    checkDriver(temp.get(3)),
                    checkDriver(temp.get(4)),
                    checkDriver(temp.get(5)),
                    checkDriver(temp.get(6)),
                    checkDriver(temp.get(7)),
                    checkDriver(temp.get(8)),
                    checkDriver(temp.get(9)),
                    checkDriver(temp.get(10))
            };
        }

        String[] column ={"Date","First","Second","Third","Fourth","Fifth","Sixth","Seventh","Eighth","Ninth","Tenth"};
        JTable Race_Table = new JTable(data,column);
        JScrollPane Scroll_Panel = new JScrollPane(Race_Table);
        Race_Table.setEnabled(false);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        Race_Table.getColumn("Date").setCellRenderer( rightRenderer );
        Race_Table.getColumn("First").setCellRenderer( rightRenderer );
        Race_Table.getColumn("Second").setCellRenderer( rightRenderer );
        Race_Table.getColumn("Third").setCellRenderer( rightRenderer );
        Race_Table.getColumn("Fourth").setCellRenderer( rightRenderer );
        Race_Table.getColumn("Fifth").setCellRenderer( rightRenderer );
        Race_Table.getColumn("Sixth").setCellRenderer( rightRenderer );
        Race_Table.getColumn("Seventh").setCellRenderer( rightRenderer );
        Race_Table.getColumn("Eighth").setCellRenderer( rightRenderer );
        Race_Table.getColumn("Ninth").setCellRenderer( rightRenderer );
        Race_Table.getColumn("Tenth").setCellRenderer( rightRenderer );
        Scroll_Panel.setBounds(150,75,760,300);
        frame.add(Scroll_Panel, BorderLayout.CENTER);

        frame.setResizable(false);
    }
    // ---------------------------------- filtering null object : https://stackoverflow.com/questions/29537639/check-if-returned-value-is-not-null-and-if-so-assign-it-in-one-line-with-one-m ----------
    public String checkDriver(F1RCC_Formula1Driver_w1839054 driver){
        String name="";
        if (driver != null){
            name = driver.getName_of_the_driver();
        }else{
            name = "-";
        }
        return name;
    }

//end of the race table


//beginning of the Driver statistic
    public void F1RCC_Driver_Statistic_w1839054 (ArrayList < F1RCC_Formula1Driver_w1839054 > f1Drivers, ArrayList <F1RCC_Race_w1839054>  Races) {
        //beginning of the common frame
        JFrame frame = new JFrame("Formula_1_Racing_Car_Championship");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        this.f1Drivers = f1Drivers;                                                     // Passing the drivers arrayList from the console to GUI
        this.Races = Races;
        DefaultTableModel Statistic_Table = new DefaultTableModel(data, columnHeading);                        // Managing data for the table

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // end of the common frame
        //back button
        JButton btnBackDS;
        btnBackDS = new JButton("Back");
        btnBackDS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                new F1RCC_GUI_w1839054(f1Drivers, Races);
            }
        });
        btnBackDS.setBounds(480, 10, 130, 30);
        frame.add(btnBackDS);

        JButton btnShowTable;

        btnShowTable = new JButton("Show the Table");

        //________________________________________________ add table into a scroll pane

        btnShowTable.setBounds(330, 10, 130, 30);         //________________________________________________________________ set of rules
        frame.add(btnShowTable);

        JComboBox driverList;

        frame.setLayout(null);
        //frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\admin\\Pictures\\back.png")));

        String[] driverNames = new String[f1Drivers.size()];

        JLabel Placeholder = new JLabel();
        Placeholder.setText("Select A Driver  ");
        Placeholder.setBounds(20,10,150,30);
        frame.add(Placeholder);

        JLabel NamePlaceholder = new JLabel();
        NamePlaceholder.setText("Driver name: ");
        NamePlaceholder.setBounds(75,80,150,30);
        frame.add(NamePlaceholder);

        JLabel NameFeild = new JLabel();
        NameFeild.setText(" Driver Name ");
        NameFeild.setBounds(175,80,150,30);
        frame.add(NameFeild);

        JLabel TeamPlaceholder = new JLabel();
        TeamPlaceholder.setText("Driver Team: ");
        TeamPlaceholder.setBounds(75,130,150,30);
        frame.add(TeamPlaceholder);

        JLabel teamFeild = new JLabel();
        teamFeild.setText(" Driver Team ");
        teamFeild.setBounds(175,130,150,30);
        frame.add(teamFeild);

        JLabel LocationPlaceholder = new JLabel();
        LocationPlaceholder.setText("Driver Location: ");
        LocationPlaceholder.setBounds(75,180,150,30);
        frame.add(LocationPlaceholder);

        JLabel LocationFeild = new JLabel();
        LocationFeild.setText("Driver Location ");
        LocationFeild.setBounds(175,180,150,30);
        frame.add(LocationFeild);

        JLabel ScorePlaceholder = new JLabel();
        ScorePlaceholder.setText("Driver Score: ");
        ScorePlaceholder.setBounds(75,220,150,30);
        frame.add(ScorePlaceholder);

        JLabel ScoreFeild = new JLabel();
        ScoreFeild.setText("000");
        ScoreFeild.setBounds(175,220,150,30);
        frame.add(ScoreFeild);

        JLabel NumRacePlaceholder = new JLabel();
        NumRacePlaceholder.setText("Num of Races: ");
        NumRacePlaceholder.setBounds(75,260,150,30);
        frame.add(NumRacePlaceholder);

        JLabel NUmraceFeild = new JLabel();
        NUmraceFeild.setText(" 000 ");
        NUmraceFeild.setBounds(175,260,150,30);
        frame.add(NUmraceFeild);

        JLabel firstPlaceholder = new JLabel();
        firstPlaceholder.setText("First places: ");
        firstPlaceholder.setBounds(75,300,150,30);
        frame.add(firstPlaceholder);

        JLabel firstPFeild = new JLabel();
        firstPFeild.setText(" 00 ");
        firstPFeild.setBounds(175,300,150,30);
        frame.add(firstPFeild);

        for(int i = 0; i < f1Drivers.size(); i++){
            driverNames[i] = f1Drivers.get(i).getName_of_the_driver();
        }

        driverList = new JComboBox(driverNames);
        driverList.setBounds(110,10,150,30);
        frame.add(driverList);

        String[][] rowdata= new String[0][];
        String column[]={"Date","Position","Driver Name"};
        DefaultTableModel tableModel = new DefaultTableModel(rowdata,column);

        btnShowTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDriver = (String) driverList.getItemAt(driverList.getSelectedIndex());
                tableModel.setNumRows(0);
                String[][] data = SerachDriver(Races,selectedDriver);
                for (String[] row:data) {
                    tableModel.addRow(row);
                }

                int driverindex = 0;
                for (F1RCC_Formula1Driver_w1839054 driver:f1Drivers) {
                    driverindex++;
                    if(driver.getName_of_the_driver().equals(selectedDriver)){
                        break;
                    }
                }

                F1RCC_Formula1Driver_w1839054 selectedDriverObject = f1Drivers.get(driverindex-1);
                NameFeild.setText(selectedDriverObject.getName_of_the_driver() + " Driver");
                teamFeild.setText(selectedDriverObject.getTeam_of_the_driver() + " Team");
                LocationFeild.setText(selectedDriverObject.getTeam_of_the_driver());
                ScoreFeild.setText(String.valueOf(selectedDriverObject.getNumber_of_points()));
                NUmraceFeild.setText(String.valueOf(selectedDriverObject.getNumber_of_races()));
                firstPFeild.setText(String.valueOf(selectedDriverObject.getNumber_of_first_positions()));
            }
        });

        JTable jt=new JTable(tableModel);
        JScrollPane sp=new JScrollPane(jt);
        jt.setEnabled(false);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jt.getColumn("Date").setCellRenderer( rightRenderer );
        jt.getColumn("Position").setCellRenderer( rightRenderer );
        jt.getColumn("Driver Name").setCellRenderer( rightRenderer );
        sp.setBounds(320,60,430,360);
        frame.add(sp);

        frame.setSize(800,500);
        frame.setTitle("Race Manager");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static String[][] SerachDriver(ArrayList<F1RCC_Race_w1839054> raceDataList,String selectedDriver){

        ArrayList <String[]> tableColums = new ArrayList<>();

        for (F1RCC_Race_w1839054 raceItem: raceDataList) {
            HashMap<Integer, F1RCC_Formula1Driver_w1839054> positions = raceItem.getParticipatingDrivers();

            for(int i=0;i<= positions.size(); i++){
                if(positions.get(i) != null){
                    if(positions.get(i).getName_of_the_driver().equals(selectedDriver)){
                        tableColums.add(new String[]{raceItem.getDate(),String.valueOf(i),positions.get(i).getName_of_the_driver()});
                    }
                }
            }

        }

        String[][] tableData = new String[tableColums.size()][3];
        int counter=0;
        for (String[] item:tableColums) {
            tableData[counter] = item;
            counter++;
        }
        return tableData;
    }

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
}
//end of the Driver statistic


//main was shifted to the console

//public static void main(String[] args) {
//F1RCC_Formula1ChampionshipManager_w1839054 obj_race = new F1RCC_Formula1ChampionshipManager_w1839054();
//F1RCC_GUI_w1839054 Home_Page_GUI = new F1RCC_GUI_w1839054(obj_race);

//}