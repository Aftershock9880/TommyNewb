package org.firstinspires.ftc.TommyNewb;

/**
 * Created by student on 3/30/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Newb OpMode2", group="Pushbot")
//@Disabled
public class Newb_autonomous_v2 extends LinearOpMode{

    NewbHardware robot       = new NewbHardware();
    private final int THREE_REV = 4320;
    private final int TURN_45_DEGREES = 360;
    private byte counter = 0;
    private int leftEncoder = 0;
    private int rightEncoder = 0;

    @Override
    public void runOpMode() {
        // Initialize the hardware variables.

        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Baby oh baby, ", "Prepare for disappointment");

        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        robot.leftMotor.setPower(.5);
        robot.rightMotor.setPower(.5);

        telemetry.addData("Left_Encoder", robot.leftMotor.getCurrentPosition());
        telemetry.addData("Right_Encoder", robot.rightMotor.getCurrentPosition());
        telemetry.addData("Current_Case", counter);




        if (robot.leftMotor.getCurrentPosition() >= THREE_REV &&
                robot.rightMotor.getCurrentPosition() >= THREE_REV) {
            robot.leftMotor.setPower(0);
            robot.rightMotor.setPower(0);
            leftEncoder = robot.leftMotor.getCurrentPosition();
            rightEncoder = robot.rightMotor.getCurrentPosition();
            counter ++;
        }

        robot.leftMotor.setPower(.5);
        robot.rightMotor.setPower(-.5);

        if (robot.leftMotor.getCurrentPosition() >= leftEncoder + TURN_45_DEGREES &&
                robot.rightMotor.getCurrentPosition() <= rightEncoder - TURN_45_DEGREES) {
            leftEncoder = robot.leftMotor.getCurrentPosition();
            rightEncoder = robot.rightMotor.getCurrentPosition();
            counter++;
        }

        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
        counter ++;

    }
}