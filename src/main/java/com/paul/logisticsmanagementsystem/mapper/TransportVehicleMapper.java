package com.paul.logisticsmanagementsystem.mapper;

import com.paul.logisticsmanagementsystem.entity.TransportVehicle;
import com.paul.logisticsmanagementsystem.entity.TransportVehicleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportVehicleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    long countByExample(TransportVehicleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    int deleteByExample(TransportVehicleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    int deleteByPrimaryKey(Integer tvid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    int insert(TransportVehicle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    int insertSelective(TransportVehicle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    List<TransportVehicle> selectByExample(TransportVehicleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    TransportVehicle selectByPrimaryKey(Integer tvid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    int updateByExampleSelective(@Param("record") TransportVehicle record, @Param("example") TransportVehicleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    int updateByExample(@Param("record") TransportVehicle record, @Param("example") TransportVehicleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    int updateByPrimaryKeySelective(TransportVehicle record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transportvehicle
     *
     * @mbg.generated Thu Apr 19 19:44:16 CST 2018
     */
    int updateByPrimaryKey(TransportVehicle record);
}