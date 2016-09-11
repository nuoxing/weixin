package com.weixin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterEncodingFilter implements Filter {

	String encoding = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("filter");
		if(encoding==null||encoding.equals("utf-8")){
			encoding = "utf-8";
		}
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) req){

			@Override
			public String getParameter(String name) {
				if("get".equals(this.getMethod().toLowerCase())){
					String value = super.getParameter(name);
					try{
						return new String(value.getBytes("iso-8859-1"),encoding);
					}catch (Exception e) {
						// TODO: handle exception
					}
					return value;
				}
				return super.getParameter(name);
			}
			
		},resp);

	}

	@Override
	public void init(FilterConfig fiterconfig) throws ServletException {
		// TODO Auto-generated method stub
         encoding = fiterconfig.getInitParameter("encoding");
	}

}
