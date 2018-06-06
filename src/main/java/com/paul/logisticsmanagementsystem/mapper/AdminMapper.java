package com.paul.logisticsmanagementsystem.mapper;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.AdminExample;

import java.util.HashMap;
import java.util.List;

import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int  resetPassword(@Param("adminid") Integer adminid);
    Admin verifyAdminByIdNumber(@Param("idnumber") String idnumber);
    Admin  verifyAdminByPhone(@Param("phone") String phone);
    Admin  verifyAdminByUserName(@Param("username") String username);
    Admin  verifyAdminByEmail(@Param("email") String email);

    HashMap<String,String> getLoginTypeByUserName(@Param("username") String username);
    Admin getAdmin(@Param("username") String username, @Param("password") String password);

    List<Admin> getAllAdmin(@Param("username") String username, @Param("phone") String phone,@Param("sex") String sex,@Param("idnumber") String idnumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    long countByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    int deleteByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    int deleteByPrimaryKey(Integer adminid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    int insert(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    int insertSelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    Admin selectByPrimaryKey(Integer adminid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table admin
     *
     * @mbg.generated Wed May 16 11:11:27 CST 2018
     */
    int updateByPrimaryKey(Admin record);
}