package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp
public class main extends LinearOpMode
{
    private movement drive;
    private intake intake;
    private shooter shooter;

    @Override
    public void runOpMode()
    {
        drive = new movement(hardwareMap);
        shooter = new shooter(hardwareMap);
        intake = new intake(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Call the drive method from the helper class
            telemetry.addData("RT", gamepad1.right_trigger);
            telemetry.addData("LT", gamepad1.left_trigger);
            telemetry.update();

            drive.teleopDrive(gamepad1);
            shooter.teleopDrive(gamepad1);
            intake.teleopDrive(gamepad1);

            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
