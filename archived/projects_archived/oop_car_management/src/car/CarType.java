package car;

/**
 * This class represents a car type. for eg: an SUV, sedan , etc.
 * 
 * @author sapan.
 * */
public class CarType {
	private String name;
	private double lengthMin;
	private double lengthMax;
	private double heigthMin;
	private double heigthMax;
	private double ccMin;
	private double ccMax;
	private int count;

	public CarType() {
		super();
		this.name = "";
		this.lengthMin = 0;
		this.lengthMax = 0;
		this.heigthMin = 0;
		this.heigthMax = 0;
		this.ccMin = 0;
		this.ccMax = 0;
		this.count++;
	}
	public CarType(String name, double lengthMin, double lengthMax, double heigthMin, double heigthMax, double ccMin, double ccMax) {
		super();
		this.name = name;
		this.lengthMin = lengthMin;
		this.lengthMax = lengthMax;
		this.heigthMin = heigthMin;
		this.heigthMax = heigthMax;
		this.ccMin = ccMin;
		this.ccMax = ccMax;
		this.count++;
	}
	/**
	 * This function checks whether the car specifications passed as arguments
	 * qualify the car as the given car type.
	 * 
	 * @author sapan.
	 * @param length
	 *            : the length of the car model to be tested for qualification
	 * @param heigth
	 *            : the heigth of the car model to be tested for qualification
	 * @param cc
	 *            : the engine capacity of the car model to be tested for
	 *            qualification
	 * @return result : whether or not the car model qualifies for the current
	 *         car type.
	 * */
	public boolean qualifies(double length, double heigth, double cc) {
		if (!(length > this.lengthMin && length < lengthMax)) {
			return false;
		}
		if (!(heigth > this.heigthMin && heigth < heigthMax)) {
			return false;
		}
		if (!(cc > this.ccMin && heigth < ccMax)) {
			return false;
		}
		return true;
	}
	public void addCar() {
		count++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLengthMin() {
		return lengthMin;
	}
	public void setLengthMin(double lengthMin) {
		this.lengthMin = lengthMin;
	}
	public double getLengthMax() {
		return lengthMax;
	}
	public void setLengthMax(double lengthMax) {
		this.lengthMax = lengthMax;
	}
	public double getHeigthMin() {
		return heigthMin;
	}
	public void setHeigthMin(double heigthMin) {
		this.heigthMin = heigthMin;
	}
	public double getHeigthMax() {
		return heigthMax;
	}
	public void setHeigthMax(double heigthMax) {
		this.heigthMax = heigthMax;
	}
	public double getCcMin() {
		return ccMin;
	}
	public void setCcMin(double ccMin) {
		this.ccMin = ccMin;
	}
	public double getCcMax() {
		return ccMax;
	}
	public void setCcMax(double ccMax) {
		this.ccMax = ccMax;
	}
	public int getCount() {
		return count;
	}
	@Override
	public String toString() {
		return "CarType [name=" + name + ", lengthMin=" + lengthMin + ", lengthMax=" + lengthMax + ", heigthMin=" + heigthMin + ", heigthMax="
				+ heigthMax + ", ccMin=" + ccMin + ", ccMax=" + ccMax + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ccMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ccMin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(heigthMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(heigthMin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lengthMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lengthMin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarType other = (CarType) obj;
		if (Double.doubleToLongBits(ccMax) != Double.doubleToLongBits(other.ccMax))
			return false;
		if (Double.doubleToLongBits(ccMin) != Double.doubleToLongBits(other.ccMin))
			return false;
		if (Double.doubleToLongBits(heigthMax) != Double.doubleToLongBits(other.heigthMax))
			return false;
		if (Double.doubleToLongBits(heigthMin) != Double.doubleToLongBits(other.heigthMin))
			return false;
		if (Double.doubleToLongBits(lengthMax) != Double.doubleToLongBits(other.lengthMax))
			return false;
		if (Double.doubleToLongBits(lengthMin) != Double.doubleToLongBits(other.lengthMin))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
