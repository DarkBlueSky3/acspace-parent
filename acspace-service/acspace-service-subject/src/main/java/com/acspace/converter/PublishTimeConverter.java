package com.acspace.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.util.List;

public class PublishTimeConverter implements Converter<List<String>> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return List.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public List<String> convertToJavaData(ReadConverterContext<?> context) throws Exception {
        String cellStr = context.getReadCellData().getStringValue();
        if ((StringUtils.isEmpty(cellStr))) {
            return null;
        }
        List<String> list = JSON.parseArray(cellStr.trim(), String.class);
        return list;
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<List<String>> context) throws Exception {
        return null;
    }
}
