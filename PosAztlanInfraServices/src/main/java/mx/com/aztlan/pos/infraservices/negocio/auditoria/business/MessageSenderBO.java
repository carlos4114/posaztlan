package mx.com.aztlan.pos.infraservices.negocio.auditoria.business;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

public class MessageSenderBO
{
  
    private ConnectionFactory connFactory;
    private String jmsUser;
    private String jmsPwd;
    private String topicName;
    
    public void sendMessage(final Serializable message) throws Exception
    {

        Connection connection = connFactory.createConnection(jmsUser, jmsPwd);
        boolean transacted = false;
        javax.jms.Session session = connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(topicName);
    	
        ObjectMessage msg = session.createObjectMessage();
        msg.setObject((Serializable)message);
        	
        javax.jms.MessageProducer producer = session.createProducer(topic);
        producer.send(msg);

    }

	public void setConnFactory(ConnectionFactory connFactory) {
		this.connFactory = connFactory;
	}

	public void setJmsUser(String jmsUser) {
		this.jmsUser = jmsUser;
	}

	public void setJmsPwd(String jmsPwd) {
		this.jmsPwd = jmsPwd;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
    
}
