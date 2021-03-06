package org.firstinspires.ftc.teamcode;
/**
 * Recreated by nerdxoverboard on 11/17/2017.
 */



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.ColorSensor;

import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

// (c) 2017 - FTC Team 11242 - Error 451 - Ferris High School - Ferris, TX
@Autonomous(name = "Red: One", group = "Concept")
//@Disabled <-- Keep commented unless this Opmode is not in use
public class AutonomousJ extends LinearOpMode {


    DcMotor leftMotor,  // left drive wheel
            rightMotor, // right drive wheel
            leftTred,   // left tread
            rightTred;  // right tread

    ColorSensor colorSensor;

    Servo armShoulder,
            armElbow;  // shoulder servo on robot

    @Override
    public void runOpMode() throws InterruptedException {

        leftMotor  = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        leftTred = hardwareMap.get(DcMotor.class, "left_tred");
        rightTred = hardwareMap.get(DcMotor.class, "right_tred");
        armShoulder = hardwareMap.get(Servo.class, "shoulder");
        armElbow = hardwareMap.get(Servo.class, "elbow");
      // colorSensor = hardwareMap.get(ColorSensor.class, "sensor_color");

        waitForStart();

        telemetry.addData("Status", "Driving");
        telemetry.update();

        while (opModeIsActive()) {

            // Beginning Part 1 of Autonomous Mode
            leftMotor.setPower(-0.25); // drive forward at quarter speed
            rightMotor.setPower(0.25); // drive forward at quarter speed
            sleep(1250); // stop after one second
            leftMotor.setPower(0); // stop left motor
            rightMotor.setPower(0); // stop right motor

            leftTred.setPower(-0.25); //  treads move up at quarter speed
            rightTred.setPower(0.25); // treads move up at quarter speed
            sleep(1000); // stop after one second
            leftTred.setPower(0); // stop left tread
            rightTred.setPower(0); //stop right tread
        }
    }


    public void turnAt(double angle, double speed) throws InterruptedException {

        leftMotor.setPower(0);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        sleep(250);


    }


    public void drive() throws InterruptedException {

        int newRightTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            leftMotor.setPower(1);
            rightMotor.setPower(1);

            // Turn off RUN_TO_POSITION
            leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            sleep(250);

        }

    }
}
