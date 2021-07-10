package annotation;
// The annotations they don't have any variables called Marker Annotations

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//We need 2 predefine Meta annotation
@Target(ElementType.TYPE) // Type says scope is class level
@Retention(RetentionPolicy.RUNTIME) // Runtime says scope is RunTime
@interface SmartDevice {
    int Id() default 0; // field in annotation with the default values
    String name() default "VG"; //1 way to specify the default values
}

@SmartDevice//(Id = 0, name = "Dell") we can specify the default values here as well
class Device {
    int id;
    String name;

    public Device(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//1 retention Annotation
@Retention(RetentionPolicy.RUNTIME) //till when this annotation exists
@interface CustomRetention{
    String name() default "retention";
}
class CustomRetentionTest{

    @CustomRetention(name = "Print data")
    public void printData(){

    }
}

//Deprecated Annotation
class CustomDeprecated {
    @Deprecated
    public void Display() {
        System.out.println("Deprecated Annotation test Method()");
    }

    public static void main(String args[]) {
        CustomDeprecated Dep = new CustomDeprecated();
        Dep.Display();
    }
}

public class CustomAnnotation {

    public static void main(String[] args) {

        Device device = new Device(1, "Test");
        System.out.println(device.name);

        //TO fetch the Values of the annotations like 0, and VG  we need to follow some steps

        //Use reflection to get the value
        Class c = device.getClass();
        Annotation an = c.getAnnotation(SmartDevice.class);
        SmartDevice smartDevice = (SmartDevice) an;
        System.out.println(smartDevice.Id() + " "+ smartDevice.name());
    }
}
