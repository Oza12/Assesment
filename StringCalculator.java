import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static void main(String[] args) {
        int answer = add("1,2,a,c,1001");
        System.out.println(answer);
    }

    public static int add(String numbers) {
        String[] number = splitter(numbers);
        int size = number.length;
        throwExceptionIfAnyNegative(number, size);
        return findSum(number, size);
    }

    private static String[] splitter(String numbers) {
        if (numbers.isEmpty()) {
            return new String[0];
        } else if (isCustomDelimiterString(numbers)) {
            return splitUsingCustomDelimiter(numbers);
        }
        return splitUsingCommaAndNewLine(numbers);
    }

    private static int findSum(String[] num, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (1000 < toInt(num[i]))
                continue;
            sum = sum + toInt(num[i]);
        }
        return sum;
    }

    private static void throwExceptionIfAnyNegative(String[] num, int size) {
        ArrayList<String> negative = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (toInt(num[i]) < 0) {
                negative.add(num[i]);
            }
        }
        if (negative.size() > 0) {
            throw new RuntimeException("negatives not allowed: " + String.join(", ", negative));
        }
    }

    private static boolean isCustomDelimiterString(String numbers) {
        return numbers.startsWith("//");
    }

    private static String[] splitUsingCommaAndNewLine(String numbers) {
        String[] num = numbers.split(",|\n");
        return num;
    }

    private static String[] splitUsingCustomDelimiter(String numbers) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        m.matches();
        String customDelim = m.group(1);
        String num = m.group(2);
        return num.split(Pattern.quote(customDelim));
    }

    private static int toInt(String numbers) {
        numbers = numbers.toLowerCase(Locale.ROOT);
        char[] charArray = numbers.toCharArray();
        char ch = 0;
        for (int i = 0; i < charArray.length; i++) {
            ch = charArray[i];
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch + 1) - 97);
            }
            else {
                return Integer.parseInt(numbers);
            }
        }
        return ch;
    }
}


Q-1	I want to add 3 days to the current date. Write all possible queries to perform this operation. Explain each one of them.


Q-2	I want to add 3 years to the current date. Write all possible queries to perform this operation. Explain each one of them.


Q-3	I want to add 3 months to the current date. Write all possible queries to perform this operation. Explain each one of them.


Q-4	I want to deduct 2 days from the current date.  Write all possible queries to perform this operation. Explain each one of them.


Q-5	Write a query to add 5 days and 15 hours to date and time "2007-01-26 12:30:45".


Q-6	Write all possible queries which will return current date.


Q-7	Write all possible queries which will return current time.


Q-8	Input Date is "2007-01-26 12:30:45". Write queries to output following date formats:

	- "January 26, 2007"
	- "The 26th of January"
	- 2007
	- 07
	- 26/1/7
	- 26/01/07
	- 26/01/2007
	- 01/26/07
	- 26/01/07 12:30:45
	- 26/01/07 12:30:45 PM


Q-9	Input Date is "2007-01-26 12:30:45". Write queries to output following date formats:

	- Friday
	- 26 (Explanation: 26th day of the month)
	- 6 (Explanation: 6th day of the week)
	- 26 (Explanation: 26th day of the year)


Q-10	Explain UNIX_TIMESTAMP and FROM_UNIXTIME functions with examples.


Q-11	Write the output of the following query and explain it.

	SELECT PERIOD_ADD(200601, 3);


Q-12	Write the output of the following query and explain it.

	SELECT PERIOD_DIFF(200601, 200609);


Q-13	Explain the use of "LAST_INSERT_ID()" function in real life applications.
    
    
    
    
    ----
    
    
    	
Table Used: 
	
	-   newstudent (recid, surname, firstname, middlename, gender, admitdate, endeffdt)


NOTE :	[I] Please specify the CREATE query for above table as well.
	[II] In all below queries, fetch and display "Name" field in this format :  
	"Surname Firstname Middlename".
	[III] "endeffdt" represents date on which a particular student record was deleted. Hence fetch only active student records from above table.

Q-1	List out the information of students whose surname is "Shah".


Q-2	List out the information of all the Male students.


Q-3	List out the information of all the Female students, whose surname is "Patel" or have 	been admitted after than 1-Jan-2006.


Q-4	List out the information of all the students whose second name ends with "Bhai".


Q-5	List out the information of all the students whose first name starts with "M" and 	second name has "ant".

Q-6	List out the information of all the students whose surname has "c" in the third place.


Q-7	List the name's of the all the students in "Ekta R. Patel" format.


Q-8	List out First Name as well as its respective length for all the students.


Q-9	Append the First Name with "bhai" for all the male students whose First Name does not 	contain "bhai".


Q-10	List out First Name of all the male students with "Mr." before the First Name.


Q-11	List out First Name of all the students which sounds like "Mira".
    
    -----
    
    Tables Used:
===========
	Table - I :	officestaff
	Fields	:	recid (Primary Key), name, designation, salary, overtimesalary, bossno, addressid (Reference Key)


	Table - II :	address
	Fields :	recid (Primary Key), address1, address2, city, county, postalcode, country



Write queries for following requirements:

Q-1	List Name, Designation and Salary of all "officestaff" members.


Q-2	List Name and Salary of all the people who are working as "Programmer".


Q-3	List all the information about those people who are earning less than Rs.10,000/- .


Q-4	List all the information about those staff members who fall in the salary range of 	Rs.5000/- to Rs.10,000/- .


Q-5	List Name of all the office staff members in Lower Case.


Q-6	List Name of all the office staff members in following format:
	For example, if name is "umeshbhai" then display it in the format "Umeshbhai".


Q-7	List all the information about those people who works for "Nileshbhai".


Q-8	List all the information about those members with salary greater than or equal to Rs.3000/- or working directly under "Nileshbhai".


Q-9	List Name, Salary, Over-time Salary of all the office staff members.


Q-10	Perform above MySQL statement again, but now 0(Zero) should be substituted for NULL in 	Over-time Salary field.


Q-11	List Name and Total Monthly Salary (Salary + Over-time Salary) of all the office staff 	members.


Q-12	List Name and Total Annual Salary of all the office staff members.


Q-13	List Name and Total Daily Salary of all the office staff members. (Consider a month is 	of 30 days).


Q-14	List all the information of the person earning Highest Salary (Salary + Over-time 	Salary) in the staff.


Q-15	List all the information of the person earning Least Salary (Salary + Over-time Salary) 	in the staff.


Q-16	List all the information about those who earn the Highest Salary (Salary + Over-time 	Salary) and those who earn the Least Salary (Salary + Over-time Salary) in the staff.


Q-17	List all the information about the person who earns more than his boss.


Q-18	List Name, Designation, Salary and City of each staff member.


Q-19	Using "address" table list total number of persons residing in "Ahmedabad" city.


Q-20	List those City Name where 3 or more than 3 people resides.
    
    -----Table Used: 
===========
student (recid, rollno, fname, sname, surname, admitdate, birthdate, standard, sex)


Write a query for following requirement:
=======================================

Q-1	Display Full Name of all the male students whose first name ends with "h" and are admitted between 1st January 2006 to 1st August 2006.

	Eg:

	|----------------------|
	|FULL NAME	       |	
	|----------------------|
	|Kamlesh Rajubhai Patel|
	------------------------

	Here "Kamlesh" is the value of 'fname' column, "Rajubhai" of 'sname' and "Patel" of 'surname' column. And first character is in capital for fname, sname, surname and each column value is separated by single space.





Tables Used:
===========

1) product (recid, mfrid, description, price, qtyonhand)

2) orders (recid, customerid, orderdate, salesrepsid, productid, qty, amount)

3) customer (recid, company, salesrepsid, creditlimit)

4) salesreps (recid, name, officeid, designation, hiredate, manager, quota, sales, age)

5) office (recid, city, region, manager, targetsales, actualsales)



Write queries for below requirements:
=====================================

Q-1	Find Name of all those sales representatives whose offices are in cities ending with 
	"pur" and who have atleast 2 customers. The sales representative must be hired before 
	1st January 2006 and his/her minimum age should be 21 yrs.

	Display fields : Sales Rep. Name, Office City, No. of Customers, Hired on



Q-2	Find following information for each customer:

	Display fields : Company Name, Sales Rep. Name, Sales Rep. Office City, Company Credit



Q-3	Find following information for each office:

	Office city, Total Sales Rep., Total sale by all sales Rep.,
	Target Sales, Actual Sales, Difference of Target and Actual Sales.

	Display fields : Office City, No. of Sales Rep., Total Sale, Target Sales, Actual  Sales, Difference.



Q-4	Find following information for each product:

	Product description, Price, Quantity on hand, Total no. of 
	orders for each product, Total quantity ordered, Total amount of the orders for each product.

	Display fields : Description, Price, Quantity, Orders, Quantity, Total Amount



Q-5	Find order details for all the customers. There will be one row per customer displaying 	
	total quantity ordered by them and the amount spent by each customer.
	
	Display fields : Company Name, Total Quantity Ordered, Total Amount



Q-6	Display all the sales representatives hired within the past five years from today along with thier Quota and 
	Sales information.
	
	Display fields : Sales Rep. Name, Hired on, Quota, Sales
	


Q-7	Find total number of customers for all the products ordered. There will be one row per 	
	order displaying product description, and total number of customers who have ordered 	that product.

	Display fields : Product Description, Total No. of Customers who Ordered this Product.
