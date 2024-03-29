package com.paul.logisticsmanagementsystem.mapper;

import com.paul.logisticsmanagementsystem.entity.VoiceMail;
import com.paul.logisticsmanagementsystem.entity.VoiceMailDetail;
import com.paul.logisticsmanagementsystem.entity.VoiceMailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VoiceMailMapper {

    List<VoiceMail> getSelectiveVocieMails(@Param("userid") Integer userid,@Param("state") String state,@Param("startDate") String startDate,@Param("endDate") String endDate);


    List<VoiceMailDetail> getAllVocieMails(@Param("userid") Integer userid,@Param("username") String username,@Param("state") String state,@Param("startDate") String startDate,@Param("endDate") String endDate);

    VoiceMailDetail getVoiceMailByPrimaryKey(@Param("vid") Integer vid);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    long countByExample(VoiceMailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    int deleteByExample(VoiceMailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    int deleteByPrimaryKey(Integer vid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    int insert(VoiceMail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    int insertSelective(VoiceMail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    List<VoiceMail> selectByExample(VoiceMailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    VoiceMail selectByPrimaryKey(Integer vid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    int updateByExampleSelective(@Param("record") VoiceMail record, @Param("example") VoiceMailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    int updateByExample(@Param("record") VoiceMail record, @Param("example") VoiceMailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    int updateByPrimaryKeySelective(VoiceMail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table voicemail
     *
     * @mbg.generated Wed Apr 25 22:43:44 CST 2018
     */
    int updateByPrimaryKey(VoiceMail record);
}