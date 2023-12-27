package com.zpache.pms.modules.common.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zpache.pms.entity.District;
import com.zpache.pms.mapper.DistrictMapper;
import com.zpache.pms.modules.common.dto.DistrictDTO;
import com.zpache.pms.modules.common.form.DistrictForm;
import com.zpache.pms.modules.common.service.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: zpache
 * @createTime: 2023/12/27 13:34
 */
@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private final DistrictMapper districtMapper;
    @Override
    public List<DistrictDTO> selectList(DistrictForm districtForm) {
        List<District> districtList = districtMapper.selectList(Wrappers.lambdaQuery(District.class)
                .eq(districtForm.getParentId() != null, District::getParentId, districtForm.getParentId())
                .eq(districtForm.getDistrictLevel() != null, District::getDistrictLevel, districtForm.getDistrictLevel()));
        List<DistrictDTO> list = new ArrayList<>();
        districtList.forEach(district -> {
            DistrictDTO districtDTO = new DistrictDTO();
            BeanUtils.copyProperties(district, districtDTO);
            list.add(districtDTO);
        });
        return list;
    }
}
