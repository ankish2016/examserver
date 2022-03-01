package com.exam.server.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String profile;
	private boolean enable = true;
	//user Has ManyRole
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user" )
	@JsonIgnore
	private Set<UserRole> userRole=new HashSet<UserRole>();
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> authSet=new HashSet<Authority>();
		this.userRole.forEach(userRole->{
			Authority auth=new Authority(userRole.getRole().getRoleName());
			authSet.add(auth);
		});
		return authSet;
	}
	
	public String getUsername() {
		return this.userName;
	}
	
	public boolean isAccountNonExpired() {
		return true;
	}
	
	public boolean isAccountNonLocked() {
		return true;
	}
	
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return this.enable;
	}

}
