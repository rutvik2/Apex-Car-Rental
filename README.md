# Apex Car Rental
This is a Java-MySQL based Car Rental database management project. This project uses various concepts of Object Oriented Programming and Database Management System. Many Java classes such as JFrame, Color, Timer, JOptionPane, BorderFactory, Connection etc were used and many event handlers helped making the interface more user friendly. The logos, background images and libraries were found online.

# Table of Contents
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Work Flow](#work-flow)
- [Getting Started](#getting-started)
- [Scope of Improvement](#scope-of-improvement)

# Tech Stack
- Java using NetBeans IDE 
- MySQL using MySQL Command Line Client and HeidiSQL
- Used external libraries such as jcalendar

# Features
- Used MySql connector jar file using JDBC driver to establish connection between the project and the database
- Implemented a Car-based Loading Frame using Timer class
- Made a classic Login flow
- Created a Navbar for the Admin and Employee panels
- Gave the GUI a modern feel
- Performed CRUD operations on the database side

# Work Flow
The project is divided into 5 source packages: home, admin, employee, connection and img. The whole flow of the code is based on two packages, admin and employee. <br>
The project starts running from the Home class. Only one person (the admin) is assumed to have access of the admin panel whereas the rest of the employees can access the employee panel. <br>

<h3>Admin package:</h3> On entering admin credentials, the Admin Panel opens up. From here the admin can go to various other windows to perform other tasks:<br>

Under Employee Dropdown -><br>
- AddEmployee: To add employee details which creates an account for the employee to log into the app.<br>
- ModifyEmployee: To modify the employee details<br>
- ListOfEmployees: Displayes the list of the current working employees in the store<br>

Under View Records Dropdown -><br>
- CustomerRecords: To view all the customer details<br>
- DriverRecords: To view all the details of the drivers hired<br>

Under Vehicles Dropdown -><br>
- AddCompany: To add a new car company in the rental<br>
- AddCar: To add the details of the new car<br>
- ViewCars: To view the car records<br>

Under Others Dropdown -><br>
- ChangePassword: To change the users password<br>
- LogOut: Brings you back to the Login Frame<br>

<h3>Employee package:</h3> On entering employee credentials, the Employee Panel opens up. From here the employee can go to various other windows to perform other tasks:<br>

Under Driver Records Dropdown -><br>
- AddDriver: To add driver details including his photo and the car that is being assigned to the driver.<br>
- Modify: To modify the driver details<br>
- ListOfDrivers: Displayes the list of the current working drivers in the store<br>

Under Customer Records Dropdown -><br>
- AddCustomer: To add customer details <br>
- Modify: To modify the customer details<br>
- ListOfCustomers: Displayes the list of the customers <br>

Under Vehicles Dropdown -><br>
- ViewCars: To view cars based on certain criteria <br>
- ReturnCar: To return a car that had been rented

We have the connection class in the connection package.

# Getting Started
1. After cloning, import the project in your IDE.
2. Import the .sql file into MySQL.
3. Go to the connection class and insert your MySQL username and password in place of mine.
4. Make sure to import the jcalendar and the driver jar files in your libraries.
5. You can access the database to find credentials.
6. Run the project in your IDE. Default admin credentials are Username: admin and Password: admin.

# Scope of Improvement
- There are a lot of bug fixes and code formatting to be done.
- The window size of the app on my laptop is significantly different when run using the IDE and when I run the jar file after a clean & build. This mislead me while configuring the GUI so the interface may look inconsistent in some areas. I will be looking up the solution for this on Stack Overflow.
- The Navbar Dropdown sometimes doesn't go back up like it is supposed to.
- The image resolution look deprecated on build which is another concern I need to get around.






