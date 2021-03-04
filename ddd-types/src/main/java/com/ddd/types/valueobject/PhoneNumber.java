package com.ddd.types.valueobject;

import lombok.Getter;

import javax.xml.bind.ValidationException;
import java.util.Arrays;

/**
 * 电话号码类
 * <p>
 * Type 指我们在今后的代码里可以通过 PhoneNumber 去显性的标识电话号这个概念
 * <p>
 * Class 指我们可以把所有跟电话号相关的逻辑完整的收集到一个文件里
 * <p>
 * Created by wubo15 on 2021/3/1.
 *
 * @author wubo15
 * @date 2021/3/1
 */
@Getter
public class PhoneNumber {

    /**
     * 电话号码
     * （Immutable）Value Object
     */
    private final String number;


    /**
     * 校验逻辑都放在了 constructor 里面，确保只要 PhoneNumber 类被创建出来后，一定是校验通过的。
     *
     * @param number
     * @throws ValidationException
     */
    public PhoneNumber(String number) throws ValidationException {
        if (number == null) {
            throw new ValidationException("number不能为空");
        } else if (isValid(number)) {
            throw new ValidationException("number格式错误");
        }
        this.number = number;
    }


    /**
     * areaCode 是  PhoneNumber 的一个计算属性
     *
     * @return
     */
    public String getAreaCode() {
        for (int i = 0; i < number.length(); i++) {
            String prefix = number.substring(0, i);
            if (isAreaCode(prefix)) {
                return prefix;
            }
        }
        return null;
    }

    private static boolean isAreaCode(String prefix) {
        String[] areas = new String[]{"0571", "021", "010"};
        return Arrays.asList(areas).contains(prefix);
    }

    public static boolean isValid(String number) {
        String pattern = "^0?[1-9]{2,3}-?\\d{8}$";
        return number.matches(pattern);
    }
}
