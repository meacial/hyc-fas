package com.hyc.fas.controller.content;

import com.hyc.fas.annonation.NeedAuthController;
import com.hyc.fas.common.HycFasConst;
import com.hyc.fas.common.HycFasDict;
import com.hyc.fas.controller.AbstractController;
import com.hyc.fas.entity.InvestRecordDetail;
import com.hyc.fas.service.HycUserDetailService;
import com.hyc.fas.service.InvestStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String startTime = request.getParameter(HycFasDict.STARTTIME);
        String endTime = request.getParameter(HycFasDict.ENDTIME);
        String investorType = request.getParameter(HycFasDict.INVESTORTYPE);
        if (false == (HycFasConst.INVESTORTYPE_DIRECT.equals(investorType) || HycFasConst.INVESTORTYPE_INDIRECT.equals(investorType))) {
            logger.warn("Illage args : [investorType={}]", investorType);
            return "table";
        }
        List<InvestRecordDetail> investRecordDetails = null;
        if (HycFasConst.INVESTORTYPE_DIRECT.equals(investorType)) {
            // 直接投资数据
            investRecordDetails = investStatService.directUserAndInvDetail(getUserIdFromSession(request));
            model.addAttribute("investRecordDetails", investRecordDetails);
        } else {
            // 间接投资数据
            investRecordDetails = investStatService.inDirectUserAndInvDetail(getUserIdFromSession(request));
        }
        if (null != investRecordDetails && false==investRecordDetails.isEmpty()) {
            model.addAttribute("investRecordDetails", investRecordDetails);
        }
        return "table";
    }


    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({"/main", "/"})
    public String main(HttpServletRequest request, HttpServletResponse response) {
        return "main";
    }
}
