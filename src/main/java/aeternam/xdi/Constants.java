package aeternam.xdi;

import java.net.URI;
import java.util.Properties;

import xdi2.client.impl.http.XDIHttpClient;
import xdi2.core.io.XDIWriter;
import xdi2.core.io.XDIWriterRegistry;
import xdi2.core.syntax.CloudNumber;
import xdi2.core.syntax.XDIAddress;

public class Constants {

	public static URI oebbEndpoint = URI.create("http://localhost:7203/xdi/graph");

	public static CloudNumber oebbCloudNumber = CloudNumber.create("+!:uuid:cd5e5900-406b-4eac-b578-eea37eb502c2");

	public static String secretToken = "alice";

	public static XDIAddress ticketXDIAddress = XDIAddress.create("*!:uuid:3fc43aa0-a86c-4a0e-b8ed-ec4dcb4f976c");

	public static XDIHttpClient oebbXDIClient() {

		return new XDIHttpClient(Constants.oebbEndpoint);
	}

	public static XDIWriter jxdXDIWriter() {

		Properties parameters = new Properties();
		parameters.setProperty(XDIWriterRegistry.PARAMETER_PRETTY, "1");
		return XDIWriterRegistry.forFormat("JXD", parameters);
	}
}
