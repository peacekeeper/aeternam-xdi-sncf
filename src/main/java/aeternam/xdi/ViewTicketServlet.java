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
import xdi2.core.io.XDIWriterRegistry;
import xdi2.messaging.Message;
import xdi2.messaging.MessageEnvelope;
import xdi2.messaging.response.MessagingResponse;

public class ViewTicketServlet extends HttpServlet {

	private static final long serialVersionUID = 3793048689633131588L;

	private static final Log log = LogFactory.getLog(ViewTicketServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MessageEnvelope me = new MessageEnvelope();
		Message m = me.createMessage(Constants.oebbCloudNumber.getXDIAddress());
		m.setToPeerRootXDIArc(Constants.oebbCloudNumber.getPeerRootXDIArc());
		m.setLinkContractClass(RootLinkContract.class);
		m.setSecretToken(Constants.secretToken);
		m.createGetOperation(Constants.ticketXDIAddress);

		MessagingResponse mr;

		try {

			mr = Constants.oebbXDIClient().send(me);
		} catch (Xdi2ClientException ex) {

			log.error(ex.getMessage(), ex);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
			return;
		}

		Constants.jxdXDIWriter().write(mr.getResultGraph(), response.getOutputStream());
	}
}
