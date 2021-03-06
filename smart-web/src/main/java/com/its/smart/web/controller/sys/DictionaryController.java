package com.its.smart.web.controller.sys;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.Strings;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.Dictionary;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.common.annotation.SysLog;
import com.its.smart.web.service.sys.IDictionaryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * <p>
 * 数据字典表 前端控制器
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/api/admin/dictionarys")
public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequiresPermissions("sys:dictionary:select")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<Dictionary>> list(@RequestBody ListFilter listFilter) {
        Wrapper<Dictionary> wrapper = QueryUtils.getWrapper(listFilter);
        return R.OK(dictionaryService.selectList(wrapper));
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequiresPermissions("sys:dictionary:select")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<Dictionary> page(@RequestBody PageSearch pageSearch) {
        Page<Dictionary> page = new Page<>(pageSearch.getPageNumber(), pageSearch.getPageSize());
        Wrapper<Dictionary> wrapper = QueryUtils.getWrapper(pageSearch);
        page = dictionaryService.selectPage(page, wrapper);
        page.setTotal(dictionaryService.selectCount(null));
        return R.OK(page);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequiresPermissions("sys:dictionary:info")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<Dictionary> detail(@PathVariable("id") String id) {
        return R.OK(dictionaryService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @SysLog("保存更新字典")
    @RequiresPermissions("sys:dictionary:save")
    @RequestMapping(method = RequestMethod.POST)
    R<Dictionary> create(@RequestBody Dictionary dictionary) {
        if (Strings.isNullOrEmpty(dictionary.getId())) {
            dictionary.setIsSys(SmartConsts.DataSysType.USER);
        }
        dictionary.setModifyTime(Calendar.getInstance().getTime());
        Dictionary result = new Dictionary();
        if (dictionaryService.insertOrUpdate(dictionary)) {
            result = dictionaryService.selectById(dictionary.getId());
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
    @RequiresPermissions("sys:dictionary:delete")
    @RequestMapping(method = RequestMethod.DELETE)
    R<String> delete(@RequestBody String[] ids) {
        return R.OK(dictionaryService.deleteBatchIds(Arrays.asList(ids)));
    }
}

