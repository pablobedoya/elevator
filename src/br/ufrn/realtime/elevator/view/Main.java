package br.ufrn.realtime.elevator.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.ufrn.realtime.elevator.controller.ElevatorController;

public class Main {

	public static Main mainInstance = null;

	private JFrame elevatorFrame = null;
	private JPanel elevatorPanel = null;

	private JPanel elevatorContainer1 = null;
	private JPanel elevatorContainer2 = null;
	
	private JLabel lampDown1stElevator = null;
	private JLabel lampUp1stElevator = null;
	private JLabel lampDown2ndElevator = null;
	private JLabel lampUp2ndElevator = null;

	private JToggleButton buttonDown1stFloor = null;
	private JToggleButton buttonDown2ndFloor = null;
	private JToggleButton buttonDown3rdFloor = null;
	private JToggleButton buttonDown4thFloor = null;

	private JToggleButton buttonUp0thFloor = null;
	private JToggleButton buttonUp1stFloor = null;
	private JToggleButton buttonUp2ndFloor = null;
	private JToggleButton buttonUp3rdFloor = null;
	
	private JPanel selectDestination1stElevatorPanel = null;
	private JPanel selectDestination2ndElevatorPanel = null;
	
	private JToggleButton buttonSelectDestination1stElevator0thFloor = null;
	private JToggleButton buttonSelectDestination1stElevator1stFloor = null;
	private JToggleButton buttonSelectDestination1stElevator2ndFloor = null;
	private JToggleButton buttonSelectDestination1stElevator3rdFloor = null;
	private JToggleButton buttonSelectDestination1stElevator4thFloor = null;
	
	private JToggleButton buttonSelectDestination2ndElevator0thFloor = null;
	private JToggleButton buttonSelectDestination2ndElevator1stFloor = null;
	private JToggleButton buttonSelectDestination2ndElevator2ndFloor = null;
	private JToggleButton buttonSelectDestination2ndElevator3rdFloor = null;
	private JToggleButton buttonSelectDestination2ndElevator4thFloor = null;
	
	private JToggleButton button1stElevator0thFloor = null;
	private JToggleButton button1stElevator1stFloor = null;
	private JToggleButton button1stElevator2ndFloor = null;
	private JToggleButton button1stElevator3rdFloor = null;
	private JToggleButton button1stElevator4thFloor = null;
	
	private JToggleButton button2ndElevator0thFloor = null;
	private JToggleButton button2ndElevator1stFloor = null;
	private JToggleButton button2ndElevator2ndFloor = null;
	private JToggleButton button2ndElevator3rdFloor = null;
	private JToggleButton button2ndElevator4thFloor = null;
	
	private JLabel labelSensor1stElevator = null;
	private JLabel labelSensor2ndElevator = null;
	
	private JLabel labelOpenDoor1stElevator = null;
	private JLabel labelOpenDoor2ndElevator = null;

	private static ElevatorController ec;

	private Icon downOff = new ImageIcon(this.getClass().getResource("/images/down-off.png"));
	private Icon downOn = new ImageIcon(this.getClass().getResource("/images/down-on.png"));
	private Icon upOff = new ImageIcon(this.getClass().getResource("/images/up-off.png"));
	private Icon upOn = new ImageIcon(this.getClass().getResource("/images/up-on.png"));

	public static Main getInstance() {
		if (mainInstance == null) {
			mainInstance = new Main();
			mainInstance.getElevatorFrame();
		}

		return mainInstance;
	}

	public JFrame getElevatorFrame() {
		if (elevatorFrame == null) {
			elevatorFrame = new JFrame();
			elevatorFrame.setSize(600, 620);
			elevatorFrame.setTitle("Elevator");
			elevatorFrame.setContentPane(getElevatorPanel());
			elevatorFrame.setLocationRelativeTo(null);
			elevatorFrame.setResizable(false);
			elevatorFrame.setVisible(true);
			elevatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setLabelSensor1stElevator(Color.RED);
			setLabelSensor2ndElevator(Color.RED);
			
			setLabelOpenDoor1stElevator(Color.BLUE);
			setLabelOpenDoor2ndElevator(Color.BLUE);
		}

		return elevatorFrame;
	}

	public JPanel getElevatorPanel() {
		if (elevatorPanel == null) {
			elevatorPanel = new JPanel();
			elevatorPanel.setLayout(null);

			elevatorPanel.add(getElevatorContainer1());
			elevatorPanel.add(getElevatorContainer2());

			elevatorPanel.add(getButtonDown1stFloor());
			elevatorPanel.add(getButtonDown2ndFloor());
			elevatorPanel.add(getButtonDown3rdFloor());
			elevatorPanel.add(getButtonDown4thFloor());
			
			elevatorPanel.add(getButtonUp0thFloor());
			elevatorPanel.add(getButtonUp1stFloor());
			elevatorPanel.add(getButtonUp2ndFloor());
			elevatorPanel.add(getButtonUp3rdFloor());
			
			elevatorPanel.add(getSelectDestination1stElevatorPanel());
			elevatorPanel.add(getSelectDestination2ndElevatorPanel());
		}

		return elevatorPanel;
	}

	private JPanel getElevatorContainer1() {
		if (elevatorContainer1 == null) {
			elevatorContainer1 = new JPanel();
			elevatorContainer1.setLayout(null);
			elevatorContainer1.setBounds(140, 20, 150, 500);
			elevatorContainer1.setBorder(new TitledBorder(1 + "st Elevator"));
			
			lampDown1stElevator = new JLabel(downOff);
			lampDown1stElevator.setBounds(10, 20, 60, 60);
			lampDown1stElevator.setFocusable(false);
			elevatorContainer1.add(lampDown1stElevator);
			
			lampUp1stElevator = new JLabel(upOff);
			lampUp1stElevator.setBounds(80, 20, 60, 60);
			lampUp1stElevator.setFocusable(false);
			elevatorContainer1.add(lampUp1stElevator);
			
			ButtonGroup buttonGroup1stElevator = new ButtonGroup();
			buttonGroup1stElevator.add(button1stElevator0thFloor);
			buttonGroup1stElevator.add(button1stElevator1stFloor);
			buttonGroup1stElevator.add(button1stElevator2ndFloor);
			buttonGroup1stElevator.add(button1stElevator3rdFloor);
			buttonGroup1stElevator.add(button1stElevator4thFloor);

			elevatorContainer1.add(getButton1stElevator0thFloor());
			elevatorContainer1.add(getButton1stElevator1stFloor());
			elevatorContainer1.add(getButton1stElevator2ndFloor());
			elevatorContainer1.add(getButton1stElevator3rdFloor());
			elevatorContainer1.add(getButton1stElevator4thFloor());
		}

		return elevatorContainer1;
	}

	private JPanel getElevatorContainer2() {
		if (elevatorContainer2 == null) {
			elevatorContainer2 = new JPanel();
			elevatorContainer2.setLayout(null);
			elevatorContainer2.setBounds(300, 20, 150, 500);
			elevatorContainer2.setBorder(new TitledBorder(2 + "nd Elevator"));
			
			lampDown2ndElevator = new JLabel(downOff);
			lampDown2ndElevator.setBounds(10, 20, 60, 60);
			lampDown2ndElevator.setFocusable(false);
			elevatorContainer2.add(lampDown2ndElevator);
			
			lampUp2ndElevator = new JLabel(upOff);
			lampUp2ndElevator.setBounds(80, 20, 60, 60);
			lampUp2ndElevator.setFocusable(false);
			elevatorContainer2.add(lampUp2ndElevator);
			
			ButtonGroup buttonGroup2ndElevator = new ButtonGroup();
			buttonGroup2ndElevator.add(button2ndElevator0thFloor);
			buttonGroup2ndElevator.add(button2ndElevator1stFloor);
			buttonGroup2ndElevator.add(button2ndElevator2ndFloor);
			buttonGroup2ndElevator.add(button2ndElevator3rdFloor);
			buttonGroup2ndElevator.add(button2ndElevator4thFloor);

			elevatorContainer2.add(getButton2ndElevator0thFloor());
			elevatorContainer2.add(getButton2ndElevator1stFloor());
			elevatorContainer2.add(getButton2ndElevator2ndFloor());
			elevatorContainer2.add(getButton2ndElevator3rdFloor());
			elevatorContainer2.add(getButton2ndElevator4thFloor());
		}

		return elevatorContainer2;
	}

	private JToggleButton getButtonUp0thFloor() {
		if (buttonUp0thFloor == null) {
			buttonUp0thFloor = new JToggleButton();
			buttonUp0thFloor.setBorderPainted(false);
			buttonUp0thFloor.setFocusPainted(false);
			buttonUp0thFloor.setFocusable(false);
			buttonUp0thFloor.setSelected(true);
			buttonUp0thFloor.setBounds(455, 520, 60, 60);
			buttonUp0thFloor.setText("\u25B2 0");

			buttonUp0thFloor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (ec.requestElevator(0, true)) {
						buttonUp0thFloor.setBackground(Color.RED);
						buttonUp0thFloor.setSelected(false);
						buttonUp0thFloor.setEnabled(false);
					} else {
						buttonUp0thFloor.setSelected(true);
					}
				}
			});
		}

		return buttonUp0thFloor;
	}

	private JToggleButton getButtonUp1stFloor() {
		if (buttonUp1stFloor == null) {
			buttonUp1stFloor = new JToggleButton();
			buttonUp1stFloor.setBorderPainted(false);
			buttonUp1stFloor.setFocusPainted(false);
			buttonUp1stFloor.setFocusable(false);
			buttonUp1stFloor.setSelected(true);
			buttonUp1stFloor.setBounds(455, 455, 60, 60);
			buttonUp1stFloor.setText("\u25B2 1");

			buttonUp1stFloor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (ec.requestElevator(1, true)) {
						buttonUp1stFloor.setBackground(Color.RED);
						buttonUp1stFloor.setSelected(false);
						buttonUp1stFloor.setEnabled(false);
					} else {
						buttonUp1stFloor.setSelected(true);
					}
				}
			});
		}

		return buttonUp1stFloor;
	}

	private JToggleButton getButtonUp2ndFloor() {
		if (buttonUp2ndFloor == null) {
			buttonUp2ndFloor = new JToggleButton();
			buttonUp2ndFloor.setBorderPainted(false);
			buttonUp2ndFloor.setFocusPainted(false);
			buttonUp2ndFloor.setFocusable(false);
			buttonUp2ndFloor.setSelected(true);
			buttonUp2ndFloor.setBounds(455, 390, 60, 60);
			buttonUp2ndFloor.setText("\u25B2 2");

			buttonUp2ndFloor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (ec.requestElevator(2, true)) {
						buttonUp2ndFloor.setBackground(Color.RED);
						buttonUp2ndFloor.setSelected(false);
						buttonUp2ndFloor.setEnabled(false);
					} else {
						buttonUp2ndFloor.setSelected(true);
					}
				}
			});
		}

		return buttonUp2ndFloor;
	}

	private JToggleButton getButtonUp3rdFloor() {
		if (buttonUp3rdFloor == null) {
			buttonUp3rdFloor = new JToggleButton();
			buttonUp3rdFloor.setBorderPainted(false);
			buttonUp3rdFloor.setFocusPainted(false);
			buttonUp3rdFloor.setFocusable(false);
			buttonUp3rdFloor.setSelected(true);
			buttonUp3rdFloor.setBounds(455, 325, 60, 60);
			buttonUp3rdFloor.setText("\u25B2 3");

			buttonUp3rdFloor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (ec.requestElevator(3, true)) {
						buttonUp3rdFloor.setBackground(Color.RED);
						buttonUp3rdFloor.setSelected(false);
						buttonUp3rdFloor.setEnabled(false);
					} else {
						buttonUp3rdFloor.setSelected(true);
					}
				}
			});
		}

		return buttonUp3rdFloor;
	}

	private JToggleButton getButtonDown1stFloor() {
		if (buttonDown1stFloor == null) {
			buttonDown1stFloor = new JToggleButton();
			buttonDown1stFloor.setBorderPainted(false);
			buttonDown1stFloor.setFocusPainted(false);
			buttonDown1stFloor.setFocusable(false);
			buttonDown1stFloor.setSelected(true);
			buttonDown1stFloor.setBounds(520, 455, 60, 60);
			buttonDown1stFloor.setText("\u25BC 1");

			buttonDown1stFloor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (ec.requestElevator(1, false)) {
						buttonDown1stFloor.setBackground(Color.RED);
						buttonDown1stFloor.setSelected(false);
						buttonDown1stFloor.setEnabled(false);
					} else {
						buttonDown1stFloor.setSelected(true);
					}
				}
			});
		}

		return buttonDown1stFloor;
	}

	private JToggleButton getButtonDown2ndFloor() {
		if (buttonDown2ndFloor == null) {
			buttonDown2ndFloor = new JToggleButton();
			buttonDown2ndFloor.setBorderPainted(false);
			buttonDown2ndFloor.setFocusPainted(false);
			buttonDown2ndFloor.setFocusable(false);
			buttonDown2ndFloor.setSelected(true);
			buttonDown2ndFloor.setBounds(520, 390, 60, 60);
			buttonDown2ndFloor.setText("\u25BC 2");

			buttonDown2ndFloor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (ec.requestElevator(2, false)) {
						buttonDown2ndFloor.setBackground(Color.RED);
						buttonDown2ndFloor.setSelected(false);
						buttonDown2ndFloor.setEnabled(false);
					} else {
						buttonDown2ndFloor.setSelected(true);
					}
				}
			});
		}

		return buttonDown2ndFloor;
	}

	private JToggleButton getButtonDown3rdFloor() {
		if (buttonDown3rdFloor == null) {
			buttonDown3rdFloor = new JToggleButton();
			buttonDown3rdFloor.setBorderPainted(false);
			buttonDown3rdFloor.setFocusPainted(false);
			buttonDown3rdFloor.setFocusable(false);
			buttonDown3rdFloor.setSelected(true);
			buttonDown3rdFloor.setBounds(520, 325, 60, 60);
			buttonDown3rdFloor.setText("\u25BC 3");

			buttonDown3rdFloor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (ec.requestElevator(3, false)) {
						buttonDown3rdFloor.setBackground(Color.RED);
						buttonDown3rdFloor.setSelected(false);
						buttonDown3rdFloor.setEnabled(false);
					} else {
						buttonDown3rdFloor.setSelected(true);
					}
				}
			});
		}

		return buttonDown3rdFloor;
	}

	private JToggleButton getButtonDown4thFloor() {
		if (buttonDown4thFloor == null) {
			buttonDown4thFloor = new JToggleButton();
			buttonDown4thFloor.setBorderPainted(false);
			buttonDown4thFloor.setFocusPainted(false);
			buttonDown4thFloor.setFocusable(false);
			buttonDown4thFloor.setSelected(true);
			buttonDown4thFloor.setBounds(520, 260, 60, 60);
			buttonDown4thFloor.setText("\u25BC 4");

			buttonDown4thFloor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (ec.requestElevator(4, false)) {
						buttonDown4thFloor.setBackground(Color.RED);
						buttonDown4thFloor.setSelected(false);
						buttonDown4thFloor.setEnabled(false);
					} else {
						buttonDown4thFloor.setSelected(true);
					}
				}
			});
		}

		return buttonDown4thFloor;
	}
	
	private JPanel getSelectDestination1stElevatorPanel() {
		if (selectDestination1stElevatorPanel == null) {
			selectDestination1stElevatorPanel = new JPanel();
			selectDestination1stElevatorPanel.setLayout(null);
			selectDestination1stElevatorPanel.setBounds(10, 20, 130, 220);
			selectDestination1stElevatorPanel.setBorder(new TitledBorder("Select destination"));
			selectDestination1stElevatorPanel.add(getButtonSelectDestination1stElevator0thFloor());
			selectDestination1stElevatorPanel.add(getButtonSelectDestination1stElevator1stFloor());
			selectDestination1stElevatorPanel.add(getButtonSelectDestination1stElevator2ndFloor());
			selectDestination1stElevatorPanel.add(getButtonSelectDestination1stElevator3rdFloor());
			selectDestination1stElevatorPanel.add(getButtonSelectDestination1stElevator4thFloor());
		}
		
		return selectDestination1stElevatorPanel;
		
	}
	
	private JPanel getSelectDestination2ndElevatorPanel() {
		if (selectDestination2ndElevatorPanel == null) {
			selectDestination2ndElevatorPanel = new JPanel();
			selectDestination2ndElevatorPanel.setLayout(null);
			selectDestination2ndElevatorPanel.setBounds(450, 20, 130, 220);
			selectDestination2ndElevatorPanel.setBorder(new TitledBorder("Select destination"));
			selectDestination2ndElevatorPanel.add(getButtonSelectDestination2ndElevator0thFloor());
			selectDestination2ndElevatorPanel.add(getButtonSelectDestination2ndElevator1stFloor());
			selectDestination2ndElevatorPanel.add(getButtonSelectDestination2ndElevator2ndFloor());
			selectDestination2ndElevatorPanel.add(getButtonSelectDestination2ndElevator3rdFloor());
			selectDestination2ndElevatorPanel.add(getButtonSelectDestination2ndElevator4thFloor());
		}
		
		return selectDestination2ndElevatorPanel;
		
	}
	
	private JToggleButton getButtonSelectDestination1stElevator0thFloor() {
		if (buttonSelectDestination1stElevator0thFloor == null) {
			buttonSelectDestination1stElevator0thFloor = new JToggleButton();
			buttonSelectDestination1stElevator0thFloor.setBounds(10, 180, 110, 30);
			buttonSelectDestination1stElevator0thFloor.setText("0th");
			buttonSelectDestination1stElevator0thFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(1, 0);
					buttonSelectDestination1stElevator0thFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination1stElevator0thFloor;
	}
	
	private JToggleButton getButtonSelectDestination1stElevator1stFloor() {
		if (buttonSelectDestination1stElevator1stFloor == null) {
			buttonSelectDestination1stElevator1stFloor = new JToggleButton();
			buttonSelectDestination1stElevator1stFloor.setBounds(10, 140, 110, 30);
			buttonSelectDestination1stElevator1stFloor.setText("1st");
			buttonSelectDestination1stElevator1stFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(1, 1);
					buttonSelectDestination1stElevator1stFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination1stElevator1stFloor;
	}
	
	private JToggleButton getButtonSelectDestination1stElevator2ndFloor() {
		if (buttonSelectDestination1stElevator2ndFloor == null) {
			buttonSelectDestination1stElevator2ndFloor = new JToggleButton();
			buttonSelectDestination1stElevator2ndFloor.setBounds(10, 100, 110, 30);
			buttonSelectDestination1stElevator2ndFloor.setText("2nd");
			buttonSelectDestination1stElevator2ndFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(1, 2);
					buttonSelectDestination1stElevator2ndFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination1stElevator2ndFloor;
	}
	
	private JToggleButton getButtonSelectDestination1stElevator3rdFloor() {
		if (buttonSelectDestination1stElevator3rdFloor == null) {
			buttonSelectDestination1stElevator3rdFloor = new JToggleButton();
			buttonSelectDestination1stElevator3rdFloor.setBounds(10, 60, 110, 30);
			buttonSelectDestination1stElevator3rdFloor.setText("3rd");
			buttonSelectDestination1stElevator3rdFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(1, 3);
					buttonSelectDestination1stElevator3rdFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination1stElevator3rdFloor;
	}
	
	private JToggleButton getButtonSelectDestination1stElevator4thFloor() {
		if (buttonSelectDestination1stElevator4thFloor == null) {
			buttonSelectDestination1stElevator4thFloor = new JToggleButton();
			buttonSelectDestination1stElevator4thFloor.setBounds(10, 20, 110, 30);
			buttonSelectDestination1stElevator4thFloor.setText("4th");
			buttonSelectDestination1stElevator4thFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(1, 4);
					buttonSelectDestination1stElevator4thFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination1stElevator4thFloor;
	}
	
	private JToggleButton getButtonSelectDestination2ndElevator0thFloor() {
		if (buttonSelectDestination2ndElevator0thFloor == null) {
			buttonSelectDestination2ndElevator0thFloor = new JToggleButton();
			buttonSelectDestination2ndElevator0thFloor.setBounds(10, 180, 110, 30);
			buttonSelectDestination2ndElevator0thFloor.setText("0th");
			buttonSelectDestination2ndElevator0thFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(2, 0);
					buttonSelectDestination2ndElevator0thFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination2ndElevator0thFloor;
	}
	
	private JToggleButton getButtonSelectDestination2ndElevator1stFloor() {
		if (buttonSelectDestination2ndElevator1stFloor == null) {
			buttonSelectDestination2ndElevator1stFloor = new JToggleButton();
			buttonSelectDestination2ndElevator1stFloor.setBounds(10, 140, 110, 30);
			buttonSelectDestination2ndElevator1stFloor.setText("1st");
			buttonSelectDestination2ndElevator1stFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(2, 1);
					buttonSelectDestination2ndElevator1stFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination2ndElevator1stFloor;
	}
	
	private JToggleButton getButtonSelectDestination2ndElevator2ndFloor() {
		if (buttonSelectDestination2ndElevator2ndFloor == null) {
			buttonSelectDestination2ndElevator2ndFloor = new JToggleButton();
			buttonSelectDestination2ndElevator2ndFloor.setBounds(10, 100, 110, 30);
			buttonSelectDestination2ndElevator2ndFloor.setText("2nd");
			buttonSelectDestination2ndElevator2ndFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(2, 2);
					buttonSelectDestination2ndElevator2ndFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination2ndElevator2ndFloor;
	}
	
	private JToggleButton getButtonSelectDestination2ndElevator3rdFloor() {
		if (buttonSelectDestination2ndElevator3rdFloor == null) {
			buttonSelectDestination2ndElevator3rdFloor = new JToggleButton();
			buttonSelectDestination2ndElevator3rdFloor.setBounds(10, 60, 110, 30);
			buttonSelectDestination2ndElevator3rdFloor.setText("3rd");
			buttonSelectDestination2ndElevator3rdFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(2, 3);
					buttonSelectDestination2ndElevator3rdFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination2ndElevator3rdFloor;
	}
	
	private JToggleButton getButtonSelectDestination2ndElevator4thFloor() {
		if (buttonSelectDestination2ndElevator4thFloor == null) {
			buttonSelectDestination2ndElevator4thFloor = new JToggleButton();
			buttonSelectDestination2ndElevator4thFloor.setBounds(10, 20, 110, 30);
			buttonSelectDestination2ndElevator4thFloor.setText("4th");
			buttonSelectDestination2ndElevator4thFloor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ec.selectDestination(2, 4);
					buttonSelectDestination2ndElevator4thFloor.setEnabled(false);
				}
			});
		}
		
		return buttonSelectDestination2ndElevator4thFloor;
	}
	
	private JToggleButton getButton1stElevator0thFloor() {
		if (button1stElevator0thFloor == null) {
			button1stElevator0thFloor = new JToggleButton();
			button1stElevator0thFloor.setEnabled(false);
			button1stElevator0thFloor.setBounds(10, 430, 130, 60);
			button1stElevator0thFloor.setText("0th Floor");
		}
		
		return button1stElevator0thFloor;
	}
	
	private JToggleButton getButton1stElevator1stFloor() {
		if (button1stElevator1stFloor == null) {
			button1stElevator1stFloor = new JToggleButton();
			button1stElevator1stFloor.setEnabled(false);
			button1stElevator1stFloor.setBounds(10, 365, 130, 60);
			button1stElevator1stFloor.setText("1st Floor");
		}
		
		return button1stElevator1stFloor;
	}
	
	private JToggleButton getButton1stElevator2ndFloor() {
		if (button1stElevator2ndFloor == null) {
			button1stElevator2ndFloor = new JToggleButton();
			button1stElevator2ndFloor.setEnabled(false);
			button1stElevator2ndFloor.setBounds(10, 300, 130, 60);
			button1stElevator2ndFloor.setText("2nd Floor");
		}
		
		return button1stElevator2ndFloor;
	}
	
	private JToggleButton getButton1stElevator3rdFloor() {
		if (button1stElevator3rdFloor == null) {
			button1stElevator3rdFloor = new JToggleButton();
			button1stElevator3rdFloor.setEnabled(false);
			button1stElevator3rdFloor.setBounds(10, 235, 130, 60);
			button1stElevator3rdFloor.setText("3rd Floor");
		}
		
		return button1stElevator3rdFloor;
	}
	
	private JToggleButton getButton1stElevator4thFloor() {
		if (button1stElevator4thFloor == null) {
			button1stElevator4thFloor = new JToggleButton();
			button1stElevator4thFloor.setEnabled(false);
			button1stElevator4thFloor.setBounds(10, 170, 130, 60);
			button1stElevator4thFloor.setText("4th Floor");
		}
		
		return button1stElevator4thFloor;
	}
	
	private JToggleButton getButton2ndElevator0thFloor() {
		if (button2ndElevator0thFloor == null) {
			button2ndElevator0thFloor = new JToggleButton();
			button2ndElevator0thFloor.setEnabled(false);
			button2ndElevator0thFloor.setBounds(10, 430, 130, 60);
			button2ndElevator0thFloor.setText("0th Floor");
		}
		
		return button2ndElevator0thFloor;
	}
	
	private JToggleButton getButton2ndElevator1stFloor() {
		if (button2ndElevator1stFloor == null) {
			button2ndElevator1stFloor = new JToggleButton();
			button2ndElevator1stFloor.setEnabled(false);
			button2ndElevator1stFloor.setBounds(10, 365, 130, 60);
			button2ndElevator1stFloor.setText("1st Floor");
		}
		
		return button2ndElevator1stFloor;
	}
	
	private JToggleButton getButton2ndElevator2ndFloor() {
		if (button2ndElevator2ndFloor == null) {
			button2ndElevator2ndFloor = new JToggleButton();
			button2ndElevator2ndFloor.setEnabled(false);
			button2ndElevator2ndFloor.setBounds(10, 300, 130, 60);
			button2ndElevator2ndFloor.setText("2nd Floor");
		}
		
		return button2ndElevator2ndFloor;
	}
	
	private JToggleButton getButton2ndElevator3rdFloor() {
		if (button2ndElevator3rdFloor == null) {
			button2ndElevator3rdFloor = new JToggleButton();
			button2ndElevator3rdFloor.setEnabled(false);
			button2ndElevator3rdFloor.setBounds(10, 235, 130, 60);
			button2ndElevator3rdFloor.setText("3rd Floor");
		}
		
		return button2ndElevator3rdFloor;
	}
	
	private JToggleButton getButton2ndElevator4thFloor() {
		if (button2ndElevator4thFloor == null) {
			button2ndElevator4thFloor = new JToggleButton();
			button2ndElevator4thFloor.setEnabled(false);
			button2ndElevator4thFloor.setBounds(10, 170, 130, 60);
			button2ndElevator4thFloor.setText("4th Floor");
		}
		
		return button2ndElevator4thFloor;
	}
	
	public void setLabelSensor1stElevator(Color color) {
		if (labelSensor1stElevator == null) {
			labelSensor1stElevator = new JLabel("1st Elevator Sensor");
			labelSensor1stElevator.setForeground(color);
			labelSensor1stElevator.setBounds(140, 520, 130, 20);
			labelSensor1stElevator.setHorizontalAlignment(SwingConstants.CENTER);
			elevatorPanel.add(labelSensor1stElevator);
		} else {
			labelSensor1stElevator.setForeground(color);
		}
	}
	
	public void setLabelSensor2ndElevator(Color color) {
		if (labelSensor2ndElevator == null) {
			labelSensor2ndElevator = new JLabel("2nd Elevator Sensor");
			labelSensor2ndElevator.setForeground(color);
			labelSensor2ndElevator.setBounds(305, 520, 130, 20);
			labelSensor2ndElevator.setHorizontalAlignment(SwingConstants.CENTER);
			elevatorPanel.add(labelSensor2ndElevator);
		} else {
			labelSensor2ndElevator.setForeground(color);
		}
	}
	
	public void setLabelOpenDoor1stElevator(Color color) {
		if (labelOpenDoor1stElevator == null) {
			labelOpenDoor1stElevator = new JLabel("Open Doors");
			labelOpenDoor1stElevator.setHorizontalAlignment(SwingConstants.CENTER);
			labelOpenDoor1stElevator.setForeground(color);
			labelOpenDoor1stElevator.setBounds(120, 540, 130, 20);
			elevatorPanel.add(labelOpenDoor1stElevator);
		} else {
			labelOpenDoor1stElevator.setForeground(color);
		}
	}
	
	public void setLabelOpenDoor2ndElevator(Color color) {
		if (labelOpenDoor2ndElevator == null) {
			labelOpenDoor2ndElevator = new JLabel("Open Doors");
			labelOpenDoor2ndElevator.setHorizontalAlignment(SwingConstants.CENTER);
			labelOpenDoor2ndElevator.setForeground(color);
			labelOpenDoor2ndElevator.setBounds(280, 540, 130, 20);
			elevatorPanel.add(labelOpenDoor2ndElevator);
		} else {
			labelOpenDoor2ndElevator.setForeground(color);
		}
	}

	public void update1stElevatorPosition(int position) {
		switch (position) {
		case 0:
			button1stElevator0thFloor.setSelected(true);
			break;
		
		case 1:
			button1stElevator1stFloor.setSelected(true);
			break;
			
		case 2:
			button1stElevator2ndFloor.setSelected(true);
			break;
				
		case 3:
			button1stElevator3rdFloor.setSelected(true);
			break;
				
		case 4:
			button1stElevator4thFloor.setSelected(true);
			break;
		
		default:
			JOptionPane.showMessageDialog(getElevatorFrame(), "The floor doesn't exist");
			break;
		}
	}

	public void update2ndElevatorPosition(int position) {
		switch (position) {
		case 0:
			button2ndElevator0thFloor.setSelected(true);
			break;
		
		case 1:
			button2ndElevator1stFloor.setSelected(true);
			break;
			
		case 2:
			button2ndElevator2ndFloor.setSelected(true);
			break;
				
		case 3:
			button2ndElevator3rdFloor.setSelected(true);
			break;
				
		case 4:
			button2ndElevator4thFloor.setSelected(true);
			break;

		default:
			JOptionPane.showMessageDialog(getElevatorFrame(), "The floor doesn't exist");
			break;
		}
	}

	public void turnOffLight1stElevator(int position) {
		switch (position) {
		case 0:
			button1stElevator0thFloor.setSelected(false);
			break;
		
		case 1:
			button1stElevator1stFloor.setSelected(false);
			break;
			
		case 2:
			button1stElevator2ndFloor.setSelected(false);
			break;
				
		case 3:
			button1stElevator3rdFloor.setSelected(false);
			break;
				
		case 4:
			button1stElevator4thFloor.setSelected(false);
			break;
		
		default:
			JOptionPane.showMessageDialog(getElevatorFrame(), "The floor doesn't exist");
			break;
		}
	}

	public void turnOffLight2ndElevator(int position) {
		switch (position) {
		case 0:
			button2ndElevator0thFloor.setSelected(false);
			break;
		
		case 1:
			button2ndElevator1stFloor.setSelected(false);
			break;
			
		case 2:
			button2ndElevator2ndFloor.setSelected(false);
			break;
				
		case 3:
			button2ndElevator3rdFloor.setSelected(false);
			break;
				
		case 4:
			button2ndElevator4thFloor.setSelected(false);
			break;
		
		default:
			JOptionPane.showMessageDialog(getElevatorFrame(), "The floor doesn't exist");
			break;
		}
	}
	
	public void updateLightDestination1stElevator(int position) {
		switch (position) {
		case 0:
			buttonSelectDestination1stElevator0thFloor.setSelected(false);
			buttonSelectDestination1stElevator0thFloor.setEnabled(true);
			break;
			
		case 1:
			buttonSelectDestination1stElevator1stFloor.setSelected(false);
			buttonSelectDestination1stElevator1stFloor.setEnabled(true);
			break;
			
		case 2:
			buttonSelectDestination1stElevator2ndFloor.setSelected(false);
			buttonSelectDestination1stElevator2ndFloor.setEnabled(true);
			break;
			
		case 3:
			buttonSelectDestination1stElevator3rdFloor.setSelected(false);
			buttonSelectDestination1stElevator3rdFloor.setEnabled(true);
			break;
			
		case 4:
			buttonSelectDestination1stElevator4thFloor.setSelected(false);
			buttonSelectDestination1stElevator4thFloor.setEnabled(true);
			break;

		default:
			JOptionPane.showMessageDialog(getElevatorFrame(), "The floor doesn't exist");
			break;
		}
	}
	
	public void updateLightDestination2ndElevator(int position) {
		switch (position) {
		case 0:
			buttonSelectDestination2ndElevator0thFloor.setSelected(false);
			buttonSelectDestination2ndElevator0thFloor.setEnabled(true);
			break;
			
		case 1:
			buttonSelectDestination2ndElevator1stFloor.setSelected(false);
			buttonSelectDestination2ndElevator1stFloor.setEnabled(true);
			break;
			
		case 2:
			buttonSelectDestination2ndElevator2ndFloor.setSelected(false);
			buttonSelectDestination2ndElevator2ndFloor.setEnabled(true);
			break;
			
		case 3:
			buttonSelectDestination2ndElevator3rdFloor.setSelected(false);
			buttonSelectDestination2ndElevator3rdFloor.setEnabled(true);
			break;
			
		case 4:
			buttonSelectDestination2ndElevator4thFloor.setSelected(false);
			buttonSelectDestination2ndElevator4thFloor.setEnabled(true);
			break;

		default:
			JOptionPane.showMessageDialog(getElevatorFrame(), "The floor doesn't exist");
			break;
		}
	}
	
	public void updateLightFloorRequestElevator(int position, boolean up) {
		switch (position) {
		case 0:
			buttonUp0thFloor.setSelected(true);
			buttonUp0thFloor.setEnabled(true);
			break;

		case 1:
			if (up) {
				buttonUp1stFloor.setSelected(true);
				buttonUp1stFloor.setEnabled(true);
			} else {
				buttonDown1stFloor.setSelected(true);
				buttonDown1stFloor.setEnabled(true);
			}
			break;

		case 2:
			if (up) {
				buttonUp2ndFloor.setSelected(true);
				buttonUp2ndFloor.setEnabled(true);
			} else {
				buttonDown2ndFloor.setSelected(true);
				buttonDown2ndFloor.setEnabled(true);
			}
			break;

		case 3:
			if (up) {
				buttonUp3rdFloor.setSelected(true);
				buttonUp3rdFloor.setEnabled(true);
			} else {
				buttonDown3rdFloor.setSelected(true);
				buttonDown3rdFloor.setEnabled(true);
			}
			break;

		case 4:
			buttonDown4thFloor.setSelected(true);
			buttonDown4thFloor.setEnabled(true);
			break;
			
		default:
			JOptionPane.showMessageDialog(getElevatorFrame(), "The floor doesn't exist");
			break;
		}
	}
	
	public void updateLampDirection(int elevator, boolean stoppedUp, boolean stoppedDown) {
		if (elevator == 1) {
			if (stoppedUp) {
				lampUp1stElevator.setIcon(upOff);
			} else {
				lampUp1stElevator.setIcon(upOn);
			}
			
			if (stoppedDown) {
				lampDown1stElevator.setIcon(downOff);
			} else {
				lampDown1stElevator.setIcon(downOn);
			}
		} else {
			if (stoppedUp) {
				lampUp2ndElevator.setIcon(upOff);
			} else {
				lampUp2ndElevator.setIcon(upOn);
			}
			
			if (stoppedDown) {
				lampDown2ndElevator.setIcon(downOff);
			} else {
				lampDown2ndElevator.setIcon(downOn);
			}
		}
	}

	public static void main(String[] args) {
		getInstance();
		
		ec = ElevatorController.getInstance();
		ec.getArrivalSensor1stElevator().setCurrentFloor(1, 0);
		ec.getArrivalSensor2ndElevator().setCurrentFloor(2, 0);
	}

}
