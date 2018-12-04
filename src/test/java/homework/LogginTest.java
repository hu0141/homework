package homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

public class LogginTest {
	private final static Logger logger = LoggerFactory.getLogger(LogginTest.class);
	public static void main(String[] args) {
		logger.info("haha");
		logger.info("heiehi:{}", 123);
	}
}
