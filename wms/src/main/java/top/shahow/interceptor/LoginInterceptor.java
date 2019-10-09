package top.shahow.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import top.shahow.entity.Borrower;
import top.shahow.entity.Staff;

@Component("loginInterceptor")
public class LoginInterceptor extends HandlerInterceptorAdapter{
	/**
     * 在请求处理之前进行调用（Controller方法调用之前）
     * 基于URL实现的拦截器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        System.err.println(path+"----"+path.matches(Const.NO_INTERCEPTOR_PATH));
        if (path.matches(Const.NO_INTERCEPTOR_PATH)) {
        	//不需要的拦截直接过
            return true;
        } else {
        	boolean flag = true;
            HttpSession session = request.getSession();
            Borrower borrower = (Borrower) session.getAttribute("borrower_login");
            Staff staff = (Staff) session.getAttribute("staff_login");
            if(borrower == null && staff == null ) {
            	flag = false;
            	request.getRequestDispatcher("/signin").forward(request, response);
            }
            return flag;
        }
    }
    
    private class Const{
    	public static final String NO_INTERCEPTOR_PATH =".*/((.css)|(.js)|(images)|(signin)|(login)|(signup)|(register)|(validName)).*";
    }
}
