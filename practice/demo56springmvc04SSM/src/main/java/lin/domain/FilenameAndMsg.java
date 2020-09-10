package lin.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilenameAndMsg implements Serializable {

    private Integer msgId;
    private Integer uId;
    private String message;
    private String filenameFull;
    private Integer filesize;
    private Date datetime;
    private User user;
    private String datetimeStr;

    @Override
    public String toString() {
        return "FilenameAndMsg{" +
                "msgId=" + msgId +
                ", uId=" + uId +
                ", message='" + message + '\'' +
                ", filenameFull='" + filenameFull + '\'' +
                ", filesize=" + filesize +
                ", datetime=" + datetime +
                ", user=" + user +
                ", datetimeStr='" + datetimeStr + '\'' +
                '}';
    }

    public String getDatetimeStr() {
        return datetimeStr;
    }

    // turn Date to String
    public void setDatetimeStr(Date datetime) {
        if (datetime != null) {
            this.datetimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime);
        }else {
            this.datetimeStr = datetimeStr;
        }
    }

    public Integer getMsgId() {
        return msgId;
    }

    public FilenameAndMsg() {
    }

    public FilenameAndMsg(Integer msgId, Integer uId, String message, String filenameFull, Integer filesize, Date datetime) {
        this.msgId = msgId;
        this.uId = uId;
        this.message = message;
        this.filenameFull = filenameFull;
        this.filesize = filesize;
        this.datetime = datetime;
        // turn Date to String
        setDatetimeStr(this.datetime);
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFilenameFull() {
        return filenameFull;
    }

    public void setFilenameFull(String filenameFull) {
        this.filenameFull = filenameFull;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
