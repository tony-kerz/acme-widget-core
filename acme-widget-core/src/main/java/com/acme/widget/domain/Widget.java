package com.acme.widget.domain;

import javax.persistence.Entity;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.kerz.jpa.NamedVersionedPersistable;

@Entity
public class Widget extends NamedVersionedPersistable<Long>
{
	private static final long serialVersionUID = 1L;
	
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
}
