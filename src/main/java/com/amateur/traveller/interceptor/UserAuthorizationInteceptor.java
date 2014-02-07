package com.amateur.traveller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserAuthorizationInteceptor extends HandlerInterceptorAdapter {
	static Logger logger = Logger.getLogger(UserAuthorizationInteceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("Intercepted request: " + request.getRequestURL());
		return super.preHandle(request, response, handler);
	}

}
