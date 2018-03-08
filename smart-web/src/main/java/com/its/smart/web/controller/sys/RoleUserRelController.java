package com.its.smart.web.controller.sys;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.Strings;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.RoleUserRel;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.web.service.sys.IRoleUserRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 角色与用户 前端控制器
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/api/admin/roleuserrels")
public class RoleUserRelController {
    @Autowired
    private IRoleUserRelService roleUserRelService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<RoleUserRel>> list(@RequestBody ListFilter listFilter) {
        Wrapper<RoleUserRel> wrapper = QueryUtils.getWrapper(listFilter);
        return R.OK(roleUserRelService.selectList(wrapper));
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<RoleUserRel> page(@RequestBody PageSearch pageSearch) {
        Page<RoleUserRel> page = new Page<>(pageSearch.getPageNumber(), pageSearch.getPageSize());
        Wrapper<RoleUserRel> wrapper = QueryUtils.getWrapper(pageSearch);
        page = roleUserRelService.selectPage(page, wrapper);
        page.setTotal(roleUserRelService.selectCount(null));
        return R.OK(page);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<RoleUserRel> detail(@PathVariable("id") String id) {
        return R.OK(roleUserRelService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @RequestMapping(method = RequestMethod.POST)
    R<RoleUserRel> create(@RequestBody RoleUserRel roleUserRel) {
        if (Strings.isNullOrEmpty(roleUserRel.getId())) {
            roleUserRel.setIsSys(SmartConsts.DataSysType.USER);
        }
        RoleUserRel result = new RoleUserRel();
        if (roleUserRelService.insertOrUpdate(roleUserRel)) {
            result = roleUserRelService.selectById(roleUserRel.getId());
        }
        return R.OK(result);
    }

    /**
     * 批量删除
     *
     * @param ids 　集合
     * @return 结果
     */
    @RequestMapping(method = RequestMethod.DELETE)
    R<String> delete(@RequestBody String[] ids) {
        return R.OK(roleUserRelService.deleteBatchIds(Arrays.asList(ids)));
    }
}

