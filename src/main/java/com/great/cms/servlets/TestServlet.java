package com.great.cms.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.great.cms.service.impl.CourseRegistrationServiceImpl;

public class TestServlet extends HttpServlet {
	@Autowired
	private CourseRegistrationServiceImpl courseRegistrationService;
	
//	private static final long serialVersionUID = 1L;
//	
//	public static Long totalRequestCounter = new Long(0);	
//	
//	private final Logger logger = LoggerFactory.getLogger(this.getClass().getPackage().getName());
//	
//	@Autowired	
//	private AgentRequestHelper agentRequestHelper;
	
	
            
    public TestServlet() {
    	
        super();       
    }

    @Override
	public void init(ServletConfig config) {
      
    	try {
		
    		super.init(config);
    	} 
    	catch (ServletException e) {
    		
    		e.printStackTrace();
    	}
    	
    	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);//processInjectionBasedOnServletContext(this,config.getServletContext());
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String studentId = request.getParameter("id");
//		
//		courseRegistrationService.getStudentRegistration(Integer.parseInt(studentId));
//		
		response.getWriter().write("Testing");				
		response.setStatus(200);
//		try {
//						
//			totalRequestCounter++;			
//			SmsUtils.logInTerminal("Request Count --> " + totalRequestCounter);			
//			SmsUtils.logInTerminal("Request SERVER:PORT --> " + request.getRemoteAddr() + ":" + request.getRemotePort() + ", " + SmsUtils.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss.SSS a"));
//
//			String command = request.getParameter("cmd");						
//			command = URLDecoder.decode(command, "ascii");
//			
//			if(null == command) {
//				
//				throw new ServletException("cmd cannot be null.");
//			}
//			
//			switch(AGENT_COMMAND.find(command)) {
//			
//				case COMMAND_SEND_SMS:
//					
//					agentRequestHelper.processSendSmsRequest(request, response);
//					break;
//					
//				case COMMAND_SMS_STATUS:
//					
//					agentRequestHelper.processSmsStatusRequest(request, response);
//					break;
//					
//				case COMMAND_SEND_FLEXI:
//					
//					agentRequestHelper.processSendFlexiRequest(request, response);
//					break;			
//				
//				case COMMAND_FLEXI_STATUS:
//					
//					agentRequestHelper.processFlexiStatusRequest(request, response);
//					break;
//					
//				case COMMAND_MODEM_RESPONSE_MSG:
//					
//					agentRequestHelper.processModemResponsePostRequest(request, response);
//					break;
//				
//				default:
//					
//					logger.warn("Reached CLI_ACTION default action, should not reach here.");
//					break;
//			}				
//		}
//		catch (Exception e) {
//			
//			e.printStackTrace();
//		}
	}
}
