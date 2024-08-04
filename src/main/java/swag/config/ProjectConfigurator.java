package swag.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;
import swag.Utils;

import java.io.IOException;

@Data
public class ProjectConfigurator {

	private JsonObject config;
	private String path;
	private String deviceName;
	private DeviceConfigurator deviceConfigurator;

	public ProjectConfigurator(final String path){
		this.path = path;
		this.deviceConfigurator = new DeviceConfigurator();
	}

	public void useDevice( String deviceName ) {
		this.deviceConfigurator.setDeviceName( deviceName );
	}

	public void initialize() throws IOException {
		this.config = JsonParser.parseString( Utils.readFile( this.path ) )
			.getAsJsonObject();

		this.deviceConfigurator.setCurrentDevice( this.config );
	}

}
