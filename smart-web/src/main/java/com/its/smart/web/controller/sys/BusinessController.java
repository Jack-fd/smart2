package com.its.smart.web.controller.sys;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.its.smart.api.dto.ListFilter;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.Business;
import com.its.smart.common.utils.QueryUtils;
import com.its.smart.web.service.sys.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    R<Business> page(@RequestBody PageSearch pageSearch) {
        return R.OK(pageSearch);
    }

    /**
     * 按编号查询
     *
     * @return 实体
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    R<Business> detail(@PathVariable("id") String id) {
        return R.OK(businessService.selectById(id));
    }

    /**
     * 添加修改实体
     *
     * @return 结果
     */
    @RequestMapping(method = RequestMethod.POST)
    R<Business> create(@RequestBody Business business) {
        Business result = new Business();
        if (businessService.insert(business)) {
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
    @RequestMapping(method = RequestMethod.DELETE)
    R<String> delete(@RequestBody String[] ids) {
        return R.OK(ids);
    }
}
