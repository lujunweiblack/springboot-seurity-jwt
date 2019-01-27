package com.example.seurity.ctrl;

import com.example.seurity.model.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.example.seurity.model.ResultBean.SUCCESS;

/**
 * @author: lujunwei
 * @time: 15:14 2019/1/18
 * @des:
 */
@RestController
@RequestMapping("/user")
public class UserCtrl {

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index() {
        return ResultBean.resultInit(SUCCESS, "/");
    }

    @RequestMapping(path = "/getUserInfo", method = RequestMethod.GET)
    public String methGetUserInfo() {
        return ResultBean.resultInit(SUCCESS, "getUserInfo");
    }

    @RequestMapping(path = "/getDetails", method = RequestMethod.GET)
    public String methgetDetails() {
        return ResultBean.resultInit(SUCCESS, "getDetails");
    }

}
