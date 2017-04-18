/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.TommyNewb;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Newb autonomous v1", group="TommyNewb")
//@Disabled
public class Newb_Autonomous_v1 extends OpMode{

    /* Declare OpMode members. */
    NewbHardware robot = new NewbHardware();
    private final int THREE_REV = 4320;
    private final int TURN_90_DEGREES = 720;
    private byte counter = 0;
    private int leftEncoder = 0;
    private int rightEncoder = 0;

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

        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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
        robot.leftMotor.setPower(.5);
        robot.rightMotor.setPower(.5);
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        telemetry.addData("Left_Encoder", robot.leftMotor.getCurrentPosition());
        telemetry.addData("Right_Encoder", robot.rightMotor.getCurrentPosition());
        telemetry.addData("Current_Case", counter);




        switch (counter)
        {
            case 0:
                if (robot.leftMotor.getCurrentPosition() >= THREE_REV &&
                        robot.rightMotor.getCurrentPosition() >= THREE_REV) {
                    robot.leftMotor.setPower(0);
                    robot.rightMotor.setPower(0);
                    leftEncoder = robot.leftMotor.getCurrentPosition();
                    rightEncoder = robot.rightMotor.getCurrentPosition();
                    counter ++;
                }

                break;

            case 1:
                robot.leftMotor.setPower(.5);
                robot.rightMotor.setPower(-.5);

                if (robot.leftMotor.getCurrentPosition() >= leftEncoder + TURN_90_DEGREES &&
                        robot.rightMotor.getCurrentPosition() <= rightEncoder - TURN_90_DEGREES) {
                    leftEncoder = robot.leftMotor.getCurrentPosition();
                    rightEncoder = robot.rightMotor.getCurrentPosition();
                    counter++;
                }

                break;

            case 2:
                    robot.leftMotor.setPower(0);
                    robot.rightMotor.setPower(0);
                    counter ++;

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

