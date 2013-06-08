package com.acme.widget.dao.fixture;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.widget.dao.jpa.WidgetDao;
import com.acme.widget.domain.Whatsit;
import com.acme.widget.domain.Widget;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class WidgetFixtureTest
{
	@Autowired
	WidgetFixture fixture;

	@Autowired
	WidgetDao dao;

	@Test
	public void basic()
	{
		List<Widget> widgets = dao.findAll();
		Assert.assertEquals(fixture.widgetCount, widgets.size());

		for (Widget widget : widgets)
		{
			Collection<Whatsit> whatsits = widget.getWhatsits();
			Assert.assertEquals(fixture.whatsitCount, whatsits.size());
		}
	}
}
