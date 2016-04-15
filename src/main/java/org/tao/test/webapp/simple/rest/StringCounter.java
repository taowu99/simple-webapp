package org.tao.test.webapp.simple.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

@RestController  
@EnableWebMvc
@RequestMapping("/countstr")  
public class StringCounter {//this is a restful service.  Using Spring MVC to implement the interface
	private final static Logger logger = Logger.getLogger(StringCounter.class);
	
	public final static List<String[]> targets = ImmutableList.of(new String[]{"aaa", "1"}, new String[]{"aba", "2"});
	
	@RequestMapping(value = "/ab",  headers="Accept=*/*", method = RequestMethod.GET, produces="application/json")	
	public @ResponseBody StringCounterResponse countAB(@RequestParam(value="data", required=true) String data) {
		//this is the rest method, for counting "aaa" and "aba"		
		logger.info("Parsing {"+data+"}");		
		
		StringBuffer res = new StringBuffer();
		StringBuffer tmp = new StringBuffer(data);
		
		for (int i=0; i< targets.size(); i++) {
			final String key = targets.get(i)[0];
			final String val = targets.get(i)[1];
			int idx = tmp.indexOf(key);
			if (idx>=0) {
				final String s = val;
				res.append(s);
				tmp.delete(idx, idx+(key.length()));
			}
		}
		
		StringCounterResponse response = new StringCounterResponse();
		response.setStatus(StringCounterResponse.STATUS.SUCCESS);
		response.setData(res.toString());
		return response;
	}
}
