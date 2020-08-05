package excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;

import java.util.Map;

public class ExcelListener extends AnalysisEventListener<Demo> {

    //读取表头
    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        super.invokeHead(headMap, context);
    }

    //一行一行读取数据
    @Override
    public void invoke(Demo demo, AnalysisContext analysisContext) {
        System.out.println(demo);
    }

    //读取后镜像的操作
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

}
