package com.zpache.pms.modules.common.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zpache.pms.entity.DictValue;
import com.zpache.pms.mapper.DictValueMapper;
import com.zpache.pms.modules.common.dto.DictDTO;
import com.zpache.pms.modules.common.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 13:35
 */
@Service
@RequiredArgsConstructor
public class DictServiceImpl implements DictService {
    private final DictValueMapper dictValueMapper;
    @Override
    public List<DictDTO> selectList(String type) {
        List<DictValue> dictValueList = dictValueMapper.selectList(Wrappers.lambdaQuery(DictValue.class)
                .eq(DictValue::getType, type));
        List<DictDTO> list = new ArrayList<>();
        if (dictValueList != null && !dictValueList.isEmpty()) {
            dictValueList.forEach((dict) -> {
                DictDTO dictDTO = new DictDTO();
                dictDTO.setLabel(dict.getDictLabel());
                dictDTO.setValue(dict.getDictValue());
                list.add(dictDTO);
            });
        }
        return list;
    }
}
