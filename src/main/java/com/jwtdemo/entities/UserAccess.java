package com.jwtdemo.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserAccess {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userAccessID;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "useraccess_usergroup", joinColumns = @JoinColumn(name = "userAccessID"), inverseJoinColumns = @JoinColumn(name = "userGroupID"))
	private Set<UserGroup> userGroupID = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "useraccess_userfunction", joinColumns = @JoinColumn(name = "userAccessID"), inverseJoinColumns = @JoinColumn(name = "functionID"))
	private Set<UserFunction> functionID = new HashSet<>();

}
