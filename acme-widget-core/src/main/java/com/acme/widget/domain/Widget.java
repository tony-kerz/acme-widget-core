package com.acme.widget.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.hateoas.Identifiable;

import com.kerz.jpa.NamedVersionedPersistable;

@Entity
public class Widget extends NamedVersionedPersistable<Long> implements Identifiable<Long>
{
	private static final long serialVersionUID = 1L;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "widget")
	private Set<Whatsit> whatsits = new HashSet<Whatsit>();

	public void addWhatsit(Whatsit whatsit)
	{
		whatsits.add(whatsit);
		whatsit.setWidget(this);
	}

	public Set<Whatsit> getWhatsits()
	{
		return whatsits;
	}

	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
}
