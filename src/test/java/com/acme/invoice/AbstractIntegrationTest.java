package com.acme.invoice;

import com.acme.invoice.TestConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author John Spangenberg
 */
@SpringApplicationConfiguration(classes = TestConfig.class)
@Transactional
public abstract class AbstractIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setupData() throws Exception {
    }
}

