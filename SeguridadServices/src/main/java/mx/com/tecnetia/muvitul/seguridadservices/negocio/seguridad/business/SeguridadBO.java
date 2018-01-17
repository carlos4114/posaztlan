package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.business;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpRequestVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.MenuVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.OpcionMenuVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.UsuarioLoginVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dao.PropiedadConfigDAOI;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Menu;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.PropiedadConfig;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.dto.Recurso;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.PropiedadConfigEnum;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.CorreoElectronicoBO;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.MenuIbatisDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.RecursoDAOI;
import mx.com.tecnetia.muvitul.seguridadservices.persistencia.muvitul.dao.UsuarioIbatisDAOI;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Configuration
@PropertySource({"classpath:config/${ENV_VAR}/global.properties","classpath:config/aplicacion/aplicacion.properties"})
public class SeguridadBO extends GlobalService{
	@Autowired
    Environment env;
	@Autowired
	MenuIbatisDAOI menuIbatisDAO;
	@Autowired
	UsuarioIbatisDAOI usuarioIbatisDAO;
	@Autowired
    RecursoDAOI recursoDAO;
	@Autowired
	CorreoElectronicoBO correoElectronicoBO;	
	@Autowired
    PropiedadConfigDAOI propiedadConfigDAO;

	private static String[] PALABRAS_INCORRECTAS=new String[]{
			"OR","AND","UNION","LIMIT","WHERE","GROUP","HAVING","SELECT","FILE","=!","=","/",
			"*","&&","||",">>","<=","<=","XOR","DIV","LIKE","SOUNDS","LIKE","RLIKE","REGEX",
			"PLEAST","GREATE","CAST","CONVERT","IS","IN","NOT","MATCH","AND","OR","BINARY",
			"BETWEEN","ISNULL","INSERT","UPDATE","DELETE","JOIN"};

	/**
     * Servicio para enviar correo electrónico de cambio de contrasenia
     */
	@Transactional (readOnly=true)
	public void enviarMailContrasenia(UsuarioLoginVO usuarioVO) throws Exception{
		final String asuntoCorreo = "MUVITUL - Accesos";
		
		Map<String,String> velAttrs = new HashMap<String,String>();
   	  	velAttrs.put("contraseniaUsuario", usuarioVO.getContrasenia());

   	  	this.correoElectronicoBO.setTemplate("mx/com/tecnetia/muvitul/seguridadservices/negocio/seguridad/business/RecuperarContraseniaMail.vm");
		this.correoElectronicoBO.setVelAttributes(velAttrs);
		this.correoElectronicoBO.setTo(new String[]{usuarioVO.getUsuario()});
		this.correoElectronicoBO.setSubject(asuntoCorreo);	
		
		PropiedadConfig urlLogo = this.propiedadConfigDAO.findById(PropiedadConfigEnum.URL_LOGO.getValue());		
		if(urlLogo!=null)
 		  	this.correoElectronicoBO.setAttachments(new String[]{urlLogo.getValor()});
		
		this.correoElectronicoBO.sendVelocityMail();
	}
	
	/**
     * Servicio para generar una contraseña aleatoria
     */
	@Transactional (readOnly=true)
	public String obtenerContraseniaAleatoria() throws Exception{
		if(log.isDebugEnabled()){
			log.debug("Creando una contrasenia aleatoria");
		}

			final int MIN_LENGTH = 8;

			java.util.Random r = new java.util.Random();

			/*
			* Set of characters. This is limited to numbers and letters for error issues.
			*/
			char[] cadenaCaracteres = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
			'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'2', '3', '4', '5', '6', '7', '8', '9', };

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < MIN_LENGTH; i++) {
				sb.append(cadenaCaracteres[r.nextInt(cadenaCaracteres.length)]);
			}

			return sb.toString();
	}
	
	/**
     * Servicio para encontrar un usuario por medio del correo
     */
	@Transactional (readOnly=true)
	public List<OpcionMenuVO> obtenerMenuParaUsuario(String correo) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("Obteniendo el menu para usuario: "+correo);
		}

		List<MenuVO> menusPadre = this.menuIbatisDAO.getMenuForUsuario(correo);
		List<OpcionMenuVO> arbolMenu = new ArrayList<OpcionMenuVO>();
		
		for(MenuVO menuPadre: menusPadre){
				Recurso recurso = this.recursoDAO.findById(menuPadre.getIdRecurso());			
				//if(recurso.get)
				List<OpcionMenuVO> submenus = new ArrayList<OpcionMenuVO>();
			
				for(Menu opcionMenu:recurso.getMenusForIdRecursoPadre()){
					Recurso recursoOpcion = opcionMenu.getRecursoByIdRecurso();	
					Integer existeRecurso = this.usuarioIbatisDAO.existeRecursoParaUsuario(correo, recursoOpcion.getIdRecurso());
					if(existeRecurso>0){
						List<OpcionMenuVO> opcionesMenu = new ArrayList<OpcionMenuVO>();		
						for(Menu opcionMenu2:recursoOpcion.getMenusForIdRecursoPadre()){
							Recurso recursoOpcion2 = opcionMenu2.getRecursoByIdRecurso();			
							existeRecurso = this.usuarioIbatisDAO.existeRecursoParaUsuario(correo, recursoOpcion2.getIdRecurso());
							if(existeRecurso>0)
								opcionesMenu.add(new OpcionMenuVO(recursoOpcion2.getIdRecurso(),"#"+recursoOpcion2.getRecursoUrl(),recursoOpcion2.getNombre(),opcionMenu2.getIcono(),null));								
						}
						submenus.add(new OpcionMenuVO(recursoOpcion.getIdRecurso(),"#"+recursoOpcion.getRecursoUrl(),recursoOpcion.getNombre(),opcionMenu.getIcono(),opcionesMenu));								
					}
				}			
				arbolMenu.add(new OpcionMenuVO(recurso.getIdRecurso(),"#"+recurso.getRecursoUrl(),recurso.getNombre(),menuPadre.getIcono(),submenus));
		}

		return arbolMenu;
	}
	
	@Transactional(readOnly=true)
	public Boolean esTokenVigente(Date fechaExpiracion) throws BusinessGlobalException, Exception{
		
		Date fechaActual = FechasUtilsBO.getCurrentDate();
        
		return !fechaActual.after(fechaExpiracion);		
	}
	
	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public LoginResponseVO actualizarToken(Claims claims) throws BusinessGlobalException, Exception{
        
		if(claims == null)
			throw new BusinessGlobalException("No se pudo actualizar el token. El objeto claims no puede ser nulo.");
		
		String pwdEncryptor = env.getProperty("jwt.password");
		Integer expirationMinutes = new Integer(env.getProperty("jwt.expiration.minutes"));
		
		//Actualizamos solo la fecha de expiracion
		Date fechaActual = FechasUtilsBO.getCurrentDate();
		Date fechaExpriacion = FechasUtilsBO.addMinutesToDate(fechaActual, expirationMinutes);

		return new LoginResponseVO(				  
				 (String)claims.get(ClaimsEnum.NOMBRE_COMPLETO_USR),
				  Jwts.builder().setSubject(claims.getSubject())
  	  			 .claim(ClaimsEnum.ROLES, (List<Integer>) claims.get(ClaimsEnum.ROLES))
  	  			 .setIssuedAt(claims.getIssuedAt())
  	  			 .claim(ClaimsEnum.USUARIO, (Integer)claims.get(ClaimsEnum.USUARIO))
  	  			 .claim(ClaimsEnum.CINE, (Integer)claims.get(ClaimsEnum.CINE))
	  			 .claim(ClaimsEnum.PUNTO_VENTA, (Integer)claims.get(ClaimsEnum.PUNTO_VENTA))
   	  			 .claim(ClaimsEnum.CAJA, (Integer)claims.get(ClaimsEnum.CAJA))
	  			 .claim(ClaimsEnum.NOMBRE_COMPLETO_USR, claims.get(ClaimsEnum.NOMBRE_COMPLETO_USR))
 	  			 .setExpiration(fechaExpriacion)
  	  			 .signWith(SignatureAlgorithm.HS256, pwdEncryptor)
  	  			 .compact());
	}
	
	@Transactional(readOnly=true)
	public String encriptarConSHA1(String texto) throws BusinessGlobalException, Exception{
		 if (texto == null) 
	            throw new BusinessGlobalException("Error al encriptar cadena. El texto no puede ser nulo.");

		String cadenaEncriptada = new String("");

		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.reset();

		byte[] buffer = texto.getBytes();
		md.update(buffer);

		byte[] digest = md.digest();

		for (int i = 0; i < digest.length; i++) {
			cadenaEncriptada +=  Integer.toString( ( digest[i] & 0xff ) + 0x100, 16).substring( 1 );
		}

		return cadenaEncriptada;
	}
	
	public Boolean contieneParametrosValidos(HttpRequestVO requestVO,String url) throws BusinessGlobalException, Exception{
		 if (requestVO == null) 
	            throw new BusinessGlobalException("Error al validar inyeccion de dependencias. El request no puede ser nulo.");
		 if (url == null) 
	            throw new BusinessGlobalException("Error al validar contenido de parametros. Url no puede ser nula.");
  	
		/* SE BARREN LOS PARAMETROS DEL REQUEST PARA FILTRAR INYECCION SQL O PALABRAS INCORRECTAS */
		Iterator<String> nombresParams = requestVO.getParameterMap().keySet().iterator();
		
		while(nombresParams.hasNext()){
			String nombreParam = nombresParams.next();
			for(String param: (String[])requestVO.getParameterMap().get(nombreParam)){
				if(contienePalabraIncorrecta(param)){
					return false;
				}
			}
		}			
		
	    /* SE VALIDA LA URL PARA FILTRAR INYECCION SQL O PALABRAS INCORRECTAS POR REST GET*/
		  String[] textos = url.split("/");
		  for(String frase:textos){
			  if(contienePalabraIncorrecta(frase)){
					return false;
			  }									  			  
		  }		  

		
		return true;
	}

	@Transactional(readOnly = true)
	public Boolean contieneInyeccionSqlJson(String texto) throws BusinessGlobalException, Exception{
		 if (texto == null) 
	            throw new BusinessGlobalException("Error al validar inyeccion de dependencias. El texto no puede ser nulo.");
		
		  /*VALIDAMOS SI HAY PARAMETROS JSON Y LOS BARREMOS PARA FILTRAR INYECCION SQL*/
		  JSONObject json = null; 
		  if(texto.length()==0?false:texto.charAt(0)=='{'){
				json = new JSONObject(texto);
			   @SuppressWarnings("unchecked")
			   Iterator<String> nombresVars = json.keys();
			   while(nombresVars.hasNext()){
					  String nombreVar = (String)nombresVars.next();					  
					  if(json.get(nombreVar)!=null){						  
						  if(contienePalabraIncorrecta(json.get(nombreVar).toString())){
							  return true;
						  }									  
					  }
				}			   
		  }
		  
		  return false;
		  
	}
	
	public Boolean contienePalabraIncorrecta(String texto) throws BusinessGlobalException, Exception{
		 if (texto == null) 
	            throw new BusinessGlobalException("Error al validar contenido de texto. El texto no puede ser nulo.");

		String[] palabras = texto.split("\\s+");
		for(String palabra : palabras){
			if(Arrays.asList(PALABRAS_INCORRECTAS).contains(palabra.toUpperCase())){
				return true;
			}
		}
		return false;
	}

	
}