package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


@Data
public class Demo {

    @ExcelProperty("学生编号")
    private Integer sno;
    @ExcelProperty("学生姓名")
    private String sname;


}
