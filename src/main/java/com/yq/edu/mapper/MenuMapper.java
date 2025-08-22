package com.yq.edu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.edu.entity.Menu;
import com.yq.edu.vo.MenuRoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    @Select ( "select tbl_menu.*,tbl_role.role_name from tbl_menu,tbl_role where tbl_menu.role_id = tbl_role.role_id" )
    IPage<MenuRoleVo> selectMenuRole(Page page);

    @Select ( "select * from tbl_menu where role_id = #{role}" )
    List<Menu> getMenuListByRoleId(@Param ( "role" ) Integer role);

}
