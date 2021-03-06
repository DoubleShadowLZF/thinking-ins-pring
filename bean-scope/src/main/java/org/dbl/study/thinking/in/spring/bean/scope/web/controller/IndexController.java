package org.dbl.study.thinking.in.spring.bean.scope.web.controller;

import org.dbl.study.thinking.in.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: IndexController <br>
 * Description: <br>
 * date: 2020/7/22 22:21<br>
 *
 * @author Double <br>
 * @since JDK 1.8
 */
@Controller
public class IndexController {

  @Autowired private User user;

  @GetMapping("/")
  public String index(Model model) {
    // userObject -> 渲染上下文
    // user 对象存在 ServletContext, 上下文名称： scopedTarget.user == 新生成 Bean 名称
    model.addAttribute("userObject", user);
    System.out.println("返回前台页面的 User Bean : " + user.hashCode());
    return "index";
  }
}
