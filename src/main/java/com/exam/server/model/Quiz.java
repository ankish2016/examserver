package com.exam.server.model;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private Long qid;
   private String title;
   private String description;
   private String maxMarks;
   private String numberOfQuestion;
   @OneToMany
   private Set<Quiz> quizes=new LinkedHashSet<Quiz>();
   private boolean active=false;
}