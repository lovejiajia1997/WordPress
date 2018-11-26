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
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;


public class FreemarkerTemplateEngine {
	public String getTemplatePath() {
	 return "";
	}
	
	//将得到的测试用例写进模板
	public String run(Map result) throws IOException, TemplateException {
		//创建一个合适的Configration对象
		Configuration configuration = new Configuration();
		String dir = "D:\\demo\\auto2018\\auto2018\\ftl";
		configuration.setDirectoryForTemplateLoading(new File(dir));
		configuration.setEncoding(Locale.CHINA, "UTF-8");// 这个一定要设置，不然在生成的页面中不然会乱码
		configuration.setObjectWrapper(new DefaultObjectWrapper());              
		configuration.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));   
		//获取或创建一个模板
		Template template = null;
		template = configuration.getTemplate("ftl/test.html");
		// 输出
//		Writer out = null;
//		out = new FileWriter(new File(dir + "test.ftl"));
        
		StringWriter out = new StringWriter();		
		// 合并数据模型和模板，并将结果输出到out中
		template.process(result, out);
		System.out.println("结果：" + out);
		// 关闭流
		out.flush();
		out.close();
		return out.toString();
	}
	
	
//private Configuration cfg;    //模板配置对象
// public void init() throws Exception {
//	//初始化FreeMarker配置
//	//创建一个Configuration实例
//	cfg=new Configuration();
//	//设置FreeMarker的模板文件夹位置
//	cfg.setDirectoryForTemplateLoading(new File("D:\\demo\\auto2018\\src"));
// }
// public void process() throws Exception{
//	 Map map = new HashMap();
//	 map.put("user","lavasoft");
//	 map.put("url","http://www.baidu.com/");
//     map.put("name","百度");
//	 //创建模版对象 
//	 Template t = cfg.getTemplate("test.ftl");
//	 //在模板上执行插值操作，并输出制定的输出流中
//	 t.process(map, new OutputStreamWriter(System.out));
//
// }
// public static void main(String[] args) throws Exception {
//	 FreemarkerTemplateEngine hf=new FreemarkerTemplateEngine();
//	  hf.init();
//	  hf.process();
// }
 }