package com.acme.widget.dao.jpa;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.acme.widget.domain.Widget;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class WidgetDaoTest
{
	@Autowired
	private WidgetDao widgetDao;
	
	@Resource(name = "widgets")
	private List<Widget> widgets;
	
	@Test
	@Transactional
	@Rollback(value=false)
	public void basic()
	{
		for (Widget w : widgets)
		{
			widgetDao.save(w);
			System.out.println("saved: " + w);
		}
	}
}
