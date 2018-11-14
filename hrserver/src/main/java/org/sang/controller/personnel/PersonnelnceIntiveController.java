package org.sang.controller.personnel;

import org.sang.bean.Employee;
import org.sang.bean.PersonnelIncentive;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 人事管理
 *
 * @author ZongXin
 * @create 2018-11-13 17:18
 */
@RestController
@RequestMapping("/personnel/basic")
public class PersonnelnceIntiveController {

    @RequestMapping(value = "/incentive", method = RequestMethod.GET)
    public Map<String, Object> getncentiveByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String keywords,
            Long politicId, Long nationId, Long posId,
            Long jobLevelId, String engageForm,
            Long departmentId, String beginDateScope) {
        List<PersonnelIncentive> personnelIncentiveByPage = new ArrayList<>();
        PersonnelIncentive pi = new PersonnelIncentive(1L,1L,"小明",0,20.00,new Date(),"厉害","就是厉害",0,null);
        personnelIncentiveByPage.add(pi);
        Map<String, Object> map = new HashMap<>();
        map.put("emps", personnelIncentiveByPage);
        map.put("count", 1);
        return map;
    }
}
