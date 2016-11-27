package com.hyc.fas.controller.content;

import com.hyc.fas.annonation.NeedAuthController;
import com.hyc.fas.common.HycFasConst;
import com.hyc.fas.common.HycFasDict;
import com.hyc.fas.common.StringUtils;
import com.hyc.fas.common.TimeUtil;
import com.hyc.fas.controller.AbstractController;
import com.hyc.fas.entity.InvestRecordDetail;
import com.hyc.fas.service.HycUserDetailService;
import com.hyc.fas.service.InvestStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.List;

/**
 * 投资统计
 *
 * @author <a href="mailto:meacial@live.cn">Gangping Li</a>
 * @version 1.0, 2016/11/22 16:36
 */
@NeedAuthController
@RequestMapping("/auth")
public class InvestStatController extends AbstractController {

    @Autowired
    private InvestStatService investStatService;
    @Autowired
    private HycUserDetailService hycUserDetailService;

    @RequestMapping("/table")
    public String table(HttpServletRequest request, HttpServletResponse response, Model model) {

        // 默认选择7天时间的数据
        String startTime = request.getParameter(HycFasDict.STARTTIME);
        String endTime = request.getParameter(HycFasDict.ENDTIME);

        if (StringUtils.isEmpty(startTime)) {
            startTime = null;
        } else {
            startTime = TimeUtil.strdataftm(startTime);
        }
        if (StringUtils.isEmpty(endTime)) {
            endTime = null;
        } else {
            endTime = TimeUtil.strdataftm(endTime);
        }

        String investorType = request.getParameter(HycFasDict.INVESTORTYPE);
        if (false == (HycFasConst.INVESTORTYPE_DIRECT.equals(investorType) || HycFasConst.INVESTORTYPE_INDIRECT.equals(investorType))) {
            logger.warn("Illage args : [investorType={}]", investorType);
            return "table";
        }
        List<InvestRecordDetail> investRecordDetails = null;
        if (HycFasConst.INVESTORTYPE_DIRECT.equals(investorType)) {
            // 直接投资数据
            investRecordDetails = investStatService.directUserAndInvDetail(getUserIdFromSession(request),startTime,endTime);
            model.addAttribute("investRecordDetails", investRecordDetails);
        } else {
            // 间接投资数据
            investRecordDetails = investStatService.inDirectUserAndInvDetail(getUserIdFromSession(request),startTime,endTime);
        }
        if (null != investRecordDetails && false==investRecordDetails.isEmpty()) {
            model.addAttribute("investRecordDetails", investRecordDetails);
        }

        model.addAttribute(HycFasDict.STARTTIME, TimeUtil.str2Date(startTime));
        model.addAttribute(HycFasDict.ENDTIME,TimeUtil.str2Date(endTime));
        return "table";
    }


    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({"/main", "/"})
    public String main(HttpServletRequest request, HttpServletResponse response,Model model) {
        Calendar calendar = Calendar.getInstance();
        model.addAttribute("endTime",calendar.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        model.addAttribute("startTime",calendar.getTime());
        return "main";
    }
}
