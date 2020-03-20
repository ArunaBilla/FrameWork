package com.frameworks.utilities;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpUtility {
public static boolean isValidPhNum(String num) {
boolean status=true;
//Pattern pattern=Pattern.compile("(0|[+]?91)?[6-9][0-9]{9}");
Pattern pattern=Pattern.compile("^[A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
Matcher matcher=pattern.matcher(num);
if(matcher.find()&&matcher.group().equalsIgnoreCase(num))
{
	System.out.println("Valid phonenumber");
	status=true;
}
else
{
	System.out.println("Invalid Phonenum");
	status =false;
}
return status;
}


}

