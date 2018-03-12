package com.its.smart.web.controller.sys;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.Strings;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.RoleMenuRel;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.common.annotation.SysLog;
import com.its.smart.web.service.sys.IRoleMenuRelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 系统角色与菜单 前端控制器
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/api/admin/rolefunctionrels")
public class RoleMenuRelController {

    @Autowired
    private IRoleMenuRelService roleFunctionRelService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequiresPermissions("sys:role:select")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<RoleMenuRel>> list(@RequestBody ListFilter listFilter) {
        Wrapper<RoleMenuRel> wrapper = QueryUtils.getWrapper(listFilter);
        return R.OK(roleFunctionRelService.selectList(wrapper));
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequiresPermissions("sys:role:select")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<RoleMenuRel> page(@RequestBody PageSearch pageSearch) {
        Page<RoleMenuRel> page = new Page<>(pageSearch.getPageNumber(), pageSearch.getPageSize());
        Wrapper<RoleMenuRel> wrapper = QueryUtils.getWrapper(pageSearch);
        page = roleFunctionRelService.selectPage(page, wrapper);
        page.setTotal(roleFunctionRelService.selectCount(null));
        return R.OK(page);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequiresPermissions("sys:role:info")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<RoleMenuRel> detail(@PathVariable("id") String id) {
        return R.OK(roleFunctionRelService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @SysLog("保存更新角色与菜单关系")
    @RequiresPermissions("sys:role:save")
    @RequestMapping(method = RequestMethod.POST)
    R<RoleMenuRel> create(@RequestBody RoleMenuRel roleMenuRel) {
        if (Strings.isNullOrEmpty(roleMenuRel.getId())) {
            roleMenuRel.setIsSys(SmartConsts.DataSysType.USER);
        }
        RoleMenuRel result = new RoleMenuRel();
        if (roleFunctionRelService.insertOrUpdate(roleMenuRel)) {
            result = roleFunctionRelService.selectById(roleMenuRel.getId());
        }
        return R.OK(result);
    }

    /**
     * 批量删除
     *
     * @param ids 　集合
     * @return 结果
     */
    @SysLog("删除角色与菜单关系")
    @RequiresPermissions("sys:role:delete")
    @RequestMapping(method = RequestMethod.DELETE)
    R<String> delete(@RequestBody String[] ids) {
        return R.OK(roleFunctionRelService.deleteBatchIds(Arrays.asList(ids)));
    }
}

