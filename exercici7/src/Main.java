import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declare scanner
        Scanner input = new Scanner(System.in);

        //Declare variables
        final int baseSalary = 1250;
        final int extraHoursBase = 15;
        final int extraHoursMoreThan5 = 12;
        final int extraHourBreak = 5;
        final int baseCovidSalary = 250;
        final int extraHourCovid = 5;
        int salary = 0;
        int hasExtraHours = 0;
        int isExposedToCovid = 0;
        int extraHours = 0;
        boolean goodExtraHours = false;

        //Ask if the user has made extra hours
        System.out.println("You have a base salary of " + baseSalary);
        System.out.println("Did you do extra hours?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        do {
            //Check if the input is a number or not
            if (input.hasNextInt())
            {
                hasExtraHours= input.nextInt();
                //If it's a number, check if it's between 1 and 2
                if (hasExtraHours != 1 && hasExtraHours != 2) {
                    //If it's not, ask again
                    System.out.println("That's not a valid number");
                } else {
                    goodExtraHours = true;
                }
            } else{
                //If it's not a number, ask again
                System.out.println("That's not a number");
            }
            //Clear input
            input.nextLine();
        } while(!goodExtraHours);

        //If the user has made extra hours, ask them how many
        if (hasExtraHours == 1) {
            System.out.println("How many hours?");
            do {
                //Check if the input is a number or not
                if (input.hasNextInt()) {
                    extraHours = input.nextInt();
                    //If it's a number, check if it's positive
                    if (extraHours < 0) {
                        //If it's not, ask again
                        System.out.println("That's not a valid number");
                    } else {
                        if (extraHours > extraHourBreak) {
                        //Calculate the salary if more than 5 extra hours
                            salary = baseSalary + (extraHourBreak * extraHoursBase) + ((extraHours - extraHourBreak) * extraHoursMoreThan5);
                        } else {
                            //Calculate the salary if less or equal than 5 extra hours
                            salary = baseSalary + extraHours * extraHoursBase;
                        }
                    }
                } else {
                    //If it's not a number, ask again
                    System.out.println("That's not a number");
                }
                //Clear input
                input.nextLine();
            } while (extraHours < 0);
        } else {
            //If the user has no extra hours, assign the base salary
            salary = baseSalary;
        }

        //Ask the user if they're exposed to covid 19
        System.out.println("Are you exposed to covid19?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        do {
            //Check if the input is a number or not
            if (input.hasNextInt())
            {
                isExposedToCovid= input.nextInt();
                //If it's a number, check if it's between 1 and 2
                if (isExposedToCovid != 1 && isExposedToCovid != 2) {
                    //If it's not, ask again
                    System.out.println("That's not a valid number");
                } else {
                    //Calculate the bonus salary if the user is exposed
                    if (isExposedToCovid == 1)
                    {
                        salary = salary + baseCovidSalary + extraHourCovid * extraHours;
                    }
                }
            } else{
                //If it's not a number, ask again
                System.out.println("That's not a number");
            }
            //Clear input
            input.nextLine();
        } while(isExposedToCovid != 1 && isExposedToCovid != 2);

        System.out.println("Your final salary is: " + salary);

    }
}