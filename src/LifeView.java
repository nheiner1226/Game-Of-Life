import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

// Extends pre-defined Frame class; creates a frame object by default
// Implements ViewInterface;
// Implements ActionListener; allows actions to occur after interacting with swing objects
public class LifeView extends Frame implements ViewInterface, ActionListener {

    String description = "";

    int deadCellCount;
    int liveCellCount;

    Music musicObj;
    Color colorOne;
    Color colorTwo;

    int numRows;
    int numCols;
    int numStartCordX;
    int numStartCordY;
    int numSelectedBoard;
    int numIterations;
    int numMilliSecSleep;

    boolean val;
    boolean val2;
    boolean val3;
    boolean val4;
    boolean val5;
    boolean val6;
    boolean val7;


    JPanel newPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    Label inputPrompt = new Label();
    Label inputPrompt2 = new Label();
    Label inputPrompt3 = new Label();
    Label inputPrompt4 = new Label();
    Label inputPrompt5 = new Label();
    Label inputPrompt6 = new Label();
    Label inputPrompt7 = new Label();
    Label outputDescription = new Label();

    TextField numberField = new TextField();
    TextField numberField2 = new TextField();
    TextField numberField3 = new TextField();
    TextField numberField4 = new TextField();
    TextField numberField5 = new TextField();
    TextField numberField6 = new TextField();
    TextField numberField7 = new TextField();

    Button okButton = new Button();
    Button quitButton = new Button();

    // Elements contained within JComboBox are of type String
    JComboBox<String> box1 = new JComboBox<>(new String[] {"Christmas", "Thanksgiving", "Halloween", "July 4th", "Valentine's Day"});

    NumListener listener = null;

    // Sets instance of the LifeView class equal to
    LifeView app = this;

    Button replayBtn = new Button("Return to Initial Screen");
    Button quit2Button = new Button("Quit GameBoard frame");

    // Stacks the Label and TextField objects vertically (in the panel)
    BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);


    public LifeView()   {

        setSize(new Dimension(400, 600));

        okButton.setLabel("Run");
        quitButton.setLabel("Quit");

        // Sets layout of JFrame object
        setLayout(boxlayout);

        add(inputPrompt, null);
        add(numberField, null);
        add(inputPrompt2, null);
        add(numberField2, null);
        add(inputPrompt3, null);
        add(numberField3, null);
        add(inputPrompt4, null);
        add(numberField4, null);
        add(inputPrompt5, null);
        add(numberField5, null);
        add(inputPrompt6, null);
        add(numberField6, null);
        add(inputPrompt7, null);
        add(numberField7, null);

        add(okButton, null);
        add(quitButton, null);

        add(outputDescription, null);

        // Adds default ActionListener object to okButton
        // Determine action taken after okButton is pressed
        okButton.addActionListener(this);

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                // Program quits
                listener.quit();

                // Close frame attribute created by app instance of the LifeView class
                app.dispose();
            }
        }
        );

        box1.setBounds(50, 50, 100, 20);
        add(box1);

        box1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                switchTheme(box1.getSelectedIndex());
            }
        }
        );
    }


    // Required for ActionListener implementation
    @Override
    public void actionPerformed(ActionEvent ae) {

        try {

            // Attributes set to true by default
            val = true;
            val2 = true;
            val3 = true;
            val4 = true;
            val5 = true;
            val6 = true;
            val7 = true;

            // Run validation checks
            validationGUI();

            // Program continues if all validation checks are passed
            if (val && val2 && val3 && val4 && val5 && val6 && val)  {
                listener.numberEntered(numRows, numCols, numStartCordX, numStartCordY, numSelectedBoard, numIterations, numMilliSecSleep);
            }

        }

        catch (Exception e) {

        }

    }

/*
    @Override
    public void displayGUI() {

    }


 */

    public void displayBoard(Object obj, int numberRows, int numberCols)  {

    }


    // Method to switch themes
    // When a different item is selected, a different set of colors will display on certain elements
    public void switchTheme(int themeSelected)   {

        // Christmas
        if (themeSelected == 0)   {
            colorOne = new Color(153, 0, 26);
            colorTwo = new Color(59, 122, 87);
        }

        // Thanksgiving
        if (themeSelected == 1)   {
            colorOne = new Color(128, 64, 0);
            colorTwo = Color.ORANGE;
        }

        // Halloween
        if (themeSelected == 2)   {
            colorOne = new Color(204, 102, 0);
            colorTwo = Color.BLACK;
        }

        // July 4th
        if (themeSelected == 3)   {
            colorOne = new Color(153, 0, 26);
            colorTwo = new Color(0, 128, 255);
        }

        // Valentine's Day
        if (themeSelected == 4)   {
            colorOne = new Color(119, 0, 179);
            colorTwo = new Color(238, 153, 255);
        }

    }


    // Display the game board on the newFrame object
    // Use java swing components including color, border, and button elements
    public void displayBoard3D(Object obj, int numberRows, int numberCols, int currentIterationCount, int sleepTime) {

        // Start music
        String musicPath = "C:\\Windows\\Media\\onestop.mid";
        musicObj = new Music();
        musicObj.playMusic(musicPath);

        JFrame newFrame = new JFrame("Game of Life");

        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        newFrame.setSize(850,850);

		buttonsPanel.setPreferredSize(new Dimension(800 ,300));
		newPanel.setPreferredSize(new Dimension(850,850));

        buttonsPanel.add(replayBtn,null);


        // Determine action taken after replayBtn is pressed
        replayBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Stop music
                musicObj.stopMusic(musicPath);

                // Close newFrame attribute
                newFrame.dispose();
            }
        });

        buttonsPanel.add(quit2Button);

        // Determine action taken after quit2Button is pressed
        quit2Button.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                // Stop music
                musicObj.stopMusic(musicPath);

                // Close newFrame attribute
                newFrame.dispose();
			}

		});


		newFrame.add(buttonsPanel, BorderLayout.NORTH);
        newFrame.add(newPanel, BorderLayout.CENTER);
        newFrame.setVisible(true);

        // New border is a combined border (compound) created from a raised bevel border and a lowered bevel border
        newPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        String objGameBoard[][][] = (String[][][]) obj;

        currentIterationCount = 0;

        try {

            while (true) {

                Graphics graphic = newPanel.getGraphics();
                Graphics boardGraphic = buttonsPanel.getGraphics();

                // Iterates through 3d gameBoard
                // Each element is a 2d gameBoard
                for (int i = 0; i < objGameBoard.length; i++) {

                    // Pass the selected item in the box1 JCombobox as argument
                    switchTheme(box1.getSelectedIndex());


                    // Set colors of the following elements
                    replayBtn.setBackground(colorTwo);
                    replayBtn.setForeground(colorOne);

                    quit2Button.setBackground(colorTwo);
                    quit2Button.setForeground(colorOne);

                    newPanel.setBackground(colorOne);
                    buttonsPanel.setBackground(colorOne);


                    // Pass current iteration of the game board, newPanel Graphic attribute, and two color attributes as arguments
                    GraphicalInterface(objGameBoard[currentIterationCount], graphic, colorOne, colorTwo);
                    currentIterationCount = currentIterationCount + 1;

                    // Creates the font characteristics with boardGraphic Graphic attribute
                    boardGraphic.setFont(new Font("TimesRoman", Font.BOLD, 15));

                    boardGraphic.setColor(colorOne);
                    boardGraphic.setColor(Color.WHITE);

                    // Objects resemble colored in rectangles
                    boardGraphic.fillRect(150,40, 850, 100);
                    boardGraphic.fillRect(150,55, 850, 100);
                    boardGraphic.setColor(colorOne);

                    // Objects resemble text using the font characteristics specified earlier
                    boardGraphic.drawString("Live Cells: " + liveCellCount, 50, 80);
                    boardGraphic.drawString("Dead Cells: " + deadCellCount, 50, 100);


                    Thread.sleep(sleepTime);

                    Thread.sleep(1);
                }

            }

        }

        catch (InterruptedException e) {
            System.out.println("catch in sleep");
        }

    }


    // Colors the board based on dead and living cells
    public void GraphicalInterface(String[][] newGameBoard, Graphics boardGraphic, Color colorOne, Color colorTwo)   {

        // Set the size of individual boxes in the gameBoard
        int boxDimensions = 30;

        liveCellCount = 0;
        deadCellCount = 0;

            // For loop iterates through each array within newGameboard[i][]
            for(int i = 0; i < newGameBoard.length; i++)   {

                // For loop iterates through each array within newGameboard[i][j]
                for(int j = 0; j < newGameBoard[0].length; j++)   {

                    int x = j * boxDimensions;
                    int y = i * boxDimensions;

                    // Set the color of living cells
                    if (newGameBoard[i][j] == "O")  {

                        // Set color of the boardGraphic instance
                        boardGraphic.setColor(colorOne);
                        liveCellCount++;
                    }

                    // Set the color of dead cells
                    else    {

                        // Set color of the boardGraphic instance
                        boardGraphic.setColor(colorTwo);
                        deadCellCount++;
                    }

                    // Creates fillRect object with boardGraphic Graphic attribute
                    boardGraphic.fillRect(y, x, boxDimensions, boxDimensions);

                }

            }

            System.out.println(liveCellCount);
            System.out.println(deadCellCount);

    }


    // Creates a series of validation checks the program uses to make sure the user provides inputs within the desired parameters
    public void validationGUI() {

        numRows = Integer.parseInt(numberField.getText());
        numCols = Integer.parseInt(numberField2.getText());
        numStartCordX = Integer.parseInt(numberField3.getText());
        numStartCordY = Integer.parseInt(numberField4.getText());
        numSelectedBoard = Integer.parseInt(numberField5.getText());
        numIterations = Integer.parseInt(numberField6.getText());
        numMilliSecSleep = Integer.parseInt(numberField7.getText());

        // Number of rows
        if ((numRows < 10) || (numRows > 100))   {
            val = false;
            JOptionPane.showMessageDialog(buttonsPanel, "Enter a number between 10 and 100.");
        }

        // Number of columns
        if ((numCols < 10) || (numCols > 100))   {
            val = false;
            JOptionPane.showMessageDialog(buttonsPanel, "Enter a number between 10 and 100.");
        }

        // Coordinate for starting x position
        if (numStartCordX != numRows/2)   {
            val = false;
            JOptionPane.showMessageDialog(buttonsPanel, "Enter the number equal to half of the value of the rows and columns.");
        }

        // Coordinate for starting x position
        if (numStartCordY != numRows/2)   {
            val = false;
            JOptionPane.showMessageDialog(buttonsPanel, "Enter the number equal to half of the value of the rows and columns.");
        }

        // Number for starting design pattern
        if ((numSelectedBoard < 1) || (numSelectedBoard > 3))   {
            val = false;
            JOptionPane.showMessageDialog(buttonsPanel, "Enter a number between 1 and 3.");
        }

        // Number of iterations
        if ((numIterations < 10) || (numIterations > 30))   {
            val = false;
            JOptionPane.showMessageDialog(buttonsPanel, "Enter a number between 10 and 30.");
        }

        // Number of seconds for sleep thread
        if ((numMilliSecSleep < 500) || (numMilliSecSleep > 2000))   {
            val = false;
            JOptionPane.showMessageDialog(buttonsPanel, "Please enter a number between 500 and 2000.");
        }

    }


    // Set input prompts to values sent from controller component
    @Override
    public void setInputPrompt(String prompt) {
        inputPrompt.setText(prompt);
    }

    @Override
    public void setInputPrompt2(String prompt) {
        inputPrompt2.setText(prompt);
    }

    @Override
    public void setInputPrompt3(String prompt) {
        inputPrompt3.setText(prompt);
    }

    @Override
    public void setInputPrompt4(String prompt) {
        inputPrompt4.setText(prompt);
    }

    @Override
    public void setInputPrompt5(String prompt) {
        inputPrompt5.setText(prompt);
    }

    @Override
    public void setInputPrompt6(String prompt) {
        inputPrompt6.setText(prompt);
    }

    @Override
    public void setInputPrompt7(String prompt) {
        inputPrompt7.setText(prompt);
    }


    // Sets listener component equal to instance created by view component
    @Override
    public void setListener(NumListener listener) {
        this.listener = listener;
    }

    // Set name of window equal to the value from the model component
    public void setWindowName(String name) {
        setTitle(name);
    }

}
