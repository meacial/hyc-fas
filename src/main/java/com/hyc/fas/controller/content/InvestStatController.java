package com.hyc.fas.controller.content;

import com.hyc.fas.annonation.NeedAuthController;
import com.hyc.fas.common.HycFasConst;
import com.hyc.fas.common.HycFasDict;
import com.hyc.fas.common.StringUtils;
import com.hyc.fas.common.TimeUtil;
import com.hyc.fas.config.HycFasProperties;
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
    @Autowired
    private HycFasProperties hycFasProperties;

    @RequestMapping("/table")
    public String table(HttpServletRequest request, HttpServletResponse response, Model model) {

        model.addAttribute("pageSize",hycFasProperties.getPageSize());
        model.addAttribute("pageCnt",1);

        // 默认选择7天时间的数据
        String startTime = request.getParameter(HycFasDict.STARTTIME);
        String endTime = request.getParameter(HycFasDict.ENDTIME);

        int pageCnt = 1;
        int pageSize = hycFasProperties.getPageSize();
        if (null != request.getParameter("pageCnt")) {
            pageCnt =  Integer.parseInt(request.getParameter("pageCnt"));
        }
        if (pageCnt < 1) {
            pageCnt = 1;
        }

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
            investRecordDetails = investStatService.directUserAndInvDetail(getUserIdFromSession(request),startTime,endTime,pageSize,(pageCnt-1)*pageSize);
            if (null != investRecordDetails &&  investRecordDetails.size() < pageSize) {
                pageCnt = pageCnt - 1;
                if (pageCnt < 1) {
                    pageCnt = 1;
                }
                if (investRecordDetails.size() == 0) {
                    investRecordDetails = investStatService.directUserAndInvDetail(getUserIdFromSession(request),startTime,endTime,pageSize,(pageCnt-1)*pageSize);
                }
            }
        } else {
            // 间接投资数据
            investRecordDetails = investStatService.inDirectUserAndInvDetail(getUserIdFromSession(request),startTime,endTime,pageSize,(pageCnt-1)*pageSize);
            if (null != investRecordDetails &&  investRecordDetails.size() < pageSize) {
                pageCnt = pageCnt - 1;
                if (pageCnt < 1) {
                    pageCnt = 1;
                }
                if (investRecordDetails.size() == 0) {
                    investRecordDetails = investStatService.inDirectUserAndInvDetail(getUserIdFromSession(request),startTime,endTime,pageSize,(pageCnt-1)*pageSize);
                }
            }
        }
        if (null != investRecordDetails && false==investRecordDetails.isEmpty()) {
            model.addAttribute("investRecordDetails", investRecordDetails);
        }
        model.addAttribute("pageCnt",pageCnt);
        model.addAttribute("pageSize", hycFasProperties.getPageSize());
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
