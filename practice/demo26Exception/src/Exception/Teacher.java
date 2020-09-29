package Exception;

public class Teacher {

    public void checkScore(int score) throws ScoreException{
        if (score<0 || score >100) {
            // extends Exception 是编译期异常,所以必须用throws抛出
            throw new ScoreException(" illegal score, should be between 0 to 100");
        }else {
            System.out.println("legal score");
        }
    }
}
