public class PassByValue {

        public static void ChangeRef(String name) {
            name = new String("xiaobei");
        }

        public static void change(String name){
            name = "daaa";
        }

        public static void main(String[] args) {
            String name = new String("shuaibei");
            String name1 = "haaa";
            ChangeRef(name);
            change(name1);
            System.out.println(name.equals("shuaibei"));
            System.out.println(name1);
        }
}
