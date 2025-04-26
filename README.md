[CppSide](https://github.com/InfernumVII/nativeconsoleJava-CppSide-/blob/master/Dll1/NativeConsole.cpp)
# Using

```java
import com.infernumvii.NativeConsole;
public class App {
    public static void main(String[] args) {
        while (true) {
            int ch = NativeConsole.readCharImmediately();
            if (ch != -1){
                System.out.println((char)ch);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```
