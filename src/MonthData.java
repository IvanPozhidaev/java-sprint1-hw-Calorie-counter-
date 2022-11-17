public class MonthData {
    int[] daysPerMonth = new int[30];
    public int stepsPerDayGoalDefault = 10000;
    //метод - сумма шагов за месяц
    public int SumStepsPerMonth() {
        int sumStepsPerMonth = 0;
        for (int i = 0; i < daysPerMonth.length; i++) {
            sumStepsPerMonth = sumStepsPerMonth + daysPerMonth[i];
        }
        return sumStepsPerMonth;
    }
    //метод - печать количества шагов за каждый день в выбранном месяце
    public void EveryDayStepsInMonth () {
        for (int i = 1; i <= daysPerMonth.length; i++) {
            System.out.print("День " + i + ": " + daysPerMonth[i - 1] + ", ");
        }
    }

    //метод - среднее число шагов за месяц
    public double MeanStepsPerMonth () {
        int sum = 0;

        for (int i = 0; i < daysPerMonth.length; i++){
            sum = sum + daysPerMonth[i];
        }
        return (double) sum / daysPerMonth.length;
    }

    //метод - максимальное пройденное количество шагов в месяце
    public int MaxStepsInMonth () {
        int maxSteps = 0;
        for (int i = 0; i < daysPerMonth.length; i++){
            if (daysPerMonth[i] > maxSteps) {
                maxSteps = daysPerMonth[i];
            }
        }
        return maxSteps;
    }

    //метод - обновление количества шагов за день
    public void UpdateStepsInDay (int dayIndex, int stepsNumber) {
        daysPerMonth [dayIndex - 1] = stepsNumber;
        System.out.println("Новое количество шагов в выбранном месяце" +
                " за " + dayIndex + " день - " + stepsNumber);
    }

    //метод - вычислить лучшую серию (количество подряд идущих дней, когда количество шагов было >= цели)
    public void BestSeriesIdentifier () {
        int daysInRow = 0;
        int bestDaysSeries = 0;

        for (int i = 1; i <= daysPerMonth.length; i++) {
            if (daysPerMonth[i - 1] >= stepsPerDayGoalDefault) {
                daysInRow = daysInRow + 1;
                if(bestDaysSeries < daysInRow) {
                    bestDaysSeries = daysInRow;
                }
            } else if (daysPerMonth[i - 1] < stepsPerDayGoalDefault) {
                daysInRow = 0;
            }
        }
        System.out.println("Лучшая серия - " + bestDaysSeries);
    }

}
