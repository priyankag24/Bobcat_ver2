package test.bobcat.pages;

import com.cognifide.qa.bb.aem.core.api.AemActions;
import com.cognifide.qa.bb.api.actions.ActionException;
import com.cognifide.qa.bb.api.actions.ActionsController;
import com.cognifide.qa.bb.junit5.guice.Modules;
import com.cognifide.qa.bb.modules.BobcatRunModule;
import com.cognifide.qa.bb.page.BobcatPageFactory;
import com.cognifide.qa.bb.aem.core.pages.AemAuthorPage;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.wait.BobcatWait;
import com.google.inject.Inject;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.cognifide.qa.bb.aem.AemLogin;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import com.cognifide.qa.bb.junit5.guice.Modules;
import com.cognifide.qa.bb.modules.BobcatRunModule;
import com.cognifide.qa.bb.page.BobcatPageFactory;

import com.cognifide.qa.bb.aem.ui.wcm.SiteAdminPage;


public class CreateNewPage {
	
	 private static final String CREATE_PAGE_TEMPLATE = "login";

	  private static final String BASE_PARENT_URL = "/mnt/overlay/wcm/core/content/sites/createpagewizard.html/content/etap/loginpage";

	  private static final String CREATED_PAGE_TITLE = "New Login Page";

	  @Inject
	  private SiteAdminPage page;

	  @Inject
	  private AemLogin aemLogin;
	  
	  @Before
	  public void openSiteadminPage() {
	    aemLogin.authorLogin();
	    page.open(BASE_PARENT_URL);
	  }
	  
	  @Test
	  public void createPage() {
		  
		System.out.println("Inside create page method");
	    if (!page.isPagePresent(CREATED_PAGE_TITLE)) {
	      page.createNewPage(CREATED_PAGE_TITLE, CREATE_PAGE_TEMPLATE);
	    }
	    assertTrue(page.isPagePresent(CREATED_PAGE_TITLE));
	    assertTrue(page.isTemplateOnTheList(CREATED_PAGE_TITLE, CREATE_PAGE_TEMPLATE));
	  }

	  /*@After
	  public void cleanUp() {
	    removePage(BASE_PARENT_URL, CREATED_PAGE_TITLE);
	  }

	  private void removePage(String parentPath, String pageTitle) {
	    page.open(parentPath);
	    if (page.isPagePresent(pageTitle)) {
	      page.deletePage(pageTitle);
	    }
	  }*/
	}

