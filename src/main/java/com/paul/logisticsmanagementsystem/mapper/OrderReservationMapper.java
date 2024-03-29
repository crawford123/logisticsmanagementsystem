package com.paul.logisticsmanagementsystem.mapper;

import com.paul.logisticsmanagementsystem.entity.OrderReservation;
import com.paul.logisticsmanagementsystem.entity.OrderReservationExample;
import java.util.*;
import org.apache.ibatis.annotations.Param;

public interface OrderReservationMapper {


    HashMap<String,String> selectStateById(@Param("id") Integer id);

    List<OrderReservation> getSelectiveManageOrderReservations(@Param("ordercode") String ordercode,@Param("logisticcode") String logisticcode, @Param("state") String state,@Param("reservestate") String reservestate, @Param("goodsname") String goodsname,@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("startFetchDate") String startFetchDate, @Param("endFetchDate") String endFetchDate);

    List<OrderReservation> getSelectiveOrderReservations(@Param("ordercode") String ordercode,@Param("logisticcode") String logisticcode ,@Param("state") String state,@Param("reservestate") String reservestate,@Param("goodsname") String goodsname, @Param("userid") Integer userid, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("startFetchDate") String startFetchDate, @Param("endFetchDate") String endFetchDate);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    long countByExample(OrderReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    int deleteByExample(OrderReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    int insert(OrderReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    int insertSelective(OrderReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    List<OrderReservation> selectByExample(OrderReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    OrderReservation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    int updateByExampleSelective(@Param("record") OrderReservation record, @Param("example") OrderReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    int updateByExample(@Param("record") OrderReservation record, @Param("example") OrderReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    int updateByPrimaryKeySelective(OrderReservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orderreservation
     *
     * @mbg.generated Wed May 23 17:33:31 CST 2018
     */
    int updateByPrimaryKey(OrderReservation record);
}