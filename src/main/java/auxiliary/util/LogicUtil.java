package auxiliary.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogicUtil {

    public static Boolean getRemFromDivByTwo(Integer param) {
        return param % 2 == 0;
    }
}
