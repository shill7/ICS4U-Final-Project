import java.awt.*;
import javax.swing.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.util.*;  

public class MainGUI {
  static int [] schedule  = new int [30];
  static String  [] activityName = new String [30];

  public static int INTtoHOUR(int holder){
      int hour = holder/4;
      hour = hour +8;
      return hour;
  }

  public static int INTtoMIN(int holder){
    if (holder == 2||holder == 6||holder == 10||holder == 14||holder == 18||holder == 22||holder == 26||holder == 30){
        return 00;
    }else if(holder == 3||holder == 7||holder == 11||holder == 15||holder == 19||holder == 23||holder == 27){
        return 15;
    }else if(holder == 0||holder == 4||holder == 8||holder == 12||holder == 16||holder == 20||holder == 24||holder == 38){
        return 30;
    }else{
        return 45;
      }
  }

  public static int TIMEtoINT(int hour, int min){
      int holder = (hour - 8)*4;
      holder = holder - 4 + (min/15);
      return holder;
  }

  public static String ActivityGen(){
      //Populate the activities done outside of class here
      String [] activities = {"Feed the cat", "Go for a run", "Do a puzzle", "Work on assignment with closest due date", "Clean your room", "Walk the dog", "Read a book", "Watch Miraculous Ladybug", "Wash your hair", "Bake some cookies", "Brush the cat", "Bake a cake", "Meditate", "Journal", "Learn to knit", "Crochet a baby hat to donate", "Make a mask", "Learn a new language", "Do some yoga", "Do a workout", "Paint your nails", "Do a sudoku", "Do a word search", "Do crossword puzzle", "Find out what type of potato you are", "Listen to a podcast", "Play a computer game", "Listen to an audio book", "Clean some windows", "Go for a walk", "Do a craft", "Play some virtual cards", "Watch a crash course video", "Do some karaoke", "Learn/practice sewing"};
      int randValue = (int)( activities.length * Math.random()- 1);
      return activities[randValue];
  }

    //     //Creating GUI
    public MainGUI () {
        JFrame frame = new JFrame("Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.add(new Drawing());
        frame.setVisible(true);
        
     }


    public static String[] sos(){
      Scanner input = new Scanner(System.in);
        //holds the classes that the student has
        activityName [1] = "Gym";
        activityName [2] = "Math";
        activityName [3] = "Chemistry";
        activityName [4] = "Spare";
        activityName [5] = "Geography";
        activityName [6] = "English";
        activityName [7] = "Computer Science";
        activityName [8] = "Careers/Civics";

        schedule [14] = 9;
        schedule [15] = 9;
        activityName[9] = "Lunch";
        activityName [10] = "Free time";

        System.out.println ("What day is it?");
        int day = input.nextInt();
        //case statements for the order of each class depending on cycle day
        switch (day) {
            case 1:
                schedule [2] = 1;
                schedule [3] = 1;
                schedule [5] = 2;
                schedule [6] = 2;
                schedule [9] = 3;
                schedule [10] = 3;
                schedule [12] = 4;
                schedule [13] = 4;
                break;

            case 2:
                schedule [2] = 5;
                schedule [3] = 5;
                schedule [6] = 6;
                schedule [5] = 6;
                schedule [9] = 7;
                schedule [10] = 7;
                schedule [12] = 8;
                schedule [13] = 8;
                break;

            case 3:
                schedule [2] = 3;
                schedule [3] =3;
                schedule [5] = 4;
                schedule [6] =4;
                schedule [9] = 1;
                schedule [10] = 1;
                schedule [12] = 2;
                schedule [13] =2;
                break;

            case 4:
                schedule [2] = 7;
                schedule [3] =7;
                schedule [5] = 8;
                schedule [6] = 8;
                schedule [9] = 5;
                schedule [10] = 5;
                schedule [12] = 6;
                schedule [13] =6;
                break;

            case 5:
                schedule [2] = 4;
                schedule [3] = 4;
                schedule [5] = 3;
                schedule [6]= 3;
                schedule [9] = 2;
                schedule [10] = 2;
                schedule [12] = 1;
                schedule [13] = 1;
                break;

            case 6:
                schedule [2] = 8;
                schedule [3] = 8;
                schedule [6] = 7;
                schedule [6] = 7;
                schedule [9] = 6;
                schedule [10] = 6;
                schedule [12] = 5;
                schedule [13] = 5;
                break;

            case 7:
                schedule [2] = 2;
                schedule [3] = 2;
                schedule [5] = 1;
                schedule [6] = 1;
                schedule [9] = 4;
                schedule [10] = 4;
                schedule [12] = 3;
                schedule [13] = 3;
              break;

            case 8:
                schedule [2] = 6;
                schedule [3] = 6;
                schedule [5] = 5;
                schedule [6] = 5;
                schedule [9] = 8;
                schedule [10] = 8;
                schedule [12] = 7;
                schedule [13] = 7;
                break;
        
            default:
               System.out.println("ERROR: Please enter a number between 1 & 8");
               break;
        }

        int p = 11;

        System.out.println("Do you have any additional activities you'd like to schedule?");
        char ans = input.next().charAt(0);

        Scanner Name = new Scanner(System.in);
      
        while (ans == 'y'){
            System.out.println("What is the name of the activity?");
            activityName [p] = Name.nextLine();

            System.out.println("What is the START HOUR?");
            int hour = input.nextInt();

            System.out.println("What is the START MINIUTE?");
            int min = input.nextInt();

            int increase = TIMEtoINT(hour,min);

            if (TIMEtoINT(hour,min) > 30){
              System.out.println ("Please Enter activities in 24hour time and only between 8:30 and 16:00");
            }

            System.out.println("What is the END HOUR?");
            int hour1 = input.nextInt();

            System.out.println("What is the END MINIUTE?");
            int min1 = input.nextInt();

            if (TIMEtoINT(hour1,min1) > 30){
              System.out.println ("Please Enter activities in 24hour time and only between 8:30 and 16:00");
            }

            while (increase != TIMEtoINT(hour1,min1)){
              schedule [increase] = p;
              increase++;

            }
    
             p++;

            System.out.println("Do you have any additional activities you'd like to schedule?");
            ans = input.next().charAt(0);
          }

        int count = 0;

        do{
            int test = count + 1;
            if (schedule[count] == 0 && schedule[test] == 0){
                activityName[p] = ActivityGen();
                schedule [test] = p;
                schedule [count] = p;
                p++;
            }
            count++;
        }while (count != schedule.length-1);

        int scan =0;
        while (scan != schedule.length ){
          if (schedule [scan] == 0){
            schedule [scan] =10;
          }
          scan++;
        }

        for(int w = 0; w<=schedule.length - 1 ;){
            int hold = schedule[w];
            System.out.println(INTtoHOUR(w) + ":" + INTtoMIN(w) + " --> "+ activityName[hold]);
            w++;
        }

        input.close();
        Name.close();
        return activityName;
    }
    public static void main (String [] args){
         //CALL GUI PRINT
         new MainGUI();
    }
    // //will draw the interface
    class Drawing extends JComponent {

        public void paint (Graphics m){
          //RETRIVE DATE & TIME 
        //This following 2 lines of code was sourced from https://www.javatpoint.com/java-get-current-date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now(); 
        
          Color lavendar = new Color(193, 177, 201);
          m.setColor(lavendar);
          m.fillRect(0,0, 1200, 800);

          Color denim = new Color (48, 50, 64);
          m.setColor(denim);
          Font monoBold = new Font("Monospaced", Font.BOLD, 20);
          m.setFont(monoBold);
          m.drawString("Today's Schedule - "   + dtf.format(now), 410, 25);

          m.drawRect(400, 30, 450, 730);

          String yo[] = new String[30];

          //duplicate of the activityName array to be used by the GUI
          yo = sos();

          Font monoPlain = new Font("Monospaced", Font.PLAIN, 12);
          m.setFont(monoPlain);
          int incrementer = 0;
          for(int w = 0; w<=schedule.length - 1; w ++){
            int hold = schedule[w];
            m.drawString(INTtoHOUR(w) + ":" + INTtoMIN(w) + " --> "+ yo[hold], 410, incrementer + 45);
            incrementer = incrementer + 24;
        }

      }
    } 
}
