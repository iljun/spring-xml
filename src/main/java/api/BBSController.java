package api;

import domain.bbs.BBS;
import domain.bbs.BBSService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 12
 * Time: 오후 3:06
 */
public class BBSController extends MultiActionController{

    private BBSService bbsService;

    public void setBbsService(BBSService bbsService){
        this.bbsService = bbsService;
    }

    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",bbsService.selectAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }

    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String method = request.getMethod();
        if(method.equals("GET")){
            return new ModelAndView("/create");
        }else{
            BBS createBBS = new BBS();
            Enumeration paramNames = request.getParameterNames();
            while(paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String[] tmp = request.getParameterValues(paramName);
                if("title".equals(paramName)){
                    createBBS.setTitle(tmp[0]);
                }else if("content".equals(paramName)){
                    createBBS.setContent(tmp[0]);
                }
            }
            bbsService.create(createBBS);
            return list(request,response);
        }
    }

    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String method = request.getMethod();
        if(method.equals("GET")){
            String[] param = request.getQueryString().split("=");
            ModelAndView mv = new ModelAndView();
            mv.addObject("item",bbsService.selectById(Long.parseLong(param[1])));
            mv.setViewName("/edit");
            return mv;
        }else{
            BBS editBBS = new BBS();
            Enumeration paraNames = request.getParameterNames();
            while(paraNames.hasMoreElements()){
                String paramName = (String)paraNames.nextElement();
                String[] tmp = request.getParameterValues(paramName);
                if("id".equals(paramName)){
                    editBBS.setId(Long.parseLong(tmp[0]));
                }else if("title".equals(paramName)){
                    editBBS.setTitle(tmp[0]);
                }else if("content".equals(paramName)){
                    editBBS.setContent(tmp[0]);
                }
                bbsService.update(editBBS);
            }
            return detail(request,response);
        }
    }

    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String[] queryString = request.getQueryString().split("=");
        System.out.println(request.getQueryString());
        bbsService.deleted(Long.parseLong(queryString[1]));

        return list(request,response);
    }

    public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String[] queryString = request.getQueryString().split("=");

        ModelAndView mv = new ModelAndView();
        mv.addObject("item",bbsService.selectById(Long.parseLong(queryString[1])));
        mv.setViewName("/detail");
        return mv;
    }
}
