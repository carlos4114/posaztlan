package mx.com.tecnetia.muvitul.infraservices.servicios;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;


@SuppressWarnings("deprecation")
public class CorreroElectronicoBO extends GlobalService{
	
    private JavaMailSenderImpl mailSender;
    private VelocityEngine velocityEngine;
    private String from;
    private String to[];
    private String cc[];
    private String bcc[];
    private String subject;
    private String body;
    private String attachments[];
    private String inLineResources[];
    private Map<String,String> velAttributes;
    private String template;
    private String fromName;
    
    private static void writeToFile(InputStream is, File f) throws IOException{
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
        int c;
        while((c = is.read()) != -1)
            out.writeByte(c);
        is.close();
        out.close();
    }


    public void sendMail(String mailTo[], String mailCc[], String mailBcc[], String mailSubject, String mailBody, File mailAttachments[], File mailInLineResources[])
        throws MessagingException, UnsupportedEncodingException
    {
        if(this.mailSender == null)
            throw new RuntimeException("No se ha instanciado objeto MailSender.");
        if(mailTo == null)
            throw new RuntimeException("No se encuentra definido ning\372n destinatario.");
        if(mailSubject == null)
            throw new RuntimeException("No se encuentra definido el asunto del correo.");
        if(mailBody == null)
            throw new RuntimeException("No se encuentra definido el cuerpo del correo.");

        if(log.isDebugEnabled())
        	log.debug("Enviando un correo desde: "+this.mailSender.getUsername());
        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(mailSubject);
        helper.setTo(mailTo);
        helper.setFrom(this.from == null ? "" : this.from, this.fromName == null ? "" : this.fromName);

        if(mailCc != null)
            helper.setCc(mailCc);
        if(mailBcc != null)
            helper.setBcc(mailBcc);
        if(mailInLineResources != null)
        {
            for(int i = 0; i < mailInLineResources.length; i++)
            {
                FileSystemResource res = new FileSystemResource(mailInLineResources[i]);
                helper.addInline(res.getFilename(), res);
            }

        }
        if(mailAttachments != null)
        {
            for(int i = 0; i < mailAttachments.length; i++)
            {
                FileSystemResource att = new FileSystemResource(mailAttachments[i]);
                helper.addAttachment(att.getFilename(), att);
            }

        }

        helper.setText(mailBody, true);

        this.mailSender.send(message);
    }

    public void sendVelocityMail(final String mailTo[], final String mailCc[], final String mailBcc[], final String mailSubject, final File mailAttachments[], final File mailInLineResources[], final String mailTemplate,
            final Map<String,String> mailVelAttributes)
        throws MessagingException
    {
        if(velocityEngine == null)
            throw new RuntimeException("No se ha instanciado objeto VelocityEngine.");
        if(this.mailSender == null)
            throw new RuntimeException("No se ha instanciado objeto MailSender.");
        if(mailTo == null)
            throw new RuntimeException("No se encuentra definido ning\372n destinatario.");
        if(mailSubject == null)
            throw new RuntimeException("No se encuentra definido el asunto del correo.");
        if(mailTemplate == null)
        {
            throw new RuntimeException("No se encuentra definido el template del correo.");
        } else
        {
            if(log.isDebugEnabled())
            	log.debug("Enviando un correo desde: "+this.mailSender.getUsername());

        	MimeMessagePreparator preparator = new MimeMessagePreparator() {

                public void prepare(MimeMessage mimeMessage)
                    throws Exception
                {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
                    message.setFrom(from,fromName);
                    message.setTo(mailTo);
                    message.setSubject(mailSubject);
                    if(mailCc != null)
                        message.setCc(mailCc);
                    if(mailBcc != null)
                        message.setBcc(mailBcc);
                    if(mailInLineResources != null)
                    {
                        for(int i = 0; i < mailInLineResources.length; i++)
                        {
                            FileSystemResource res = new FileSystemResource(mailInLineResources[i]);
                            message.addInline(res.getFilename(), res);
                        }

                    }
                    if(mailAttachments != null)
                    {
                        for(int i = 0; i < mailAttachments.length; i++)
                        {
                            FileSystemResource att = new FileSystemResource(mailAttachments[i]);
                            message.addAttachment(att.getFilename(), att);
                        }

                    }
                    Map<String,Object> model = new HashMap<String,Object>();
                    if(mailVelAttributes != null)
                    {
                        String key;
                        for(Iterator<String> iterator = mailVelAttributes.keySet().iterator(); iterator.hasNext(); model.put(key, mailVelAttributes.get(key)))
                            key = iterator.next();

                    }
                    
					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, mailTemplate, model);
                    message.setText(text, true);
                }

            };
            this.mailSender.send(preparator);
            return;
        }
    }

    public void sendMail(File mailAttachments[], File mailInLineResources[])
        throws MessagingException, UnsupportedEncodingException
    {
        sendMail(to, cc, bcc, subject, body, mailAttachments, mailInLineResources);
    }

    public void sendVelocityMail(File mailAttachments[], File mailInLineResources[])
        throws MessagingException
    {
        sendVelocityMail(to, cc, bcc, subject, mailAttachments, mailInLineResources, template, velAttributes);
    }

    public void sendMail()
        throws MessagingException, UnsupportedEncodingException
    {
        File mailAttachments[] = (File[])null;
        File mailInLineResources[] = (File[])null;
        try
        {
            if(attachments != null)
            {
                mailAttachments = new File[attachments.length];
                for(int i = 0; i < attachments.length; i++)
                {
                    URL url = getClass().getResource(attachments[i]);
                    if(url==null){
                    	url = new URL(attachments[i]);
                    }
                    File f = new File(url.getFile().substring(url.getFile().lastIndexOf("/") + 1));
                    f.deleteOnExit();
                    InputStream is = url.openStream();
                    writeToFile(is, f);
                    mailAttachments[i] = f;
                    is.close();
                }

            }
            if(inLineResources != null)
            {
                mailInLineResources = new File[inLineResources.length];
                for(int i = 0; i < inLineResources.length; i++)
                {
                    URL url = getClass().getResource(inLineResources[i]);
                    if(url==null){
                    	url = new URL(inLineResources[i]);
                    }
                    File f = new File(url.getFile().substring(url.getFile().lastIndexOf("/") + 1));
                    f.deleteOnExit();
                    InputStream is = url.openStream();
                    writeToFile(is, f);
                    mailInLineResources[i] = f;
                    is.close();
                }

            }
        }
        catch(IOException e)
        {
            throw new MessagingException(e.getMessage());
        }
        sendMail(to, cc, bcc, subject, body, mailAttachments, mailInLineResources);
    }


    public void sendVelocityMail()
        throws MessagingException
    {
        File mailAttachments[] = (File[])null;
        File mailInLineResources[] = (File[])null;
        try
        {
            if(attachments != null)
            {
                mailAttachments = new File[attachments.length];
                for(int i = 0; i < attachments.length; i++)
                {                    
                    File f = new File(attachments[i]);
                    InputStream is = new FileInputStream(f);
                    mailAttachments[i] = f;
                    is.close();
                }

            }
            if(inLineResources != null)
            {
                mailInLineResources = new File[inLineResources.length];
                for(int i = 0; i < inLineResources.length; i++)
                {
                    URL url = getClass().getResource(inLineResources[i]);
                    if(url==null){
                    	url = new URL(inLineResources[i]);
                    }
                    File f = new File(url.getFile().substring(url.getFile().lastIndexOf("/") + 1));
                    f.deleteOnExit();
                    InputStream is = url.openStream();
                    writeToFile(is, f);
                    mailInLineResources[i] = f;
                    is.close();
                }

            }
        }
        catch(IOException e)
        {
            throw new MessagingException(e.getMessage());
        }
        sendVelocityMail(to, cc, bcc, subject, mailAttachments, mailInLineResources, template, velAttributes);
    }

    public void setMailSender(JavaMailSenderImpl mailSender)
    {
        this.mailSender = mailSender;
    }

    public void setTo(String to[])
    {
        this.to = to;
    }

    public void setCc(String cc[])
    {
        this.cc = cc;
    }

    public void setBcc(String bcc[])
    {
        this.bcc = bcc;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public void setAttachments(String attachments[])
    {
        this.attachments = attachments;
    }

    public void setInLineResources(String inLineResources[])
    {
        this.inLineResources = inLineResources;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine)
    {
        this.velocityEngine = velocityEngine;
    }

    public void setVelAttributes(Map<String,String> velAttributes)
    {
        this.velAttributes = velAttributes;
    }

    public void setTemplate(String template)
    {
        this.template = template;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public void setFromName(String fromName)
    {
        this.fromName = fromName;
    }

}
