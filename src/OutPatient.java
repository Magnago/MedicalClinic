/* File Name: OutPatient.java
 * Course Name: Computer Programmer
 * Lab Section: 310 
 * Student Name: 040915490
 * Date: 26/Nov/2018  
 */ 



/*	Represents a OutPatient to set and get
 *  the patient subclass into the ArrayList
 */ 
public class OutPatient extends Patient{
	
	private double distanceFromClinic;
	private boolean mobility;
	
	/*
	 * Chain Default Constructor 
	 * no values can be null
	 */
	public OutPatient() {
		this("unknown", "unknown", "000000000", new OurDate(), -1, false);
	}
	/*
	 * Overloaded Constructor
	 * to set values since method set is Private
	 */
	public OutPatient(String firstName, String lastName, String healthCardNumber, OurDate birthDate, double distanceFromClinic, boolean mobility) {
		super(firstName, lastName, healthCardNumber, birthDate);
		setDistanceFromClinic(distanceFromClinic);
		setMobility(mobility);
	}

	public double getDistanceFromClinic() {
		return distanceFromClinic;
	}

	private void setDistanceFromClinic(double distanceFromClinic) {
		this.distanceFromClinic = distanceFromClinic;
	}

	public boolean isMobility() {
		return mobility;
	}

	private void setMobility(boolean mobility) {
		this.mobility = mobility;
	}

	@Override
	public String toString() {
		return super.toString() + " distanceFromClinic: " + distanceFromClinic + ", mobility:" + mobility;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(distanceFromClinic);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (mobility ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof OutPatient))
			return false;
		OutPatient other = (OutPatient) obj;
		if (Double.doubleToLongBits(distanceFromClinic) != Double.doubleToLongBits(other.distanceFromClinic))
			return false;
		if (mobility != other.mobility)
			return false;
		return true;
	}
	

}
