

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartPanel
{
    JPanel cards; //a panel that uses CardLayout
    JButton cardChangeButton, button1;
    JTextField textField;
    final static String BUTTONPANEL = "This is the First Card";
    final static String TEXTPANEL = "This is the second Card";
    final static String GAMEPANEL = "Card with MathGame";

    public void addComponentToPane(Container pane)
    {
        // these will be contained in the OuterPane
        JLabel hello = new JLabel("Start up");
        cardChangeButton = new JButton("Next Card");
        cardChangeButton.addActionListener(new ButtonListener());

        // OuterPane will be placed above the cards
        JPanel OuterPane = new JPanel();
        OuterPane.add(hello);
        OuterPane.add(cardChangeButton);

        /** Create the "cards" **/
        // card1 is the title/start-up page
        JLabel place = new JLabel("Welcome to the Game");
        JPanel card1 = new JPanel();
        card1.add(place);

        // provide the content that will be on card2
        // right now, it's just a textfield, button, and combobox
        JLabel settings = new JLabel("Settings");
        textField = new JTextField("TextField", 20);
        button1 = new JButton("Button 1");
        // button1.addActionListener(new ButtonListener());
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL, GAMEPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        // cb.addActionListener(new ButtonListener());

        // card2 will be the settings page
        JPanel card2 = new JPanel();
        card2.add(settings);
        card2.add(textField);
        card2.add(button1);
        card2.add(cb);

        // card3 will be the actual game
        JLabel blank = new JLabel("This is where the game will be");
        JPanel card3 = new JPanel();
        card3.add(blank);

        //Create the panel that actually contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);
        cards.add(card3, GAMEPANEL);

        // put everything together
        pane.add(OuterPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == cardChangeButton)
            {
                CardLayout c1 = (CardLayout)cards.getLayout();
                c1.next(cards); // to show the next card
                // c1.first(cards); // to show the first card
                // c1.show(cards, TEXTPANEL); // to show a specific card, cards are identified by their names(Strings)
                
            }
        }
    }

    public static void main(String[] args)
    {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        StartPanel demo = new StartPanel();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    } // main()
}