/* File Name: MedicalClinicException.java
 * Course Name: Computer Programmer
 * Lab Section: 310 
 * Student Name: 040915490
 * Date: 26/Nov/2018
 */ 
public class MedicalClinicException extends RuntimeException{
	private String message;
	
	public MedicalClinicException() {
		this("unknown");
	}
	
	public MedicalClinicException(String message) {
		super(message);
	}
}
