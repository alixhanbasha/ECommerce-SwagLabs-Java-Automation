package swag.models;

import lombok.Data;

@Data
public class Device {
	private String deviceName;
	private int width;
	private int height;

	public Device( String dn, int w, int h ) {
		this.deviceName = dn;
		this.width = w;
		this.height = h;
	}

	@Override
	public String toString() {
		return "[ name -> '" + this.deviceName +
			   "'  width -> '" + this.width +
			   "' height -> '" + this.height + "' ]";
	}
}
