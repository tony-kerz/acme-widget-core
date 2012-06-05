package com.acme.widget.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.widget.domain.Widget;

public interface WidgetDao extends JpaRepository<Widget, Long>
{
}
