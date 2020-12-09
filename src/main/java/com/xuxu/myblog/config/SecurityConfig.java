package com.xuxu.myblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/*****
 *  登陆权限管理相关的配置类
 *  @author Monster Xu
 *  @date 2020/8/11
 *****/
@EnableWebSecurity  //开启Security模式
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 密码的编码方式
     * NoOpPasswordEncoder.getInstance(); 不推荐使用这个，这个是明文密码（不加密）
     * <p>
     * new BCryptPasswordEncoder(); 使用BCrypt对密码进行编码
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置资源的访问权限
        http.authorizeRequests()
                //.antMatchers("/admin/**").permitAll()
                .antMatchers("/admin/adminLogin").permitAll()
                .antMatchers("/admin/**").hasRole("admin")

            .and().csrf().disable()
                //登陆的页面
                .formLogin()  //允许表单登录
                //自定义登录页面，登录成功之后跳转到 "/success"
                .loginPage("/admin/adminLogin")    //登录页面
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/admin")  //登录成功之后跳转的页面

            .and()
                //退出登陆,退出成功之后回到主界面
                .logout().logoutUrl("/logout").logoutSuccessUrl("/admin/adminLogin");
    }

/*
    //用户登陆认证账户
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("xu").password(new BCryptPasswordEncoder().encode("123")).roles("ADMIN")
                .and()
                .withUser("dd").password(new BCryptPasswordEncoder().encode("dd2377")).roles("ADMIN");


    }

*/

}
