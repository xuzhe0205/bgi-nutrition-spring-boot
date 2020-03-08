package com.health.nutrition.common.filter;

import com.health.nutrition.common.aspect.annotation.IsValidUserInfo;
import com.health.nutrition.entity.UserInfoEntity;
import org.springframework.util.StringUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.regex.Pattern;

public class IsValidUserInfoValidator implements ConstraintValidator<IsValidUserInfo, UserInfoEntity> {

    private String message;

    @Override
    public void initialize(IsValidUserInfo constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserInfoEntity userInfoEntity, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        boolean validationFlag = true;
        if (userInfoEntity == null) return true;
        
        if (StringUtils.isEmpty(userInfoEntity.getName())){
            message = "name不能为null";
            validationFlag = false;
        }
        else if ((!Pattern.matches("(\\b(19[0-8][0-9]|199[0-9]|200[0-9]|201[0-9])\\b)(\\/)(\\b(0[1-9]|1[0-2])\\b)(\\/)(\\b(0[1-9]|1[0-9]|2[0-9]|3[0-1])\\b)",
                userInfoEntity.getDob()))||userInfoEntity.getDob() == null){
            message="dob格式错误（yyyy/mm/dd）";
            validationFlag = false;
        }
        else if (!userInfoEntity.getPregnancyStatus().equals("无") && userInfoEntity.getSex().equals("男")){
            message = "如果已怀孕或是母乳，性别不能为男性";
            validationFlag = false;
        }
        else if (!userInfoEntity.getHealthStatus().contains("高尿酸") && !userInfoEntity.getHealthStatus().contains("高血压") &&
                !userInfoEntity.getHealthStatus().contains("高血糖") && !userInfoEntity.getHealthStatus().contains("无") &&
                !userInfoEntity.getHealthStatus().contains("血脂异常")){
            message = "不能输入除高血糖Diabetes、高血压Hypertension、血脂异常Dyslipidemia、高尿酸Hyperuricemia、无None 以外的值";
            validationFlag = false;
        }
        else if (!Arrays.asList("孕期（早）", "孕期（中）", "孕期（晚）", "乳母","无").contains(userInfoEntity.getPregnancyStatus())){
            message = "不能输入除孕期(早)Early Pregnancy、孕期(中)Medium Pregnancy、孕期(晚)Late Pregnancy、乳母Breastfeeding、无None 以外的值";
            validationFlag = false;
        }
        else if (!userInfoEntity.getIsSmoker().equals("0") && !userInfoEntity.getIsSmoker().equals("1")){
            message = "不能输入不吸烟'0'和吸烟'1'以外的值";
            validationFlag = false;
        }
        else if (!Arrays.asList("不喝酒", "以前喝现在不喝", "喝酒").contains(userInfoEntity.getAlcoholicStatus())){
            message = "不能输入不喝酒Never、以前和现在不喝Stop、喝酒Still 以外的值";
            validationFlag = false;
        }
        else if (!userInfoEntity.getSex().equals("男") && !userInfoEntity.getSex().equals("女")){
            message = "不能输入男性Male 和女性Female 以外的值";
            validationFlag = false;
        }
        ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder=context.buildConstraintViolationWithTemplate(message);
        constraintViolationBuilder.addConstraintViolation();
        return validationFlag;
    }
}
