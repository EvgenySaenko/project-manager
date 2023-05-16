package com.projectmanager.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends PersistableEntity{

	@Column(name = "name")
	private String name;

}
