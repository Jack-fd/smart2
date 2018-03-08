package com.its.smart.web.controller.sys;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.Strings;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.RoleFunctionRel;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.web.service.sys.IRoleFunctionRelService;
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
public class RoleFunctionRelController {
    @Autowired
    private IRoleFunctionRelService roleFunctionRelService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<RoleFunctionRel>> list(@RequestBody ListFilter listFilter) {
        Wrapper<RoleFunctionRel> wrapper = QueryUtils.getWrapper(listFilter);
        return R.OK(roleFunctionRelService.selectList(wrapper));
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<RoleFunctionRel> page(@RequestBody PageSearch pageSearch) {
        Page<RoleFunctionRel> page = new Page<>(pageSearch.getPageNumber(), pageSearch.getPageSize());
        Wrapper<RoleFunctionRel> wrapper = QueryUtils.getWrapper(pageSearch);
        page = roleFunctionRelService.selectPage(page, wrapper);
        page.setTotal(roleFunctionRelService.selectCount(null));
        return R.OK(page);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<RoleFunctionRel> detail(@PathVariable("id") String id) {
        return R.OK(roleFunctionRelService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @RequestMapping(method = RequestMethod.POST)
    R<RoleFunctionRel> create(@RequestBody RoleFunctionRel roleFunctionRel) {
        if (Strings.isNullOrEmpty(roleFunctionRel.getId())) {
            roleFunctionRel.setIsSys(SmartConsts.DataSysType.USER);
        }
        RoleFunctionRel result = new RoleFunctionRel();
        if (roleFunctionRelService.insertOrUpdate(roleFunctionRel)) {
            result = roleFunctionRelService.selectById(roleFunctionRel.getId());
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
        return R.OK(roleFunctionRelService.deleteBatchIds(Arrays.asList(ids)));
    }
}

