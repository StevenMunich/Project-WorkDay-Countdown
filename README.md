This program is made to take user input. 
Type in the month
Type in the Day
Type in the Year

It calculates today's date until your due date.
It calculates the workdays by throwing out saturday, sunday, and holidays.
It checks for holidays first and removes them so there is no overlapping.
Holidays without a set date are estimated in the program. For example Easter is set to April 6, LabourDay September 7, etc


For debugging the autoMaticTesting() function sets a date to 04/06/2025.

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
