/*** Jordan Nguyen ***/

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JApplet
{
    Controller panel;

    public void init()
    {
       	panel = new Controller();

        // Import Sounds
        panel.GAME_PANEL.MODEL.correctSFX = getAudioClip(getCodeBase(), "answerCorrect.wav");
        panel.GAME_PANEL.MODEL.accessSFX = getAudioClip(getCodeBase(), "winInternet.wav");
        panel.GAME_PANEL.MODEL.wrongSFX = getAudioClip(getCodeBase(), "answerWrong.wav");

        getContentPane().add(panel.GAME_PANEL);
        setSize(350, 300); // Should the Button Panel be placed underneath
        //setSize(500, 200); // or to the side?
		
    } // init()

    public void destroy()
    {
        panel.GAME_PANEL.MODEL.close();
    } // destroy()

} // Game class
