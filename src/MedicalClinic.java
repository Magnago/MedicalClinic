
/* File Name: MedicalClinic.java
 * Course Name: Computer Programmer
 * Lab Section: 310 
 * Student Name: 040915490
 * Date: 26/Nov/2018  
 */

import java.util.ArrayList;

/*	Represents a MedicalClinic to keep track of  
 *  appointments between doctors and patients. 
 */
public class MedicalClinic {

	// private ArrayList<Appointment> appointments;
	// private ArrayList<Appointment> patients;
	// private ArrayList<Appointment> doctors;

	private static int numberAppointments, numberPatients, numberDoctors;
	private final int MAX_APPOINTMENTS = 5;
	private final int MAX_DOCTORS = 5;
	private final int MAX_PATIENTS = 5;
	private ArrayList<Appointment> appointments = new ArrayList<>(MAX_APPOINTMENTS);
	private ArrayList<Patient> patients = new ArrayList<>(MAX_DOCTORS);
	private ArrayList<Doctor> doctors = new ArrayList<>(MAX_PATIENTS);
	private Patient newPatient;

	public MedicalClinic() {
		// appointments = new ArrayList<>(MAX_APPOINTMENTS);
		// patients = new ArrayList<>(MAX_PATIENTS);
		// doctors = new ArrayList<>(MAX_DOCTORS);
		doctors.add(0, new Doctor("Vikash", "Singh", "endocrinologist"));
		doctors.add(1, new Doctor("Susan", "Miller", "cardiologist"));
		doctors.add(2, new Doctor("Thanh", "Do", "neurologist"));
		doctors.add(3, new Doctor("Francois", "DaSilva", "internist"));
		doctors.add(4, new Doctor("Judy", "Chin", "Family Physician"));
		numberAppointments = 0;
		numberPatients = 0;
		numberDoctors = 0;
	}

	/*
	 * Method to add a regular Patient  into the ArrayList<Patient> check the type to use the
	 * correct Patient class or subclass
	 */
	public void addPatients(String lastName, String firstName, String healthCardNumber, OurDate date) {
		newPatient = new Patient(firstName, lastName, healthCardNumber, date);
		patients.add(newPatient);
		numberPatients++;
	}
	/*
	 * Method to add a OutPatient into the ArrayList<Patient> check the type to use the
	 * correct Patient class or subclass
	 */
	public void addPatients(String lastName, String firstName, String healthCardNumber, OurDate date, double distance,
			boolean mobility) {
		newPatient = new OutPatient(firstName, lastName, healthCardNumber, date, distance, mobility);
		patients.add(newPatient);
		numberPatients++;
	}
	/*
	 * Method to add a Maternity Patient into the ArrayList<Patient> check the type to use the
	 * correct Patient class or subclass
	 */
	public void addPatients(String lastName, String firstName, String healthCardNumber, OurDate date, OurDate dueDate,
			boolean nutrionTesting) {
		newPatient = new MaternityPatient(firstName, lastName, healthCardNumber, date, dueDate, nutrionTesting);
		patients.add(newPatient);
		numberPatients++;

	}

	/*
	 * Method to add appointment from ArrayList<Appointment>
	 */
	public void addAppointment(Patient patient, Doctor doctor, OurDate date) {
		appointments.add(new Appointment(patient, doctor, date));
		numberAppointments++;
		numberDoctors++;
	}

	/*
	 * Method to remove appointment from ArrayList<Appointment>
	 */
	public void cancelAppointment(int index) {
		appointments.remove(index);
		numberAppointments--;
		numberDoctors--;
	}

	public int getNumberAppointments() {
		return numberAppointments;
	}

	public int getNumberPatients() {
		return numberPatients;
	}

	public int getNumberDoctors() {
		return numberDoctors;
	}

	public int getMaxAppointments() {
		return MAX_APPOINTMENTS;
	}

	public int getMaxDoctors() {
		return MAX_DOCTORS;
	}

	public int getMaxPatients() {
		return MAX_PATIENTS;
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

}
