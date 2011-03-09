package no.f12.jzx.weboo.web.view;

import org.junit.Test;

import static junit.framework.Assert.*;

public class FrontPageWebTest extends AbstractWebTest {

	@Test
	public void shouldDisplayWelcomeMessage() {
		getDriver().get(getApplicationUrl());
		assertTrue(getDriver().getPageSource(), getDriver().getPageSource().contains("Hello World!"));
	}

	@Test
	public void shouldApplySitemeshDecorator() {
		getDriver().get(getApplicationUrl());
		assertTrue(getDriver().getPageSource(), getDriver().getPageSource().contains("Sitemesh decorator"));
	}

}
