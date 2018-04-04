import oracle.oats.scripting.modules.basic.api.*;
import oracle.oats.scripting.modules.browser.api.*;
import oracle.oats.scripting.modules.functionalTest.api.*;
import oracle.oats.scripting.modules.utilities.api.*;
import oracle.oats.scripting.modules.utilities.api.sql.*;
import oracle.oats.scripting.modules.utilities.api.xml.*;
import oracle.oats.scripting.modules.utilities.api.file.*;
import oracle.oats.scripting.modules.webdom.api.*;

public class script extends IteratingVUserScript {
	@ScriptService oracle.oats.scripting.modules.utilities.api.UtilitiesService utilities;
	@ScriptService oracle.oats.scripting.modules.browser.api.BrowserService browser;
	@ScriptService oracle.oats.scripting.modules.functionalTest.api.FunctionalTestService ft;
	@ScriptService oracle.oats.scripting.modules.webdom.api.WebDomService web;
	
	public void initialize() throws Exception {
		browser.launch();
	}
		
	/**
	 * Add code to be executed each iteration for this virtual user.
	 */
	public void run() throws Exception {
		beginStep("[1] Google (/)", 0);
		{
			web.window(2, "/web:window[@index='0' or @title='about:blank']")
					.navigate("http://google.com/");
			web.window(4, "/web:window[@index='0' or @title='Google']")
					.waitForPage(null);
			{
				think(1.336);
			}
			web.textBox(
					5,
					"/web:window[@index='0' or @title='Google']/web:document[@index='0']/web:form[@id='tsf' or @name='f' or @index='0']/web:input_text[@id='lst-ib' or @name='q' or @index='0']")
					.click();
			{
				think(0.376);
			}
			web.textBox(
					6,
					"/web:window[@index='0' or @title='Google']/web:document[@index='0']/web:form[@id='tsf' or @name='f' or @index='0']/web:input_text[@id='lst-ib' or @name='q' or @index='0']")
					.setText("tes oats");
			{
				think(2.654);
			}
			web.button(
					7,
					"/web:window[@index='0' or @title='Google']/web:document[@index='0']/web:form[@id='tsf' or @name='f' or @index='0']/web:input_submit[@name='btnK' or @value='Google Search' or @index='0']")
					.click();
		}
		endStep();
		beginStep("[2] tes oats - Google Search (/search)", 0);
		{
			web.window(8,
					"/web:window[@index='0' or @title='tes oats - Google Search']")
					.waitForPage(null);
		}
		endStep();

	}
	
	public void finish() throws Exception {
	}
}
