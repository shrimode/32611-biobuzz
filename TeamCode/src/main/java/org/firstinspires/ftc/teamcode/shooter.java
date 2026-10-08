package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class shooter
{
    public DcMotor shooter;
    double shooterVal = 0;

    public shooter(HardwareMap hardwareMap)
    {
        shooter = hardwareMap.get(DcMotor.class, "shooterMotor");

        shooter.setDirection(DcMotor.Direction.REVERSE); // might need edits based on testing
    }

    public void teleopDrive(Gamepad gamepad1)
    {

        if (gamepad1.left_trigger > 0)
        {
            shooterVal = 1;
        }
        else
        {
            shooterVal = 0;
        }

        shooter.setPower(shooterVal);
    }
}
