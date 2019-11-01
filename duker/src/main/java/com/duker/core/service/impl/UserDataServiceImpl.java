package com.duker.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duker.core.entity.UserDataEntity;
import com.duker.core.mapper.UserDataMapper;
import com.duker.core.service.IUserDataService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiebq
 * @since 2019-10-17
 */
@Service
public class UserDataServiceImpl extends ServiceImpl<UserDataMapper, UserDataEntity> implements IUserDataService {

}
