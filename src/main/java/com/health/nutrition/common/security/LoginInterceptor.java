package com.health.nutrition.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.health.nutrition.common.util.TokenUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Log4j2
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static ObjectMapper objectMapper = new ObjectMapper();
    /**
     * 预处理回调方法，实现处理器的预处理（如登录检查）。
     * 第三个参数为响应的处理器，即controller。
     * 返回true，表示继续流程，调用下一个拦截器或者处理器。
     * 返回false，表示流程中断，通过response产生响应。
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*朱然威 注释掉权限拦截
        //Collections.list(request.getHeaders("st-ticket")).forEach(s -> log.info("st-ticket = "+s));
        String st = request.getHeader("st-ticket");
        log.info("st = "+st);
        if (st==null || "".equals(st)) { //无权限调用资源
            request.getRequestDispatcher("/unauthorized").forward(request, response);
            return false;
        }
        String redis_st = stringRedisTemplate.opsForValue().get(st);
        log.info("redis_st = "+redis_st);
        if(redis_st!=null) return true; //如果st存在于redis，证明是已经验证过的st，直接授权访问资源

        JSONObject json = new JSONObject();
        json.put("ticket", st);
        String result = SSOWebServiceProxy.getSSOProxyBean().validate(json.toJSONString());
        Map<String, Object> map = objectMapper.readValue(result, Map.class);
        if (map!=null && "0".equals(String.valueOf(map.get("flag")))) {
            stringRedisTemplate.opsForValue().set(st, st); //存入redis
            return true;
        } else {
            //无权限调用资源
            request.getRequestDispatcher("/unauthorized").forward(request, response);
            return false;
        }

        if(result!=null && beeModuleService.checkFetchSampleDataSecurity(request)){
        */

        Map result = TokenUtil.verify(request);
        if (result != null) {
            request.setAttribute("customerInfo", result);
            return true;
        } else {
            //   request.getRequestDispatcher("/../unauthorized").forward(request, response);
            request.getServletContext().getRequestDispatcher("/unauthorized").forward(request, response);
            return false;
        }

    }

    /**
     * 当前请求进行处理之后，也就是Controller 方法调用之后执行，
     * 但是它会在DispatcherServlet 进行视图返回渲染之前被调用。
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
     * 这个方法的主要作用是用于进行资源清理工作的。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }

}

