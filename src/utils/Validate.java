package utils;

import utils.myexception.*;

public class Validate {
    public static boolean validateDate (String date) throws InvalidDate {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        if (date.matches(regex)) {
            return true;
        }
        else {
            throw new InvalidDate("Invalid date format (yyyy-mm-dd) : "+ date);
        }

    }
    public static boolean validateEmail (String email) throws InvalidEmail {
        String regex = "^\\w+@[a-zA-Z]+\\.[a-zA-Z]+$";
        if (!email.matches(regex)) {
            throw new InvalidEmail("Invalid email format : "+ email);
        }
        return true;
    }
    public static boolean validatePhone (String phone) throws InvalidPhone {
        String regex = "^0\\d{9}$";
        if (!phone.matches(regex)) {
            throw new InvalidPhone("Invalid phone format (10 digits and start with 0) : "+ phone);
        }
        return true;
    }
    public static boolean validateEmployeeId (String id) throws InvalidEmployeeId {
        String regex = "^NV-\\d{4}$";
        if (!id.matches(regex)) {
            throw new InvalidEmployeeId ("Invalid Employee Id (NV-xxxx) : "+  id);
        }
        return true;
    }
    public static boolean validateName (String name) throws InvalidName {
        String regex = "^NV-\\d {4}$";
        if (!name.matches(regex)) {
            throw new InvalidName ("Invalid Name : "+  name);
        }
        return true;
    }
    public static boolean validateSalary (double salary) throws InvalidSalary {
        if (!(salary>0)) {
            throw new InvalidSalary ("Invalid Salary (>0) : "+  salary);
        }
        return true;
    }


}
