public interface ViewInterface {

    // Display text prompts to console
    void show();


    // Displays game board
    // Used by the LifeViewText class
    void displayBoard(Object obj, int numberRow, int numberCol);


    // Displays game board
    // Used by the LifeView class
    void displayBoard3D(Object obj, int numberRows, int numberCols, int currentInterationCount, int sleepTime);


    // Set input prompts
    void setInputPrompt(String prompt);

    void setInputPrompt2(String prompt);

    void setInputPrompt3(String prompt);

    void setInputPrompt4(String prompt);

    void setInputPrompt5(String prompt);

    void setInputPrompt6(String prompt);

    void setInputPrompt7(String prompt);


    // Sets listener component equal to instance created by view component
    void setListener(NumListener listen);

    // Set name of window
    void setWindowName(String name);

}
