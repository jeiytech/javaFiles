/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclass;

/**
 *
 * @author HP
 */
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
public class DateTimeApi {
    public void testPeriod(){
    
        //Tests the current date over a long period of time
    LocalDate ld = LocalDate.now();
    
    System.out.println("Current Date is " +ld);
    
    LocalDate ld1 = ld.plus(5, ChronoUnit.MONTHS);
    System.out.println("Next month " +ld1);
    
    Period pd = Period.between(ld1, ld);
    System.out.println("Period " +pd);
    
    Instant ins = Instant.now();
    System.out.println("Instant " +ins);
OffsetTime d = OffsetTime.now(); 
int e = d.getMinute(); 
System.out.println("Minutes: " + e); 

System.out.println(" The Present Year():"+Year.now().isLeap()); 
System.out.println("The year 2002 is a Leap year :"+ Year.isLeap(2002));
// to display whether the year 2002 is a leap // year or not 
System.out.println("The year 2012 is a Leap year :"+ Year.isLeap(2012)); 
// to display whether the year 2012 is a leap year or not 
    }
    public void testDuration() {
        //Tests the current date over a short period of time
        LocalTime time1 = LocalTime.now();
        System.out.println("Present time is: " + time1);
        Duration twoHours;
        twoHours = Duration.ofHours(2);

      LocalTime time2 = time1.plus(twoHours);
     System.out.println("Time after 2hrs: "+time2);

      Duration duration = Duration.between(time1, time2);
      System.out.println("Duration: " + duration);
      System.out.println("The Present Year Month:"+YearMonth.now());
      // To display present year and month
      System.out.println(ZonedDateTime.now());
   }
    
    public void enumChromoUnits(){
        
    // ChronoUnit --: Unit that represents the concept of a nanosecond, the smallest supported unit of time.
        // To display the current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today); 
// To display the result 2 weeks addition to the current date 
LocalDate nextWeek = today.plus(2, ChronoUnit.WEEKS); 
System.out.println("After 2 weeks: " + nextWeek); 
// To display the result 2 months addition to the current date
LocalDate nextMonth = today.plus(2, ChronoUnit.MONTHS); 
System.out.println("After 2 months: " + nextMonth);
// To display the result 2 years addition to the current date
    
LocalDate nextYear = today.plus(2, ChronoUnit.YEARS);
System.out.println("After 2 years: " + nextYear); 
// To display the result 20 years addition to the current date

LocalDate nextDecade = today.plus(2, ChronoUnit.DECADES); 
System.out.println("Date after twenty year: " + nextDecade);
    }
    
     public static void checkingAdjusters() 
    { 
        //Sets time to a specific and significant date/period/time
        LocalDate date = LocalDate.now(); 
        System.out.println("The current date is "+ 
                            date); 
        // to get the first day of next month 
        LocalDate dayOfNextMonth = date.with(TemporalAdjusters.firstDayOfNextMonth()); 
        System.out.println("FirstDayOfNextMonth : " +dayOfNextMonth ); 
        // get the next saturday 
        LocalDate nextSaturday = date.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));   
        System.out.println("Next satuday from now is "+ nextSaturday); 
        // first day of current month 
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());                             
        System.out.println("FirstDayOfMonth : " +firstDay); 
        // last day of current month      
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());    
        System.out.println("LastDayOfMonth : " +lastDay); 
    }
     public void testBackwardCompatability() 
     {
      //Get the current date
      Date currentDate = new Date();
      System.out.println("Current date: " + currentDate);
		
      //Get the instant of current date in terms of milliseconds
      Instant now = currentDate.toInstant();
      ZoneId currentZone = ZoneId.systemDefault();
		
      LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
      System.out.println("Local date: " + localDateTime);
		
      //Gets the TimeZone of the local time
      ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
      System.out.println("Zoned date: " + zonedDateTime);
   }
    public static void main(String args[])
    {
    Clock cl = Clock.systemUTC();
    System.out.println("Clock is " +cl);
    Clock cl2 = Clock.systemDefaultZone();
    System.out.println("Clock is " +cl2);
    DateTimeApi dta = new DateTimeApi();
    dta.testPeriod();
    dta.testDuration();
    dta.enumChromoUnits();
    checkingAdjusters() ;
    dta.testBackwardCompatability();
}
    
}

