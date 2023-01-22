public class LifeModel implements ModelInterface {

    public int row;
    public int col;
    //3public int numCycles;

    String[][] gameBoard;
    String[][] tempGameBoard;
    String[][][] threeDimBoard;

    String aliveCell = "O";
    String deadCell = " ";

    private int cellCount;

    public int centerRow;
    public int centerCol;

    public int selectedBoard;
    public int iterationsNum;

    public int sleepNum;


    // Create gameBoard with selected initial design
    public String[][] printBoard(int selectedBoard)   {

        // Initialize gameboard objects
        this.gameBoard = new String[row][col];
        this.tempGameBoard = new String[row][col];
        this.threeDimBoard = new String[iterationsNum][row][col];

        for(int i = 0; i <= row-1; i++)   {

            for(int j = 0; j <= col-1; j++)   {

                // Initialize boards
                gameBoard[i][j] = deadCell;
                tempGameBoard[i][j] = deadCell;

                // Create initial designs
                if (selectedBoard == 1)     {
                    gameBoard[centerRow][centerCol-1] = aliveCell;
                    gameBoard[centerRow+1][centerCol] = aliveCell;
                    gameBoard[centerRow+1][centerCol+1] = aliveCell;
                    gameBoard[centerRow][centerCol+1] = aliveCell;
                    gameBoard[centerRow-1][centerCol+1] = aliveCell;

                }

                else if (selectedBoard == 2)   {
                    gameBoard[centerRow][centerCol-1] = aliveCell;
                    gameBoard[centerRow-1][centerCol-1] = aliveCell;
                    gameBoard[centerRow-1][centerCol] = aliveCell;
                    gameBoard[centerRow+1][centerCol+2] = aliveCell;
                    gameBoard[centerRow+2][centerCol+2] = aliveCell;
                    gameBoard[centerRow+2][centerCol+1] = aliveCell;

                }

                else if (selectedBoard == 3)   {
                    gameBoard[centerRow+1][centerCol-1] = aliveCell;
                    gameBoard[centerRow][centerCol-2] = aliveCell;
                    gameBoard[centerRow-1][centerCol-2] = aliveCell;
                    gameBoard[centerRow-2][centerCol-2] = aliveCell;
                    gameBoard[centerRow-2][centerCol-1] = aliveCell;
                    gameBoard[centerRow-2][centerCol] = aliveCell;
                    gameBoard[centerRow-2][centerCol+1] = aliveCell;
                    gameBoard[centerRow-2][centerCol+2] = aliveCell;
                    gameBoard[centerRow-1][centerCol+3] = aliveCell;
                    gameBoard[centerRow+1][centerCol+3] = aliveCell;
                    gameBoard[centerRow+2][centerCol+1] = aliveCell;

                }

            }

        }
        return gameBoard;
    }


    // Method to determine if cell is alive or dead
    public String[][] neighborChecker() {

        for (int i = 0; i <= row - 1; i++) {

            try {

                for (int j = 0; j <= col - 1; j++) {

                    cellCount = 0;

                    // Check for alive cell
                    // Iterate through elements
                    if ((i >= 1) && (j < col - 1)) {
                        if (gameBoard[i - 1][j + 1] == aliveCell) {
                            cellCount++;
                        }
                    }

                    if (j < col - 1) {
                        if (gameBoard[i][j + 1] == aliveCell) {
                            cellCount++;
                        }
                    }

                    if ((i < row - 1) && (j < col - 1)) {
                        if (gameBoard[i + 1][j + 1] == aliveCell) {
                            cellCount++;
                        }
                    }

                    if (i < row - 1) {
                        if (gameBoard[i + 1][j] == aliveCell) {
                            cellCount++;
                        }
                    }

                    if ((i < row - 1) && (j >= 1)) {
                        if (gameBoard[i + 1][j - 1] == aliveCell) {
                            cellCount++;
                        }
                    }

                    if (j >= 1) {

                        if (gameBoard[i][j - 1] == aliveCell) {
                            cellCount++;
                        }

                    }

                    if ((i >= 1) && (j >= 1)) {
                        if (gameBoard[i - 1][j - 1] == aliveCell) {
                            cellCount++;
                        }
                    }

                    if (i >= 1) {
                        if (gameBoard[i - 1][j] == aliveCell) {
                            cellCount++;
                        }
                    }

                    cellConverter(cellCount, i, j);

                }
            }

            catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("You have encountered an ArrayIndexOutOfBoundsException.");
                continue;

            }

        }
        return gameBoard;
    }


    // Method to change cells to either alive or dead
    public String[][] cellConverter(int count, int row, int col)   {

        if (gameBoard[row][col] == deadCell) {

            if (count == 3) {
                tempGameBoard[row][col] = aliveCell;
            }

            else    {
                tempGameBoard[row][col] = deadCell;
            }

        }


        else if (gameBoard[row][col] == aliveCell) {

            if (count == 2 || count == 3)   {
                tempGameBoard[row][col] = aliveCell;
            }

            else    {
                tempGameBoard[row][col] = deadCell;
            }

        }
        return tempGameBoard;
    }


    // Sets the gameBoard variable equal to tempGameBoard
    public String [][] updateGameBoard()    {

        // Outer loop to iterate through rows
        for (int i = 0; i <= row - 1; i++) {

            // Inner loop to iterate through cols
            for (int j = 0; j <= col - 1; j++) {

                gameBoard[i][j] = tempGameBoard[i][j];

            }

        }
        return gameBoard;
    }


    // Called from the LifeController class
    // Passes initial board design and following iterations
    @Override
    public Object solve() {

        neighborChecker();
        updateGameBoard();

        return gameBoard;

    }


    // Called from the LifeController class
    // Passes initial board design and following iterations
    public Object solveGUI(int boardNum)    {

        threeDimBoard[0] = gameBoard;

        printBoard(boardNum);

        for (int i = 0; i < iterationsNum; i++) {

            neighborChecker();
            updateGameBoard();
            addTo3DimBoard(i);

        }

        return threeDimBoard;

    }


    // Adds each 2d array to 3d array
    public void addTo3DimBoard(int num) {

        for (int i=0; i<row; i++) {

            for (int j=0; j<col; j++) {
                threeDimBoard[num][i][j] = gameBoard[i][j];
            }

            System.out.println();

        }

    }


    // Set values of row and col to user inputs
    public void setInitialRowColValues(int num1, int num2)    {
        row = num1;
        col = num2;
    }


    // Set numbers equal to values received from controller component
    @Override
    public void setNumber(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.row = n;
        this.col = n2;
        this.centerRow = n3;
        this.centerCol = n4;
        this.selectedBoard = n5;
        this.iterationsNum = n6+1;
        this.sleepNum = n7;
    }


    @Override
    // Return the window name
    public String getWindowName()   {
        return "Game of Life";
    }

}