package com.demo.Calculator.IndexController;

import com.demo.Calculator.Entity.DataStore;
import com.demo.Calculator.Repo.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {

    @Autowired
    DataRepo rep;
    @RequestMapping("home")
    public ModelAndView homePage(){
        ModelAndView mav=new ModelAndView("home");
        return mav;
    }
    @RequestMapping("add")
    public ModelAndView add(DataStore data){
        rep.save(data);
        ModelAndView mav=new ModelAndView("addition");
      int value= data.getNum1()+ data.getNum2();
      mav.addObject("num1",data.getNum1());
        mav.addObject("num2",data.getNum2());
        mav.addObject("additionValue",value);
        return mav;
    }
    @RequestMapping("sub")
    public ModelAndView sub(DataStore data){
        rep.save(data);
        ModelAndView mav=new ModelAndView("Subtraction");
        int value= data.getNum1()- data.getNum2();
        mav.addObject("num1",data.getNum1());
        mav.addObject("num2",data.getNum2());
        mav.addObject("subValue",value);
        return mav;
    }
    @RequestMapping("multiply")
    public ModelAndView multiply(DataStore data){
        rep.save(data);
        ModelAndView mav=new ModelAndView("multiplication");
       int value= data.getNum1()*data.getNum2();
        mav.addObject("num1",data.getNum1());
        mav.addObject("num2",data.getNum2());
        mav.addObject("multiValue",value);
        return mav;
    }
    @RequestMapping("division")
    public ModelAndView division(DataStore data){
        rep.save(data);
        ModelAndView mav=new ModelAndView("division");
       int value = 0;
       String str = null;
        if(data.getNum2()==0){
         str="Cannot divided by Zero";
            mav.addObject("divValue",str);
        }else{
            value=data.getNum1()/data.getNum2();
            mav.addObject("divValue",value);
        }
        mav.addObject("num1",data.getNum1());
        mav.addObject("num2",data.getNum2());

        return mav;
    }

}
