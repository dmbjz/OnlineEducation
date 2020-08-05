package excel;

import com.alibaba.excel.EasyExcel;
import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {


    public static void main(String[] args) {
       //实现Excel写操作
        String url = "D:\\dmbjz.xlsx";

         /*
        //实现写操作，（路径+实体类.class）.sheet(excel的sheet名称).dowrite
        EasyExcel.write(url,Demo.class).sheet("学生列表").doWrite(getData());

*/
        //Excel读操作
        EasyExcel.read(url,Demo.class,new ExcelListener()).sheet().doRead();
    }

    //返回list集合
    private static List<Demo> getData(){
        List<Demo> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            Demo demo = new Demo();
            demo.setSno(i);
            demo.setSname("lucy"+i);
            list.add(demo);
        }
        return list;
    }

}
