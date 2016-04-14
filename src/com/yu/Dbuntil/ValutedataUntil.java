package com.yu.Dbuntil;





import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2016/4/8.
 */
public class ValutedataUntil {
    public  static boolean ValuedataNull(HttpServletRequest req, String[] file){
             boolean value=true;
        Map<String,String>  errorMsg= new HashMap<String, String>();
        for(String str:file){
            String error= req.getParameter(str);
           if(error==null||"".equals(error.trim())){
               value=false;
               errorMsg.put(str,str+"能为空");
           }
        }
        if(!value){
           req.setAttribute("errorMsg",errorMsg);
        }



        return value;
    }
    public static String showMesg(HttpServletRequest req, String fide){
        Map<String,String> Emesg=(Map<String,String>)req.getAttribute("errorMsg");
        if(Emesg==null) return "";
        String msg=Emesg.get(fide);
        if(msg==null) return "";
        return msg;
    }


}
