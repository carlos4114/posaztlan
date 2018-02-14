package mx.com.aztlan.pos.infraservices.negocio.seguridad.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import mx.com.aztlan.pos.infraservices.negocio.posaztlanbd.vo.CineVO;

public class UserDetailsVO implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String password;
	private String username;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private CineVO cineVO;
	private Set<PerfilVO> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public UserDetailsVO() {
		this.password = "";
		this.username = "";
		this.setEnabled(false);
		this.setAccountNonExpired(false);
		this.setAccountNonLocked(false);
		this.setCredentialsNonExpired(false);
	}

	public CineVO getCineVO() {
		return cineVO;
	}

	public void setCineVO(CineVO cineVO) {
		this.cineVO = cineVO;
	}

	public Set<PerfilVO> getRoles() {
		return roles;
	}

	public void setRoles(Set<PerfilVO> roles) {
		this.roles = roles;
	}

	public List<GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (PerfilVO perfil : roles) {
//			authorities.add(new SimpleGrantedAuthority(perfil.getNombre()));
		}

		return authorities;
	}
}
