package com.acme.widget.dao.fixture;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.acme.widget.dao.jpa.WidgetDao;
import com.acme.widget.domain.Whatsit;
import com.acme.widget.domain.Widget;

@Component
public class WidgetFixture implements InitializingBean
{
	int widgetCount, whatsitCount;

	@Autowired
	WidgetDao widgetDao;

	public WidgetFixture(int widgetCount, int whatsitCount)
	{
		this.widgetCount = widgetCount;
		this.whatsitCount = whatsitCount;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		Assert.notNull(widgetDao, "widget-dao required");
	}

	public void fixture1()
	{
		for (int i = 0; i < widgetCount; i++)
		{
			Widget widget = new Widget();
			widget.setName("widget-" + i);
			for (int j = 0; j < whatsitCount; j++)
			{
				Whatsit whatsit = new Whatsit();
				whatsit.setName("whatsit-" + i + "-" + j);
				widget.addWhatsit(whatsit);
			}
			widgetDao.save(widget);
		}
	}

	public void setWidgetDao(WidgetDao widgetDao)
	{
		this.widgetDao = widgetDao;
	}
}
