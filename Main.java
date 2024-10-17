/*
* Task Schedualer:
* This program takes a date from user and calculates amount of days until that date
* It also shows a workday countdown that excludes weekends and Holidays. Some Holidays are
* not on a set date and are estimated. For example Easter is set to date of 04/06
* To remove any holiday cut out 4 lines of code for that particular holiday.
* To remove Memorial day remove these lines 69-72:
*  if (date.getDayOfMonth() == 26 && date.getMonth() == Month.MAY){
*    System.out.println("Found Memorial Day");
*            isHoliday = true;
*        }
* */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class Main {

    private static boolean isWorkDay(LocalDate date){

        DayOfWeek day = date.getDayOfWeek(); //finds date's day of week

        //if Holiday is true return false. It is not a workday
        if(isHoliday(date))
            return false;

        //return true if not saturday or sunday
        return day != DayOfWeek.SATURDAY ||
                day != DayOfWeek.SUNDAY;
    }
    private static boolean isHoliday(LocalDate date) {
        boolean isHoliday = false;
        if (date.getDayOfMonth() == 25 && date.getMonth() == Month.DECEMBER){
            System.out.println("Found Christmas");
            isHoliday = true;
        }
        if (date.getDayOfMonth() == 24 && date.getMonth() == Month.NOVEMBER){
            System.out.println("Found ThanksGiving");
            isHoliday = true;
        }
        if (date.getDayOfMonth() == 4 && date.getMonth() == Month.JULY){
            System.out.println("Found 4th of July");
            isHoliday = true;
        }
        if (date.getDayOfMonth() == 1 && date.getMonth() == Month.JANUARY){
            System.out.println("Found New years");
            isHoliday = true;
        }

        //Holidays without a set date are estimated.
        if (date.getDayOfMonth() == 6 && date.getMonth() == Month.APRIL){
            System.out.println("Found EASTER");
            isHoliday = true;
        }
        if (date.getDayOfMonth() == 21 && date.getMonth() == Month.JANUARY){
            System.out.println("Found MLK DAY");
            isHoliday = true;
        }
        if (date.getDayOfMonth() == 21 && date.getMonth() == Month.FEBRUARY){
            System.out.println("Found President's DAY");
            isHoliday = true;
        }
        if (date.getDayOfMonth() == 26 && date.getMonth() == Month.MAY){
            System.out.println("Found Memorial Day");
            isHoliday = true;
        }
        if (date.getDayOfMonth() == 7 && date.getMonth() == Month.SEPTEMBER){
            System.out.println("Found Labour Day");
            isHoliday = true;
        }
        if (date.getDayOfMonth() == 10 && date.getMonth() == Month.OCTOBER){
            System.out.println("Found Columbus Day");
            isHoliday = true;
        }

        return isHoliday;
    }
    public static void main(String[] args) {

        //autoMaticTesting();
        LocalDate now = LocalDate.now();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Type in the Month of the Date");
        int dueMonth = scanner.nextInt();
        System.out.println("Type in the Day of the Date");
        int dueDay = scanner.nextInt();
        System.out.println("Type in the Year of the Date");
        int dueYear = scanner.nextInt();
        //This is the dueDate
        LocalDate dueDate = LocalDate.of(dueYear, dueMonth, dueDay);

        int days = now.until(dueDate).getDays();
        int months = now.until(dueDate).getMonths();
        int years = now.until(dueDate).getYears();

        int workDays = 0;

        for(LocalDate start = now; start.isBefore(dueDate.plusDays(1)); start = start.plusDays(1)){
            if(isWorkDay(start)){
                workDays++;
            }
        }
        System.out.println("Number of work days: " + workDays + " days.");

        System.out.println("INCLUDING WEEKENDS: " + days + " days, " + months + " months, " + years + " years.");
    }

    //Is for debug purposes. Requires no user input. The Date is set to 2025 April 6
    private static void autoMaticTesting(){
        LocalDate now = LocalDate.now();

        //This is the dueDate
        LocalDate dueDate = LocalDate.of(2025, Month.APRIL, 6);

        int days = now.until(dueDate).getDays();
        int months = now.until(dueDate).getMonths();
        int years = now.until(dueDate).getYears();

        int workDays = 0;

        for(LocalDate start = now; start.isBefore(dueDate.plusDays(1)); start = start.plusDays(1)){
            if(isWorkDay(start)){
                workDays++;
            }
        }
        System.out.println("Number of work days: " + workDays + " days.");

        System.out.println("INCLUDING WEEKENDS: " + days + " days, " + months + " months, " + years + " years.");
    }
}