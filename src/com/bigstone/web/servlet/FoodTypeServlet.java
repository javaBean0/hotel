package com.bigstone.web.servlet;

import com.bigstone.domain.FoodType;
import com.bigstone.factory.BeanFactory;
import com.bigstone.service.IFoodTypeService;
import com.bigstone.service.impl.FoodTypeServiceImpl;
import com.bigstone.utils.commons.CommonUtils;
import com.bigstone.utils.commons.PageBean;
import com.bigstone.utils.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/23
 * Time:9:59
 */
public class FoodTypeServlet extends BaseServlet {

   private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService", FoodTypeServiceImpl.class);
   /**
     * 菜系的列表展示
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public String list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String keyword = req.getParameter("keyword");
        int pagenum = Integer.parseInt(req.getParameter("pagenum"));
        //查询数据库数据
        PageBean pageBean = foodTypeService.getAll(keyword, pagenum);
        //保存数据到request域中
        req.setAttribute("pageBean", pageBean);
        //转发到页面
        return "f:/sys/type/foodtype_list.jsp";
    }

    /**
     * 添加菜系
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foodTypeName = req.getParameter("foodTypeName");
        FoodType foodType = new FoodType();
        foodType.setTypeName(foodTypeName);
        foodTypeService.save(foodType);
        return list(req, resp);
    }

    /**
     * 删除菜系
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取页面传递的ID
            int id = Integer.parseInt(req.getParameter("id"));
            //删除数据
            foodTypeService.delete(id);
            return list(req ,resp);
        } catch (NumberFormatException e) {
            return "r:/error/error.jsp";
        }
    }

    public String updateUI(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        FoodType foodType = foodTypeService.getById(id);
        req.setAttribute("foodType", foodType);
        return "f:/sys/type/foodtype_update.jsp";
    }


    public String update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FoodType foodType = CommonUtils.toBean(req.getParameterMap(), FoodType.class);
        foodTypeService.update(foodType);
        return list(req, resp);
    }

    public String search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String typeName = req.getParameter("keyword");
        List<FoodType> foodTypeList = foodTypeService.getByName(typeName);
        //保存查询数据
        req.setAttribute("foodTypeList", foodTypeList);
        //保存回显数据
        req.setAttribute("keyword", typeName);
        return "f:/sys/type/foodtype_list.jsp";
    }


}
