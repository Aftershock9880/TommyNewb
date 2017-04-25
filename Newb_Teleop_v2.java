package org.firstinspires.ftc.TommyNewb;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="Newb Teleop v2", group="TommyNewb")
//@Disabled
public class Newb_Teleop_v2 extends OpMode{

    NewbHardware robot = new NewbHardware();
    private byte counter = 0;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Baby oh baby, ", "Prepare for disappointment");

    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        telemetry.addData("Left_Y_Value", gamepad1.left_stick_y);
        telemetry.addData("Right_X_Value", gamepad1.right_stick_x);
        telemetry.addData("Current_Case", counter);

        counter = 0;

        switch (counter)
        {
            case 0:
                if (gamepad1.left_stick_y <= -.5) {
                    robot.leftMotor.setPower(.5);
                    robot.rightMotor.setPower(.5);
                }
                counter++;

                break;

            case 1:
                if (gamepad1.right_stick_x <= -.5) {
                    robot.leftMotor.setPower(-.5);
                    robot.rightMotor.setPower(.5);
                }
                counter++;

                break;

            case 2:
                if (gamepad1.right_stick_x >= .5) {
                    robot.leftMotor.setPower(.5);
                    robot.rightMotor.setPower(-.5);
                }
                counter ++;

                break;

            case 3:
                if (gamepad1.left_stick_y <= -.5 && gamepad1.right_stick_x <=-.5) {
                    robot.leftMotor.setPower(.1);
                    robot.rightMotor.setPower(.5);
                }
                counter++;

                break;

            case 4:
                if (gamepad1.left_stick_y <= -.5 && gamepad1.right_stick_x >= .5) {
                    robot.leftMotor.setPower(.1);
                    robot.rightMotor.setPower(.5);
                }
                counter++;

                break;

            case 5:
                if (gamepad1.left_stick_y >= .5) {
                    robot.leftMotor.setPower(-.5);
                    robot.rightMotor.setPower(-.5);
                }
                counter++;

                break;

        }
    }
    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop () {

    }

}

