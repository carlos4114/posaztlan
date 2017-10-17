package mx.com.tecnetia.muvitul.seguridadservices.negocio.seguridad.business;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.HttpRequestVO;
import mx.com.tecnetia.muvitul.infraservices.negocio.seguridad.vo.LoginResponseVO;
import mx.com.tecnetia.muvitul.infraservices.persistencia.muvitul.enumeration.ClaimsEnum;
import mx.com.tecnetia.muvitul.infraservices.persistencia.utileria.business.FechasUtilsBO;
import mx.com.tecnetia.muvitul.infraservices.servicios.BusinessGlobalException;
import mx.com.tecnetia.muvitul.infraservices.servicios.GlobalService;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

	private static String[] PALABRAS_INCORRECTAS=new String[]{
			"OR","AND","UNION","LIMIT","WHERE","GROUP","HAVING","SELECT","FILE","=!","=","/",
			"*","&&","||",">>","<=","<=","XOR","DIV","LIKE","SOUNDS","LIKE","RLIKE","REGEX",
			"PLEAST","GREATE","CAST","CONVERT","IS","IN","NOT","MATCH","AND","OR","BINARY",
			"BETWEEN","ISNULL","INSERT","UPDATE","DELETE","JOIN"};

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

		return new LoginResponseVO(Jwts.builder().setSubject(claims.getSubject())
  	  			 .claim(ClaimsEnum.ROLES, (List<Integer>) claims.get(ClaimsEnum.ROLES))
  	  			 .setIssuedAt(claims.getIssuedAt())
  	  			 .claim(ClaimsEnum.USUARIO, (Integer)claims.get(ClaimsEnum.USUARIO))
  	  			 .claim(ClaimsEnum.CINE, (Integer)claims.get(ClaimsEnum.CINE))
	  			 .claim(ClaimsEnum.PUNTO_VENTA, (Integer)claims.get(ClaimsEnum.PUNTO_VENTA))
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