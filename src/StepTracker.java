public class StepTracker {
    int stepsPerDayGoalDefault = 10000;
    MonthData[] monthToData;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    //метод чтобы установить новую цель по количеству шагов в день
    public int SetNewGoalStepsPerDay(int newStepsGoal) {
        stepsPerDayGoalDefault = newStepsGoal;
        return stepsPerDayGoalDefault;
    }

}