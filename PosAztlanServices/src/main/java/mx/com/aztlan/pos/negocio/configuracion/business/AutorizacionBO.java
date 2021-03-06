package mx.com.aztlan.pos.negocio.configuracion.business;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.AutorizacionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoAutorizacionDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.TipoAutorizacionXPerfilDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dao.UsuariosDAOI;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Autorizacion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Perfil;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.PerfilesXUsuario;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoAutorizacion;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.TipoAutorizacionXPerfil;
import mx.com.aztlan.pos.infraservices.persistencia.posaztlanbd.dto.Usuario;
import mx.com.aztlan.pos.infraservices.servicios.BusinessGlobalException;
import mx.com.aztlan.pos.negocio.configuracion.assembler.AutorizacionAssembler;
import mx.com.aztlan.pos.negocio.configuracion.vo.EstatusAutorizacionVO;
import mx.com.aztlan.pos.negocio.configuracion.vo.RequestAutorizacionVO;
import mx.com.aztlan.pos.servicios.util.Cipher;

@Service
@Transactional
public class AutorizacionBO {
	private static final Logger logger = LoggerFactory.getLogger(AutorizacionBO.class);
	@Autowired
	private UsuariosDAOI usuariosDAO;
	
	@Autowired
	private TipoAutorizacionDAOI tipoAutorizacionDAO;
	
	@Autowired
	private TipoAutorizacionXPerfilDAOI tipoAutorizacionXPerfilDAO;
	
	@Autowired
	private AutorizacionDAOI autorizacionDAO;

	public EstatusAutorizacionVO createAutorizacion(RequestAutorizacionVO requestAutorizacionVO) throws BusinessGlobalException {
		
			String password="";
			try {
				password = Cipher.SHA1Encrypter(requestAutorizacionVO.getContrasenia());
			} catch (Exception e) {
				logger.error("Error al encriptar contrasenia.");
			}
			
			Usuario usuario= usuariosDAO.findByCorreoAndPwd(requestAutorizacionVO.getCorreo(), password);
			
			if (usuario==null){
				return AutorizacionAssembler.getEstatusAutorizacionVO(0, "Usuario o Password invalido.", null);
			}
			
			if (usuario.getPerfilesXUsuarios()==null || usuario.getPerfilesXUsuarios().isEmpty()){
				return AutorizacionAssembler.getEstatusAutorizacionVO(0, "Usuario sin perfiles.", null);
			}
			
			TipoAutorizacion tipoAutorizacion =tipoAutorizacionDAO.findById(requestAutorizacionVO.getIdTipoAutorizacion());
			
			if (tipoAutorizacion==null){
				return AutorizacionAssembler.getEstatusAutorizacionVO(0, "Tipo de autorizacion invalido.", null);
			}
			
			
			List <Perfil> perfiles= new ArrayList<Perfil>();
			for (PerfilesXUsuario perfilXUsuario : usuario.getPerfilesXUsuarios()) {
				perfiles.add(perfilXUsuario.getPerfil());
			}
			
			List <TipoAutorizacionXPerfil>  tipoAutorizacionXPerfiles = tipoAutorizacionXPerfilDAO.
					findByTipoAndPerfiles(requestAutorizacionVO.getIdTipoAutorizacion(), perfiles);
			
			if (tipoAutorizacionXPerfiles==null || tipoAutorizacionXPerfiles.isEmpty()){
				return AutorizacionAssembler.getEstatusAutorizacionVO(0, "Usuario sin perfil para autorizar.", null);
			}
			
			Autorizacion autorizacion= AutorizacionAssembler.getAutorizacion(usuario.getIdUsuario(), requestAutorizacionVO);
			autorizacionDAO.save(autorizacion);

			
			return AutorizacionAssembler.getEstatusAutorizacionVO(1, "Successful.",autorizacion.getIdAutorizacion() );


	}

}
