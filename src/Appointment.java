import java.util.Calendar;

/* File Name: Appointment.java
 * Course Name: Computer Programmer
 * Lab Section: 310 
 * Student Name: 040915490
 * Date: 26/Nov/2018  
 */ 



/*	Represents a Appointment to set and get
 *  the appointment into the ArrayList
 */ 
public class Appointment {
	
	private Doctor doctor;
	private Patient patient;
	private OurDate appointmentDate;
	private Calendar now = Calendar.getInstance();
	
	/*
	 * Chain Default Constructor 
	 * no values can be null
	 */
	public Appointment() {
		this(new Patient(), new Doctor(), new OurDate());
	}
	
	/*
	 * Overloaded Constructor
	 * to set values since method set is Private
	 */
	public Appointment(Patient patient, Doctor doctor, OurDate appointmentDate) {
		setAppointmentDate(appointmentDate);
		setDoctor(doctor);
		setPatient(patient);
	}

	public Doctor getDoctor() {
		return doctor;
	}

	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	private void setPatient(Patient patient) {
		this.patient = patient;
	}

	public OurDate getAppointmentDate() {
		return appointmentDate;
	}

	private void setAppointmentDate(OurDate appointmentDate) {
		if (appointmentDate.getYear() < now.get(Calendar.YEAR)) {
			throw new MedicalClinicException("Appointment cannot be in the past");
		}
		else if (appointmentDate.getYear() == now.get(Calendar.YEAR) && appointmentDate.getMonth()-1 < now.get(Calendar.MONTH)) {
			throw new MedicalClinicException("Appointment cannot be in the past");
		}
		else if (appointmentDate.getYear() == now.get(Calendar.YEAR) && appointmentDate.getMonth()-1 == now.get(Calendar.MONTH) && appointmentDate.getDay() < now.get(Calendar.DATE)) {
			throw new MedicalClinicException("Appointment cannot be in the past");
		}
		else if (appointmentDate.getYear() == now.get(Calendar.YEAR) && appointmentDate.getMonth()-1 == now.get(Calendar.MONTH) && appointmentDate.getDay() == now.get(Calendar.DATE)) {
			throw new MedicalClinicException("Appointment cannot be today");
		} else {
			this.appointmentDate = appointmentDate;
		}	
	}

	@Override
	public String toString() {
		return "Appointment date: " + appointmentDate + ", " + doctor + ", " + patient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentDate == null) ? 0 : appointmentDate.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Appointment))
			return false;
		Appointment other = (Appointment) obj;
		if (appointmentDate == null) {
			if (other.appointmentDate != null)
				return false;
		} else if (!appointmentDate.equals(other.appointmentDate))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		return true;
	}
	

}
