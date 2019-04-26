package com.bigstone.web.servlet;

import com.bigstone.domain.DinnerTable;
import com.bigstone.factory.BeanFactory;
import com.bigstone.service.DinnerTableService;
import com.bigstone.service.impl.DinnerTableServiceImpl;
import com.bigstone.utils.commons.CommonUtils;
import com.bigstone.utils.servlet.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 餐桌管理Servlet
 * Created with IDEA
 * author:bigStone
 * Date:2019/4/25
 **/
public class DinnerTableServlet extends BaseServlet {

    private DinnerTableService dinnerTableService = BeanFactory.getInstance(
            "dinnerTableService", DinnerTableServiceImpl.class);

    public String save(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        DinnerTable dinnerTable = CommonUtils.toBean(req.getParameterMap(), DinnerTable.class);
        dinnerTableService.save(dinnerTable);
        return list(req, resp);
    }

    public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dinnerTableService.delete(id);
        return list(req, resp);

    }

    public String list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<DinnerTable> dinnerTableList = dinnerTableService.getAll();
        req.setAttribute("dinnerTableList", dinnerTableList);
        return "f:/sys/dinnertable_list.jsp";
    }
    
    public String search(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String tableName = req.getParameter("keyword");
        List<DinnerTable> dinnerTableList =  dinnerTableService.findByName(tableName);
        req.setAttribute("dinnerTableList", dinnerTableList);
        req.setAttribute("keyword", tableName);
        return "f:/sys/dinnertable_list.jsp";
    }

    public String cancel(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        dinnerTableService.cancel(id);
        return list(req, resp);
    }

    
    
}
