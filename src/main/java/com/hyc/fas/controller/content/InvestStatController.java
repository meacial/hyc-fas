package com.hyc.fas.controller.content;

import com.hyc.fas.annonation.NeedAuthController;
import com.hyc.fas.common.HycFasConst;
import com.hyc.fas.common.HycFasDict;
import com.hyc.fas.controller.AbstractController;
import com.hyc.fas.entity.TgUserAndInvDeatil;
import com.hyc.fas.service.InvestStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({"/main", "/"})
    public String main(HttpServletRequest request, HttpServletResponse response,Model model) {

        String startTime = request.getParameter(HycFasDict.STARTTIME);
        String endTime = request.getParameter(HycFasDict.ENDTIME);
        String investorType = request.getParameter(HycFasDict.INVESTORTYPE);

        if (false == (HycFasConst.INVESTORTYPE_DIRECT.equals(investorType) || HycFasConst.INVESTORTYPE_INDIRECT.equals(investorType))) {
            logger.warn("Illage args : [investorType={}]", investorType);
            return "main";
        }

        TgUserAndInvDeatil tgUserAndInvDeatil = investStatService.userAndInvDetail(getUserIdFromSession(request));

        if (null != tgUserAndInvDeatil) {

            model.addAttribute("tgUserAndInvDeatil",tgUserAndInvDeatil);

            return "table";
        }

        return "main";
    }
}
