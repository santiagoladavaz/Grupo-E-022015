package aspect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



@Aspect
public class ServiceAuditorAspect {

	Logger logger = Logger.getLogger(ServiceAuditorAspect.class);
	
	
	@Before("@annotation(aspect.Aspectable)")
	public void inspect(JoinPoint proceedingJoinPoint) throws Throwable{
		Object target = proceedingJoinPoint.getTarget();
		
		String method= proceedingJoinPoint.getSignature().getName();
		Object[] params = proceedingJoinPoint.getArgs();
		String stringparams = "";
		for (Object obj : params){
			stringparams += obj.toString() + ", ";
		}
		Date d = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String date = format.format(d);
		logger.info("**************************************** SERVICE INSPECTOR *********************************************");
		logger.info("DATE: "+ date +" Executing method: '"+ method + "' Of class: '" + target.getClass() +"' With Params: '"+ stringparams + "'");
		logger.info("**************************************** SERVICE INSPECTOR END *****************************************");
//		proceedingJoinPoint.proceed();			
	}
}
