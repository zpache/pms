package com.zpache.pms.modules.common.service;

import com.zpache.pms.modules.common.dto.DistrictDTO;
import com.zpache.pms.modules.common.form.DistrictForm;

import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 13:34
 */
public interface DistrictService {

    List<DistrictDTO> selectList(DistrictForm districtForm);

}
