package com.hcl.msastudio.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hcl.msastudio.model.FileUpload;
import com.hcl.msastudio.model.User;
import com.hcl.msastudio.service.UserService;

@Component
public class FileUploadValidator implements Validator {
   
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	
    	FileUpload input = (FileUpload)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "file", "NotEmpty");
        if(input.getFile().isEmpty() || input.getFile().getSize() == 0L) {
        	errors.rejectValue("file", "NotEmpty");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectType", "NotEmpty");
        
    }
}
