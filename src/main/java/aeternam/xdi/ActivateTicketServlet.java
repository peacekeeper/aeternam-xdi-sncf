package aeternam.xdi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xdi2.client.exceptions.Xdi2ClientException;
import xdi2.core.features.linkcontracts.instance.RootLinkContract;
import xdi2.core.syntax.XDIStatement;
import xdi2.messaging.Message;
import xdi2.messaging.MessageEnvelope;

public class ActivateTicketServlet extends HttpServlet {

	private static final long serialVersionUID = 3716999752371513442L;

	private static final Log log = LogFactory.getLog(ActivateTicketServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MessageEnvelope me = new MessageEnvelope();
		Message m = me.createMessage(Constants.selfCloudNumber.getXDIAddress());
		m.setToPeerRootXDIArc(Constants.selfCloudNumber.getPeerRootXDIArc());
		m.setLinkContractClass(RootLinkContract.class);
		m.setSecretToken(Constants.secretToken);
		m.createSetOperation(XDIStatement.create(Constants.ticketXDIAddress + "<#active>/&/\"true\""));

		try {

			Constants.selfXDIClient().send(me);
		} catch (Xdi2ClientException ex) {

			log.error(ex.getMessage(), ex);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
			return;
		}
	}
}
