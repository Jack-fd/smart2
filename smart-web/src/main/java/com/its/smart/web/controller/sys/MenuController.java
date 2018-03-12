package com.its.smart.web.controller.sys;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.Menu;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.common.annotation.SysLog;
import com.its.smart.web.service.sys.IMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * <p>
 * 系统菜单表 前端控制器
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/api/admin/functions")
public class MenuController {

    @Autowired
    private IMenuService functionService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequiresPermissions("sys:menu:select")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<Menu>> list(@RequestBody ListFilter listFilter) {
        Wrapper<Menu> wrapper = QueryUtils.getWrapper(listFilter);
        return R.OK(functionService.selectList(wrapper));
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequiresPermissions("sys:menu:select")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<Menu> page(@RequestBody PageSearch pageSearch) {
        Page<Menu> page = new Page<>(pageSearch.getPageNumber(), pageSearch.getPageSize());
        Wrapper<Menu> wrapper = QueryUtils.getWrapper(pageSearch);
        page = functionService.selectPage(page, wrapper);
        page.setTotal(functionService.selectCount(null));
        return R.OK(page);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequiresPermissions("sys:menu:info")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<Menu> detail(@PathVariable("id") String id) {
        return R.OK(functionService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @SysLog("保存更新目录")
    @RequiresPermissions("sys:menu:save")
    @RequestMapping(method = RequestMethod.POST)
    R<Menu> create(@RequestBody Menu function) {
        function.setModifyTime(Calendar.getInstance().getTime());
        Menu result = new Menu();
        if (functionService.insertOrUpdate(function)) {
            result = functionService.selectById(function.getId());
        }
        return R.OK(result);
    }

    /**
     * 批量删除
     *
     * @param ids 　集合
     * @return 结果
     */
    @SysLog("删除字典")
    @RequiresPermissions("sys:menu:delete")
    @RequestMapping(method = RequestMethod.DELETE)
    R<String> delete(@RequestBody String[] ids) {
        return R.OK(functionService.deleteBatchIds(Arrays.asList(ids)));
    }
}

