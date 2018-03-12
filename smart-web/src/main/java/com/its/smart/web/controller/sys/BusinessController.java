package com.its.smart.web.controller.sys;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.google.common.base.Strings;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.Business;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.common.annotation.SysLog;
import com.its.smart.web.service.sys.IBusinessService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * 企业信息REST接口
 *
 * @author MQ
 */
@RestController
@RequestMapping("/api/admin/businesss")
public class BusinessController {

    @Autowired
    private IBusinessService businessService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequiresPermissions("sys:business:select")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<Business>> list(@RequestBody ListFilter listFilter) {
        Wrapper<Business> wrapper = QueryUtils.getWrapper(listFilter);
        return R.OK(businessService.selectList(wrapper));
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequiresPermissions("sys:business:select")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<Business> page(@RequestBody PageSearch pageSearch) {
        Page<Business> page = new Page<>(pageSearch.getPageNumber(), pageSearch.getPageSize());
        Wrapper<Business> wrapper = QueryUtils.getWrapper(pageSearch);
        page = businessService.selectPage(page, wrapper);
        page.setTotal(businessService.selectCount(null));
        return R.OK(page);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequiresPermissions("sys:business:info")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<Business> detail(@PathVariable("id") String id) {
        return R.OK(businessService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @SysLog("保存更新企业")
    @RequiresPermissions("sys:business:save")
    @RequestMapping(method = RequestMethod.POST)
    R<Business> create(@RequestBody Business business) {
        if (Strings.isNullOrEmpty(business.getId())) {
            business.setName(PinyinHelper.getShortPinyin(business.getDisplayName()));
            business.setIsSys(SmartConsts.DataSysType.USER);
        }
        business.setModifyTime(Calendar.getInstance().getTime());
        Business result = new Business();
        if (businessService.insertOrUpdate(business)) {
            result = businessService.selectById(business.getId());
        }
        return R.OK(result);
    }

    /**
     * 批量删除
     *
     * @param ids 　集合
     * @return 结果
     */
    @SysLog("删除企业")
    @RequiresPermissions("sys:business:delete")
    @RequestMapping(method = RequestMethod.DELETE)
    R<String> delete(@RequestBody String[] ids) {
        return R.OK(businessService.deleteBatchIds(Arrays.asList(ids)));
    }
}
