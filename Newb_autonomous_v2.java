package org.firstinspires.ftc.TommyNewb;

/**
 * Created by student on 3/30/17.
 */

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Newb Autonomous v2", group="TommyNewb")
//@Disabled
public class Newb_Autonomous_v2 extends LinearOpMode{

    NewbHardware robot = new NewbHardware();
    private final int ONE_REV = 1440;
    private final int TWO_REV = 2880;
    private final int TURN_180_DEGREES = 2160;
    private final int THREE_REV = 4320;
    private final int FOUR_REV =  5760;
    private int leftEncoder = 0;
    private int rightEncoder = 0;

    @Override
    public void runOpMode() {
        // Initialize the hardware variables.

        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Victory or Death! ", "Lok'tar Ogar!");

        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        robot.leftMotor.setPower(.5);
        robot.rightMotor.setPower(.5);

        robot.leftMotor.setTargetPosition(THREE_REV);
        robot.rightMotor.setTargetPosition(THREE_REV);

        while (robot.leftMotor.isBusy() && robot.rightMotor.isBusy() && opModeIsActive()) {
            telemetry.addData("Left_Encoder", robot.leftMotor.getCurrentPosition());
            telemetry.addData("Right_Encoder", robot.rightMotor.getCurrentPosition());
        }
        leftEncoder = robot.leftMotor.getCurrentPosition();
        rightEncoder = robot.rightMotor.getCurrentPosition();

        robot.leftMotor.setTargetPosition(leftEncoder + ONE_REV);
        robot.rightMotor.setTargetPosition(rightEncoder - ONE_REV);

        while (robot.leftMotor.isBusy() && robot.rightMotor.isBusy() && opModeIsActive()) {
            telemetry.addData("Left_Encoder", robot.leftMotor.getCurrentPosition());
            telemetry.addData("Right_Encoder", robot.rightMotor.getCurrentPosition());
        }

        leftEncoder = robot.leftMotor.getCurrentPosition();
        rightEncoder = robot.rightMotor.getCurrentPosition();

        robot.leftMotor.setTargetPosition(leftEncoder + TWO_REV);
        robot.rightMotor.setTargetPosition(rightEncoder + TWO_REV);

        while (robot.leftMotor.isBusy() && robot.rightMotor.isBusy() && opModeIsActive()) {
            telemetry.addData("Left_Encoder", robot.leftMotor.getCurrentPosition());
            telemetry.addData("Right_Encoder", robot.rightMotor.getCurrentPosition());
        }

        leftEncoder = robot.leftMotor.getCurrentPosition();
        rightEncoder = robot.rightMotor.getCurrentPosition();

        robot.leftMotor.setTargetPosition(leftEncoder + TURN_180_DEGREES);
        robot.rightMotor.setTargetPosition(rightEncoder - TURN_180_DEGREES);

        while (robot.leftMotor.isBusy() && robot.rightMotor.isBusy() && opModeIsActive()) {
            telemetry.addData("Left_Encoder", robot.leftMotor.getCurrentPosition());
            telemetry.addData("Right_Encoder", robot.rightMotor.getCurrentPosition());
        }

        leftEncoder = robot.leftMotor.getCurrentPosition();
        rightEncoder = robot.rightMotor.getCurrentPosition();

        robot.leftMotor.setTargetPosition(leftEncoder + FOUR_REV);
        robot.rightMotor.setTargetPosition(rightEncoder + FOUR_REV);

        while (robot.leftMotor.isBusy() && robot.rightMotor.isBusy() && opModeIsActive()) {
            telemetry.addData("Left_Encoder", robot.leftMotor.getCurrentPosition());
            telemetry.addData("Right_Encoder", robot.rightMotor.getCurrentPosition());
        }

        leftEncoder = robot.leftMotor.getCurrentPosition();
        rightEncoder = robot.rightMotor.getCurrentPosition();

        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);

    }
}