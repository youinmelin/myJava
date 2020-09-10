package lin.utils;

public class StringUtils {
     /**
      *  change "%#&^" into other char, because if these chars are in filename, thses files can not download.
      * @param originName
      * @return
      */
     public static String changeSign(String originName) {
          String newName = null;
          newName = originName.replace("%","％").
                  replace("#","＃").
                  replace("&","＆").
                  replace("^","");
//          System.out.println(newName);
          return newName;
     }
}
