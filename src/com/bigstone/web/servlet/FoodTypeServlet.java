package com.bigstone.web.servlet;

import com.bigstone.domain.FoodType;
import com.bigstone.factory.BeanFactory;
import com.bigstone.service.IFoodTypeService;
import com.bigstone.service.impl.FoodTypeServiceImpl;
import com.bigstone.utils.commons.CommonUtils;
import com.sun.deploy.panel.DeleteFilesDialog;
import org.apache.commons.dbutils.DbUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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

        //查询数据库数据
        List<FoodType> foodTypeList = foodTypeService.getAll();
        //保存数据到request域中
        req.setAttribute("foodTypeList", foodTypeList);
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
            return "/error/error.jsp";
        }
    }

    public void updata(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
