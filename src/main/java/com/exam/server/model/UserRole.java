package com.exam.server.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 private User user;
 @ManyToOne
 private Role role;
}
