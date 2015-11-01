package com.health.mongo.dbutil;

import java.util.Map;

/**
 * This interface is the contract to be satisfied by template engine
 * implementations
 * 
 * @author martin.simon
 *
 */
public interface ITemplateEngine {
	/**
	 * Read the template and inject the context data
	 * 
	 * @param templateName
	 *            the template name
	 * @param contextData
	 *            the contextual data to be injected in the template
	 */
	String readTemplate(String templateName, Map<String, Object> contextData);
}
