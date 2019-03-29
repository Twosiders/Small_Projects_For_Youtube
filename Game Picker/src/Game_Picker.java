/* GAME PICKER APP - created by 2Siders
Reads a .txt file which contains a list of video games
Picks a random video game
Using an interface, it shows selected game
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Frame;

public class Game_Picker extends Frame{
    private Label lblListofGames;
    private TextField tfChosenGame, tfMinNum, tfMaxNum, tfRandomNum;
    private Button btnRandomGame, btnRandomNum;
    private Random randomNumber;
    private Panel pnl0,pnl1,pnl2,pnl3;
    ArrayList<String> listofGames;

    public Game_Picker() throws Exception{
        pnl0 = new Panel();          // Panel is a container
        pnl0.setLayout(new GridLayout(5,5,3,3)); //components left to right
        pnl1 = new Panel();          // Panel is a container
        pnl1.setLayout(new FlowLayout()); //components left to right
        pnl2 = new Panel();          // Panel is a container
        pnl2.setLayout(new FlowLayout()); //components left to right

        //-------------PANEL 0 and FILE READER--------------
        lblListofGames = new Label("The List of Games is:" +
                "\n--------------------\n");
        pnl0.add(new Label("The list of Games is:"));
        add(pnl0, BorderLayout.NORTH);


        //saves text file into variable 'file' and open a buffered reader on it.
        //each line is saved to an arraylist and printed out
        listofGames = new ArrayList<String>();
        File file = new File("C:\\Users\\Jimmy\\Desktop\\Game Picker\\list_of_games.txt");
        BufferedReader buffReader = new BufferedReader(new FileReader(file));
        String line;
        int numofGames = 0;
        System.out.print("The List of Games is:" +
                "\n--------------------\n");

        while((line = buffReader.readLine()) != null) {
            listofGames.add(line);
            pnl0.add(new Label(""+line)).setBackground(Color.green);
            numofGames++;
        }
        System.out.println(listofGames+"\nThe number of games on the list is: "+numofGames);

        //-------------PANEL 1 COMPONENTS--------------
        //Create new components and add them to 'super' frame.
        pnl1.add(new Label("Game Title:"));
        tfChosenGame = new TextField("",30);
        tfChosenGame.setEditable(false);
        pnl1.add(tfChosenGame);
        btnRandomGame = new Button("Pick a Game");
        pnl1.add(btnRandomGame);
        btnRandomGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomNumber = new Random();
                int index = randomNumber.nextInt(listofGames.size());
                tfChosenGame.setText(listofGames.get(index));
            }
        });
        add(pnl1, BorderLayout.CENTER);

        //-------------PANEL 2 COMPONENTS--------------
        tfMinNum = new TextField("",10);
        tfMaxNum = new TextField("",10);
        tfRandomNum = new TextField("",10);
        btnRandomNum = new Button("Generate");
        btnRandomNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int min = Integer.parseInt(tfMinNum.getText());
                int max = Integer.parseInt(tfMaxNum.getText());
                Random randomNum = new Random();
                int randomInt = min + randomNum.nextInt(max);
                tfRandomNum.setText(""+randomInt);
            }
        });
        pnl2.add(new Label("Min:"));
        pnl2.add(tfMinNum);
        pnl2.add(new Label("Max:"));
        pnl2.add(tfMaxNum);
        pnl2.add(tfRandomNum);
        pnl2.add(btnRandomNum);
        add(pnl2, BorderLayout.SOUTH);

        setTitle("Game Picker");  // "super" Frame sets its title
        setSize(750, 500);
        setVisible(true);
    }

    //<MAIN METHOD>
    public static void main(String[] args) throws Exception {
        Game_Picker app = new Game_Picker();

    }
}
