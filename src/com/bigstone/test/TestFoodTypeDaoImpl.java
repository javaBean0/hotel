package com.bigstone.test;

import com.bigstone.dao.IFoodTypeDao;
import com.bigstone.dao.impl.FoodTypeDaoImpl;
import com.bigstone.domain.FoodType;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * Created with IDEA
 * author: bigStone
 * Date:2019/4/22
 * Time:20:01
 */
public class TestFoodTypeDaoImpl {

    private IFoodTypeDao getFoodTypeDao() {
        return new FoodTypeDaoImpl();
    }

    @Test
    public void testRandom() {
        for (int i = 0; i < 100; i++) {
            System.out.print(new Random().nextInt(5) + "  ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }

    }

    @Test
    public void testSave() throws  Exception {
        FoodType[] foodTypes = new FoodType[10];
        String[] strings = new String[]{"川菜", "湘菜", "东北菜", "粤菜", "豫菜", "闽菜"};
        for (int i = 0; i < 5; i++) {
            foodTypes[i] = new FoodType();
            foodTypes[i].setId(i);
            foodTypes[i].setTypeName(strings[i]);
            getFoodTypeDao().save(foodTypes[i]);
        }
    }

    @Test
    public void testFindAll() throws SQLException{
        List<FoodType> foodTypes = getFoodTypeDao().getAll();
        for (FoodType foodType : foodTypes){
            System.out.println(foodType);
        }
    }




}
