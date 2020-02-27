import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.SQLOutput;

/**
 *java.lang.reflect.Field; 类中的属性
 */

public class ReflectTest1 {

    public static void main(String[] args) throws Exception {

        //获取整个类
        Class c = Class.forName("java.lang.Integer");

//        获取属性Field
//        Field[] fs = c.getFields();   // 获取所有的public属性
//
//        for(int i = 0; i < fs.length; i++)
//        {
//            System.out.println(fs[i].getName() + " ");
//        }

//        /**
//         * 利用反射机制获取类的所有属性
//         */
//        Field[] fs = c.getDeclaredFields();
//
//        for (Field Fs : fs
//             ) {
//            int i = Fs.getModifiers();
//            String strModField = Modifier.toString(i);
//            System.out.println(strModField);
//
//            Class type = Fs.getType();
//            System.out.println(type.getSimpleName());
//            System.out.println(Fs.getName());
//        }

        /**
         * 反编译
         */
        Field[] fs = c.getDeclaredFields();
        StringBuffer sb = new StringBuffer();

        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + " { \n");

        for (Field Fs : fs
             ) {
            sb.append("\t");
            sb.append(Modifier.toString(Fs.getModifiers()) + " ");
            sb.append(Fs.getType().getSimpleName()+ " " );
            sb.append(Fs.getName() + "\n");
        }
        sb.append("}");

        System.out.println(sb);
    }

}
