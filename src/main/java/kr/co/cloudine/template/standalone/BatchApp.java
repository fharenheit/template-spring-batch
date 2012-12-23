package kr.co.cloudine.template.standalone;

import kr.co.cloudine.template.standalone.batch.HelloWorldJob;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test Application
 *
 * @author Edward KIM
 * @since 1.0
 */
public class BatchApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-batch.xml");
        JobRepository jobRepository = context.getBean(JobRepository.class);
        JobLauncher jobLauncher = context.getBean(JobLauncher.class);

        try {
            jobLauncher.run(new HelloWorldJob(), new JobParameters());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
