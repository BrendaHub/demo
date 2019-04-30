package com.example.demo.filter;

/**
 * @author Sam
 * @date 2019/4/30 15:31
 */

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 配置监控拦截器, druid监控拦截器
 * @ClassName: DruidStatFilter
 * @author garyond
 * @date 2018年4月24日
 */
@WebFilter(filterName="druidWebStatFilter",
        urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源
        })
public class DruidStatFilter extends WebStatFilter {

}
