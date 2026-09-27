package org.firstinspires.ftc.teamcode;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.utils.Timer;
import com.pedropathing.paths.PathTracker;
import com.pedropathing.paths.Path;

@Autonomous
public class auto extends OpMode{

    private Follower follower;
    private Timer pathTimer, opModeTimer;

    public enum PathState{
        // START POSITION_ENDPOSITION
        // DRIVE > MOVEMENT STATE
        // SHOOT > ATTEMPT TO SCORE THE ARTIFACT

        DRIVE_STARTPOS_MID_POS,
        MID_POS_PARK
    }

    PathState pathState;

    private final Pose redFarStart = new Pose(58.195345557122714, 0.6156558533145237, Math.toRadians(90));
    private final Pose redFarShoot = new Pose(58.875, 32.968, Math.toRadians(180));
    private final Pose redFarMid = new Pose(22.353, 38.556, Math.toRadians(152));
    private final Pose redFarPark = new Pose(15.966, 92.040, Math.toRadians(97));

    private Path redFarDriveStart, redFarDriveMid, redFarDrivePark;

    public void buildPaths(){
        // put in coordinate for starting pose, then put in coordinates for ending pose
        redFarDriveStart = follower.pathBuilder();
    }
    @Override
    public void init()
    {

    }

    @Override
    public void loop()
    {

    }
}
