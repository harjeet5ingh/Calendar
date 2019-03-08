import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String[] day = {"Su","Mo","Tu","We","Th","Fr","Sa"};
		int nOfDays,lastDay;
		GregorianCalendar c = (GregorianCalendar)GregorianCalendar.getInstance();
		
		//input year
		System.out.print("Enter the year: ");
		int year = in.nextInt();
		in.close();
		
		//check first day of that year
		c.set(GregorianCalendar.YEAR, year);
		c.set(GregorianCalendar.DAY_OF_YEAR,1);
		lastDay=c.get(GregorianCalendar.DAY_OF_WEEK)-1;
		
		System.out.println();

		for(int i=0;i<month.length;i++) {
			//set number of days in every month
			if(i==0||i==2||i==4||i==6||i==7||i==9||i==11)
				nOfDays=31;
			else if(i==1)
				nOfDays=c.isLeapYear(year)?29:28;
			else
				nOfDays=30;
			
			//print name of month
			System.out.println("\t "+month[i]);
			
			//print name of days at columns
			for(int j=0;j<day.length;j++) {
				System.out.print(day[j]+"  ");
			}			
			System.out.println();
			
			//leave spaces accordingly
			for(int j=0;j<lastDay;j++)
				System.out.print("    ");
			
			//print dates
			for(int j=1;j<=nOfDays;j++) {
				if((j-1+lastDay)%7==0 && j!=1) {
					System.out.println();
				}
				System.out.printf("%2d  ",j);
			}
			System.out.println("\n");
			
			//set last day of the month, to start next month from next day
			lastDay=(lastDay+nOfDays)%7;
		}
	}
}
