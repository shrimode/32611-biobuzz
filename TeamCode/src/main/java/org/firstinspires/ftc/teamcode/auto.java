package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.pedropathing.follower.Follower;
import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import static com.pedropathing.api.Paths.*;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import com.pedropathing.ivy.Command;
import static com.pedropathing.ivy.groups.Groups.sequential;


@Autonomous
public class auto extends OpMode{

    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();
    private final Pose startPose = p.of(58.195, 0.616, 90);
    private final Pose park = p.of(15.467, 93.040, -82);
    // *create more positions as needed

    @Override
    public void init() {
        Scheduler.reset();

        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
    }

    @Override
    public void start() {
        schedule(autoRoutine());
    }

    @Override
    public void loop() {
        follower.update();
        Scheduler.execute();
        // any other methods needed in the loop here
    }

    // create an autonomous routine here
    private Command autoRoutine() {
        return sequential(
                // follow(follower, startToScore()), <-- example code, change when needed
                // Add mechanism commands here.
                follow(follower, park())
        );
    }

    // create a new method for each path that returns a path object
    private Path park() {
        return line(startPose, park).linear(startPose, park);
    }
}

