//Country object that initializes key metrics and generates random values for them
//adjust methods are used to change metrics after the question is answered
//checkCrisis method checks if either budget or GDP are negative and terminate the game once the variable is true


public class Country {
        private int budget;
        private double GDP;
        private double happinessIndex;
        private double sustainability;
        private Boolean isCrisis;


        public Country() {
            this.budget = 50+(int)(Math.random()*151); //initial budget is between 50 and 200 billion
            this.GDP = 100+(int)(Math.random()*201); //initial GDP is between 100 and 300 billion
            this.happinessIndex = (int)(Math.random()*10+1); //initial Happiness Index is between 0 and 10
            this.sustainability = (int)(Math.random()*10+1); //initial Sustainability is between 0 and 10
            this.isCrisis = false;
        }

        //adjust metrics methods based on each question's respective values
public void adjustBudget (int amount) {
    this.budget +=  amount;
    checkCrisis();
}
    public void adjustGDP (double amount) {
        this.GDP += amount;
        checkCrisis();
    }
    public void adjustHappinessIndex (double amount  ) {
        this.happinessIndex += amount;
        checkCrisis();
    }
    public void adjustSustainability (double amount) {
        this.sustainability += amount;
        checkCrisis();
    }

    public Boolean checkCrisis() {
            if (budget < 0 || GDP < 0|| sustainability < 0|| happinessIndex < 0) {
                isCrisis = true;
            }
            return isCrisis;
    }

    public int getBudget () {
            return budget;
    }
    public double getGDP () {
        return GDP;
    }

    public double getHappinessIndex () {
        return happinessIndex;
    }
    public double getSustainability () {
        return sustainability;
    }

    public boolean getIsCrisis () {
        return isCrisis;
    }

    public String toString() {
        return"Country Metrics:\n" +"Budget: $" + budget + " billion\n" + "GDP: $" + GDP + " billion\n" + "Happiness Index: " + (happinessIndex) + "%\n" +
                "Sustainability: " + (sustainability) + "%\n" + "Crisis Status: " + isCrisis+ " \n ";

    }
    }
