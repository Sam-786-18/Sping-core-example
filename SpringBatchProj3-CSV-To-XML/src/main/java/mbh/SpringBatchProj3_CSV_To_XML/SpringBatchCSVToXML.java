package mbh.SpringBatchProj3_CSV_To_XML;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class SpringBatchCSVToXML
{
	

		@SuppressWarnings("resource")
		public static void main(String areg[]) {

			ApplicationContext ctx = null;
			JobLauncher jobLauncher = null;
			JobExecution execution = null;
			Job job = null;

			ctx = new ClassPathXmlApplicationContext("com/mhb/cfgs/spring-batch-beans.xml");

			jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
			job = (Job) ctx.getBean("examResultJob");

			try {
				System.out.println("-------- " + jobLauncher);

				execution = jobLauncher.run(job, new JobParameters());
				System.out.println("Job Exit Status : " + execution.getStatus());
			} 
			catch (JobExecutionException e) {
				System.out.println("Job ExamResult failed");
				e.printStackTrace();
			}
		}

	}


