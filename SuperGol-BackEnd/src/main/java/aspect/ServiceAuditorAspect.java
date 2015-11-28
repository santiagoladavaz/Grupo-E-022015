package aspect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;



@Aspect
public class ServiceAuditorAspect {

	Logger logger = Logger.getLogger(ServiceAuditorAspect.class);
	
	
	@Around("@annotation(aspect.Aspectable)")
	public void inspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
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
		
		proceedingJoinPoint.proceed();			
	}
}
