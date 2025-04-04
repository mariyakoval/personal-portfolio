//ScenarioBank contains an array of questions for the game

public class ScenarioBank{
private Scenario[] scenarios;
private int scenarioIndex;
private boolean[] used;

    public ScenarioBank() {
    this.scenarios = new Scenario[100];
    this.used = new boolean[scenarios.length];
    scenarioIndex = 0;
    filling();
}

//method is used to populate an array of questions
private void filling(){
    addScenario(new Scenario(
            "Choose the type of government you would like to be.",
            new String [] {
                    "Democratic government",
                    "Single ruler",
            },
            new int[] {25, 25},
            new double[] {75.0, -50},
            new double[] {2, -2},
            new double[] {2, -2}
    )
    );

    addScenario(new Scenario(
            "People in your country are tired from years of dictatorship. Act to prevent a coup.",
            new String [] {
                    "Help entrepreneurs",
                    "Help people with subsidies",
                    "Build a house by the sea"
            },
            new int[] {50, -20, -95},
            new double[] {70, 30, -70},
            new double[] {-1, 4, -7},
            new double[] {2, 1, -5}
    ));
    addScenario(new Scenario(
            "People started opening businesses, government got more money in taxes. What will you do with it?",
            new String [] {
                    "Invest in programs for people",
                    "Invest in domestic companies",
                    "Buy Gucci bag"
            },
            new int[] {10, 40, -30},
            new double[] {20, 50, -40},
            new double[] {4, 3, -4},
            new double[] {2, -1, 0}
    ));

    addScenario(new Scenario(
            "Economy has diversified. The state is doing well but people don't see direct improvements in their daily lives and the doubt your leadership",
            new String [] {
                    "Invest in science and technology",
                    "Invest in social programs",
                    "Steal some money"
            },
            new int[] {50, -10, -50},
            new double[] {70, 30, -50},
            new double[] {4, 2, 0},
            new double[] {4, 4, -5}
    ));

    addScenario(new Scenario(
            "Research led to discovery of cure for cancer. \nSo you can keep selling this abroad and make it cheaper for the rest of the world.",
            new String [] {
                    "Invest in science and technology",
                    "Redistribute cure",
                    "Privatize medical institutions"
            },
            new int[] {50, 50, 20},
            new double[] {70, 30, -50},
            new double[] {4, 5, -1},
            new double[] {2, 5, -2}
    ));

    addScenario(new Scenario(
            "Building roads and industrial areas costs a large portion of the budget. \nIt made you borrow money from other countries. \nHowever, new changes attracted investors and pushed them to open businesses in your country. That's how you will repay debts.",
            new String [] {
                    "Support domestic businesses",
                    "Admit foreign companies",
                    "Take away private oil company"
            },
            new int[] {-20, 30, -30},
            new double[] {70, 10, -30},
            new double[] {1, -1, -3},
            new double[] {-2, -4, -5}
    ));

    addScenario(new Scenario(
            "You invested a lot in AI and robots developed their own needs. They didn't want to work for free and started protesting.",
            new String [] {
                    "Ignore people",
                    "Fight robots",
                    "Invest more in robots"
            },
            new int[] {30, -50, -50},
            new double[] {30, -10, 40},
            new double[] {-10, 5, -3},
            new double[] {3, -2, -3}
    ));

    addScenario(new Scenario(
            "Unemployment is high. Government needs to introduce social benefits because people have no other ways to earn money. \nHow will you get money for these benefits?",
            new String [] {
                    "Print more money",
                    "Raise taxes",
                    "Hire more family members"
            },
            new int[] {50, 20, -10},
            new double[] {30, -10, -10},
            new double[] {5, -3, -5},
            new double[] {2, 2, 0}
    ));

    addScenario(new Scenario(
            "Suddenly oil crisis comes. You diversified economy in the past but most domestic companies still focused on oil extraction",
            new String [] {
                    "Look for alternative oil usage",
                    "Reorient to the electric industry",
                    "Keep earning from oil industry"
            },
            new int[] {-20, 20, -50},
            new double[] {20, 30, -70},
            new double[] {3, 20, -50},
            new double[] {3, 10, -30}
    ));

    addScenario(new Scenario(
            "Foreign companies came to your country. But because you don't support domestic market, people are not on your side anymore. \nThey riot and ask for change",
            new String [] {
                    "Give social benefits",
                    "Give away cinema tickets",
                    "Support domestic companies"
            },
            new int[] {-30, -50, -50},
            new double[] {30, -20, 30},
            new double[] {4, 2, 1},
            new double[] {-2, 1, 1}
    ));

    addScenario(new Scenario(
            "Climate change affects your country terribly. People lose jobs because of constant floods. ",
            new String [] {
                    "Invest in flood defenses",
                    "Relocate affected industries",
                    "Ask for international support"
            },
            new int[] {-30, -40, 10},
            new double[] {10, 20, 0},
            new double[] {2, 2, 1},
            new double[] {2, 1, -1}
    ));

    addScenario(new Scenario(
            "There are talks that a terrorist attack is being planned on your country",
            new String [] {
                    "Strengthen border security",
                    "Initiate diplomatic talks",
                    "Prepare the military"
            },
            new int[] {-30, 0, -20},
            new double[] {10, 0, -10},
            new double[] {2, 3, -3},
            new double[] {0, 0, -1}
    ));

    addScenario(new Scenario(
            "Media releases secret government papers",
            new String [] {
                    "Promise reforms",
                    "Suppress the media",
                    "Deny and ignore"
            },
            new int[] {-30, -30, -20},
            new double[] {-20, -30, -10},
            new double[] {2, -6, -4},
            new double[] {0, -1, -1}
    ));

    addScenario(new Scenario(
            "Your political rival started an opposition campaign and wants to get your place in the next election",
            new String [] {
                    "Engage in fair competition",
                    "Conduct fake elections",
                    "Launch a counter-campaign"
            },
            new int[] {10, -30, -30},
            new double[] {10, -30, -10},
            new double[] {2, -5, -4},
            new double[] {0, -1, -1}
    ));

    addScenario(new Scenario(
            "The period of drought depleted your resources and led to famine.",
            new String [] {
                    "Request international aid",
                    "Invest in sustainable farming",
                    "Prioritize water conservation"
            },
            new int[] {10, -10, -10},
            new double[] {10, 20, 20},
            new double[] {4, 1, 2},
            new double[] {-3, 3, 3}
    ));
}


private void addScenario (Scenario scenario) {
    if (scenarioIndex < scenarios.length) {
        scenarios[scenarioIndex] = scenario;
        scenarioIndex++;
    }
}

public Scenario getScenario (int i) {
    return scenarios[i];
}

//method to get random scenario that hasn't been used yet and that is not the first scenario
public Scenario getRandomScenario() {
    int index = -1;
    while (index == -1 || used[index]) {
       index = (int) (Math.random() * scenarioIndex+1);
    }
    used[index] = true;
    return scenarios[index];

}

//resetting the array on each game iteration
    public void resetUsed() {
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
    }
}
