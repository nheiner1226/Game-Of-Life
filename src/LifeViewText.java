public class LifeViewText implements ViewInterface {

    String prompt = "";
    String prompt2 = "";
    String prompt3 = "";
    String prompt4 = "";
    String prompt5 = "";
    String prompt6 = "";
    String prompt7 = "";
    String name = "";

    NumListener listener = null;


    // Display text prompts to console
    @Override
    public void show() {

        int numRows;
        int numCols;
        int numStartCordX;
        int numStartCordY;
        int numSelectedBoard;
        int numIterations;
        int numMilliSecSleep;

        int answer;

        // Determine status of inputs
        boolean inputsAsked = false;

        while (!inputsAsked)    {


            // Display input prompts to user/
            // Validation check
            System.out.println(getInputPrompt());
            numRows = readInt();
            while   (numRows < 10 || numRows > 100)  {
                System.out.println("Enter a number between 10 and 100.");
                numRows = readInt();
            }

            System.out.println(getInputPrompt());
            numCols = readInt();
            while   (numCols < 10 || numCols > 100)  {
                System.out.println("Enter a number between 10 and 100.");
                numCols = readInt();
            }

            System.out.println(getInputPrompt3());
            numStartCordX = readInt();
            while   (numStartCordX != (numRows/2))   {
                System.out.println("Enter the number equal to half of the value of the rows and columns.");
                numStartCordX = readInt();
            }

            System.out.println(getInputPrompt4());
            numStartCordY = readInt();
            while   (numStartCordY != (numRows/2))   {
                System.out.println("Enter the number equal to half of the value of the rows and columns.");
                numStartCordY = readInt();
            }

            System.out.println(getInputPrompt5());
            numSelectedBoard = readInt();
            while   (numSelectedBoard < 1 || numSelectedBoard > 3)   {
                System.out.println("Enter a number between 1 and 3.");
                numSelectedBoard = readInt();
            }

            System.out.println(getInputPrompt6());
            numIterations = readInt();
            while   (numIterations < 10 || numIterations > 30)   {
                System.out.println("Enter a number between 10 and 30.");
                numIterations = readInt();
            }

            System.out.println(getInputPrompt7());
            numMilliSecSleep = readInt();
            while   (numMilliSecSleep < 500 || numMilliSecSleep > 2000)  {
                System.out.println("Please enter a number between 500 and 2000.");
                numMilliSecSleep = readInt();
            }

            // Pass user inputs to controller component
            listener.numberEntered(numRows, numCols, numStartCordX, numStartCordY, numSelectedBoard, numIterations, numMilliSecSleep);

            System.out.println("Do you want to run the program again? (1 - yes, 2 - no)");

            answer = readInt();

            if(answer == 2)    {
                inputsAsked = true;
                listener.quit();
            }

        }

    }


    // Displays game board
    @Override
    public void displayBoard(Object obj, int numberRows, int numberCols) {

        int alive = 0;
        int dead = 0;

        String objGameBoard[][] = (String[][]) obj;

        for (int i = 0; i <= numberRows - 1; i++) {

            for (int j = 0; j <= numberCols - 1; j++)  {

                if (objGameBoard[i][j] == "O")   {
                    alive++;
                }

                else if (objGameBoard[i][j] == " ")   {
                    dead++;
                }

            }

            System.out.println(java.util.Arrays.toString(objGameBoard[i]));
        }

        System.out.println(alive);
        System.out.println(dead);

    }

    // Displays game board
    // Used by the LifeView class
    @Override
    public void displayBoard3D(Object obj, int numberRows, int numberCols, int currentInterationCount, int sleepTime) {

    }


    // Input prompt setters
    @Override
    public void setInputPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setInputPrompt2(String prompt) {
        this.prompt2 = prompt;
    }

    public void setInputPrompt3(String prompt) {
        this.prompt3 = prompt;
    }

    public void setInputPrompt4(String prompt) {
        this.prompt4 = prompt;
    }

    public void setInputPrompt5(String prompt) {
        this.prompt5 = prompt;
    }

    public void setInputPrompt6(String prompt) {
        this.prompt6 = prompt;
    }

    public void setInputPrompt7(String prompt) { this.prompt7 = prompt; }


    // Input prompt getters
    private String getInputPrompt()  {
        return prompt;
    }

    private String getInputPrompt2()  {
        return prompt2;
    }

    private String getInputPrompt3()  {
        return prompt3;
    }

    private String getInputPrompt4() { return prompt4; }

    private String getInputPrompt5()  {
        return prompt5;
    }

    private String getInputPrompt6() {
        return prompt6;
    }

    private String getInputPrompt7() {
        return prompt7;
    }

    /*
    public void displayBoard3D(Object obj, int numberRows, int numberCols, int currentInterationCount)  {

    }


     */

    @Override
    // Sets listener component equal to instance created by view component
    public void setListener(NumListener listener) {
        this.listener = listener;
    }

    @Override
    public void setWindowName(String name) {
        this.name = name;
    }

    public String getWindowName() {
        return name;
    }


    //
    private static int readInt() {
        int ch;
        String inString = "";
        try {
            while (((ch = System.in.read()) >= 0) && (
                    ch != '\n'))
                inString = inString + (char) ch;
            return Integer.valueOf(inString.trim()).intValue();
        }
        catch(Exception e) {}
        return 0;
    }

}
