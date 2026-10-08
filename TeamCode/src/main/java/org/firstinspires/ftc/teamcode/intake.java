package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class intake
{
    public DcMotor intake;
    double intakeVal = 0;

    public intake(HardwareMap hardwareMap)
    {
        intake = hardwareMap.get(DcMotor.class, "intakeMotor");

        intake.setDirection(DcMotor.Direction.FORWARD);
    }

    public void teleopDrive(Gamepad gamepad1)
    {
        if (gamepad1.right_trigger > 0)
        {
            intakeVal = 0.9;
        }
        else if (gamepad1.a)
        {
            intakeVal = 0.1;
        }
        else if (gamepad1.b)
        {
            intakeVal = -0.1;
        }
        else
        {
            intakeVal = 0;
        }

        intake.setPower(intakeVal);
    }
}
