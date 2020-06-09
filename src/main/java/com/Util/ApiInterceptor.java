package com.Util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




/**
 * api 拦截器
 * @author Wangshaocheng
 *
 */
public class ApiInterceptor extends HandlerInterceptorAdapter {

//	private static Logger logger = LoggerFactory.getLogger(ApiInterceptor.class);
//	// 10分钟有效请求时间
//	private static final long REQUEST_TIMEOUT_EXPIRE = 10 * 60 * 1000;
//	private static final String UTF8 = "utf-8";
//	private static final String CONTENT_TYPE = "application/json";
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		return true;
//		// 签名比较
//		String sign = request.getParameter("sign");
//	    if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
//	    	AuthCheck authCheck = ((HandlerMethod) handler).getMethodAnnotation(AuthCheck.class);
//            //没有声明需要权限,或者声明不验证权限
//            if(authCheck == null || authCheck.validate() == false){
//            	return true;
//            }else{
//            	String timestamp = request.getParameter("timestamp");
//            	// 时间戳参数检查
//        		if (StringUtils.isBlank(timestamp)) {
//        			logger.error("签名参数timestamp'{}'为空 requestInfo:{}", timestamp, request.getServletPath());
//        			responseJson(response, "{\"flag\":false,\""+Constants.STATUS+"\":"+CodeConstants.CONNCODECHECK+",\"msg\":\"非法请求,服务器已拒绝!\"}");
//        			return false;
//        		}
//        		// 请求失效检查
//        		long clientTimestamp = new Long(timestamp);
//        		if (!(Math.abs(System.currentTimeMillis() - clientTimestamp) < REQUEST_TIMEOUT_EXPIRE)) {
//        			logger.error("请求已过期 clientTimestampStr:{} requestInfo:{}", timestamp, request.getServletPath());
//        			responseJson(response, "{\"flag\":false,\""+Constants.STATUS+"\":"+CodeConstants.CONNCODECHECK+",\"msg\":\"非法请求,服务器已拒绝!\"}");
//        			return false;
//        		}
//
//        		// 服务端签名
//        		String serverSign;
//        	    // 服务端签名参数
//        	 	Map<String, Object> paramMap = new HashMap<String, Object>();
//        	    Map<String, String[]> parameterMap = request.getParameterMap();
//        		for (String key : parameterMap.keySet()) {
//        			paramMap.put(key, getParamValue(parameterMap.get(key)));
//        		}
//        		serverSign = SignUtil.getSign(paramMap);
//                //在这里实现自己的权限验证逻辑
//            	if (StringUtils.isBlank(serverSign) || !serverSign.equals(sign)) {//如果验证失败
//        			logger.error("签名不一致 serverSign:{}    clientSign:{}    requestInfo:{}", new Object[] { serverSign, sign, request.getServletPath() });
//        			responseJson(response, "{\"flag\":false,\""+Constants.STATUS+"\":"+CodeConstants.CONNCODECHECK+",\"msg\":\"非法请求,服务器已拒绝!\"}");
//        			return false;
//        		}else{ //校验成功
//                    return true;
//                }
//            }
//        }
//        else
//            return true;
//     }
//
//	/**
//	 * 获取请求中的所有参数
//	 * @param paramValues
//	 * @return
//	 */
//	private String getParamValue(String[] paramValues) {
//		if (paramValues == null) {
//			return StringUtils.EMPTY;
//		}
//		String paramValue = null;
//		if (paramValues.length == 1) {
//			paramValue = paramValues[0];
//		} else if (paramValues.length > 1) {
//			paramValue = StringUtils.join(paramValues, ",");
//		}
//		return StringUtils.defaultString(paramValue);
//	}
//
//	public static void responseJson(HttpServletResponse response, String responseContent) throws IOException {
//		if (response.isCommitted()) {
//			logger.info("response.isCommitted()! responseContent:{"+responseContent+"}");
//			return;
//		}
//		response.setCharacterEncoding(UTF8);
//		response.setContentType(CONTENT_TYPE);
//		PrintWriter printWriter = response.getWriter();
//		printWriter.print(responseContent);
//		printWriter.flush();
//		printWriter.close();
//	}
	
}
