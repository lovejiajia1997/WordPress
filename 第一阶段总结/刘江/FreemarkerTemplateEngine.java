package com.webtest.core;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class FreemarkerTemplateEngine {
	public String getTemplatePath() {
	 return "";
	}
	public String run(Map result) throws IOException, TemplateException {
		Configuration configuration = new Configuration();
		String dir = "D:\\demo\\auto2018\\auto2018\\ftl";
		configuration.setDirectoryForTemplateLoading(new File(dir));
		configuration.setEncoding(Locale.CHINA, "UTF-8");
		configuration.setObjectWrapper(new DefaultObjectWrapper());              
		configuration.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));   
		Template template = null;
		template = configuration.getTemplate("ftl/test.html");
        
		StringWriter out = new StringWriter();		
		template.process(result, out);
		System.out.println("结果：" + out);
		out.flush();
		out.close();
		return out.toString();
	}
 }