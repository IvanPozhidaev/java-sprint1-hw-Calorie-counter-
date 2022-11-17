import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        MonthData inner = new MonthData();
        Converter converter = new Converter();

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int inputCommand = scanner.nextInt();
        int monthIndex;

        while(true) {
            switch (inputCommand) {
                case 1:
                    //ввести количество шагов за определённый день
                    System.out.println("Выберите месяц: 1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5- Май, 6 - Июнь\n" +
                            "7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
                    monthIndex = scanner.nextInt();
                    while (true) {
                        if (monthIndex <= 0 || monthIndex > stepTracker.monthToData.length) {
                            System.out.println("Введите действительный номер месяца от 1 до 12");
                            monthIndex = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                    System.out.println("Введите день, за который необходимо обновить количество шагов:");
                    int dayIndex = scanner.nextInt();
                    while (true) {
                        if (dayIndex <= 0 || dayIndex > inner.daysPerMonth.length) {
                            System.out.println("Введите действительный номер дня от 1 до 30");
                            dayIndex = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                    System.out.println("Введите количество шагов за выбранный день:");
                    int newStepsValue = scanner.nextInt();
                    while (true) {
                        if (newStepsValue <= 0) {
                            System.out.println("Введите действительное число шагов больше нуля");
                            newStepsValue = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                    stepTracker.monthToData[monthIndex - 1].UpdateStepsInDay(dayIndex, newStepsValue);
                    break;
                case 2:
                    //статистика за определённый месяц
                    System.out.println("Выберите месяц: 1 - Январь, 2 - Февраль, 3 - Март, 4 - Апрель, 5- Май, 6 - Июнь\n" +
                            "7 - Июль, 8 - Август, 9 - Сентябрь, 10 - Октябрь, 11 - Ноябрь, 12 - Декабрь");
                    monthIndex = scanner.nextInt();
                    while (true) {
                        if (monthIndex <= 0 || monthIndex > stepTracker.monthToData.length) {
                            System.out.println("Введите действительный номер месяца от 1 до 12");
                            monthIndex = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                    stepTracker.monthToData[monthIndex - 1].EveryDayStepsInMonth();
                    System.out.println("\nКоличество шагов за месяц - " +
                            stepTracker.monthToData[monthIndex - 1].SumStepsPerMonth());
                    System.out.println("Среднее количество шагов за месяц - " +
                            stepTracker.monthToData[monthIndex - 1].MeanStepsPerMonth());
                    System.out.println("Максимальное пройденное количество шагов в месяце - " +
                            stepTracker.monthToData[monthIndex - 1].MaxStepsInMonth());
                    converter.DistanceKilometers(stepTracker.monthToData[monthIndex - 1].SumStepsPerMonth());
                    converter.CaloriesBurned(stepTracker.monthToData[monthIndex - 1].SumStepsPerMonth());
                    stepTracker.monthToData[monthIndex - 1].BestSeriesIdentifier();
                    break;
                case 3:
                    //изменение цели по количеству шагов в день
                    System.out.print("Количество шагов в день - новая цель. Введите желаемое число:");
                    int newStepsNumber = scanner.nextInt();
                    while (true) {
                        if (newStepsNumber <= 0) {
                            System.out.println("Новая цель по числу шагов в день должна быть больше нуля");
                            newStepsNumber = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                    System.out.println("Новая цель по количеству шагов в день - " +
                            stepTracker.SetNewGoalStepsPerDay(newStepsNumber));
                    break;
                default:
                    //проверка ввода
                    System.out.println("Ошибка ввода команды. Введите действительную цифру команды.");
                    break;
            }
            printMenu();
            inputCommand = scanner.nextInt();
            if (inputCommand == 0) {
                System.out.println("Выход.");
                break;
            }
        }
        System.out.println("Пользование программой завершено.");

    }
    private static void printMenu () {
        System.out.println("\n\tКакое действие выполняем?");
        System.out.println("1 - Сохранить количество шагов за день");
        System.out.println("2 - Вывод статистики за месяц");
        System.out.println("3 - Изменение целевого количества шагов");
        System.out.println("0 - Выход");

    }

    }