package com.sy.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sy.utils.JWTUtils;

import javax.servlet.http.HttpServletRequest;

public class PreFilter extends ZuulFilter
{

    @Override
    public String filterType() {
        // 过滤器类型，可选值有 pre、route、post、error。
        return "pre";
    }

    @Override
    public int filterOrder() {
        //  过滤器的执行顺序，数值越小，优先级越高。
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        //  是否执行该过滤器，true 为执行，false 为不执行，这个也可以利用配置中心来实现，达到动态的开启和关闭过滤器。
        //  RequestContext.getCurrentContext();获取请求的上下文信息对象
        //  再使用.getRequest()获取 HttpServletRequest 对象
        //  再通过.getRequestURI() 方法可获取到请求路径
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.println("============================================"+request.getRequestURI());
        if("/client/Accountclient/userAccount".equals(request.getRequestURI()))
        {
            return false;
        }
        else if ("/client/Accountclient/adminAccount".equals(request.getRequestURI()))
        {
            return false;
        }else if ("/client/Userclient/save".equals(request.getRequestURI()))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public Object run() throws ZuulException
    {
        //  RequestContext.getCurrentContext();获取请求的上下文信息对象
        //  再使用.getRequest()获取 HttpServletRequest 对象
        //  再通过.getRequestURI() 方法可获取到请求路径
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //获取请求头中的token对象
        String token = request.getHeader("Authorization");

        System.out.println("=========================================="+token);
        if(JWTUtils.verify(token)==null)
        {

            //  如果未通过验证，则终止该请求进行路由,并设置返回状态码为401
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);

        }
        else
        {
            DecodedJWT decodedJWT = JWTUtils.verify(token);
            System.out.println("============================"+decodedJWT.getExpiresAt());
            //  如果通过验证，则对该请求进行路由,并设置返回状态码为200
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(200);
        }
        return null;
    }
}
