package com.yq.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.edu.entity.User;
import com.yq.edu.vo.UserRoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select tbl_user.*,tbl_role.role_name from tbl_user,tbl_role where tbl_user.role_id = tbl_role.role_id and tbl_user.role_id = #{roleId} and tbl_user.user_id = #{userId}")
    UserRoleVo getUserAndRole(@Param ( "roleId" ) Integer roleId,@Param ( "userId" ) String userId);

}
