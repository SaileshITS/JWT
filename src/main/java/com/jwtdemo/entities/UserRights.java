package com.jwtdemo.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
public class UserRights {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userRightsID;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private UserDetails userId;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "userrights_usergroup", joinColumns = @JoinColumn(name = "userRightsID"), inverseJoinColumns = @JoinColumn(name = "userGroupID"))
	private Set<UserGroup> userGroupID = new HashSet<>();

}
