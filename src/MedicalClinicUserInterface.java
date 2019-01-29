
/* File Name: MedicalClinicUserInterface.java
 * Course Name: Computer Programmer
 * Lab Section: 310 
 * Student Name: 040915490
 * Date: 26/Nov/2018  
 */

import java.util.Scanner;

/*	Represents a MedicalClinicInterface to add or remove 
 *  appointments between doctors and patients. 
 */
public class MedicalClinicUserInterface {

	private final int ADD_PATIENT = 1;
	private final int ADD_APPOINTMENT = 2;
	private final int CANCEL_APPOINTMENT = 3;
	private final int LIST_APPOINTMENT = 4;
	private final int QUIT = 5;
	private MedicalClinic clinic;
	private Scanner in;
	private String date, firstName, lastName, healthCardNumber, duedate;
	private int patientType, day, month, year, DoctorNumber, choice, nutritionT, mobilityT, dueday, duemonth, dueyear;
	private double distance;
	private boolean nutrition, mobility, flag;

	/*
	 * Default constructor to initialize Scanner and MedicalClinic
	 */
	public MedicalClinicUserInterface() {
		clinic = new MedicalClinic();
		in = new Scanner(System.in);
	}

	/*
	 * Main method to create a MedicalClinicUserInterface obj and call menu
	 */
	public static void main(String[] args) {
		MedicalClinicUserInterface m = new MedicalClinicUserInterface();
		m.menu();
	}

	/*
	 * Menu to choose between methods addPatient, addAppointment, listAppointments,
	 * cancelAppointment and to quit the program.
	 */
	public void menu() {
		System.out.println(
				"Please make a choice:\n 1. Enter a new patient\n 2. Make an appointment for a patient\n 3. Cancel an appointment for a patient\n 4. List all appointments\n 5. Quit");
		choice = in.nextInt();
		if (choice == ADD_PATIENT) {
			addPatient();
		} else if (choice == ADD_APPOINTMENT) {
			addAppointment();
		} else if (choice == CANCEL_APPOINTMENT) {
			cancelAppointment();
		} else if (choice == LIST_APPOINTMENT) {
			listAppointments();
		} else if (choice == QUIT) {
			System.out.println("GoodBye");
		} else if (choice == 8) {
			printPatients();
		} else if (choice == 9) {
			loadPatient();
		}
	}

	/*
	 * Method to add patient on the list
	 */

	public void loadPatient() {
		try {
			clinic.addPatients("Brolin", "Josh", "123456789", new OurDate(12, 4, 1987));
			clinic.addPatients("Dunstd", "Brack", "222222222", new OurDate(12, 12, 2007));
		} catch (MedicalClinicException e) {
			e.printStackTrace();
		}
		menu();
	}

	public void addPatient() {

		if (clinic.getNumberPatients() != clinic.getMaxPatients()) {
			System.out.print("Enter first name: ");
			firstName = in.next();

			System.out.print("Enter last name: ");
			lastName = in.next();
			System.out.println();

			System.out.print("Enter health card number: ");
			healthCardNumber = in.next();

			while (true) {
				if (healthCardNumber.length() == 9 && healthCardNumber.matches("[0-9]+")) {
					break;
				} else {
					try {
						Patient patientTest = new Patient("unknown", "unkown", healthCardNumber,
								new OurDate(01, 01, 2000));
					} catch (MedicalClinicException e) {
						// e.printStackTrace();
						System.out.println(e.getMessage());
					}
					System.out.println("Enter health card number: ");
					healthCardNumber = in.next();
				}
			}

			do {
				flag = true;
				System.out.print("Enter birth date DDMMYYYY: ");
				date = in.next();
				day = Integer.parseInt(date.substring(0, 2));
				month = Integer.parseInt(date.substring(2, 4));
				year = Integer.parseInt(date.substring(4, 8));
				try {
					Patient patientTest = new Patient("unknown", "unkown", "000000000", new OurDate(day, month, year));
					flag = false;
				} catch (MedicalClinicException e) {
					System.out.println(e.getMessage());
				}
			} while (flag);

			System.out
					.println("Enter the type of patient:\n 1. Maternity Patient\n 2. OutPatient\n 3. Regular Patient");
			patientType = in.nextInt();

			if (patientType == 1) {
				System.out.println("Enter the due date");
				duedate = in.next();
				dueday = Integer.parseInt(date.substring(0, 2));
				duemonth = Integer.parseInt(date.substring(2, 4));
				dueyear = Integer.parseInt(date.substring(4, 8));

				System.out.println("Set the nutrition testing 1 for True or 2 for False");
				nutritionT = in.nextInt();
				if (nutritionT == 1) {
					nutrition = true;
				} else if (nutritionT == 2) {
					nutrition = false;
				}
				clinic.addPatients(lastName, firstName, healthCardNumber, new OurDate(day, month, year),
						new OurDate(dueday, duemonth, dueyear), nutrition);
			} else if (patientType == 2) {
				System.out.println("What is the distance to the clinic?");
				distance = in.nextDouble();

				System.out.println("Set the mobility 1 for True or 2 for False ");
				mobilityT = in.nextInt();
				if (mobilityT == 1) {
					mobility = true;
				} else if (mobilityT == 2) {
					mobility = false;
				}
				clinic.addPatients(lastName, firstName, healthCardNumber, new OurDate(day, month, year), distance,
						mobility);
			} else if (patientType == 3) {
				clinic.addPatients(lastName, firstName, healthCardNumber, new OurDate(day, month, year));
			}
		} else {
			System.out.println("Patient list already full.\n");
		}
		menu();
	}

	/*
	 * Method to add an appointment, a doctor can't have more than one appointment
	 * in the same day.
	 */
	public void addAppointment() {
		Patient patient = null;
		Doctor doctor = null;
		if (clinic.getNumberAppointments() != clinic.getMaxAppointments()) {

			System.out.println("Enter  your health card number");
			healthCardNumber = in.next();

			while (true) {
				if (healthCardNumber.length() == 9 && healthCardNumber.matches("[0-9]+")) {
					break;
				} else {
					try {
						Patient patientTest = new Patient("unknown", "unkown", healthCardNumber,
								new OurDate(01, 01, 2000));
					} catch (MedicalClinicException e) {
						// e.printStackTrace();
						System.out.println(e.getMessage());
					}
					System.out.println("Enter health card number: ");
					healthCardNumber = in.next();
				}
			}

			for (int i = 0; i < clinic.getPatients().size(); i++) {
				if (clinic.getPatients().get(i).getHealthCardNumber().equals(healthCardNumber)) {
					System.out.println(clinic.getPatients().get(i) + "\n");
					patient = clinic.getPatients().get(i);
				}
			}

			if (patient == null) {
				System.out.println("Patient does not exists.");
				menu();
			}
			if (choice == ADD_APPOINTMENT) {
				printDoctors();
				System.out.println("Enter number of doctor selection: ");
				DoctorNumber = in.nextInt();

				switch (DoctorNumber) {
				case 1:
					doctor = clinic.getDoctors().get(0);
					break;
				case 2:
					doctor = clinic.getDoctors().get(1);
					break;
				case 3:
					doctor = clinic.getDoctors().get(2);
					break;
				case 4:
					doctor = clinic.getDoctors().get(3);
					break;
				case 5:
					doctor = clinic.getDoctors().get(4);
					break;
				}

				// System.out.println("Enter desired appointment date DDMMYYYY: ");
				// date = in.next();
				// day = Integer.parseInt(date.substring(0, 2));
				// month = Integer.parseInt(date.substring(2, 4));
				// year = Integer.parseInt(date.substring(4, 8));

				do {
					flag = true;
					System.out.println("Enter desired appointment date DDMMYYYY: ");
					date = in.next();
					day = Integer.parseInt(date.substring(0, 2));
					month = Integer.parseInt(date.substring(2, 4));
					year = Integer.parseInt(date.substring(4, 8));
					try {
						Appointment appointmentTest = new Appointment(
								new Patient("unknown", "unkown", "000000000", new OurDate(01, 01, 2000)), new Doctor(),
								new OurDate(day, month, year));
						flag = false;
					} catch (MedicalClinicException e) {
						System.out.println(e.getMessage());
					}
				} while (flag);

				if (clinic.getNumberAppointments() == 0) {
					clinic.addAppointment(patient, doctor, new OurDate(day, month, year));
				} else {
					for (int k = 0; k < clinic.getAppointments().size(); k++) {
						if (clinic.getAppointments().get(k).getDoctor().equals(doctor) && clinic.getAppointments()
								.get(k).getAppointmentDate().equals(new OurDate(day, month, year))) {
							System.out.println("Doctor already has an appointment that day \n");
							menu();
						}
					}
					clinic.addAppointment(patient, doctor, new OurDate(day, month, year));
				}
			}
		} else {
			System.out.println("Appointment list is already full.");
		}
		if (choice == ADD_APPOINTMENT) {
			menu();
		}
	}

	/*
	 * Method to cancel Appointment from the ArrayList<Appointment>
	 */
	public void cancelAppointment() {
		Patient patient = null;
		Doctor doctor = null;

		System.out.println("Enter  your health card number");
		healthCardNumber = in.next();

		while (true) {
			if (healthCardNumber.length() == 9 && healthCardNumber.matches("[0-9]+")) {
				break;
			} else {
				try {
					Patient patientTest = new Patient("unknown", "unkown", healthCardNumber,
							new OurDate(01, 01, 2000));
				} catch (MedicalClinicException e) {
					// e.printStackTrace();
					System.out.println(e.getMessage());
				}
				System.out.println("Enter health card number: ");
				healthCardNumber = in.next();
			}
		}

		for (int i = 0; i < clinic.getPatients().size(); i++) {
			if (clinic.getPatients().get(i).getHealthCardNumber().equals(healthCardNumber)) {
				System.out.println(clinic.getPatients().get(i) + "\n");
				patient = clinic.getPatients().get(i);
			}
		}

		printDoctors();
		System.out.println("Enter number of doctor selection: ");
		DoctorNumber = in.nextInt();
		switch (DoctorNumber) {
		case 1:
			doctor = clinic.getDoctors().get(0);
			break;
		case 2:
			doctor = clinic.getDoctors().get(1);
			break;
		case 3:
			doctor = clinic.getDoctors().get(2);
			break;
		case 4:
			doctor = clinic.getDoctors().get(3);
			break;
		case 5:
			doctor = clinic.getDoctors().get(4);
			break;
		}

		System.out.println("Enter desired appointment date DDMMYYYY: ");
		date = in.next();
		day = Integer.parseInt(date.substring(0, 2));
		month = Integer.parseInt(date.substring(2, 4));
		year = Integer.parseInt(date.substring(4, 8));

		for (int k = 0; k < clinic.getAppointments().size(); k++) {
			if (clinic.getAppointments().get(k).getPatient().equals(patient)
					&& clinic.getAppointments().get(k).getDoctor().equals(doctor)
					&& clinic.getAppointments().get(k).getAppointmentDate().equals(new OurDate(day, month, year))) {
				clinic.cancelAppointment(k);
				System.out.println("Appointment Cancelled\n");
			}
		}
		menu();
	}

	/*
	 * Method to list all appointments previous added.
	 */
	public void listAppointments() {
		if (clinic.getAppointments().isEmpty()) {
			System.out.println("No appointments\n");
		}
		for (int i = 0; i < clinic.getAppointments().size(); i++) { 
			System.out.println(clinic.getAppointments().get(i).toString());
		}
		menu();
	}

	/*
	 * Method to list all Doctors
	 */
	public void printDoctors() {

		for (int i = 0; i < clinic.getDoctors().size(); i++) {
			System.out.println((i + 1) + " " + clinic.getDoctors().get(i).toString());
		}

	}

	/*
	 * Method to list all Patients
	 */
	public void printPatients() {

		for (int i = 0; i < clinic.getPatients().size(); i++) {
			System.out.println(clinic.getPatients().get(i).toString());
		}
		menu();
	}
}
