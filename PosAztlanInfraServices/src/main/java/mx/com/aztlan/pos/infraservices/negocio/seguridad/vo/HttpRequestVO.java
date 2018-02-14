
package mx.com.aztlan.pos.infraservices.negocio.seguridad.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HttpRequestVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Map<String,String[]> parameterMap;
	private List<Integer> roles;
	private String pathInfo;
	private String body;
	private Date expiration;
	
	
	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}
	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}
	public String getPathInfo() {
		return pathInfo;
	}
	public void setPathInfo(String pathInfo) {
		this.pathInfo = pathInfo;
	}
	public List<Integer> getRoles() {
		return roles;
	}
	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
}
