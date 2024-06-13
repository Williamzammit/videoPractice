// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  private final CANSparkFlex rollerMotor = new CANSparkFlex(23, MotorType.kBrushless);
  private final TalonFX rotationMotor = new TalonFX(22);
  /** Creates a new Intake. */
  public Intake() {
    configureRotationMotor();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake Position", rotationMotor.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Roller Speed", rollerMotor.getAppliedOutput());
    // This method will be called once per scheduler run
  }

  private void configureRotationMotor(){
    rotationMotor.getConfigurator().apply(new TalonFXConfiguration());
    TalonFXConfiguration talonfxConfigs = new TalonFXConfiguration();
    talonfxConfigs.Slot0 = IntakeConstants.rotationSlot0Configs;
    talonfxConfigs.CurrentLimits = IntakeConstants.rotationCurrentLimits;
    talonfxConfigs.Voltage = IntakeConstants.rotationVoltageConfigs;
    talonfxConfigs.Feedback = IntakeConstants.rotationFeedbackConfigs;
    talonfxConfigs.MotionMagic = IntakeConstants.rotationMotionMagicConfigs;
    talonfxConfigs.SoftwareLimitSwitch = IntakeConstants.rotationSoftwareLimitSwitchConfigs;
    talonfxConfigs.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    rotationMotor.getConfigurator().apply(talonfxConfigs);

    //Not ness
    rotationMotor.setPosition(IntakeConstants.homePosition);
  }
}
