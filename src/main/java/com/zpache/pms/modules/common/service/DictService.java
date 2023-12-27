package com.zpache.pms.modules.common.service;

import com.zpache.pms.modules.common.dto.DictDTO;

import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 13:35
 */
public interface DictService {

    List<DictDTO> selectList(String type);

}
