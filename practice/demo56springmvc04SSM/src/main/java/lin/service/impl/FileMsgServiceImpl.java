package lin.service.impl;

import lin.dao.IFileMsgDao;
import lin.domain.FilenameAndMsg;
import lin.service.IFileMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fileMsgService")
public class FileMsgServiceImpl implements IFileMsgService {

    @Autowired
    private IFileMsgDao fileMsgDao;

    @Override
    public void saveFileMsg(FilenameAndMsg fileMsg) {
        System.out.println("BLL: " + fileMsg);
        fileMsgDao.saveFileMsg(fileMsg);
    }

    @Override
    public List<FilenameAndMsg> findAllFileMsg(Integer currentFirstIndex, Integer numPerPage) {

        System.out.println("BLL: find all file msg");
        System.out.println("currentFirstIndex: " + currentFirstIndex + ", numPerPage: "  + numPerPage);
        return fileMsgDao.findAllFileMsg(currentFirstIndex, numPerPage);
    }

    @Override
    public List<FilenameAndMsg> findMsgWithUser(Integer currentFirstIndex, Integer numPerPage) {
        List<FilenameAndMsg> msgWithUser = fileMsgDao.findMsgWithUser(currentFirstIndex, numPerPage);
        return msgWithUser;
    }

    @Override
    public String delFileByMsgId(Integer msgId) {
        String filename = fileMsgDao.findFilenameByMsgId(msgId);
        fileMsgDao.delFileByMsgId(msgId);
        return filename;
    }

    @Override
    public Integer findMsgCount() {
        return fileMsgDao.findMsgCount();
    }
}
