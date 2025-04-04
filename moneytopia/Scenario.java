public class Scenario {
    private String description;
    private String[] options;
    private int[] budgetEffects;
    private double[] gdpEffects;
    private double[] happinessEffects;
    private double[] sustainabilityEffects;

    public Scenario(String description, String[] options, int[] budgetEffects, double[] gdpEffects,
                    double[] happinessEffects, double[] sustainabilityEffects) {
        this.description = description;
        this.options = options;
        this.budgetEffects = budgetEffects;
        this.gdpEffects = gdpEffects;
        this.happinessEffects = happinessEffects;
        this.sustainabilityEffects = sustainabilityEffects;
    }

    public String getDescription() {
        return description;
    }
    public String[] getOptions() {
        return options;
    }

    public void answerQuestion(Country country, int choice) {
country.adjustBudget(budgetEffects[choice]);
        country.adjustGDP(gdpEffects[choice]);
        country.adjustHappinessIndex(happinessEffects[choice]);
        country.adjustSustainability(sustainabilityEffects[choice]);
    }



}
