package org.tao.test.webapp.simple.rest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController  
@EnableWebMvc
@RequestMapping("/countstr")  
public class StringCounter {
	final static Logger logger = Logger.getLogger(StringCounter.class);
	
	@RequestMapping(value = "/ab",  headers="Accept=*/*", method = RequestMethod.GET, produces="application/json")	
	public @ResponseBody StringCounterResponse countAB(@RequestParam(value="data", required=true) String data) {
		logger.info("Parsing {"+data+"}");
		StringBuffer res = new StringBuffer();
		StringBuffer tmp = new StringBuffer(data);
		int idx = tmp.indexOf("aaa");
		if (idx>=0) {
			res.append("1");
			tmp.delete(idx, idx+3);
		}
		idx = tmp.indexOf("aba");
		if (idx>=0)
			res.append("2");
		StringCounterResponse response = new StringCounterResponse();
		response.setStatus(StringCounterResponse.STATUS.SUCCESS);
		response.setData(res.toString());
		return response;
	}
}
