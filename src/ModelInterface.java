public interface ModelInterface {

    // Code to create the game board object in model component and is used to pass to LifeViewText component
    Object solve();

    // Code to create the game board object in model component and is used to pass to LifeView component
    Object solveGUI(int boardNum);

    // Set numbers equal to values received from controller component
    void setNumber(int numRows, int numCols, int numStartCordX, int numStartCordY, int numSelectedBoard, int numIterations, int numMilliSecSleep);

    // Return the name of the window containing the JFrame object
    // For the graphic UI
    String getWindowName();

    // Determines the number of rows and columns
    void setInitialRowColValues(int numRows, int numCols);

    // Method to print initial board
    String[][] printBoard(int selectedBoard);

}
