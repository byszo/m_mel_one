/**
 * The class {@code Date} represents a date.
 * 
 * A {@code Date} consists of a day, a month and a year.
 * 
 *
 */
public class Date {
	/**
	 * the day of the date
	 */
	private int day;
	
	/**
	 * the month of the date
	 */
	private int month;
	
	/**
	 * the year of the date
	 */
	private int year;
	
	
	/**
	 * Constructs a date that represents the current date.
	 */
	public Date() {
		this.day = Terminal.TODAYS_DAY;
		this.month = Terminal.TODAYS_MONTH;
		this.year = Terminal.TODAYS_YEAR;
	}


	/**
	 * Constructs a date with the given values.
	 * 
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	
	/**
	 * set day of the Date 
	 * @param day
	 */
	public void setDay(int day) {
		if(day <1 && day>31){
			System.out.println("Fehler");
			return;
		}
		this.day = day;
	}
	
	
	/**
	 *set month of the Date  
	 * @param month
	 */
	public void setMonth(int month) {
		if(month<1 && month>12){
			System.out.println("Fehler");
			return;
		}
		this.month = month;
	}
	
	
	/**
	 * set year of the Date 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	
	/**
	 * Returns the day of the date.
	 * @return the day of the date
	 */
	public int getDay() {
		return day;
	}


	/**
	 * Returns the month of the date.
	 * @return the month of the date
	 */
	public int getMonth() {
		return month;
	}


	/**
	 * Returns the year of the date.
	 * @return the year of the date
	 */
	public int getYear() {
		return year;
	}
	
	
	
	/**
	 * Returns the days of this date since 01/01/1900. 
	 * We have to admit that this is a very simple implementation that
	 * assumes that every month has exactly 30 days and that there are no leap years.
	 * 
	 * @return the days since 01/01/1900
	 */
	private int daysSince1900() {
		// 30 days for every month
		return (this.year - 1900) * 30 * 12 + (this.month - 1) * 30
				+ (this.day - 1);
	}
	
	
	/**
	 * Returns the full years between the specified date and the date represented by this instance.
	 * 
	 * @param today the specified date
	 * @return the full years
	 */
	public int getAgeInYears(Date today) {
		int ageInDays = this.getAgeInDays(today);
		int ageInMonths = ageInDays / 30;
		int ageInYears = ageInMonths / 12;
		return ageInYears;
	}
	
	
	/**
	 * Returns the days between the specified date and the date represented by this instance.
	 * 
	 * @param today the specified date
	 * @return the days
	 */
	public int getAgeInDays(Date today) {		
		return today.daysSince1900() - this.daysSince1900();
	}
	
	
	
	/**
	 * Returns a string representation of this date.
	 */
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
}
