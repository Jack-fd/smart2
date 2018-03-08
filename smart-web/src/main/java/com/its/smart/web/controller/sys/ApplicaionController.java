package com.its.smart.web.controller.sys;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.Applicaion;
import com.its.smart.api.entity.sys.Business;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.web.service.sys.IApplicaionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * <p>
 * 系统应用管理 前端控制器
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/api/admin/applications")
public class ApplicaionController {

    @Autowired
    private IApplicaionService applicaionService;

    /**
     * 按条件查询
     *
     * @return 集合
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    R<List<Business>> list(@RequestBody ListFilter listFilter) {
        Wrapper<Applicaion> wrapper = QueryUtils.getWrapper(listFilter);
        return R.OK(applicaionService.selectList(wrapper));
    }

    /**
     * 分页查询
     *
     * @param pageSearch 　查询条件
     * @return 集合
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<Business> page(@RequestBody PageSearch pageSearch) {
        Page<Applicaion> page = new Page<>(pageSearch.getPageNumber(), pageSearch.getPageSize());
        Wrapper<Applicaion> wrapper = QueryUtils.getWrapper(pageSearch);
        page = applicaionService.selectPage(page, wrapper);
        page.setTotal(applicaionService.selectCount(null));
        return R.OK(page);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<Business> detail(@PathVariable("id") String id) {
        return R.OK(applicaionService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @RequestMapping(method = RequestMethod.POST)
    R<Business> create(@RequestBody Applicaion applicaion) {
        applicaion.setModifyTime(Calendar.getInstance().getTime());
        Applicaion result = new Applicaion();
        if (applicaionService.insertOrUpdate(applicaion)) {
            result = applicaionService.selectById(applicaion.getId());
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
        return R.OK(applicaionService.deleteBatchIds(Arrays.asList(ids)));
    }
}

