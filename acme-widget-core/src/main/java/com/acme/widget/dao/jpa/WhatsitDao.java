package com.acme.widget.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.widget.domain.Whatsit;

public interface WhatsitDao extends JpaRepository<Whatsit, Long>
{
}
