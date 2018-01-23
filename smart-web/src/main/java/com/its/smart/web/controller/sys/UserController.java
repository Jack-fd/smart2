package com.its.smart.web.controller.sys;

import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.User;
import com.its.smart.web.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户信息REST接口
 *
 * @author MQ
 */
@RestController
@RequestMapping("/api/admin/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<User>> list(@RequestBody ListFilter listFilter) {
        return R.OK(listFilter);
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<User> page(@RequestBody PageSearch pageSearch) {
        return R.OK(pageSearch);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<User> detail(@PathVariable("id") String id) {
        return R.OK(userService.queryObject(id));
//    return R.OK("234234");
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @RequestMapping(method = RequestMethod.POST)
    R<User> create(@RequestBody User user) {
        return R.OK(user);
    }

    /**
     * 批量删除
     *
     * @param ids 　集合
     * @return 结果
     */
    @RequestMapping(method = RequestMethod.DELETE)
    R<String> delete(@RequestBody String[] ids) {
        return R.OK(ids);
    }
}
