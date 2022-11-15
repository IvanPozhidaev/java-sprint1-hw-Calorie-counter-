public class Converter {
    double oneStepDistance = 0.00075;
    double caloriesPerStep = 0.05;

    public void DistanceKilometers (int sumSteps) {
        double distance = sumSteps * oneStepDistance;
        System.out.println("В выбранном месяце пройдено " + distance + " километров.");
    }
    public void CaloriesBurned (int steps) {
        double calories = steps * caloriesPerStep;
        System.out.println("В выбранном месяце сожжено " + calories + " килокалорий.");
    }
}