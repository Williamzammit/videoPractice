// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Constants;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.configs.VoltageConfigs;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.GravityTypeValue;

/** Add your docs here. */
public class IntakeConstants {
    public static final double rotationGearRatio = 45.7143;
    
    public static final Slot0Configs rotationSlot0Configs = new Slot0Configs()
        .withGravityType(GravityTypeValue.Arm_Cosine)
        .withKG(0.0) // Voltage need to overcome gravity (Total voltage - static friction Voltage)
        .withKS(0.0) // Voltage to overcome Static Friction
        .withKV(0.0) // (Voltage x Seconds) / Rotations - Find value in Phoenix Tuner
        .withKA(0.0) // (Voltage x Seconds^2) / Rotations - Find value in Phoenix Tuner
        .withKP(0.0) // P value, assign last
        .withKI(0.0)
        .withKD(0.0);

    public static final CurrentLimitsConfigs rotationCurrentLimits = new CurrentLimitsConfigs()
        .withStatorCurrentLimit(20.0)//20 Amps is our current limit
        .withStatorCurrentLimitEnable(true);
    public static final VoltageConfigs rotationVoltageConfigs = new VoltageConfigs()
        .withPeakForwardVoltage(10.0) // voltage limit is 10
        .withPeakReverseVoltage(10.0); // voltage limit is 10

    public static final FeedbackConfigs rotationFeedbackConfigs = new FeedbackConfigs()
        .withFeedbackSensorSource(FeedbackSensorSourceValue.RotorSensor)
        .withSensorToMechanismRatio(rotationGearRatio);

    public static final MotionMagicConfigs rotationMotionMagicConfigs = new MotionMagicConfigs()
        .withMotionMagicAcceleration(0.0) // Target Acceleration
        .withMotionMagicCruiseVelocity(0.0) // Target Velocity
        .withMotionMagicExpo_kA(0.0)
        .withMotionMagicExpo_kV(0)
        .withMotionMagicJerk(0.0);

    public static final SoftwareLimitSwitchConfigs rotationSoftwareLimitSwitchConfigs = new SoftwareLimitSwitchConfigs()
        .withForwardSoftLimitEnable(false)
        .withForwardSoftLimitThreshold(0)
        .withReverseSoftLimitEnable(false)
        .withReverseSoftLimitThreshold(0.0);

        public static final double homePosition = 0.449; // Restart robot with intake in home position, record encoder value from TunerX
}