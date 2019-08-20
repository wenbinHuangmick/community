package com.gem.interceptor;

import com.gem.mapper.UserMapper;
import com.gem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Mick
 * @Date: 2019/8/20 22:44
 * @Description:
 */
@Service
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;
    //在控制器执行前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        Cookie[] cookies = request.getCookies();
        if (cookies !=null && cookies.length !=0)
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("token")){
                    String token=cookie.getValue();
                    User user=userMapper.findByToken(token);
                    if (user !=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }

        return true;
    }

    //在后端控制器执行后调用
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {

    }
    //整个请求执行完成后调用
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }


}
