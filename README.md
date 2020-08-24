* The project is developed as a maven project using TDD. It was developed in almost a single sitting with iterative development, over around 20 git commits
* In order to run the project please execute the class:-
         "com.lme.robot.mars.client.MarsRobotClient"
* The program is extensible, ie it can be extended for any other types
of robots which may turn at any angle and can move by any amount, not just
by single unit. It can also be extended for 3D terrain, by having one more coordinate field and angle in the Coordinates class.
* Above is achieved by having an interface "Rover", base class "Robot", and a subclass "MarsRobot". And By Segregating the Coordinates into a separate class.
* The class MarsRobotDriver translates user input into the meaningful instructions for the MarsRobot


TODO:-
* the class Coordinates is not immutable. Therefore While instantiating
the MarsRobots, same objects of Coordinates class should not be shared, otherwise it will cause inconsistencies.
If had more amount of time would have designed accordingly and tested this class for the immutability
* (trivial) The Abstract base class Robot uses primitive datatypes "double", it could be changed to BigDecimal
