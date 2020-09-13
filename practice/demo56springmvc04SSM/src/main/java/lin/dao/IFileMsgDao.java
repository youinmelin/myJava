package lin.dao;

import lin.domain.FilenameAndMsg;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFileMsgDao {

    @Update("insert into file_msg (msgid,uid,message,filename,filesize,datetime) values(null,#{uId},#{message},#{filenameFull},#{filesize},#{datetime})")
    void saveFileMsg(FilenameAndMsg filenameAndMsg);

//    @Select("select msgId,username,message,filename,datetime from file_and_msg" )
    @Select("select * from file_msg limit #{param1},#{param2}" )
    List<FilenameAndMsg> findAllFileMsg(Integer currentFirstIndex, Integer numPerPage);

    @Select("select * from file_msg order by datetime desc limit #{param1},#{param2}")
    @Results(id = "MsgWithUserMapper", value = {
            @Result (id = true, property = "msgId", column = "msgid"),
            @Result(property = "uId", column = "uid"),
            @Result(property = "message", column = "message"),
            @Result(property = "filenameFull", column = "filename"),
            @Result(property = "filesize", column = "filesize"),
            @Result(property = "datetime", column = "datetime"),
            @Result(property = "user", column = "uid",
             one = @One (select = "lin.dao.IUserDao.findUserById", fetchType = FetchType.EAGER))

    })
    List<FilenameAndMsg> findMsgWithUser(Integer currentFirstIndex, Integer numPerPage);

    @Delete("delete from file_msg where msgid = #{msgId}")
    void delFileByMsgId(Integer msgId);

    @Select("select filename from file_msg where msgid = #{msgId}")
    String findFilenameByMsgId(Integer msgId);

    @Select("select count(msgId) from file_msg")
    Integer findMsgCount();
}

