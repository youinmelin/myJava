package lin.dao;

import lin.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISyslogDao {

    @Insert("insert into syslog (visitTime, username, ip, url, executionDuring, method) values(#{visitTime}, #{username}, #{ip}, #{url}, #{executionDuring}, #{method})")
    void saveSyslog(Syslog syslog);

    @Select("select * from syslog")
    List<Syslog> findAllLog();

}
