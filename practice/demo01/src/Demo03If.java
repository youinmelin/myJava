class Demo03If {
    public static void main(String[] args) {
        int num = 9;
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        }else{
            System.out.println(num + " is odd.");
        }
        int i = 1 ;
        int j = 1;
        while(j < 10){
            while(i < 10){
                    int ret = i*j;
                    System.out.println(j+"X"+i+"="+ret+";");
                    i++;
            }
            j++;
            i = j;
        }
    }
}
