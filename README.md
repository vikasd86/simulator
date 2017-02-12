#Toy Simulator Application

Description:
-The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units.
-There are no other obstructions on the table surface.
-The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. 

Application executes the following commands :

	1. PLACE 1,2,NORTH
	    This command initializes the robot position on the table top.
			1 indicates the x coordinate. This can take any integer value.
			2 indicates the y coordinate. This can take any integer value.
			NORTH indicates the direction in which robot is facing. This can take in values : NORTH, SOUTH, EAST & WEST.
   
	2. MOVE 
	    This command moves the toy one step forward.
   
	3. LEFT
		This command turns the robot to the left.

	4. RIGHT 
		This command turns the robot to the right.

	5. REPORT
		This command prints the current location of the robot to screen.
		
All other commands will be ignored till PLACE command has been executed.

System Requirements:

1. Java 1.7 & higher.
2. Test cases require JUnit.
3. Maven as a build tool.

Run the application:

1. Clone/Download the code from GitHub.
2. Navigate to the project directory.
3. Execute command mvn clean install.
4. Execute command java -jar <File Location> in the target directory. For Example : java -jar c:/input.

Run in the IDE:
1. Run App class as java application and pass in the input file as argument.



