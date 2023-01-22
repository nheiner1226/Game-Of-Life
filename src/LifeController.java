public class LifeController implements NumListener {

    private ModelInterface model;
    private ViewInterface view;

    static String viewType;


    public LifeController(ViewInterface view, ModelInterface model)   {

        this.view = view;
        this.model = model;

        // Sets the name of the window to the name determined in the model component
        view.setWindowName(model.getWindowName());

        // Sets inputs in the view components
        view.setInputPrompt("Enter the amount of rows: ");
        view.setInputPrompt2("Enter the amount of columns: ");
        view.setInputPrompt3("Enter the y for starting shape center coordinate: ");
        view.setInputPrompt4("Enter the x val for starting shape center coordinate: ");
        view.setInputPrompt5("Select the starting gameboard (1 - Glider, 2 - Beacon, 3 - Middle Weight Spaceship: ");
        view.setInputPrompt6("Enter the number of iterations: ");
        view.setInputPrompt7("Enter the number for sleep: (milliseconds) ");

        // Sets listener object in view components to instance created in this class
        view.setListener(this);

        // Displays the elements of the graphic UI LifeView component
        view.show();

    }


    // Passes int elements to view and model components
    @Override
    public void numberEntered(int num, int num2, int num3, int num4, int num5, int num6, int num7) {

        Music musicObj = new Music();

        // Text display
        if (viewType.equals("LifeViewText"))   {

            // Start music
            String musicPath = "C:\\Windows\\Media\\onestop.mid";
            musicObj.playMusic(musicPath);

            // Sends input values to model class to create board
            model.setNumber(num, num2, num3, num4, num5, num6, num7);

            // Display the initial design to the console
            view.displayBoard(model.printBoard(num5), num, num2);

            try {
                Thread.sleep(num7);
            }

            catch(InterruptedException e)  {
                System.out.println("You encountered an InterruptedException.");
            }


            // Display the following iterations to the console
            for(int i = 0; i < num6; i++)    {

                // Create the next iteration
                view.displayBoard(model.solve(), num, num2);

                try {
                    // Sleep thread (milliseconds)
                    Thread.sleep(num7);
                }

                catch(InterruptedException e)  {
                    System.out.println("You encountered an InterruptedException.");
                }

            }

            // Stop music
            musicObj.stopMusic(musicPath);

        }


        // Graphic display
        else if (viewType.equals("LifeView")) {

            // Sends input values to model class to create board
            model.setNumber(num, num2, num3, num4, num5, num6, num7);

            // Displays initial design
            model.printBoard(num5);

            // Display the following iterations in the JFrame object
            view.displayBoard3D(model.solveGUI(num5), num, num2, num6, num7);

            try {
                Thread.sleep(num7);
            } catch (InterruptedException e) {
                System.out.println("You encountered an InterruptedException.");
            }

        }

    }


    // Program exits if no model or view components
    @Override
    public void quit() {
        view = null;
        model = null;
        System.exit(0);
    }


    // Main method
    public static void main(String args[]) {

        viewType = args[0];

        // If less than 2 arguments are passed to command line, don't run program
        if (args.length < 2) {
            System.out.println("Usage : java NumberProblemController " +
                    "<ViewClassName> <ModelClassName>");
            return;
        }


        try {

            // Accepts user input in command line
            // First argument for View class and second argument for Model class
            new LifeController(
                    (ViewInterface)Class.forName(args[0]).getDeclaredConstructor().newInstance(),
                    (ModelInterface)Class.forName(args[1]).getDeclaredConstructor().newInstance());
        }

        catch (Exception e) {
            System.out.println("Invalid class name supplied");
            e.printStackTrace();
        }

    }

}
