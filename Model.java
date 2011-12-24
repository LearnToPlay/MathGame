/*** Chris Jeffery ***/

import java.applet.AudioClip;
import java.util.Random;
import javax.swing.Timer;
import java.io.*;

public class Model {

    protected int product;
    protected int numNeeded = 3;
    protected Random rnd;
    // Each String corresponds to one of GamePanel's JLabels
    protected String str, prb, time, msg;
    protected StopWatch watch;
    protected Timer timer;
    protected AudioClip correctSFX, accessSFX, wrongSFX;
    protected FileWriter outputStream = null; // should I use BufferedWriter or PrintStream instead?
    
    Model()
    {
    	rnd = new Random();
    	
    	// start timer & watch
        watch = new StopWatch();
    	
        generateProb();
        gameReplay();

        try {
            // create file for output
            outputStream = new FileWriter("YourRecord.txt"); // added
            outputStream.write("User Name: _____\r\n\r\n");
            // instead of using "\r\n" probably System.getProperty("line.separator") would be better...
        } catch (IOException x)
        { System.out.println("There was an error"); }
    }

    // Generate Random Problems
    protected void generateProb()
    {
        int num1 = rnd.nextInt(11); // numbers 0 to 10
        int num2 = rnd.nextInt(11); // numbers 0 to 10
        product = num1*num2;
        prb = "<html><font face=\"Comic Sans MS\" color =\"BLUE\" size=\"6\"><b>"
                + "What is " + num1 + " x " + num2 + "?"
                + "</b></font></html>";
    }

    protected void answerCorrect()
    {
        try {
            String output = "Problems Left: " + numNeeded
                    + "\r\nElapsed Time: " + watch.getElapsedTime() + "\r\n\r\n";
            outputStream.write(output);
        } catch (IOException x)
        { System.out.println("Could Not Write"); }

        correctSFX.play();
        numNeeded--;
        
        str = "<html>You need to get <font color =\"GREEN\">"
                + numNeeded
                + "</font> more right before you get internet.</html>";
        msg = "Correct!";
        
        generateProb();
    }

    protected void answerWrong()
    {
        wrongSFX.play();
        msg = "<html><font color =\"RED\">"
                + "Your answer is wrong. Please double check your math."
                + "</font></html>";
    }

    protected void answerInvalid()
    {
        wrongSFX.play();
        msg = "<html><font color =\"RED\">Please enter only digits.</font></html>";
    }

    protected void gameReplay()
    {
    	generateProb();
    	
        str = "<html>You need to get <font color =\"GREEN\">"
                + numNeeded
                + "</font> problems right to get internet.</html>";
        msg = "";
        time = "<html>Elapsed Time: <font color =\"GREEN\">0</font> Seconds</html>";
    }

    // ABSOLUTELY MUST CLOSE BEFORE CLOSING APPLICATION
    protected void close()
    {
        try {
            outputStream.write("End of File");
            outputStream.close();
        } catch (IOException x)
        { System.out.println("Nothing to Close"); }
    }

}
