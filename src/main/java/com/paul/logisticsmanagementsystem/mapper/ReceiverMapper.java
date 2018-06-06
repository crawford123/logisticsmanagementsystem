package com.paul.logisticsmanagementsystem.mapper;

import com.paul.logisticsmanagementsystem.entity.Receiver;
import com.paul.logisticsmanagementsystem.entity.ReceiverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiverMapper {

    int selectReceiveridIdByMark(@Param("mark") String mark);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    long countByExample(ReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    int deleteByExample(ReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    int deleteByPrimaryKey(@Param("receiverid") Integer receiverid, @Param("userid") Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    int insert(Receiver record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    int insertSelective(Receiver record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    List<Receiver> selectByExample(ReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    Receiver selectByPrimaryKey(@Param("receiverid") Integer receiverid, @Param("userid") Integer userid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    int updateByExampleSelective(@Param("record") Receiver record, @Param("example") ReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    int updateByExample(@Param("record") Receiver record, @Param("example") ReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    int updateByPrimaryKeySelective(Receiver record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    int updateByPrimaryKey(Receiver record);
}