//Here, the program prints details about the country and selects the random question from the Scenarios bank, as well as prints the options
//After this, user needs to select the valid option .
//Once the correct input is made, the program updates country metrics and prints the current state
//If the country is in crisis, a respective message is printed and the game is terminated

import java.awt.*;

public class Project {
public static void main(String[] args) {
    boolean playAgain = true;
    while (playAgain) {
        Country country = new Country();
        ScenarioBank scenarioBank = new ScenarioBank();

        //before each new game iteration, the array of used scenarios is reset
        scenarioBank.resetUsed();
        Graphics.startAnimation(country);
        int rounds = 0;

        while (rounds < 15 && !country.checkCrisis()) {
            System.out.println(country);
            Scenario scenarioNew;

            //first round is always the same
            if (rounds == 0) {
                scenarioNew = scenarioBank.getScenario(0);
            } else {
                scenarioNew = scenarioBank.getRandomScenario();
            }
            String[] options = scenarioNew.getOptions();

            //based on mouse click in STD draw interface, the program takes the parameter and uses to adjust country statistics
            int selectedOption = Graphics.displayDescription(scenarioNew.getDescription(), options, rounds, country, scenarioBank);
            scenarioNew.answerQuestion(country, selectedOption);
            rounds++;
        }
        //result screen
        if (!country.checkCrisis()) {
            Graphics.win();
        } else {
                Graphics.displayResult(country);
        }
        playAgain = Graphics.drawButton("Start again");
    }
}
}