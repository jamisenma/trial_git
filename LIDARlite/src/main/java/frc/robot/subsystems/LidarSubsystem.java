package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;

public class LidarSubsystem {
    /*
     * Adjust the Calibration Offset to compensate for differences in each unit.
     * We've found this is a reasonably constant value for readings in the 25 cm to
     * 600 cm range. You can also use the offset to zero out the distance between
     * the sensor and edge of the robot.
     */

    private static final int CALIBRATION_CONSTANT = -20;

    private Counter counter;
    private int printedWarningCount = 5;
    private DigitalInput input = new DigitalInput(6); 

    /**
     * 
     * @param source The DigitalInput or DigitalSource where the LIDAR-Lite is
     *               attached (ex: new DigitalInput(9))
     */
    public LidarSubsystem() {
        counter = new Counter(input);
        //counter.setMaxPeriod(1.0);
    // Configure for measuring rising to falling pulses
        //ounter.setSemiPeriodMode(true);
        //counter.reset();
}

/**
 * 
 * @return Distance in cm
 */
public double getDistance() {
	double cm;
	if (counter.get() < 1) {
		if (printedWarningCount-- > 0) {
			System.out.println("LidarLitePWM: waiting for distance measurement");
		}
		return 0;
	}
	
	cm = (counter.getPeriod() * 1000000.0 / 10.0) + CALIBRATION_CONSTANT;
	return cm;
}
}