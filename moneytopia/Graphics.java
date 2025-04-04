import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Graphics {
    public static void startAnimation(Country country) {

        StdDraw.setCanvasSize(405, 720);
        StdDraw.setXscale(0, 405);
        StdDraw.setYscale(0, 720);
        StdDraw.enableDoubleBuffering();

        //screen with game rules
        StdDraw.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 30));
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledRectangle(0, 720, 405, 432);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledRectangle(0, 338, 312, 143);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledCircle(315, 285, 90);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.line(10, 635, 65, 635);
        StdDraw.text(185, 632, "Welcome to ");
        StdDraw.text(185, 600, "Moneytopia!");
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.setFont(new java.awt.Font("Verdana", Font.PLAIN, 14));
        double leftX = 40;
        StdDraw.textLeft(leftX, 555, "You will face a number of real world cases.");
        StdDraw.textLeft(leftX, 535, "As a president of Moneytopia, you have to ");
        StdDraw.textLeft(leftX, 515, "make decisions that will lead your country");
        StdDraw.textLeft(leftX, 495, "to prosperity without falling into crisis.");
        StdDraw.show();
        // StdDraw.pause(2000);
        StdDraw.show();
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(0, 261, 311, 110);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledRectangle(396, 338, 321, 110);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledCircle(315, 242, 91);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.filledCircle(90, 358, 91);


        //country info screen
        StdDraw.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 30));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(15, 373, 55, 373);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(200, 370, "Country details");
        StdDraw.setFont(new java.awt.Font("Verdana", Font.PLAIN, 18));
        StdDraw.textLeft(leftX, 330, "Budget: " + country.getBudget() + " billion");
        StdDraw.textLeft(leftX, 305, "GDP: " + country.getGDP() + " billion");
        StdDraw.textLeft(leftX, 280, "Happiness Index: " + country.getHappinessIndex());
        StdDraw.textLeft(leftX, 255, "Sustainability Index: " + country.getSustainability());
        StdDraw.textLeft(leftX, 230, "Crisis status: " + country.getIsCrisis());

        StdDraw.show();
        StdDraw.show();

        //button design
        String s = "Start the game";
        drawButton(s);
        StdDraw.clear();
    }

    //questions section
    public static int displayDescription(String description, String[] options, int round, Country country, ScenarioBank scenarioBank) {
        while (round < 15 && !country.checkCrisis()) {
            displayBackground();
            displayRounds(round);
            displayCountry(country);

            int numChar = 35;
            String currLine = "";
            int heightLineY = 390;
            int lineNum = 0;

// description and options display
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.line(10, 635, 65, 635);

            //splitting words for the question description
            //I split sentences into an array of words separated by a space character
            String[] words = description.split(" ");
            for (String word : words) {
                //checking if the word fits line character limit
                if ((currLine + " " + word).length() <= numChar) {
                    if (!currLine.isEmpty()) {
                        currLine += " ";
                    }
                    currLine += word;
                    //if it doesn't fit, then the word is moved to a different line
                } else {
                    StdDraw.textLeft(40, heightLineY - (lineNum * 25), currLine);
                    currLine = word;
                    lineNum++;
                }
            }
            //final line for remaining text
            if (!currLine.isEmpty()) {
                StdDraw.textLeft(40, heightLineY - (lineNum * 25), currLine);
            }
            StdDraw.show();

            //drawing blue backfround for each option
            StdDraw.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 16));
            int optionStart = heightLineY - (lineNum + 1) * 25 - 50;
            for (int i = 0; i < options.length; i++) {
                StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                StdDraw.filledRectangle(192, optionStart - (i * 50), 170, 21);
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.textLeft(40, optionStart - (i * 50), (i + 1) + ". " + options[i]);
            }
            StdDraw.show();

            //based on the area of user mouse click, the program calculates the respective value of i and translates it into the choice
            int selected = -2;
            while (selected < 0) {
                if (StdDraw.isMousePressed()) {
                    double mouseX = StdDraw.mouseX();
                    double mouseY = StdDraw.mouseY();
                    for (int i = 0; i < options.length; i++) {
                        double rectY = optionStart - (i * 50);
                        double rectHeight = 42;
                        if (mouseX >= 22 && mouseX <= 362 && mouseY >= rectY - rectHeight / 2 && mouseY <= rectY + rectHeight / 2) {
                            selected = i;
                            break;
                        }
                    }
                    StdDraw.pause(100);
                }
            }
//choice is sent to country
            displayChoice(options, selected);
            displayResult(country);
            StdDraw.show();
            return selected;
        }
        return round;
    }

    public static boolean drawButton(String s) {
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledRectangle(260, 83, 100, 30);
        StdDraw.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 14));
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(260, 80, s);
        StdDraw.show();
        boolean isHovered = false;

        //mouse clicks and hover effect are done here
        while (true) {
            double mouseX = StdDraw.mouseX();
            double mouseY = StdDraw.mouseY();

            //mouse is inside button box
            boolean b = mouseX >= 260 - 100 && mouseX <= 260 + 100 && mouseY >= 83 - 30 && mouseY <= 83 + 30;
            if (b) {
                if (!isHovered) {
                    StdDraw.setPenColor(StdDraw.GRAY);
                    StdDraw.filledRectangle(260, 83, 100, 30);
                    StdDraw.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 14));
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(260, 80, s);
                    StdDraw.show();
                    isHovered = true;
                }
            } else {
                if (isHovered) {
                    StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                    StdDraw.filledRectangle(260, 83, 100, 30);
                    StdDraw.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 14));
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(260, 80, s);
                    StdDraw.show();
                    isHovered = false;
                }
            }

            if (StdDraw.isMousePressed()&& b) {
                while (StdDraw.isMousePressed()) {
                    StdDraw.pause(20);
                }
                StdDraw.clear();
                StdDraw.show();
                return true;

            }
        }
    }


    public static void displayBackground() {
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledRectangle(0, 720, 4300, 3000);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledRectangle(0, 720, 3000, 3000);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledCircle(316, 202, 90);
        StdDraw.show();
    }

    public static void displayRounds (int round) {
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.setFont(new java.awt.Font("Verdana", Font.PLAIN, 16));
        StdDraw.textLeft(280, 632, "Round " + (round + 1));
    }

    public static void displayCountry(Country country) {
        StdDraw.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 30));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(40, 585, "Country details");
        StdDraw.setFont(new java.awt.Font("Verdana", Font.PLAIN, 18));
        StdDraw.textLeft(40, 545, "Budget: " + country.getBudget() + " billion");
        StdDraw.textLeft(40, 520, "GDP: " + country.getGDP() + " billion");
        StdDraw.textLeft(40, 495, "Happiness Index: " + country.getHappinessIndex());
        StdDraw.textLeft(40, 470, "Sustainability Index: " + country.getSustainability());
        StdDraw.textLeft(40, 445, "Crisis status: " + country.getIsCrisis());
    }

    public static void displayChoice (String [] options, int selected) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(new Font("Verdana", Font.BOLD, 20));
        StdDraw.text(200, 360, "You chose: ");
        StdDraw.text(200, 330, options[selected]);
        StdDraw.show();
        StdDraw.pause(1500);
    }

    //method is used when country gets into crisis and the game terminates before reaching 15 rounds
    public static void displayResult (Country country) {
        StdDraw.clear();
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(40, 600, 100, 100);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.picture(200, 360, "crisis.png", 405, 720);
        StdDraw.setFont(new Font("Verdana", Font.BOLD, 24));
        StdDraw.text(200, 360, "Game Over: Crisis!");

        //based on the metric that went negative, the specific comment is shown
        if (country.getBudget()<0) {
            StdDraw.text(200, 335, "You ran out of money");
        } else if (country.getGDP()<0) {
            StdDraw.text(200, 335, "Your DGP is too small");
        } else if (country.getSustainability()<0) {

            StdDraw.text(200, 335, "You depleted all ");
            StdDraw.text(200, 310, "natural resources");
        } else {
            StdDraw.text(200, 335, "People are depressed");
        }
        Graphics.displayCountry(country);
    }

    // method is used for successful competition of the game
    public static void win(){
        StdDraw.picture(200, 360, "win.png", 405, 720);
        StdDraw.setFont(new Font("Verdana", Font.BOLD, 24));
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(200, 360, 300, 40);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(200, 370, "Congratulations!");
        StdDraw.text(200, 350, "You made it!");
    }
}