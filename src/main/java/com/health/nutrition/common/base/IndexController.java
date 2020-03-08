package com.health.nutrition.common.base;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by 2018/1/6
 * @apiNote 定义公共的控制器
 * @author  段斌
 * @version 0.0.1-SNAPSHOT
 **/

@Log4j2
@ApiIgnore
@RestController
public class IndexController extends BaseController
{

    @RequestMapping("/unauthorized")
    public ResponseResult unauthorizedAction() {
        log.info("can not access this resource!");
        return new ResponseResult(500, "未经授权访问资源", "Unauthorized Access Resource (code: 401)");
    }

    @RequestMapping("/failure")
    public ResponseResult failure() {
        log.debug("run there failure");
        return new ResponseResult(500, "错误的请求, 请重试!", "REQUEST IS ERROR");
    }
}
