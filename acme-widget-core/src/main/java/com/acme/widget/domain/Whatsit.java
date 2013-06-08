package com.acme.widget.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.hateoas.Identifiable;

import com.kerz.jpa.NamedVersionedPersistable;

@Entity
public class Whatsit extends NamedVersionedPersistable<Long> implements Identifiable<Long>
{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Widget widget;

	// package protected
	void setWidget(Widget widget)
	{
		this.widget = widget;
	}
	
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
}
