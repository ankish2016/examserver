package com.exam.server.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserRole {
 @Id	 
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long UserRoleId;
 @ManyToOne(fetch=FetchType.EAGER)
 @JoinColumn(name="user_id")
 private User user;
 @ManyToOne
 @JoinColumn(name="role_id")
 private Role role;
}
