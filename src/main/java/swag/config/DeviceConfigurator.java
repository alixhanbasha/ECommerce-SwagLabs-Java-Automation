package swag.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Data;
import swag.models.Device;

@Data
public class DeviceConfigurator {
	private Device device;
	private String deviceName;

	public void setCurrentDevice( JsonObject config ){
		var deviceJsonConfig = config.getAsJsonObject("device")
			.get( this.deviceName );

		this.device = new Gson().fromJson( deviceJsonConfig, Device.class );
		this.device.setDeviceName( this.deviceName );
	}

}
