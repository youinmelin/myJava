package lin.service;

import lin.domain.FilenameAndMsg;

import java.util.List;

public interface IFileMsgService {

    public void saveFileMsg(FilenameAndMsg fileMsg);

    List<FilenameAndMsg> findAllFileMsg(Integer currentFirstIndex, Integer currentLastIndex);

    List<FilenameAndMsg> findMsgWithUser(Integer currentFirstIndex, Integer numPerPage);

    String delFileByMsgId(Integer msgId);

    Integer findMsgCount();
}
