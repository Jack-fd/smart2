package com.its.smart.web.controller.sys;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.google.common.base.Strings;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.User;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.web.service.sys.IUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * <p>
 * 系统用户信息 前端控制器
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/api/admin/users")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequiresPermissions("sys:user:select")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<User>> list(@RequestBody ListFilter listFilter) {
        Wrapper<User> wrapper = QueryUtils.getWrapper(listFilter);
        return R.OK(userService.selectList(wrapper));
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequiresPermissions("sys:user:select")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<User> page(@RequestBody PageSearch pageSearch) {
        Page<User> page = new Page<>(pageSearch.getPageNumber(), pageSearch.getPageSize());
        Wrapper<User> wrapper = QueryUtils.getWrapper(pageSearch);
        page = userService.selectPage(page, wrapper);
        page.setTotal(userService.selectCount(null));
        return R.OK(page);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequiresPermissions("sys:user:info")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<User> detail(@PathVariable("id") String id) {
        return R.OK(userService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @RequiresPermissions("sys:user:save")
    @RequestMapping(method = RequestMethod.POST)
    R<User> create(@RequestBody User user) {
        if (Strings.isNullOrEmpty(user.getId())) {
            user.setName(PinyinHelper.getShortPinyin(user.getDisplayName()));
            user.setSalt(RandomStringUtils.randomAlphanumeric(20));
            user.setIsSys(SmartConsts.DataSysType.USER);
        }
        user.setModifyTime(Calendar.getInstance().getTime());
        User result = new User();
        if (userService.insertOrUpdate(user)) {
            result = userService.selectById(user.getId());
        }
        return R.OK(result);
    }

    /**
     * 批量删除
     *
     * @param ids 　集合
     * @return 结果
     */
    @RequiresPermissions("sys:user:delete")
    @RequestMapping(method = RequestMethod.DELETE)
    R<String> delete(@RequestBody String[] ids) {
        return R.OK(userService.deleteBatchIds(Arrays.asList(ids)));
    }
}

