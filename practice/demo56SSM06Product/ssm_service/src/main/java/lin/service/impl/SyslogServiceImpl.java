package lin.service.impl;

import lin.dao.ISyslogDao;
import lin.domain.Syslog;
import lin.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SyslogServiceImpl implements ISyslogService {

    @Autowired
    ISyslogDao syslogDao;

    @Override
    public void saveSyslog(Syslog syslog) {
        syslogDao.saveSyslog(syslog);
    }

    @Override
    public List<Syslog> findAllLog() {
        List<Syslog> syslogs = syslogDao.findAllLog();
        return syslogs;
    }
}
