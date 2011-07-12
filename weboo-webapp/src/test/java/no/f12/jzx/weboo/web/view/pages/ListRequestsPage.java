package no.f12.jzx.weboo.web.view.pages;

import static junit.framework.Assert.*;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.URL_INFORMATION_REQUEST;
import static no.f12.jzx.weboo.web.controller.NavigationRegistry.url;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import no.f12.jzx.weboo.domain.InformationRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ListRequestsPage extends AbstractPage {

	private WebElement requestListing;
	
	public ListRequestsPage(WebDriver driver, String applicationUrl) {
		super(driver, applicationUrl);
	}

	@Override
	protected String getTitle() {
		return "All information requests";
	}

	public void assertShows(InformationRequest request) {
		assertNotNull(requestListing);
		assertTrue(requestListing.isEnabled());
		
		Map<Long, String> requests = requestMap();
		
		assertTrue(requests.containsKey(request.getId()));
		assertEquals(request.getTitle(), requests.get(request.getId()));
	}

	private Map<Long, String> requestMap() {
		List<WebElement> requestElements = requestListing.findElements(By.className("informationRequest"));
		Map<Long, String> requests = Maps.newLinkedHashMap();
		for (WebElement webElement : requestElements) {
			WebElement numberElement = webElement.findElement(By.className("requestNumber"));
			WebElement titleElement = webElement.findElement(By.className("requestTitle"));
			requests.put(Long.valueOf(numberElement.getText()), titleElement.getText());
		}
		return requests;
	}

	public void goTo() {
		getDriver().get(getApplicationUrl() + url(URL_INFORMATION_REQUEST));
		assertAt();
	}

	public void assertAlphabeticalSorting() {
		Map<Long, String> requests = requestMap();
		List<String> nameList = Lists.newArrayList(requests.values());
		List<String> sortedNameList = Lists.newArrayList(nameList);
		Collections.sort(sortedNameList);
		
		assertEquals(sortedNameList, nameList);
	}

	public void clickReceived(InformationRequest informationRequest) {
		WebElement requestRow = findElementRow(informationRequest);
		WebElement receivedElement = requestRow.findElement(By.className("received"));
		receivedElement.click();
		
		
	}

	private WebElement findElementRow(InformationRequest informationRequest) {
		List<WebElement> requestRows = requestListing.findElements(By.className("informationRequest"));
		for (WebElement row : requestRows) {
			WebElement requestNumber = row.findElement(By.className("requestNumber"));
			if (requestNumber.getText().equals(Long.toString(informationRequest.getId()))){
				return row;
			}
		} 
		return null;
	}

}
