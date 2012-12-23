/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.co.cloudine.template.standalone.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;

/**
 * Simple Spring Batch Job.
 *
 * @author Edward KIM
 * @since 0.1
 */
public class HelloWorldJob implements Job {

    JobParametersIncrementer incrementer = new RunIdIncrementer();

    JobParametersValidator validator = new DefaultJobParametersValidator();

    @Override
    public String getName() {
        return "Hello Spring Batch Job";
    }

    @Override
    public boolean isRestartable() {
        return true;
    }

    @Override
    public void execute(JobExecution execution) {
        System.out.println("Hi~! " + this.getName());
    }

    @Override
    public JobParametersIncrementer getJobParametersIncrementer() {
        return incrementer;
    }

    @Override
    public JobParametersValidator getJobParametersValidator() {
        return validator;
    }
}
