public interface NumListener {

    // Passes int elements to view and model components
    void numberEntered(int numRows, int numCols, int numStartCordX, int numStartCordY, int numSelectedBoard, int numIterations, int numMilliSecSleep) ;

    // Holds code to let user quit
    void quit();

}
