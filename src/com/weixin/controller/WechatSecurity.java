package com.weixin.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.weixin.util.MessageUtil;
import com.weixin.util.SignUtil;
import com.weixin.wechat.dispatcher.EventDispatcher;
import com.weixin.wechat.dispatcher.MsgDispatcher;

@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
	private static Logger logger = Logger.getLogger(WechatSecurity.class);

	/**
	 * ����ͨ����֤ǩ����΢�ŷ��������Լ��ķ�����֮�佨������,�״ν�����֤ʱ�Ż��յ�echostr����
	 * 
	 * @Description: ���ڽ��� get ������������֤����
	 * @param @param request
	 * @param @param response
	 * @param @param signature
	 * @param @param timestamp
	 * @param @param nonce
	 * @param @param echostr
	 * @author dapengniao
	 * @date 2016 �� 3 �� 4 �� ���� 6:20:00
	 */
	@RequestMapping(value = "security", method = RequestMethod.GET)
	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "signature", required = true) String signature,
			@RequestParam(value = "timestamp", required = true) String timestamp,
			@RequestParam(value = "nonce", required = true) String nonce,
			@RequestParam(value = "echostr", required = true) String echostr) {
		try {
			System.out.println("get");
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				PrintWriter out = response.getWriter();
				out.print(echostr);//ǩ����ȷ���ɹ�����
				out.close();
			} else {
				logger.info("������ڷǷ�����");
			}
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
    
	
	/**
	 * 	 post �������ڽ���΢�ŷ������Ϣ,�ı���ͼƬ��url��
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "security", method = RequestMethod.POST)
	public void DoPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("���� post ������");
		String result = "";
		try {
			//�� request ��ȡ��������   
	        InputStream inputStream = request.getInputStream(); 
			Map<String, String> map = MessageUtil.parseXml(inputStream);
			String msgtype = map.get("MsgType");
			if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)) {
				result = EventDispatcher.processEvent(map); // �����¼�����
			} else {
				result = MsgDispatcher.processMessage(map); // ������Ϣ����
			}
			//����ظ�
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
			out = null;
		} catch (Exception e) {
			logger.error(e, e);
		}
	}
}