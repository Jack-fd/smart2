package com.its.smart.web.controller.sys;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.Strings;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.Role;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.common.annotation.SysLog;
import com.its.smart.web.service.sys.IRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * <p>
 * 系统角色表 前端控制器
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/api/admin/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequiresPermissions("sys:role:select")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<Role>> list(@RequestBody ListFilter listFilter) {
        Wrapper<Role> wrapper = QueryUtils.getWrapper(listFilter);
        return R.OK(roleService.selectList(wrapper));
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequiresPermissions("sys:role:select")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<Role> page(@RequestBody PageSearch pageSearch) {
        Page<Role> page = new Page<>(pageSearch.getPageNumber(), pageSearch.getPageSize());
        Wrapper<Role> wrapper = QueryUtils.getWrapper(pageSearch);
        page = roleService.selectPage(page, wrapper);
        page.setTotal(roleService.selectCount(null));
        return R.OK(page);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequiresPermissions("sys:role:info")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<Role> detail(@PathVariable("id") String id) {
        return R.OK(roleService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @SysLog("保存更新角色")
    @RequiresPermissions("sys:role:save")
    @RequestMapping(method = RequestMethod.POST)
    R<Role> create(@RequestBody Role role) {
        if (Strings.isNullOrEmpty(role.getId())) {
            role.setIsSys(SmartConsts.DataSysType.USER);
        }
        role.setModifyTime(Calendar.getInstance().getTime());
        Role result = new Role();
        if (roleService.insertOrUpdate(role)) {
            result = roleService.selectById(role.getId());
        }
        return R.OK(result);
    }

    /**
     * 批量删除
     *
     * @param ids 　集合
     * @return 结果
     */
    @SysLog("删除角色")
    @RequiresPermissions("sys:role:delete")
    @RequestMapping(method = RequestMethod.DELETE)
    R<String> delete(@RequestBody String[] ids) {
        return R.OK(roleService.deleteBatchIds(Arrays.asList(ids)));
    }
}

