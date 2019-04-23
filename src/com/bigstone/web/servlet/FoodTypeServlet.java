package com.bigstone.web.servlet;

import com.bigstone.domain.FoodType;
import com.bigstone.factory.BeanFactory;
import com.bigstone.service.IFoodTypeService;
import com.sun.deploy.panel.DeleteFilesDialog;

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
public class FoodTypeServlet extends HttpServlet {

    //用工厂进行实例化FoodTypeService类
    private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService", IFoodTypeService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String methodName = req.getParameter("method");

        if ("list".equals(methodName)) {
            //查看列表
            list(req, resp);

        } else if ("addFoodType".equals(methodName)) {
            //添加菜系
            save(req, resp);
        } else if ("delete".equals(methodName)) {
            //删除
            delete(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    /**
     * 菜系的列表展示
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //查询数据库数据
        List<FoodType> foodTypeList = foodTypeService.getAll();
        //保存数据到request域中
        req.setAttribute("foodTypeList", foodTypeList);
        //转发到页面
        req.getRequestDispatcher("/sys/type/foodtype_list.jsp").forward(req, resp);
    }

    /**
     * 添加菜系
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foodTypeName = req.getParameter("foodTypeName");
        FoodType foodType = new FoodType();
        foodType.setTypeName(foodTypeName);
        foodTypeService.save(foodType);
        req.getRequestDispatcher("/sys/type/foodtype_list.jsp").forward(req, resp);
    }

    /**
     * 删除菜系
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
