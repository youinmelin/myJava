package lin.service;

import lin.domain.Syslog;

import java.util.List;

public interface ISyslogService {

    void saveSyslog(Syslog syslog);

    List<Syslog> findAllLog();
}
